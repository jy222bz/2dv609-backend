package se.lnu.ems.backend.services.questions.exceptions;

import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;

/**
 * A class for QuestionNotFoundException.
 *
 * @author Osama Zarraa
 * @version 1.0
 * @since 2020 -05-17
 */
public class QuestionNotFoundException extends BaseException {

    /**
     * A constructor to constrict an object.
     */
    public QuestionNotFoundException() {
        super(Code.QUESTION_NOT_FOUND);
    }

    /**
     * A constructor to constrict an object.
     *
     * @param message a customized message for the exception.
     */
    public QuestionNotFoundException(String message) {
        super(Code.QUESTION_NOT_FOUND, message);
    }
}
