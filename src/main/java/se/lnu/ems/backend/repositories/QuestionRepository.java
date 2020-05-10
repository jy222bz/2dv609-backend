package se.lnu.ems.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import se.lnu.ems.backend.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{

}
