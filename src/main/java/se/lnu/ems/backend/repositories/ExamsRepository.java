package se.lnu.ems.backend.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import se.lnu.ems.backend.models.Exam;

import java.util.List;

@Repository
public interface ExamsRepository extends PagingAndSortingRepository<Exam, Long>, JpaSpecificationExecutor<Exam> {

    @Deprecated
    @Query(value = "SELECT * FROM exams WHERE title LIKE %?1%", nativeQuery = true)
    List<Exam> findByTitle(String title);

    @Deprecated
    @Query(value = "SELECT * FROM exams WHERE note LIKE %?1%", nativeQuery = true)
    List<Exam> findByNote(String note);

    @Deprecated
    @Query(value = "SELECT * FROM exams WHERE course_code = ?1", nativeQuery = true)
    List<Exam> findByCourseCode(String note);
}
