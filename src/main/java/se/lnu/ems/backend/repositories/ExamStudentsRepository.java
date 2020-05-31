package se.lnu.ems.backend.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import se.lnu.ems.backend.models.ExamStudent;


/**
 * The interface Exam students repository.
 */
public interface ExamStudentsRepository extends PagingAndSortingRepository<ExamStudent, Long>,
        JpaSpecificationExecutor<ExamStudent> {

}
