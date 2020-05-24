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
    public Exam convert(CreateInput input) {
        Exam exam = new Exam();
        exam.setCreatedAt(new Date());
        exam.setUpdatedAt(new Date());
        exam.setCourseCode(input.getCourseCode());
        exam.setCredits(input.getCredits());
        exam.setNote(input.getNote());
        exam.setTitle(input.getTitle());
        exam.setStartAt(input.getStartAt());
        exam.setEndAt(input.getEndAt());
        return exam;
    }
}
