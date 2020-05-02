package se.lnu.ems.backend.controllers.api.role;

import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lnu.ems.backend.controllers.api.role.input.RetrieveInput;
import se.lnu.ems.backend.services.RolesService;

import javax.validation.Valid;

/**
 * A class for the users controller.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
@RestController("RolesController")
@RequestMapping("/api/v1/roles")
public class RolesController {

    /**
     * A private for the roles service.
     */
    private final RolesService rolesService;

    /**
     * A constructor, to construct an object.
     *
     * @param rolesService the roles service.
     */
    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    /**
     * It retrieves the roles.
     *
     * @param input  the input.
     * @param result the result.
     * @return Object.
     */
    @GetMapping("")
    public Object get(@Valid RetrieveInput input, BindingResult result) {
        if (result.hasErrors()) {
            return result.getAllErrors();
        }
        return rolesService.retrieve(PageRequest.of(input.getPageIndex(), input.getPageSize()));
    }
}
