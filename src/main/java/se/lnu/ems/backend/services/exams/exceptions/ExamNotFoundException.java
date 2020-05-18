package se.lnu.ems.backend.services.exams.exceptions;

import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;

/**
 * A class for ExamNotFoundException.
 *
 * @author Osama Zarraa
 * @version 1.0
 * @since 2020 -05-17
 */
public class ExamNotFoundException extends BaseException {

    /**
     * A constructor to constrict an object.
     */
    public ExamNotFoundException() {
        super(Code.EXAM_NOT_FOUND);
    }

    /**
     * A constructor to constrict an object.
     *
     * @param message a customized message for the exception.
     */
    public ExamNotFoundException(String message) {
        super(Code.EXAM_NOT_FOUND, message);
    }
}
