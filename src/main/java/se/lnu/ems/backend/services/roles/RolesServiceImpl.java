package se.lnu.ems.backend.services.roles;

import org.springframework.stereotype.Service;
import se.lnu.ems.backend.models.Role;
import se.lnu.ems.backend.repositories.RolesRepository;
import se.lnu.ems.backend.services.roles.exceptions.RoleNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for the Roles Service.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
@Service
public class RolesServiceImpl implements IRolesService {

    /**
     * A private field for the roles repository.
     */
    private final RolesRepository rolesRepository;

    /**
     * A constructor, to construct an object.
     *
     * @param rolesRepository the role repository.
     */
    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    /**
     * It retrieves the roles.
     *
     * @return List<Role>
     */
    @Override
    public List<Role> retrieve() {
        var list = new ArrayList<Role>();
        rolesRepository.findAll().forEach(list::add);
        return list;
    }

    /**
     * It finds the role by the id.
     *
     * @param id the id of the role.
     * @return Role
     */
    @Override
    public Role findById(Long id) {
        return rolesRepository.findById(id).orElseThrow(RoleNotFoundException::new);
    }
}
