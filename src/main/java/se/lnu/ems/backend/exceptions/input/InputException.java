package se.lnu.ems.backend.exceptions.input;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.lnu.ems.backend.exceptions.BaseException;
import se.lnu.ems.backend.exceptions.Classification;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InputException extends BaseException {

    public InputException() {
        super(Classification.INPUT_INVALID);
    }

    public InputException(String message) {
        super(Classification.INPUT_INVALID, message);
    }
}
