package se.lnu.ems.backend.models;

import se.lnu.ems.backend.controllers.api.users.input.UpdateInput;

import java.util.Date;

/**
 * A class for updating users.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
public class UserManager {

    /**
     * A private field for the User manager.
     */
    private static UserManager userManager;

    /**
     * A private constructor, to prevent creating instances.
     */
    private UserManager() {
    }

    /**
     * It returns the instance of the UserFactory.
     *
     * @return UserFactory instance
     */
    public static UserManager getInstance() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }

    /**
     * It updates the user.
     *
     * @param input update input.
     * @param user  the user.
     * @param role  the role of the user.
     * @return User user
     */
    public User updateUser(UpdateInput input, User user, Role role) {
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setRole(role);
        user.setEmail(input.getEmail());
        user.setPassword(input.getPassword());
        user.setUpdatedAt(new Date());
        user.setNote(input.getNote());
        return user;
    }
}
