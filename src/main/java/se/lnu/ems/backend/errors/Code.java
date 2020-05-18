package se.lnu.ems.backend.errors;

/**
 * A class for the error codes.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
public enum Code {

    /**
     * The Input invalid.
     */
    INPUT_INVALID(-1000, "Invalid input"),
    /**
     * The User not found.
     */
    USER_NOT_FOUND(-5000, "The user is not found!"),
    /**
     * The User could not be created.
     */
    USER_COULD_NOT_BE_CREATED(-5001, "The user could not created!"),
    /**
     * The Role not found.
     */
    ROLE_NOT_FOUND(-6000, "The role is not found!"),

	/**
	 * Exam not found
	 */
	EXAM_NOT_FOUND(-7000, "The exam does not exist."),


	QUESTION_NOT_FOUND(-8000, "The question does not exist.");

    /**
     * A private field for the message.
     */
    private final String message;

    /**
     * A private field for the code.
     */
    private final int value;

    /**
     * A constructor to construct the object.
     *
     * @param value   numeric code.
     * @param message message.
     */
    Code(int value, String message) {
        this.value = value;
        this.message = message;
    }

    /**
     * It returns the message.
     *
     * @return String message
     */
    public String getMessage() {
        return message;
    }

    /**
     * It returns the code.
     *
     * @return int value
     */
    public int getValue() {
        return value;
    }
}
