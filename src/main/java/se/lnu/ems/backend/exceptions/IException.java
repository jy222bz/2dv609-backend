package se.lnu.ems.backend.exceptions;

/**
 * An interface for the exceptions.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
public interface IException {

    /**
     * It returns the classification.
     *
     * @return the code
     */
    Classification getClassification();

    /**
     * It returns the message.
     *
     * @return the message
     */
    String getMessage();
}
