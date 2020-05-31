package se.lnu.ems.backend.controllers.api.student.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import se.lnu.ems.backend.controllers.api.student.dto.StudentExamDTO;
import se.lnu.ems.backend.models.ExamStudent;

/**
 * The type Exam to exam dto converter.
 */
@Component
public class ExamStudentToStudentExamDTOConverter implements Converter<ExamStudent, StudentExamDTO> {

    @Override
    public StudentExamDTO convert(ExamStudent examStudent) {
        StudentExamDTO studentExamDTO = new StudentExamDTO();
        studentExamDTO.setId(examStudent.getExam().getId());
        studentExamDTO.setCredits(examStudent.getExam().getCredits());
        studentExamDTO.setCourseCode(examStudent.getExam().getCourseCode());
        studentExamDTO.setStartAt(examStudent.getExam().getStartAt());
        studentExamDTO.setEndAt(examStudent.getExam().getEndAt());
        studentExamDTO.setTitle(examStudent.getExam().getTitle());
        studentExamDTO.setNote(examStudent.getExam().getNote());
        return studentExamDTO;
    }
}
