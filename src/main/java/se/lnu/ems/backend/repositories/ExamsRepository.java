package se.lnu.ems.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import se.lnu.ems.backend.models.Exam;

public interface ExamsRepository extends CrudRepository<Exam, Long>{

}
