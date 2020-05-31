package se.lnu.ems.backend.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import se.lnu.ems.backend.models.QuestionChoice;


/**
 * The interface Question choices repository.
 */
public interface QuestionChoicesRepository extends PagingAndSortingRepository<QuestionChoice, Long>,
        JpaSpecificationExecutor<QuestionChoice> {

}
