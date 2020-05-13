package se.lnu.ems.backend.services.questions.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends BaseException{

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 952414179381562557L;

	public InternalServerErrorException(String msg) {
		super(Code.EXAM_NOT_FOUND.getValue(), msg);
	}
	
}
