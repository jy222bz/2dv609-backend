package se.lnu.ems.backend.controllers.api.question_choices.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import se.lnu.ems.backend.controllers.api.question_choices.input.CreateInput;
import se.lnu.ems.backend.models.QuestionChoice;

import java.util.Date;

/**
 * The type Create input to question choice converter.
 */
@Component
public class CreateInputToQuestionChoiceConverter implements Converter<CreateInput, QuestionChoice> {


    @Override
    public QuestionChoice convert(CreateInput input) {
        QuestionChoice questionChoice = new QuestionChoice();
        questionChoice.setText(input.getText());
        questionChoice.setNote(input.getNote());
        questionChoice.setCorrect(input.isCorrect());
        questionChoice.setCreatedAt(new Date());
        questionChoice.setUpdatedAt(new Date());
        return questionChoice;
    }
}
