package se.lnu.ems.backend.services.common;

import se.lnu.ems.backend.services.common.search.SearchCriteria;
import se.lnu.ems.backend.services.common.search.SearchOperation;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Entity specification.
 *
 * @param <T> the type parameter
 */
public class EntitySpecification<T> implements org.springframework.data.jpa.domain.Specification<T> {
    /**
     * The enum Criteria type.
     */
    public enum Operator {
        /**
         * And criteria type.
         */
        AND,
        /**
         * Or criteria type.
         */
        OR
    }

    private Operator operator = Operator.AND;

    private final List<SearchCriteria> list = new ArrayList<>();

    /**
     * Add.
     *
     * @param criteria the criteria
     */
    public void add(SearchCriteria criteria) {
        list.add(criteria);
    }

    /**
     * Sets criteria type.
     *
     * @param operator the criteria type
     */
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /**
     * Add if value not empty.
     *
     * @param criteria the criteria
     */
    public void addIfValueNotEmpty(SearchCriteria criteria) {
        if ((criteria.getValue() == null) || ((criteria.getValue() instanceof String) && ((String) criteria.getValue()).isEmpty())) {
            return;
        }
        this.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        // return if empty
        if (list.isEmpty()) {
            return builder.and();
        }

        //add criteria to predicates
        List<Predicate> predicates = toPredicates(root, builder);

        if (operator == Operator.AND) {
            return builder.and(predicates.toArray(new Predicate[0]));
        } else {
            return builder.or(predicates.toArray(new Predicate[0]));
        }
    }

    private List<Predicate> toPredicates(Root<T> root, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : list) {
            if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
                predicates.add(builder.greaterThan(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
                predicates.add(builder.lessThan(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
                predicates.add(builder.lessThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
                predicates.add(builder.notEqual(
                        root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                predicates.add(builder.equal(
                        root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_START)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue().toString().toLowerCase()));
            } else if (criteria.getOperation().equals(SearchOperation.IN)) {
                predicates.add(builder.in(root.get(criteria.getKey())).value(criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_IN)) {
                predicates.add(builder.not(root.get(criteria.getKey())).in(criteria.getValue()));
            }
        }
        return predicates;
    }
}
