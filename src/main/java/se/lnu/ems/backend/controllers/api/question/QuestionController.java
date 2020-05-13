package se.lnu.ems.backend.controllers.api.question;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import se.lnu.ems.backend.services.exams.exceptions.*;
import se.lnu.ems.backend.controllers.api.question.input.CreateInputQuestion;
import se.lnu.ems.backend.models.Question;
import se.lnu.ems.backend.services.questions.IQuestionService;


@RestController("QuestionController")
@RequestMapping("/api/v1/questions")
public class QuestionController {

	/**
	 * Question service instance
	 */
	@Autowired
	private IQuestionService questionService;

	/**
	 * Conversion Service instance to convert input
	 */
	@Autowired
	private ConversionService conversionService;


	/**
	 * Constructor
	 * @param questionService
	 * @param conversionService
	 */
	public QuestionController(IQuestionService questionService, ConversionService conversionService) {
		super();
		this.questionService = questionService;
		this.conversionService = conversionService;
	}

	/**
	 * method to return all question available in the database.
	 * @return List<Question> 
	 */
	@GetMapping("")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	/**
	 * method to return a question which has a specific id.
	 * @param id
	 * @return Question
	 * @throws InternalServerErrorException
	 */
	@GetMapping("/{id}")
	public Question getQuestionById(@PathVariable long id) throws InternalServerErrorException {
		return questionService.getQuestionById(id);
	}

	/**
	 * To add question 
	 * @param input
	 * @param result
	 * @return ResponseEntity<Question>
	 * @throws InternalServerErrorException
	 */
	@PostMapping(value = "", consumes = "application/json")
	public ResponseEntity<Question> addQuestion(@RequestBody @Valid CreateInputQuestion input, BindingResult result) throws InternalServerErrorException {
		if(result.hasErrors()) {
			throw new InternalServerErrorException("Input values are invalid.");
		}
		Question question = questionService.addQuestion(conversionService.convert(input, Question.class));
		return ResponseEntity.accepted().body(question);
	}

	/**
	 * to update an existence question
	 * @param input
	 * @param result
	 * @param id
	 * @return ResponseEntity<Question>
	 * @throws InternalServerErrorException
	 */
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Question> updateQuestion(@RequestBody @Valid CreateInputQuestion input, BindingResult result, @PathVariable long id) throws InternalServerErrorException {
		if(result.hasErrors()) {
			throw new InternalServerErrorException("Unable to update exam.");
		}		

		Question question = questionService.getQuestionById(id);

		if(input.getNote() != null) {
			question.setNote(input.getNote());
		}
		if(input.getText() != null) {
			question.setText(input.getText());
		}
		if(input.getType() != 0) {
			question.setType(input.getType());
		}
		if(input.getExam_id() != 0) {
			question.setExam_id(input.getExam_id());
		}

		question.setUpdatedAt(new Date());

		questionService.updateQuestion(question);
		return ResponseEntity.ok().body(questionService.getQuestionById(id));
	}

	/**
	 * to delete a certain question 
	 * @param id
	 * @return ResponseEntity<Question>
	 * @throws InternalServerErrorException
	 */
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<Question> deleteQuestion(@PathVariable long id) throws InternalServerErrorException {
		Question question = questionService.getQuestionById(id);
		questionService.deleteQuestion(id);
		return ResponseEntity.ok().body(question);
	}
}
