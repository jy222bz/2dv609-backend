package se.lnu.ems.backend.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import se.lnu.ems.backend.models.Role;

/**
 * An interface for the Roles Repository.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
public interface RolesRepository extends PagingAndSortingRepository<Role, Long> {

}
