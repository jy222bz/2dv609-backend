package se.lnu.ems.backend.controllers.api.exams;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import se.lnu.ems.backend.models.Error;
import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.services.exams.exceptions.BadRequestException;
import se.lnu.ems.backend.services.exams.exceptions.InternalServerErrorException;

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
