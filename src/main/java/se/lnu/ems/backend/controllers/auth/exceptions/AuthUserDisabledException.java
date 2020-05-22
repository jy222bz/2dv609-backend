package se.lnu.ems.backend.controllers.auth.exceptions;

import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;

/**
 * The type Auth user disabled exception.
 */
public class AuthUserDisabledException extends BaseException {

    /**
     * Instantiates a new Input exception.
     */
    public AuthUserDisabledException() {
        this(Code.AUTH_USER_DISABLED.getMessage());
    }

    /**
     * Instantiates a new Input exception.
     *
     * @param message the message
     */
    public AuthUserDisabledException(String message) {
        super(Code.AUTH_USER_DISABLED, message);
    }
}
