package se.lnu.ems.backend.services.roles.exceptions;

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
public class RoleNotFoundException extends BaseException {

    /**
     * A constructor to construct an object.
     */
    public RoleNotFoundException() {
        this(Code.ROLE_NOT_FOUND.getMessage());
    }

    /**
     * A constructor to construct an object.
     *
     * @param message a customized message for the exception.
     */
    public RoleNotFoundException(String message) {
        super(Code.ROLE_NOT_FOUND, message);
    }
}
