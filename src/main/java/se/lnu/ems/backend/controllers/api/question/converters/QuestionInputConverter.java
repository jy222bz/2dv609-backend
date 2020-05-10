package se.lnu.ems.backend.controllers.api.question.converters;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import se.lnu.ems.backend.controllers.api.question.input.CreateInputQuestion;
import se.lnu.ems.backend.models.Question;

@Component
public class QuestionInputConverter implements Converter<CreateInputQuestion, Question> {

	@Override
	public Question convert(CreateInputQuestion source) {
		
		return new Question(source.getType(), source.getText(), new Date(), new Date(), source.getNote(), source.getExam_id());
	}

}
