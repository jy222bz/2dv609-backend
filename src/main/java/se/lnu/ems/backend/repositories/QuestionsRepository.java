package se.lnu.ems.backend.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import se.lnu.ems.backend.models.Question;

public interface QuestionsRepository extends PagingAndSortingRepository<Question, Long> {

}
