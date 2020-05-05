package se.lnu.ems.backend.services.users.exceptions;

import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;

/**
 * A class for UserNotFoundException.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
public class UserNotFoundException extends BaseException {

    /**
     * A constructor to constrict an object.
     */
    public UserNotFoundException() {
        super(Code.USER_NOT_FOUND);
    }

    /**
     * A constructor to constrict an object.
     *
     * @param message a customized message for the exception.
     */
    public UserNotFoundException(String message) {
        super(Code.USER_NOT_FOUND, message);
    }
}
