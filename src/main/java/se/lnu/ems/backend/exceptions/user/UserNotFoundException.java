package se.lnu.ems.backend.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.lnu.ems.backend.exceptions.BaseException;
import se.lnu.ems.backend.exceptions.Classification;

/**
 * A class for UserNotFoundException.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends BaseException {

    /**
     * A constructor to constrict an object.
     */
    public UserNotFoundException() {
        super(Classification.USER_NOT_FOUND);
    }

    /**
     * A constructor to constrict an object.
     *
     * @param message a customized message for the exception.
     */
    public UserNotFoundException(String message) {
        super(Classification.USER_NOT_FOUND, message);
    }
}
