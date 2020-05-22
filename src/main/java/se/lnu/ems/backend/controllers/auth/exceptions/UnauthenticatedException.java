package se.lnu.ems.backend.controllers.auth.exceptions;

import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;

/**
 * The type Auth user disabled exception.
 */
public class UnauthenticatedException extends BaseException {

    /**
     * Instantiates a new Input exception.
     */
    public UnauthenticatedException() {
        this(Code.AUTH_UNAUTHENTICATED.getMessage());
    }

    /**
     * Instantiates a new Input exception.
     *
     * @param message the message
     */
    public UnauthenticatedException(String message) {
        super(Code.AUTH_UNAUTHENTICATED, message);
    }
}
