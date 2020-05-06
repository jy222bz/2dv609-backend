package se.lnu.ems.backend.controllers.api.exams.converters;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import se.lnu.ems.backend.controllers.api.exams.input.CreateInput;
import se.lnu.ems.backend.models.Exam;
@Component
public class InputToExamConverter implements Converter<CreateInput, Exam>{

	@Override
	public Exam convert(CreateInput source) {
		return new Exam(new Date(), source.getStartDate(), source.getEndDate(), source.getCredits(), source.getCourseCode(), source.getTitle(), source.getNote());
	}
	
	

}
