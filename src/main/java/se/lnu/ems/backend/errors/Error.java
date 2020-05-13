package se.lnu.ems.backend.errors;

import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Error.
 */
public class Error {
    /**
     * A private field for the code of the exception.
     */
    private int code;

    /**
     * A private field for the description.
     */
    private String description;

    private List<ObjectError> details;

    /**
     * Instantiates a new Error.
     *
     * @param code the code
     */
    public Error(int code) {
        this(code, "");
    }

    /**
     * Instantiates a new Error.
     *
     * @param code        the code
     * @param description the description
     */
    public Error(int code, String description) {
        this(code, description, new ArrayList<>());
    }

    /**
     * Instantiates a new Error.
     *
     * @param code        the code
     * @param description the description
     * @param details     the details
     */
    public Error(int code, String description, List<ObjectError> details) {
        this.code = code;
        this.description = description;
        this.details = details;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    public List<ObjectError> getDetails() {
        return details;
    }

    /**
     * Sets details.
     *
     * @param details the details
     */
    public void setDetails(List<ObjectError> details) {
        this.details = details;
    }
}