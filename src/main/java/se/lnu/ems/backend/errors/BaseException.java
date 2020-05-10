package se.lnu.ems.backend.errors;


/**
 * An interface for the base exception.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
public class BaseException extends RuntimeException {
    /**
     * A private field for the code of the exception.
     */
    private final int code;

    /**
     * Instantiates a new Base exception.
     *
     * @param code the code
     */
    public BaseException(Code code) {
        this(code, code.getMessage());
    }

    /**
     * Instantiates a new Base exception.
     *
     * @param code    the code
     * @param message the message
     */
    public BaseException(Code code, String message) {
        this(code.getValue(), message);
    }

    /**
     * A constructor, to construct an object.
     *
     * @param code    exception code.
     * @param message a customized message for the exception.
     */
    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * It returns the code of the exception.
     *
     * @return int code
     */
    public int getCode() {
        return code;
    }
}
