package se.lnu.ems.backend.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import se.lnu.ems.backend.models.Exam;

import java.util.List;

/**
 * The interface Exams repository.
 */
@Repository
public interface ExamsRepository extends PagingAndSortingRepository<Exam, Long>, JpaSpecificationExecutor<Exam> {

    /**
     * Find by title list.
     *
     * @param title the title
     * @return the list
     */
    @Deprecated
    @Query(value = "SELECT * FROM exams WHERE title LIKE %?1%", nativeQuery = true)
    List<Exam> findByTitle(String title);

    /**
     * Find by note list.
     *
     * @param note the note
     * @return the list
     */
    @Deprecated
    @Query(value = "SELECT * FROM exams WHERE note LIKE %?1%", nativeQuery = true)
    List<Exam> findByNote(String note);

    /**
     * Find by course code list.
     *
     * @param note the note
     * @return the list
     */
    @Deprecated
    @Query(value = "SELECT * FROM exams WHERE course_code = ?1", nativeQuery = true)
    List<Exam> findByCourseCode(String note);
}
