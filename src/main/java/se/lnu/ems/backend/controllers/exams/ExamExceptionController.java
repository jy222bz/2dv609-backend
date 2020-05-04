package se.lnu.ems.backend.controllers.exams;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import exceptions.BadRequestException;
import exceptions.InternalServerErrorException;
import se.lnu.ems.backend.models.Error;
import se.lnu.ems.backend.models.Exam;

@ControllerAdvice
public class ExamExceptionController {
	
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<?> internalServerErrorException(InternalServerErrorException e){
		return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> badRequestException(BadRequestException e){
		return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
}
