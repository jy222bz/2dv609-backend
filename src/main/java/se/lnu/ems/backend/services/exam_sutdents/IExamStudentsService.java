package se.lnu.ems.backend.services.exam_sutdents;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se.lnu.ems.backend.models.ExamStudent;
import se.lnu.ems.backend.services.common.EntitySpecification;


/**
 * The interface Exam students service.
 */
public interface IExamStudentsService {

    /**
     * Retrieve page.
     *
     * @param specification the specification
     * @param pageable      the pageable
     * @return the page
     */
    Page<ExamStudent> retrieve(EntitySpecification<ExamStudent> specification, Pageable pageable);

    /**
     * Find by id exam student.
     *
     * @param id the id
     * @return the exam student
     */
    ExamStudent findById(long id);

    /**
     * Find by exam id and id exam student.
     *
     * @param examId the exam id
     * @param id     the id
     * @return the exam student
     */
    ExamStudent findByExamIdAndId(long examId, long id);

    /**
     * Create exam student.
     *
     * @param examStudent the exam student
     * @return the exam student
     */
    ExamStudent create(ExamStudent examStudent);

    /**
     * Delete.
     *
     * @param examStudent the exam student
     */
    void delete(ExamStudent examStudent);

    /**
     * Count long.
     *
     * @param specification the specification
     * @return the long
     */
    long count(EntitySpecification<ExamStudent> specification);
}
