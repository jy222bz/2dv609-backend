package se.lnu.ems.backend.models;

import se.lnu.ems.backend.controllers.api.users.input.CreateInput;

import java.util.Date;

/**
 * A class for creating users.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
public class UserFactory {

    /**
     * A private field for the User factory.
     */
    private static UserFactory userFactory;

    /**
     * A private constructor, to prevent creating instances.
     */
    private UserFactory() {
    }

    /**
     * It returns the instance of the UserFactory.
     *
     * @return UserFactory
     */
    public static UserFactory getInstance() {
        if (userFactory == null) {
            userFactory = new UserFactory();
        }
        return userFactory;
    }

    /**
     * It takes the create input to create a new user and returns it.
     *
     * @param input the create input.
     * @return User
     */
    public User createUser(CreateInput input) {
        User user = new User();
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setEmail(input.getEmail());
        user.setPassword(input.getPassword());
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        return user;
    }
}
