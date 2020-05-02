package se.lnu.ems.backend.controllers.api.users.input;

/**
 * A class for the delete input.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
public class DeleteInput {


    /**
     * A private field for the id of the user.
     */
    private long id;

    /**
     * It returns the user id.
     *
     * @return Long.
     */
    public long getUserId() {
        return id;
    }

    /**
     * It sets the id.
     *
     * @param id the id of the user.
     */
    public void setId(long id) {
        this.id = id;
    }
}
