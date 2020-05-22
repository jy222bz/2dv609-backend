package se.lnu.ems.backend.errors.common;

import org.springframework.validation.ObjectError;
import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for InputException.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
public class BadRequestException extends BaseException {
    private final List<ObjectError> errorList;

    /**
     * A constructor to construct an object.
     *
     * @param message a customized message for the exception.
     */
    public BadRequestException(String message) {
        this(message, new ArrayList<>());
    }

    /**
     * Instantiates a new Input exception.
     *
     * @param errorList the error list
     */
    public BadRequestException(List<ObjectError> errorList) {
        this(Code.INPUT_INVALID.getMessage(), errorList);
    }

    /**
     * Instantiates a new Input exception.
     *
     * @param message   the message
     * @param errorList the error list
     */
    public BadRequestException(String message, List<ObjectError> errorList) {
        super(Code.INPUT_INVALID, message);
        this.errorList = errorList;
    }

    /**
     * Gets error list.
     *
     * @return the error list
     */
    public List<ObjectError> getErrorList() {
        return errorList;
    }
}
