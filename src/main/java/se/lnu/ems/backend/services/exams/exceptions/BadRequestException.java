package se.lnu.ems.backend.services.exams.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import se.lnu.ems.backend.errors.BaseException;
import se.lnu.ems.backend.errors.Code;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends BaseException{

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -4683589242203615733L;

	public BadRequestException(String msg) {
		super(Code.INPUT_INVALID.getValue(), msg);
	}
}
