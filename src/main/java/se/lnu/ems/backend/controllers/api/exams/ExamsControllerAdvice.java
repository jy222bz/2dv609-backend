package se.lnu.ems.backend.controllers.api.exams;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import se.lnu.ems.backend.errors.base.BadRequestException;
import se.lnu.ems.backend.services.exams.exceptions.ExamNotFoundException;

/**
 * The type Exams controller advice.
 */
@ControllerAdvice
public class ExamsControllerAdvice {

    /**
     * Exam not found exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(ExamNotFoundException.class)
    public ResponseEntity<Error> examNotFoundException(ExamNotFoundException e) {
        return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Bad request exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Error> badRequestException(BadRequestException e) {
        return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
