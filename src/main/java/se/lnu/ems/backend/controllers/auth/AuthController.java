package se.lnu.ems.backend.controllers.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.lnu.ems.backend.configuration.jwt.JwtTokenUtil;
import se.lnu.ems.backend.controllers.auth.dto.AccountDTO;
import se.lnu.ems.backend.controllers.auth.exceptions.AuthCredentialsInvalidException;
import se.lnu.ems.backend.controllers.auth.exceptions.AuthUserDisabledException;
import se.lnu.ems.backend.controllers.auth.exceptions.UnauthenticatedException;
import se.lnu.ems.backend.controllers.auth.input.LoginInput;
import se.lnu.ems.backend.errors.common.BadRequestException;
import se.lnu.ems.backend.models.UserPrinciple;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * The type Auth controller.
 */
@RestController("AuthController")
@RequestMapping("/")
public class AuthController {

    /**
     * A private field for the conversion service.
     */
    private final ConversionService conversionService;

    private final AuthenticationProvider authenticationProvider;
    private final JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.validity}")
    private long validity;

    /**
     * Instantiates a new Auth controller.
     *
     * @param authenticationProvider the authentication provider
     * @param jwtTokenUtil           the jwt token util
     */
    public AuthController(AuthenticationProvider authenticationProvider, JwtTokenUtil jwtTokenUtil,
                          ConversionService conversionService) {
        this.authenticationProvider = authenticationProvider;
        this.jwtTokenUtil = jwtTokenUtil;
        this.conversionService = conversionService;
    }

    /**
     * Login.
     *
     * @param input    the input
     * @param result   the result
     * @param response the response
     */
    @PostMapping(value = "login", consumes = "application/json")
    public Object login(@RequestBody @Valid LoginInput input, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        Authentication authentication;
        try {
            authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
        } catch (DisabledException e) {
            throw new AuthUserDisabledException();
        } catch (BadCredentialsException e) {
            throw new AuthCredentialsInvalidException();
        }
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        Cookie cookie = new Cookie("token", jwtTokenUtil.generateToken(userPrinciple));
        cookie.setMaxAge((int) validity);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return conversionService.convert(userPrinciple, AccountDTO.class);
    }

    /**
     * Logout.
     *
     * @param response the response
     */
    @PutMapping(value = "logout", consumes = "application/json")
    public void logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0); // expired
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    /**
     * Get object.
     *
     * @return the object
     */
    @GetMapping(value = "account")
    public Object get() {
        if (!(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof  UserPrinciple)) {
            throw new UnauthenticatedException();
        }
        UserPrinciple userDetails = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return conversionService.convert(userDetails, AccountDTO.class);
    }
}
