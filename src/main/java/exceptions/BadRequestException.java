package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception{

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = -4683589242203615733L;

	public BadRequestException(String msg) {
		super(msg);
	}
}