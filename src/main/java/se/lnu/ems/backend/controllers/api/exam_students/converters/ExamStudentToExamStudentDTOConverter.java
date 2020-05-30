package se.lnu.ems.backend.controllers.api.exam_students.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import se.lnu.ems.backend.controllers.api.exam_students.dto.ExamStudentDTO;
import se.lnu.ems.backend.models.ExamStudent;

/**
 * The type Question to Question dto converter.
 */
@Component
public class ExamStudentToExamStudentDTOConverter implements Converter<ExamStudent, ExamStudentDTO> {

    @Override
    public ExamStudentDTO convert(ExamStudent examStudent) {
        ExamStudentDTO examStudentDTO = new ExamStudentDTO();
        examStudentDTO.setId(examStudent.getId());
        examStudentDTO.setExamId(examStudent.getExam().getId());
        examStudentDTO.setCreatedAt(examStudent.getCreatedAt());
        examStudentDTO.setEmail(examStudent.getUser().getEmail());
        examStudentDTO.setFirstName(examStudent.getUser().getFirstName());
        examStudentDTO.setLastName(examStudent.getUser().getLastName());
        examStudentDTO.setUserId(examStudent.getUser().getId());
        return examStudentDTO;
    }
}
