package se.lnu.ems.backend.controllers.api.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lnu.ems.backend.errors.Error;
import se.lnu.ems.backend.services.users.exceptions.UserAlreadyExistsException;
import se.lnu.ems.backend.services.users.exceptions.UserNotFoundException;

/**
 * The type User controller advice.
 */
@ControllerAdvice(basePackageClasses = UsersController.class)
@RequestMapping(produces = "application/json")
public class UsersAdvice {

    /**
     * User not found exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> userNotFoundException(final UserNotFoundException e) {
        return new ResponseEntity<>(new Error(e.getCode(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Error> userAlreadyExists(final UserAlreadyExistsException e) {
        return new ResponseEntity<>(new Error(e.getCode(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
