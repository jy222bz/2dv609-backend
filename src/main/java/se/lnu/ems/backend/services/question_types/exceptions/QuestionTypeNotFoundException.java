package se.lnu.ems.backend.services.question_types.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;

/**
 * A class for RoleNotFoundException.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class QuestionTypeNotFoundException extends BaseException {

    /**
     * A constructor to construct an object.
     */
    public QuestionTypeNotFoundException() {
        this(Code.QUESTION_TYPE_NOT_FOUND.getMessage());
    }

    /**
     * A constructor to construct an object.
     *
     * @param message a customized message for the exception.
     */
    public QuestionTypeNotFoundException(String message) {
        super(Code.QUESTION_TYPE_NOT_FOUND, message);
    }
}
