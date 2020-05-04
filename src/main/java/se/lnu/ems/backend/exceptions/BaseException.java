package se.lnu.ems.backend.exceptions;


/**
 * An interface for the base exception.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
public class BaseException extends RuntimeException {
    /**
     * A private field for the code of the exception.
     */
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

    /**
     * A constructor, to construct an object.
     *
     * @param classification the classification of the exception.
     * @param description    a customized message for the exception.
     */
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

    /**
     * It returns the code of the exception.
     *
     * @return int
     */
    public int getCode() {
        return code;
    }
}
