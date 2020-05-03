package se.lnu.ems.backend.exceptions.role;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.lnu.ems.backend.exceptions.BaseException;
import se.lnu.ems.backend.exceptions.Classification;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RoleNotFoundException extends BaseException {

    public RoleNotFoundException() {
        super(Classification.ROLE_NOT_FOUND);
    }

    public RoleNotFoundException(String message) {
        super(Classification.ROLE_NOT_FOUND, message);
    }
}
