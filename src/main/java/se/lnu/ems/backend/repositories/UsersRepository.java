package se.lnu.ems.backend.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import se.lnu.ems.backend.models.User;

/**
 * An interface for the Users Repository.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
public interface UsersRepository extends PagingAndSortingRepository<User, Long> {

}
