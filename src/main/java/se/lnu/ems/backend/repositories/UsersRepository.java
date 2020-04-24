package se.lnu.ems.backend.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import se.lnu.ems.backend.models.User;

public interface UsersRepository extends PagingAndSortingRepository<User, Long> {

}
