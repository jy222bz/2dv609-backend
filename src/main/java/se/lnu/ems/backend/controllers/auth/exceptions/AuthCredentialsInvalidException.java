package se.lnu.ems.backend.controllers.auth.exceptions;

import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;

/**
 * The type Auth credentials invalid exception.
 */
public class AuthCredentialsInvalidException extends BaseException {

    /**
     * Instantiates a new Input exception.
     */
    public AuthCredentialsInvalidException() {
        this(Code.AUTH_CREDENTIALS_INVALID.getMessage());
    }

    /**
     * Instantiates a new Input exception.
     *
     * @param message the message
     */
    public AuthCredentialsInvalidException(String message) {
        super(Code.AUTH_CREDENTIALS_INVALID, message);
    }
}
