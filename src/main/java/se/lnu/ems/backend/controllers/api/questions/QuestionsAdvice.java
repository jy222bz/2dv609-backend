package se.lnu.ems.backend.controllers.api.questions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lnu.ems.backend.errors.Error;
import se.lnu.ems.backend.services.questions.exceptions.QuestionNotFoundException;

/**
 * The type Questions controller advice.
 */
@ControllerAdvice(basePackageClasses = QuestionsController.class)
@RequestMapping(produces = "application/json")
public class QuestionsAdvice {

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
}
