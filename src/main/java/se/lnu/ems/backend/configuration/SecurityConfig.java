package se.lnu.ems.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import se.lnu.ems.backend.configuration.jwt.JwtRequestFilter;
import se.lnu.ems.backend.services.auth.AuthService;

/**
 * The type Security config.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthService authService;
    private final JwtRequestFilter jwtRequestFilter;
    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_TEACHER = "TEACHER";
    private static final String ROLE_STUDENT = "STUDENT";

    /**
     * Instantiates a new Security config.
     *
     * @param authService      the auth service
     * @param jwtRequestFilter the jwt request filter
     */
    public SecurityConfig(AuthService authService, JwtRequestFilter jwtRequestFilter) {
        this.authService = authService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    /**
     * Password encoder password encoder.
     *
     * @return the password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .authorizeRequests()
                .antMatchers("/api/v1/account/**")
                .hasAnyRole(ROLE_ADMIN, ROLE_TEACHER, ROLE_STUDENT)
                .and()

                .authorizeRequests()
                .antMatchers("/api/v1/users/**")
                .hasRole(ROLE_ADMIN)
                .and()

                .authorizeRequests()
                .antMatchers("/api/v1/exams/**")
                .hasAnyRole(ROLE_ADMIN, ROLE_TEACHER)
                .and()

                .authorizeRequests()
                .anyRequest()
                .permitAll()
        ;
        // disable logout function
        http.formLogin().disable();
        http.logout().disable();
        // csrf
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        // add jwt request filter
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * Auth provider dao authentication provider.
     *
     * @return the dao authentication provider
     */
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(authService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
