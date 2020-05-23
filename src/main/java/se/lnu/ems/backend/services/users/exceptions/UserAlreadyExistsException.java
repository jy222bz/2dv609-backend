package se.lnu.ems.backend.services.users.exceptions;

import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;

/**
 * A class for UserAlreadyExistsException.
 *
 * @author Osama Zarraa
 * @version 1.0
 * @since 2020 -05-01
 */
public class UserAlreadyExistsException extends BaseException {

    /**
     * A constructor to constrict an object.
     */
    public UserAlreadyExistsException() {
        super(Code.USER_ALREADY_EXISTS);
    }

    /**
     * A constructor to constrict an object.
     *
     * @param message a customized message for the exception.
     */
    public UserAlreadyExistsException(String message) {
        super(Code.USER_ALREADY_EXISTS, message);
    }
}
