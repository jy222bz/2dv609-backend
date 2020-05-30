package se.lnu.ems.backend.controllers.api.exam_students.input;

import javax.validation.constraints.NotNull;

/**
 * The type Create input.
 */
public class CreateInput {

    @NotNull
    private Long userId;


    /**
     * Gets user id.
     *
     * @return the user id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
