package se.lnu.ems.backend.models;

public class Error{
	public String message;
	
	public Error(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
