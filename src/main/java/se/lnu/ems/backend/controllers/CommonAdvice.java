package se.lnu.ems.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lnu.ems.backend.errors.Error;
import se.lnu.ems.backend.errors.common.BadRequestException;

/**
 * The type controller advice.
 */
@ControllerAdvice
@RequestMapping(produces = "application/json")
public class CommonAdvice {
    /**
     * Input exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Error> badRequest(final BadRequestException e) {
        return new ResponseEntity<>(new Error(e.getCode(), e.getMessage(), e.getErrorList()),
                HttpStatus.BAD_REQUEST);
    }
}
