package se.lnu.ems.backend.exceptions;


/**
 * An interface for the base exception.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
public class BaseException extends RuntimeException {
    private final int code;

    /**
     * A private field for the description.
     */
    private final String description;

    /**
     * A constructor to construct an Exception Object.
     *
     * @param classification the classification of the exception.
     */
    public BaseException(Classification classification) {
        super(classification.getDescription());
        this.code = classification.getCode();
        this.description = classification.getDescription();
    }

    public BaseException(Classification classification, String description) {
        super(classification.getDescription());
        this.code = classification.getCode();
        this.description = description;
    }

    /**
     * It returns the description.
     *
     * @return String.
     */
    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }
}
