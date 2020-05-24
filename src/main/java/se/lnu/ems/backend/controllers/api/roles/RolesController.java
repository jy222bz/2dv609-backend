package se.lnu.ems.backend.controllers.api.roles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lnu.ems.backend.services.roles.IRolesService;

/**
 * A class for the users controller.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
@RestController("RolesController")
@RequestMapping("/api/v1/roles")
public class RolesController {

    /**
     * A private for the roles service.
     */
    private final IRolesService rolesService;

    /**
     * A constructor, to construct an object.
     *
     * @param rolesService the roles service.
     */
    public RolesController(IRolesService rolesService) {
        this.rolesService = rolesService;
    }

    /**
     * It retrieves the roles.
     *
     * @return Object. object
     */
    @GetMapping("")
    public Object get() {
        return rolesService.retrieve();
    }
}
