package se.lnu.ems.backend.services.questions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se.lnu.ems.backend.models.Question;
import se.lnu.ems.backend.services.common.EntitySpecification;

/**
 * The interface Questions service.
 */
public interface IQuestionsService {
    /**
     * Retrieve page.
     *
     * @param specification the specification
     * @param pageable      the pageable
     * @return the page
     */
    Page<Question> retrieve(EntitySpecification<Question> specification, Pageable pageable);

    /**
     * Find by id question.
     *
     * @param id the id
     * @return the question
     */
    Question findById(long id);

    /**
     * Find by id and exam question.
     *
     * @param examId the exam id
     * @param id     the id
     * @return the question
     */
    Question findByExamIdAndId(long examId, long id);

    /**
     * Create question.
     *
     * @param question the question
     * @return the question
     */
    Question create(Question question);

    /**
     * Update question.
     *
     * @param question the question
     * @return the question
     */
    Question update(Question question);

    /**
     * Delete.
     *
     * @param question the question
     */
    void delete(Question question);

    /**
     * Count long.
     *
     * @param specification the specification
     * @return the long
     */
    long count(EntitySpecification<Question> specification);
}
