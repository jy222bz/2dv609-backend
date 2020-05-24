package se.lnu.ems.backend.controllers.api.exams.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import se.lnu.ems.backend.controllers.api.exams.dto.ExamDTO;
import se.lnu.ems.backend.models.Exam;

/**
 * The type Exam to exam dto converter.
 */
@Component
public class ExamToExamDTOConverter implements Converter<Exam, ExamDTO> {

    @Override
    public ExamDTO convert(Exam exam) {
        ExamDTO examDTO = new ExamDTO();
        examDTO.setId(exam.getId());
        examDTO.setTitle(exam.getTitle());
        examDTO.setNote(exam.getNote());
        examDTO.setEndAt(exam.getEndAt());
        examDTO.setStartAt(exam.getStartAt());
        examDTO.setCreatedAt(exam.getCreatedAt());
        examDTO.setCourseCode(exam.getCourseCode());
        examDTO.setCredits(exam.getCredits());
        return examDTO;
    }
}
