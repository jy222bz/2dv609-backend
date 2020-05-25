package se.lnu.ems.backend.controllers.api.question_choices.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import se.lnu.ems.backend.controllers.api.question_choices.dto.QuestionChoiceDTO;
import se.lnu.ems.backend.models.QuestionChoice;

/**
 * The type User to user dto converter.
 */
@Component
public class QuestionChoiceToDTOConverter implements Converter<QuestionChoice, QuestionChoiceDTO> {

    @Override
    public QuestionChoiceDTO convert(QuestionChoice questionChoice) {
        QuestionChoiceDTO questionChoiceDTO = new QuestionChoiceDTO();
        questionChoiceDTO.setId(questionChoice.getId());
        questionChoiceDTO.setText(questionChoice.getText());
        questionChoiceDTO.setCreatedAt(questionChoice.getCreatedAt());
        questionChoiceDTO.setUpdatedAt(questionChoice.getUpdatedAt());
        questionChoiceDTO.setCorrect(questionChoice.isCorrect());
        return questionChoiceDTO;
    }
}
