package se.lnu.ems.backend.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se.lnu.ems.backend.models.Role;
import se.lnu.ems.backend.repositories.RolesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A class for the Roles Service.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
@Service
public class RolesService {

    /**
     * A private field for the roles repository.
     */
    private final RolesRepository rolesRepository;

    /**
     * A constructor, to construct an object.
     *
     * @param rolesRepository the role repository.
     */
    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    /**
     * It retrieves the roles.
     *
     * @param pageable pageable.
     * @return List<Role>
     */
    public List<Role> retrieve(Pageable pageable) {
        var list = new ArrayList<Role>();
        rolesRepository.findAll(pageable).forEach(list::add);
        return list;
    }

    /**
     * It finds the role by the id.
     *
     * @param id the id of the role.
     * @return Optional<Role>
     */
    public Optional<Role> findById(Long id) {
        return rolesRepository.findById(id);
    }
}
