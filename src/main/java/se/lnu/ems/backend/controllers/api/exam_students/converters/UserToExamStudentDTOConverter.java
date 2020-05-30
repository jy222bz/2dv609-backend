package se.lnu.ems.backend.controllers.api.exam_students.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import se.lnu.ems.backend.controllers.api.exam_students.dto.ExamStudentDTO;
import se.lnu.ems.backend.models.User;

/**
 * The type Question to Question dto converter.
 */
@Component
public class UserToExamStudentDTOConverter implements Converter<User, ExamStudentDTO> {

    @Override
    public ExamStudentDTO convert(User user) {
        ExamStudentDTO examStudentDTO = new ExamStudentDTO();
        examStudentDTO.setId(user.getId());
        examStudentDTO.setCreatedAt(user.getCreatedAt());
        examStudentDTO.setEmail(user.getEmail());
        examStudentDTO.setFirstName(user.getFirstName());
        examStudentDTO.setLastName(user.getLastName());
        examStudentDTO.setUserId(user.getId());
        return examStudentDTO;
    }
}
