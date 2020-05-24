package se.lnu.ems.backend.controllers.api.questions;

import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.lnu.ems.backend.controllers.api.questions.dto.QuestionDTO;
import se.lnu.ems.backend.controllers.api.questions.input.CreateInput;
import se.lnu.ems.backend.controllers.api.questions.input.RetrieveInput;
import se.lnu.ems.backend.controllers.api.questions.input.UpdateInput;
import se.lnu.ems.backend.errors.common.BadRequestException;
import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.models.Question;
import se.lnu.ems.backend.services.common.EntitySpecification;
import se.lnu.ems.backend.services.common.search.SearchCriteria;
import se.lnu.ems.backend.services.common.search.SearchOperation;
import se.lnu.ems.backend.services.exams.IExamsService;
import se.lnu.ems.backend.services.question_types.IQuestionTypesService;
import se.lnu.ems.backend.services.questions.IQuestionsService;
import se.lnu.ems.backend.services.questions.exceptions.QuestionNotFoundException;

import javax.validation.Valid;
import java.util.Date;


/**
 * The type Questions controller.
 */
@RestController("QuestionsController")
@RequestMapping("/api/v1/exams/{examId}/questions")
public class QuestionsController {

    /**
     * Question service instance
     */
    private final IQuestionsService questionsService;

    /**
     * Question service instance
     */
    private final IExamsService examsService;

    private final IQuestionTypesService questionTypesService;

    /**
     * Conversion Service instance to convert input
     */
    private final ConversionService conversionService;

    /**
     * Instantiates a new Questions controller.
     *
     * @param questionsService     the questions service
     * @param examsService         the exams service
     * @param questionTypesService the question types service
     * @param conversionService    the conversion service
     */
    public QuestionsController(IQuestionsService questionsService, IExamsService examsService,
                               IQuestionTypesService questionTypesService,
                               ConversionService conversionService) {
        this.questionsService = questionsService;
        this.examsService = examsService;
        this.questionTypesService = questionTypesService;
        this.conversionService = conversionService;
    }

    /**
     * method to return all question available in the database.
     *
     * @param examId the exam id
     * @param input  the input
     * @param result the result
     * @return List<Question>   list
     */
    @GetMapping("")
    public Object get(@Valid @PathVariable long examId, @Valid RetrieveInput input, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        Exam exam = examsService.findById(examId);
        EntitySpecification<Question> specification = new EntitySpecification<>();
        specification.addIfValueNotEmpty(new SearchCriteria("exam", exam, SearchOperation.EQUAL));
        specification.addIfValueNotEmpty(new SearchCriteria("text", input.getFilterValue(), SearchOperation.MATCH));
        return questionsService.retrieve(specification, PageRequest.of(input.getPageIndex(), input.getPageSize()))
                .map(question -> conversionService.convert(question, QuestionDTO.class));
    }

    @GetMapping("/count")
    public Object count(@Valid @PathVariable long examId) {
        Exam exam = examsService.findById(examId);
        EntitySpecification<Question> specification = new EntitySpecification<>();
        specification.addIfValueNotEmpty(new SearchCriteria("exam", exam, SearchOperation.EQUAL));
        return questionsService.count(specification);
    }

    /**
     * method to return a question which has a specific id.
     *
     * @param examId the exam id
     * @param id     the id
     * @return Question question by id
     */
    @GetMapping("/{id}")
    public Object retrieve(@Valid @PathVariable long examId, @PathVariable long id) {
        return conversionService.convert(questionsService.findByExamIdAndId(examId, id), QuestionDTO.class);
    }

    /**
     * To add question
     *
     * @param examId the exam id
     * @param input  the input
     * @param result the result
     * @return ResponseEntity<Question>   response entity
     */
    @PostMapping(value = "", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Object create(@Valid @PathVariable long examId, @RequestBody @Valid CreateInput input, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        Question question = conversionService.convert(input, Question.class);
        if (question == null) {
            throw new QuestionNotFoundException();
        }
        question.setQuestionType(questionTypesService.findById(input.getType()));
        question.setExam(examsService.findById(examId));
        return conversionService.convert(questionsService.create(question), QuestionDTO.class);
    }

    /**
     * to update an existence question
     *
     * @param examId the exam id
     * @param input  the input
     * @param result the result
     * @param id     the id
     * @return ResponseEntity<Question>   response entity
     */
    @PutMapping("/{id}")
    public Object update(@Valid @PathVariable long examId,
                         @RequestBody @Valid UpdateInput input, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        Question question = questionsService.findByExamIdAndId(examId, id);
        if (input.getNote() != null) {
            question.setNote(input.getNote());
        }
        if (input.getText() != null) {
            question.setText(input.getText());
        }
        question.setQuestionType(questionTypesService.findById(input.getType()));
        question.setUpdatedAt(new Date());
        return conversionService.convert(questionsService.update(question), QuestionDTO.class);
    }

    /**
     * to delete a certain question
     *
     * @param examId the exam id
     * @param id     the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable long examId, @Valid @PathVariable long id) {
        questionsService.delete(questionsService.findById(id));
    }
}
