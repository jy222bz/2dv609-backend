package se.lnu.ems.backend.controllers.api.questions.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import se.lnu.ems.backend.controllers.api.questions.input.CreateInput;
import se.lnu.ems.backend.models.Question;

import java.util.Date;

/**
 * The type Question input converter.
 */
@Component
public class QuestionInputConverter implements Converter<CreateInput, Question> {

    @Override
    public Question convert(CreateInput source) {
        Question question = new Question();
        question.setNote(source.getNote());
        question.setText(source.getText());
        question.setUpdatedAt(new Date());
        question.setCreatedAt(new Date());
        return question;
    }
}
