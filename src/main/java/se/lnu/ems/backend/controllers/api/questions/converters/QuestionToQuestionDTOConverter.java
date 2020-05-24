package se.lnu.ems.backend.controllers.api.questions.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import se.lnu.ems.backend.controllers.api.questions.dto.QuestionDTO;
import se.lnu.ems.backend.models.Question;

/**
 * The type Question to Question dto converter.
 */
@Component
public class QuestionToQuestionDTOConverter implements Converter<Question, QuestionDTO> {

    @Override
    public QuestionDTO convert(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setText(question.getText());
        questionDTO.setNote(question.getNote());
        questionDTO.setCreatedAt(question.getCreatedAt());
        questionDTO.setExamId(question.getExam().getId());
        questionDTO.setType(question.getQuestionType().getId());
        questionDTO.setTypeName(question.getQuestionType().getName());
        return questionDTO;
    }
}
