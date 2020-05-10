package se.lnu.ems.backend.services.questions;

import java.util.List;

import exceptions.InternalServerErrorException;
import se.lnu.ems.backend.models.Question;

public interface IQuestionService {
	
	public List<Question> getAllQuestions();
	public Question getQuestionById(long id) throws InternalServerErrorException;
	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public void deleteQuestion(long id);

}
