package se.lnu.ems.backend.controllers.api.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lnu.ems.backend.errors.Error;
import se.lnu.ems.backend.errors.base.InputException;
import se.lnu.ems.backend.services.users.exceptions.UserNotFoundException;

/**
 * The type User controller advice.
 */
@ControllerAdvice(basePackageClasses = UsersController.class)
@RequestMapping(produces = "application/json")
public class UserControllerAdvice {

    /**
     * Input exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(InputException.class)
    public ResponseEntity<Error> inputException(final InputException e) {
        return new ResponseEntity<>(new Error(e.getCode(), e.getMessage(), e.getErrorList()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> userNotFoundException(final UserNotFoundException e) {
        return new ResponseEntity<>(new Error(e.getCode(), e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
