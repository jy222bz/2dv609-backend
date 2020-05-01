package se.lnu.ems.backend.controllers.api.users;


import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.lnu.ems.backend.controllers.api.users.input.CreateInput;
import se.lnu.ems.backend.controllers.api.users.input.RetrieveInput;
import se.lnu.ems.backend.models.User;
import se.lnu.ems.backend.services.UsersService;

import javax.validation.Valid;
import java.util.Date;

@RestController("UsersController")
@RequestMapping("/api/v1/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("")
    public Object get(@Valid RetrieveInput input, BindingResult result) {
        if (result.hasErrors()) {
            return result.getAllErrors();
        }
        return usersService.retrieve(PageRequest.of(input.getPageIndex(), input.getPageSize()));
    }

    @PostMapping(value = "", consumes = "application/json")
    public Object create(@RequestBody @Valid CreateInput input, BindingResult result) {
        if (result.hasErrors()) {
            return result.getAllErrors();
        }
        User user = new User();
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setEmail(input.getEmail());
        user.setPassword(input.getPassword());
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        return usersService.create(user);
    }
}
