package se.lnu.ems.backend.exceptions;

/**
 * A class for the classifications.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
public enum Classification {

    INPUT_INVALID(-1000, "Invalid input"),
    USER_NOT_FOUND(-5000, "The user is not found!"),
    USER_COULD_NOT_BE_CREATED(-5001, "The user could not created!"),
    ROLE_NOT_FOUND(-6000, "The role is not found!");

    /**
     * A private field for the description.
     */
    private final String desc;

    /**
     * A private field for the code.
     */
    private final int code;

    /**
     * A constructor to construct the object.
     *
     * @param desc desc.
     */
    Classification(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * It returns the description.
     *
     * @return String
     */
    public String getDescription() {
        return desc;
    }

    /**
     * It returns the code.
     *
     * @return int
     */
    public int getCode() {
        return code;
    }
}
