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
     * The User already exists.
     */
    USER_ALREADY_EXISTS(-5002, "The user already exits!"),

    /**
     * The Role not found.
     */
    ROLE_NOT_FOUND(-6000, "The role is not found!"),

    /**
     * Exam not found
     */
    EXAM_NOT_FOUND(-7000, "The exam does not exist."),
    /**
     * The Exam end date invalid.
     */
    EXAM_END_DATE_INVALID(-7001, "The exam has an invalid end date."),
    /**
     * The Exam student not found.
     */
    EXAM_STUDENT_NOT_FOUND(-7101, "The student does not exist."),

    /**
     * The Question not found.
     */
    QUESTION_NOT_FOUND(-8000, "The question does not exist."),
    /**
     * The Question choice not found.
     */
    QUESTION_CHOICE_NOT_FOUND(-8100, "The question choice does not exist."),

    /**
     * The Auth credentials invalid.
     */
    AUTH_CREDENTIALS_INVALID(-9000, "Invalid credentials provided"),

    /**
     * The Auth user disabled.
     */
    AUTH_USER_DISABLED(-9001, "User is disabled"),

    /**
     * The Auth unauthenticated.
     */
    AUTH_UNAUTHENTICATED(-9002, "User is unauthenticated"),

    /**
     * The Question type not found.
     */
    QUESTION_TYPE_NOT_FOUND(-10000, "The question type is not found!"),

    ;

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
