package se.lnu.ems.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import se.lnu.ems.backend.models.Exam;

@Repository
public interface ExamsRepository extends PagingAndSortingRepository<Exam, Long>{
	
	@Query(value = "SELECT * FROM exams WHERE title LIKE %?1%", nativeQuery = true)
	List<Exam> findByTitle(String title);
	
	@Query(value = "SELECT * FROM exams WHERE note LIKE %?1%", nativeQuery = true)
	List<Exam> findByNote(String note);
	
	@Query(value = "SELECT * FROM exams WHERE course_code = ?1", nativeQuery = true)
	List<Exam> findByCourseCode(String note);
	
}
