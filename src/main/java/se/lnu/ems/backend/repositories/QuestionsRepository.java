package se.lnu.ems.backend.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import se.lnu.ems.backend.models.Question;

/**
 * The interface Questions repository.
 */
public interface QuestionsRepository extends PagingAndSortingRepository<Question, Long>,
        JpaSpecificationExecutor<Question> {

}
