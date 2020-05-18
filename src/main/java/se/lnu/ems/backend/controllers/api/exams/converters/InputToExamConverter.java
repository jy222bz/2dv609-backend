package se.lnu.ems.backend.controllers.api.exams.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import se.lnu.ems.backend.controllers.api.exams.input.CreateInput;
import se.lnu.ems.backend.models.Exam;

import java.util.Date;

/**
 * The type Input to exam converter.
 */
@Component
public class InputToExamConverter implements Converter<CreateInput, Exam> {

    @Override
    public Exam convert(CreateInput source) {
        return new Exam(new Date(), source.getStartDate(), source.getEndDate(), source.getCredits(), source.getCourseCode(), source.getTitle(), source.getNote());
    }
}
