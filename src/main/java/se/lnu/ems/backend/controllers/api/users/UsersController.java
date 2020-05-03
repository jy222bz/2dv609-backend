package se.lnu.ems.backend.controllers.api.users;


import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.lnu.ems.backend.controllers.api.users.input.CreateInput;
import se.lnu.ems.backend.controllers.api.users.input.RetrieveInput;

import se.lnu.ems.backend.controllers.api.users.input.UpdateInput;
import se.lnu.ems.backend.exceptions.input.InputException;
import se.lnu.ems.backend.exceptions.role.RoleNotFoundException;
import se.lnu.ems.backend.exceptions.user.UserNotFoundException;
import se.lnu.ems.backend.models.Role;
import se.lnu.ems.backend.models.User;
import se.lnu.ems.backend.models.UserManager;
import se.lnu.ems.backend.services.RolesService;
import se.lnu.ems.backend.services.UsersService;

import javax.validation.Valid;
import java.util.Optional;

/**
 * A class for the users controller.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
 */
@RestController("UsersController")
@RequestMapping("/api/v1/users")
public class UsersController {

    /**
     * A private field for the UserService.
     */
    private final UsersService usersService;

    /**
     * A private field for the uer manager.
     */
    private final UserManager userManager;

    /**
     * A private field for the roles service.
     */
    private final RolesService rolesService;

    /**
     * A constructor, to construct an object.
     *
     * @param usersService the users service.
     * @param rolesService the roles service.
     */
    public UsersController(UsersService usersService, RolesService rolesService) {
        this.usersService = usersService;
        this.rolesService = rolesService;
        userManager = UserManager.getInstance();
    }

    /**
     * It retrieves the user[s].
     *
     * @param input  the user input.
     * @param result the binding result.
     * @return Object.
     */
    @GetMapping("")
    public Object get(@Valid RetrieveInput input, BindingResult result) {
        if (result.hasErrors()) {
            //return result.getAllErrors();
            throw new InputException();
        }
        return usersService.retrieve(PageRequest.of(input.getPageIndex(), input.getPageSize()));
    }

    /**
     * It creates a new user.
     *
     * @param input  the user data.
     * @param result the binding result.
     * @return Object.
     */
    @PostMapping(value = "", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody @Valid CreateInput input, BindingResult result) {
        if (result.hasErrors()) {
            // return result.getAllErrors();
            throw new InputException();
        }
        Optional<Role> role = rolesService.findById(input.getRoleId());
        if (role.isEmpty()) {
            throw new RoleNotFoundException();
        }
        return usersService.create(userManager.createUser(input, role.get()));
    }

    /**
     * It updates the user.
     *
     * @param input  the user data.
     * @param result the binding result.
     */
    @PutMapping(value = "{id}", consumes = "application/json")
    public void update(@RequestBody @Valid UpdateInput input, BindingResult result, @PathVariable String id) {
        if (result.hasErrors()) {
            //return result.getAllErrors();
            throw new InputException();
        }
        Optional<Role> role = rolesService.findById(input.getRoleId());
        Optional<User> user = usersService.findById(Long.parseLong(id));
        if (role.isEmpty()) {
            throw new RoleNotFoundException();
        }
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        usersService.update(userManager.updateUser(input, user.get(), role.get()));
    }

    /**
     * It deletes the user.
     *
     * @param result the binding result.
     */
    @DeleteMapping(value = "{id}", consumes = "application/json")
    public void delete(BindingResult result, @PathVariable String id) {
        if (result.hasErrors()) {
           // return result.getAllErrors();
            throw new InputException();
        }
        Optional<User> user = usersService.findById(Long.parseLong(id));
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        usersService.delete(user.get());
    }
}
