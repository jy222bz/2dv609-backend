package se.lnu.ems.backend.controllers.api.users;


import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.lnu.ems.backend.controllers.api.users.input.CreateInput;
import se.lnu.ems.backend.controllers.api.users.input.RetrieveInput;

import se.lnu.ems.backend.controllers.api.users.input.UpdateInput;
import se.lnu.ems.backend.exceptions.input.InputException;
import se.lnu.ems.backend.exceptions.role.RoleNotFoundException;
import se.lnu.ems.backend.exceptions.user.UserNotCreatedException;
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
     * A private field for the conversion service.
     */
    private final ConversionService conversionService;

    /**
     * A constructor, to construct an object.
     *
     * @param usersService      the users service.
     * @param rolesService      the roles service.
     * @param conversionService the conversion service.
     */
    public UsersController(UsersService usersService, RolesService rolesService, ConversionService conversionService) {
        this.usersService = usersService;
        this.rolesService = rolesService;
        this.conversionService = conversionService;
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
            throw new InputException();
        }
        Optional<Role> role = rolesService.findById(input.getRoleId());
        if (role.isEmpty()) {
            throw new RoleNotFoundException();
        }
        User user = conversionService.convert(input, User.class);
        if (user == null) {
            throw new UserNotCreatedException();
        }
        user.setRole(role.get());
        return usersService.create(user);
    }

    /**
     * It updates the user.
     *
     * @param input  the user data.
     * @param result the binding result.
     * @return Object the updated user.
     */
    @PutMapping(value = "{id}", consumes = "application/json")
    public Object update(@RequestBody @Valid UpdateInput input, BindingResult result, @PathVariable @Valid Long id) {
        if (result.hasErrors()) {
            throw new InputException();
        }
        Optional<Role> role = rolesService.findById(input.getRoleId());
        Optional<User> user = usersService.findById(id);
        if (role.isEmpty()) {
            throw new RoleNotFoundException();
        }
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        User updatedUser = userManager.updateUser(input, user.get(), role.get());
        usersService.update(updatedUser);
        return updatedUser;
    }

    /**
     * It deletes the user.
     *
     * @param result the binding result.
     */
    @DeleteMapping(value = "{id}", consumes = "application/json")
    public void delete(BindingResult result, @PathVariable @Valid Long id) {
        if (result.hasErrors()) {
            throw new InputException();
        }
        Optional<User> user = usersService.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }
        usersService.delete(user.get());
    }
}
