package se.lnu.ems.backend.controllers.api.users;


import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.lnu.ems.backend.controllers.api.users.dto.UserDTO;
import se.lnu.ems.backend.controllers.api.users.input.CreateInput;
import se.lnu.ems.backend.controllers.api.users.input.RetrieveInput;
import se.lnu.ems.backend.controllers.api.users.input.UpdateInput;
import se.lnu.ems.backend.errors.base.BadRequestException;
import se.lnu.ems.backend.models.User;
import se.lnu.ems.backend.services.roles.IRolesService;
import se.lnu.ems.backend.services.users.IUsersService;
import se.lnu.ems.backend.services.users.exceptions.UserNotCreatedException;

import javax.validation.Valid;
import java.util.List;

/**
 * A class for the users controller.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
@RestController("UsersController")
@RequestMapping("/api/v1/users")
public class UsersController {

    /**
     * A private field for the UserService.
     */
    private final IUsersService usersService;

    /**
     * A private field for the roles service.
     */
    private final IRolesService rolesService;

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
    public UsersController(IUsersService usersService, IRolesService rolesService, ConversionService conversionService) {
        this.usersService = usersService;
        this.rolesService = rolesService;
        this.conversionService = conversionService;
    }

    /**
     * It retrieves the user[s].
     *
     * @param input  the user input.
     * @param result the binding result.
     * @return Object. object
     */
    @GetMapping("")
    public Object get(@Valid RetrieveInput input, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        List<User> users = usersService.retrieve(PageRequest.of(input.getPageIndex(), input.getPageSize()));
        return conversionService.convert(users,
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserDTO.class))
        );
    }

    /**
     * It creates a new user.
     *
     * @param input  the user data.
     * @param result the binding result.
     * @return Object. user
     */
    @PostMapping(value = "", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody @Valid CreateInput input, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        User user = conversionService.convert(input, User.class);
        if (user == null) {
            throw new UserNotCreatedException();
        }
        user.setRole(rolesService.findById(input.getRoleId()));
        return usersService.create(user);
    }

    /**
     * It updates the user.
     *
     * @param input  the user data.
     * @param result the binding result.
     * @param id     the id
     * @return Object the updated user.
     */
    @PutMapping(value = "/{id}", consumes = "application/json")
    public Object update(@RequestBody @Valid UpdateInput input, BindingResult result, @PathVariable @Valid Long id) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        User user = usersService.findById(id);
        user.setRole(rolesService.findById(input.getRoleId()));

        //User user = userManager.updateUser(input, user, );
        return usersService.update(user);
    }

    /**
     * It deletes the user.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Valid Long id) {
        usersService.delete(usersService.findById(id));
    }
}
