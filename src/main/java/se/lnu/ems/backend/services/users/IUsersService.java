package se.lnu.ems.backend.services.users;

import org.springframework.data.domain.Pageable;
import se.lnu.ems.backend.models.User;

import java.util.List;

/**
 * A class for the Users Service.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
public interface IUsersService {
    /**
     * It retrieves and returns the users.
     *
     * @param pageable pageable.
     * @return List<User> list
     */
    List<User> retrieve(Pageable pageable);

    /**
     * It finds the user by the id.
     *
     * @param id the id of the user.
     * @return User user
     */
    User findById(Long id);

    /**
     * It creates the user in the repository.
     *
     * @param user the user.
     * @return User. user
     */
    User create(User user);

    /**
     * It deletes the user from the repository.
     *
     * @param user the user.
     */
    void delete(User user);

    /**
     * It updates the user.
     *
     * @param user the user.
     */
    User update(User user);
}
