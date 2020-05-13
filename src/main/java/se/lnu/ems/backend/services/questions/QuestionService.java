package se.lnu.ems.backend.services.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.lnu.ems.backend.services.exams.exceptions.*;
import se.lnu.ems.backend.models.Question;
import se.lnu.ems.backend.repositories.QuestionRepository;

@Service
public class QuestionService implements IQuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public List<Question> getAllQuestions(){
		List<Question> questions = new ArrayList<>();
		questionRepository.findAll().forEach(questions::add);
		return questions;
	}
	
	@Override
	public Question getQuestionById(long id) throws InternalServerErrorException {
		return questionRepository.findById(id).orElseThrow(() -> new InternalServerErrorException("ID not found"));
	}
	
	@Override
	public Question addQuestion(Question question) {
		
		return questionRepository.save(question);
		
	}
	
	@Override
	public Question updateQuestion(Question question) {
		return questionRepository.save(question);
	}
	
	@Override
	public void deleteQuestion(long id) {
		questionRepository.deleteById(id);
	}
}
