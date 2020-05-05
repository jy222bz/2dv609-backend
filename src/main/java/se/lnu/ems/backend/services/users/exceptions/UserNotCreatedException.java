package se.lnu.ems.backend.services.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;

/**
 * A class for UserNotFoundException.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotCreatedException extends BaseException {

    /**
     * A constructor to construct an object.
     */
    public UserNotCreatedException() {
        super(Code.USER_COULD_NOT_BE_CREATED);
    }

    /**
     * A constructor to construct an object.
     *
     * @param message a customized message for the exception.
     */
    public UserNotCreatedException(String message) {
        super(Code.USER_COULD_NOT_BE_CREATED, message);
    }
}
