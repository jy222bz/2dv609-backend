package se.lnu.ems.backend.http;

/**
 * A class for the HTTP Codes.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
public enum HTTPCode {

    CREATED("201"),
    OKAY("200");

    /**
     * A private field for the code.
     */
    private final String code;

    /**
     * A constructor to construct the object.
     *
     * @param code  code.
     */
    HTTPCode(String code) {
        this.code = code;
    }

    /**
     * It returns the code.
     *
     * @return String.
     */
    public String getCode() {
        return code;
    }
}
