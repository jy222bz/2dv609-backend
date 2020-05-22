package se.lnu.ems.backend.controllers.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lnu.ems.backend.controllers.auth.exceptions.AuthCredentialsInvalidException;
import se.lnu.ems.backend.controllers.auth.exceptions.AuthUserDisabledException;
import se.lnu.ems.backend.controllers.auth.exceptions.UnauthenticatedException;
import se.lnu.ems.backend.errors.Error;

/**
 * The type controller advice.
 */
@ControllerAdvice
@RequestMapping(produces = "application/json")
public class AuthAdvice {

    /**
     * Auth credentials invalid response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(AuthCredentialsInvalidException.class)
    public ResponseEntity<Error> authCredentialsInvalid(final AuthCredentialsInvalidException e) {
        return new ResponseEntity<>(new Error(e.getCode(), e.getMessage()), HttpStatus.FORBIDDEN);
    }

    /**
     * Auth user disabled response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(AuthUserDisabledException.class)
    public ResponseEntity<Error> authUserDisabled(final AuthUserDisabledException e) {
        return new ResponseEntity<>(new Error(e.getCode(), e.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UnauthenticatedException.class)
    public ResponseEntity<Error> unauthenticated(final UnauthenticatedException e) {
        return new ResponseEntity<>(new Error(e.getCode(), e.getMessage()), HttpStatus.FORBIDDEN);
    }
}
