package se.lnu.ems.backend.controllers.api.questions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import se.lnu.ems.backend.errors.Error;
import se.lnu.ems.backend.errors.base.BadRequestException;
import se.lnu.ems.backend.services.questions.exceptions.QuestionNotFoundException;

/**
 * The type Questions controller advice.
 */
public class QuestionsControllerAdvice {

    /**
     * Internal server error exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(QuestionNotFoundException.class)
    public ResponseEntity<Error> questionNotFound(QuestionNotFoundException e) {
        return new ResponseEntity<>(new Error(e.getCode(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    /**
     * Bad request exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Error> badRequestException(BadRequestException e) {
        return new ResponseEntity<>(new Error(e.getCode(), e.getMessage(), e.getErrorList()), HttpStatus.BAD_REQUEST);
    }
}
