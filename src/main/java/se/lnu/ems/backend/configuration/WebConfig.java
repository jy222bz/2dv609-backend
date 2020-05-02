package se.lnu.ems.backend.configuration;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.repositories.ExamsRepository;
import se.lnu.ems.backend.services.ExamServiceImpl;
import se.lnu.ems.backend.services.ExamsService;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }
}