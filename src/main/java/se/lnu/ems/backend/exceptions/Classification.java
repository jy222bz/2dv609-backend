package se.lnu.ems.backend.exceptions;

/**
 * A class for the classifications.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
public enum Classification {

    NO_SUCH_USER("The user is not found!"),
    NO_SUCH_ROLE("The role is not found!");


    /**
     * A private field for the description.
     */
    private final String desc;


    /**
     * A constructor to construct the object.
     *
     * @param desc desc.
     */
    Classification(String desc) {
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
}
