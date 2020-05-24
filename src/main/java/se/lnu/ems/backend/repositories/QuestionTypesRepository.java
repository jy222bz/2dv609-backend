package se.lnu.ems.backend.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import se.lnu.ems.backend.models.QuestionType;

/**
 * An interface for the Question Type Repository.
 *
 * @author Osama Zarraa
 * @version 1.0
 * @since 2020 -05-24
 */
public interface QuestionTypesRepository extends PagingAndSortingRepository<QuestionType, Long> {

}
