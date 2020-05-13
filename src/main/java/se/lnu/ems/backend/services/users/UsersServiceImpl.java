package se.lnu.ems.backend.services.users;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se.lnu.ems.backend.models.User;
import se.lnu.ems.backend.repositories.UsersRepository;
import se.lnu.ems.backend.services.users.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for the Users Service.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
@Service
public class UsersServiceImpl implements IUsersService {

    /**
     * A private field for the user repository.
     */
    private final UsersRepository usersRepository;

    /**
     * A constructor, to construct an object.
     *
     * @param usersRepository the user repository.
     */
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * It retrieves and returns the users.
     *
     * @param pageable pageable.
     * @return List<User>
     */
    @Override
    public List<User> retrieve(Pageable pageable) {
        var list = new ArrayList<User>();
        usersRepository.findAll(pageable).forEach(list::add);
        return list;
    }

    /**
     * It finds the user by the id.
     *
     * @param id the id of the user.
     * @return User
     */
    @Override
    public User findById(Long id) {
        return usersRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    /**
     * It creates the user in the repository.
     *
     * @param user the user.
     * @return User.
     */
    @Override
    public User create(User user) {
        return usersRepository.save(user);
    }

    /**
     * It deletes the user from the repository.
     *
     * @param user the user.
     */
    @Override
    public void delete(User user) {
        usersRepository.delete(user);
    }

    /**
     * It updates the user.
     *
     * @param user the user.
     */
    @Override
    public void update(User user) {
        usersRepository.save(user);
    }
}
