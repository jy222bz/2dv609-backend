package se.lnu.ems.backend.exceptions.input;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.lnu.ems.backend.exceptions.BaseException;
import se.lnu.ems.backend.exceptions.Classification;

/**
 * A class for InputException.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InputException extends BaseException {

    /**
     * A constructor to construct an object.
     */
    public InputException() {
        super(Classification.INPUT_INVALID);
    }

    /**
     * A constructor to construct an object.
     *
     * @param message a customized message for the exception.
     */
    public InputException(String message) {
        super(Classification.INPUT_INVALID, message);
    }
}
