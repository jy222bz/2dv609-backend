package se.lnu.ems.backend.services.question_choices.exceptions;

import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;


/**
 * The type Question choice not found exception.
 */
public class QuestionChoiceNotFoundException extends BaseException {

    /**
     * Instantiates a new Question choice not found exception.
     */
    public QuestionChoiceNotFoundException() {
        super(Code.QUESTION_CHOICE_NOT_FOUND);
    }

    /**
     * Instantiates a new Question choice not found exception.
     *
     * @param message the message
     */
    public QuestionChoiceNotFoundException(String message) {
        super(Code.QUESTION_CHOICE_NOT_FOUND, message);
    }
}
