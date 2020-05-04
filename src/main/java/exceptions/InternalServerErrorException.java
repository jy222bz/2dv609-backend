package exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends Exception{

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 952414179381562557L;

	public InternalServerErrorException(String msg) {
		super(msg);
	}
	
}
