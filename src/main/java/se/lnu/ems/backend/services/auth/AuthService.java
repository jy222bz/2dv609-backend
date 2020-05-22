package se.lnu.ems.backend.services.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lnu.ems.backend.models.User;
import se.lnu.ems.backend.models.UserPrinciple;
import se.lnu.ems.backend.repositories.UsersRepository;

/**
 * The type Auth service.
 */
@Service
@Transactional
public class AuthService implements UserDetailsService {
    private final UsersRepository usersRepository;

    /**
     * Instantiates a new Auth service.
     *
     * @param usersRepository the users repository
     */
    public AuthService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = usersRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + email);
        }
        return new UserPrinciple(user.getId(), user.getEmail(), user.getPassword(), user.getRole().getName());
    }
}
