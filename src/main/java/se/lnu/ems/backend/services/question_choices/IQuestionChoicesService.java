package se.lnu.ems.backend.services.question_choices;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se.lnu.ems.backend.models.QuestionChoice;
import se.lnu.ems.backend.services.common.EntitySpecification;


/**
 * The interface Question choices service.
 */
public interface IQuestionChoicesService {
    /**
     * Retrieve page.
     *
     * @param specification the specification
     * @param pageable      the pageable
     * @return the page
     */
    Page<QuestionChoice> retrieve(EntitySpecification<QuestionChoice> specification, Pageable pageable);


    /**
     * Find by id question choice.
     *
     * @param id the id
     * @return the question choice
     */
    QuestionChoice findById(long id);


    /**
     * Create question choice.
     *
     * @param question the question
     * @return the question choice
     */
    QuestionChoice create(QuestionChoice question);

    /**
     * Update question choice.
     *
     * @param question the question
     * @return the question choice
     */
    QuestionChoice update(QuestionChoice question);


    /**
     * Delete.
     *
     * @param question the question
     */
    void delete(QuestionChoice question);

    /**
     * Count long.
     *
     * @param specification the specification
     * @return the long
     */
    long count(EntitySpecification<QuestionChoice> specification);
}
