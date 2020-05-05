package se.lnu.ems.backend.services.roles;

import org.springframework.data.domain.Pageable;
import se.lnu.ems.backend.models.Role;

import java.util.List;

/**
 * A class for the Roles Service.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
public interface IRolesService {
    /**
     * It retrieves the roles.
     *
     * @param pageable pageable.
     * @return List<Role> list
     */
    List<Role> retrieve(Pageable pageable);

    /**
     * It finds the role by the id.
     *
     * @param id the id of the role.
     * @return Role role
     */
    Role findById(Long id);
}
