package se.lnu.ems.backend.services.question_types;

import se.lnu.ems.backend.models.QuestionType;

import java.util.List;

/**
 * A class for the Question Type Service.
 *
 * @author Osama Zarraa
 * @version 1.0
 * @since 2020 -05-24
 */
public interface IQuestionTypesService {
    /**
     * It retrieves the question types.
     *
     * @return List<QuestionType>    list
     */
    List<QuestionType> retrieve();

    /**
     * It finds the question type by the id.
     *
     * @param id the id of the question type.
     * @return QuestionType question type
     */
    QuestionType findById(Long id);
}
