package se.lnu.ems.backend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import se.lnu.ems.backend.controllers.api.users.converters.UserConverterFromCreateInput;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new UserConverterFromCreateInput());
    }
}