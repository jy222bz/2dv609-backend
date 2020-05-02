package se.lnu.ems.backend.models;

import se.lnu.ems.backend.controllers.api.users.input.CreateInput;
import se.lnu.ems.backend.controllers.api.users.input.UpdateInput;

import java.util.Date;

/**
 * A class for creating and updating users.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
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
     * @return UserFactory
     */
    public static UserManager getInstance() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }

    /**
     * It takes the create input to create a new user and returns it.
     *
     * @param input the create input.
     * @param role  the role of the user.
     * @return User
     */
    public User createUser(CreateInput input, Role role) {
        User user = new User();
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setRole(role);
        user.setEmail(input.getEmail());
        user.setPassword(input.getPassword());
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        user.setNote(input.getNote());
        return user;
    }


    /**
     * It updates the user.
     *
     * @param input update input.
     * @param user  the user.
     * @param role  the role of the user.
     * @return the updates user.
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
