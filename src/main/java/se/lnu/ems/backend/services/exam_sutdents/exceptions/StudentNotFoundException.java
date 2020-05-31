package se.lnu.ems.backend.services.exam_sutdents.exceptions;

import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;


/**
 * The type Student not found exception.
 */
public class StudentNotFoundException extends BaseException {


    /**
     * Instantiates a new Student not found exception.
     */
    public StudentNotFoundException() {
        super(Code.EXAM_STUDENT_NOT_FOUND);
    }

    /**
     * Instantiates a new Student not found exception.
     *
     * @param message the message
     */
    public StudentNotFoundException(String message) {
        super(Code.EXAM_STUDENT_NOT_FOUND, message);
    }
}
