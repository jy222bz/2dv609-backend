package se.lnu.ems.backend.services.questions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2964510673515684507L;

	public BadRequestException(String msg) {
		super(Code.INPUT_INVALID.getValue(), msg);
	}
}
