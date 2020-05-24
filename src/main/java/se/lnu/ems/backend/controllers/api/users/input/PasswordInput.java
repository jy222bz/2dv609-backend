package se.lnu.ems.backend.controllers.api.users.input;


import javax.validation.constraints.*;

/**
 * A class for the update input.
 *
 * @author Osama Zarraa
 * @version 1.0
 * @since 2020 -05-01
 */
public class PasswordInput {
    /**
     * A private field for the first name.
     */
    @NotNull
    @NotEmpty()
    @Size(min = 5, max = 255)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
