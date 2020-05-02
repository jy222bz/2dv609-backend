package se.lnu.ems.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import se.lnu.ems.backend.models.Exam;

@Repository
public interface ExamsRepository extends PagingAndSortingRepository<Exam, Long>{

}
