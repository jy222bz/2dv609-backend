package se.lnu.ems.backend.controllers.api.questions;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.lnu.ems.backend.controllers.api.questions.dto.QuestionDTO;
import se.lnu.ems.backend.controllers.api.questions.input.CreateInput;
import se.lnu.ems.backend.controllers.api.questions.input.RetrieveInput;
import se.lnu.ems.backend.errors.common.BadRequestException;
import se.lnu.ems.backend.models.Question;
import se.lnu.ems.backend.services.exams.IExamsService;
import se.lnu.ems.backend.services.questions.IQuestionsService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;


/**
 * The type Questions controller.
 */
@RestController("QuestionsController")
@RequestMapping("/api/v1/questions")
public class QuestionsController {

    /**
     * Question service instance
     */
    private final IQuestionsService questionsService;

    /**
     * Question service instance
     */
    private final IExamsService examsService;

    /**
     * Conversion Service instance to convert input
     */
    private final ConversionService conversionService;

    /**
     * Instantiates a new Questions controller.
     *
     * @param questionsService  the questions service
     * @param conversionService the conversion service
     */
    public QuestionsController(IQuestionsService questionsService, IExamsService examsService, ConversionService conversionService) {
        this.questionsService = questionsService;
        this.examsService = examsService;
        this.conversionService = conversionService;
    }

    /**
     * method to return all question available in the database.
     *
     * @param input  the input
     * @param result the result
     * @return List<Question>  list
     */
    @GetMapping("")
    public Object get(@Valid RetrieveInput input, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        List<Question> questions = questionsService.retrieve(PageRequest.of(input.getPageIndex(), input.getPageSize()));
        return conversionService.convert(questions,
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Question.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(QuestionDTO.class))
        );
    }

    /**
     * method to return a question which has a specific id.
     *
     * @param id the id
     * @return Question question by id
     */
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable long id) {
        return questionsService.findById(id);
    }

    /**
     * To add question
     *
     * @param input  the input
     * @param result the result
     * @return ResponseEntity<Question>  response entity
     * @throws URISyntaxException the uri syntax exception
     */
    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<Question> create(@RequestBody @Valid CreateInput input, BindingResult result) throws URISyntaxException {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        return ResponseEntity.created(new URI("")).body(questionsService.create(conversionService.convert(input, Question.class)));
    }

    /**
     * to update an existence question
     *
     * @param input  the input
     * @param result the result
     * @param id     the id
     * @return ResponseEntity<Question>  response entity
     */
    @PutMapping("/{id}")
    public Object updateQuestion(@RequestBody @Valid CreateInput input, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        Question question = questionsService.findById(id);

        if (input.getNote() != null) {
            question.setNote(input.getNote());
        }
        if (input.getText() != null) {
            question.setText(input.getText());
        }
        if (input.getType() != 0) {
            question.setType(input.getType());
        }

        question.setExam(examsService.findById(input.getExamId()));
        question.setUpdatedAt(new Date());
        return questionsService.update(question);
    }

    /**
     * to delete a certain question
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestion(@Valid @PathVariable long id) {
        questionsService.delete(questionsService.findById(id));
    }
}
