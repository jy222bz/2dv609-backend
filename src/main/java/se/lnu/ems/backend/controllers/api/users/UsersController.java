package se.lnu.ems.backend.controllers.api.users;


import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.lnu.ems.backend.controllers.api.users.dto.UserDTO;
import se.lnu.ems.backend.controllers.api.users.input.CreateInput;
import se.lnu.ems.backend.controllers.api.users.input.PasswordInput;
import se.lnu.ems.backend.controllers.api.users.input.RetrieveInput;
import se.lnu.ems.backend.controllers.api.users.input.UpdateInput;
import se.lnu.ems.backend.errors.common.BadRequestException;
import se.lnu.ems.backend.models.User;
import se.lnu.ems.backend.services.common.EntitySpecification;
import se.lnu.ems.backend.services.common.search.SearchCriteria;
import se.lnu.ems.backend.services.common.search.SearchOperation;
import se.lnu.ems.backend.services.roles.IRolesService;
import se.lnu.ems.backend.services.users.IUsersService;
import se.lnu.ems.backend.services.users.exceptions.UserNotCreatedException;

import javax.validation.Valid;

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


    private final PasswordEncoder passwordEncoder;

    /**
     * A constructor, to construct an object.
     *
     * @param usersService      the users service.
     * @param rolesService      the roles service.
     * @param conversionService the conversion service.
     */
    public UsersController(IUsersService usersService, IRolesService rolesService, ConversionService conversionService,
                           PasswordEncoder passwordEncoder
    ) {
        this.usersService = usersService;
        this.rolesService = rolesService;
        this.conversionService = conversionService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * It retrieves the user[s].
     *
     * @param input  the user input.
     * @param result the binding result.
     * @return Object. object
     */
    @GetMapping("")
    public Page<UserDTO> get(@Valid RetrieveInput input, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        EntitySpecification<User> specification = new EntitySpecification<>();
        specification.setOperator(EntitySpecification.Operator.OR);
        specification.addIfValueNotEmpty(new SearchCriteria("firstName", input.getFilterValue(), SearchOperation.MATCH));
        specification.addIfValueNotEmpty(new SearchCriteria("lastName", input.getFilterValue(), SearchOperation.MATCH));
        return usersService.retrieve(specification, PageRequest.of(input.getPageIndex(), input.getPageSize()))
                .map(user -> conversionService.convert(user, UserDTO.class));
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
        user.setPassword(passwordEncoder.encode(input.getPassword()));
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
        user.setEmail(input.getEmail());
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setNote(input.getNote());
        return conversionService.convert(usersService.update(user), UserDTO.class);
    }

    @PutMapping(value = "/{id}/password", consumes = "application/json")
    public Object updatePassword(@RequestBody @Valid PasswordInput input, BindingResult result, @PathVariable @Valid Long id) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        User user = usersService.findById(id);
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        return conversionService.convert(usersService.update(user), UserDTO.class);
    }

    /**
     * It deletes the user.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Valid Long id) {
        usersService.delete(usersService.findById(id));
    }
}
