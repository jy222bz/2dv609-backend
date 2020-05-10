package se.lnu.ems.backend.controllers.api.question;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import exceptions.BadRequestException;
import exceptions.InternalServerErrorException;


public class QuestionExceptionController {
	
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<?> internalServerErrorException(InternalServerErrorException e){
		return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> badRequestException(BadRequestException e){
		return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.BAD_REQUEST);
	}

}
