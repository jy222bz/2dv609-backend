package se.lnu.ems.backend.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.lnu.ems.backend.exceptions.BaseException;
import se.lnu.ems.backend.exceptions.Classification;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends BaseException {

    public UserNotFoundException() {
        super(Classification.USER_NOT_FOUND);
    }

    public UserNotFoundException(String message) {
        super(Classification.USER_NOT_FOUND, message);
    }
}
