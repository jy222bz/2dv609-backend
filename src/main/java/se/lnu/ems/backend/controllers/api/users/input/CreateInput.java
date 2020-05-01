package se.lnu.ems.backend.controllers.api.users.input;

import javax.validation.constraints.*;

public class CreateInput {
    @NotNull
    @Email
    private String email;

    @NotNull
    @NotEmpty()
    @Size(min = 8, max = 255)
    private String password;

    @NotNull
    @NotEmpty()
    @Size(min = 1, max = 255)
    private String firstName;

    @NotNull
    @NotEmpty()
    @Size(min = 1, max = 255)
    private String lastName;

    private int role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
