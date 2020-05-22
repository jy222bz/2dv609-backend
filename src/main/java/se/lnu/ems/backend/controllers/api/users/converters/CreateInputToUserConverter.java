package se.lnu.ems.backend.controllers.api.users.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import se.lnu.ems.backend.controllers.api.users.input.CreateInput;
import se.lnu.ems.backend.models.User;

import java.util.Date;

/**
 * A class for the users, it converts the input into a user.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
@Component
public class CreateInputToUserConverter implements Converter<CreateInput, User> {

    /**
     * It takes the create input to convert a new user and returns it.
     *
     * @param input the create input.
     * @return User
     */
    @Override
    public User convert(CreateInput input) {
        User user = new User();
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setEmail(input.getEmail());
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        user.setNote(input.getNote());
        return user;
    }
}
