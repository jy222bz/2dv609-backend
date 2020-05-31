package se.lnu.ems.backend.controllers.api.question_choices;

import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.lnu.ems.backend.controllers.api.question_choices.dto.QuestionChoiceDTO;
import se.lnu.ems.backend.controllers.api.question_choices.input.CreateInput;
import se.lnu.ems.backend.controllers.api.question_choices.input.RetrieveInput;
import se.lnu.ems.backend.controllers.api.question_choices.input.UpdateInput;
import se.lnu.ems.backend.errors.common.BadRequestException;
import se.lnu.ems.backend.models.Question;
import se.lnu.ems.backend.models.QuestionChoice;
import se.lnu.ems.backend.services.common.EntitySpecification;
import se.lnu.ems.backend.services.common.search.SearchCriteria;
import se.lnu.ems.backend.services.common.search.SearchOperation;
import se.lnu.ems.backend.services.question_choices.IQuestionChoicesService;
import se.lnu.ems.backend.services.question_choices.exceptions.QuestionChoiceNotFoundException;
import se.lnu.ems.backend.services.questions.IQuestionsService;

import javax.validation.Valid;
import java.util.Date;


/**
 * The type Question choices controller.
 */
@RestController("QuestionChoicesController")
@RequestMapping("/api/v1/exams/{examId}/questions/{questionId}/choices")
public class QuestionChoicesController {
    private final IQuestionChoicesService questionChoicesService;
    private final IQuestionsService questionsService;

    private final ConversionService conversionService;


    /**
     * Instantiates a new Question choices controller.
     *
     * @param questionChoicesService the question choices service
     * @param questionsService       the questions service
     * @param conversionService      the conversion service
     */
    public QuestionChoicesController(IQuestionChoicesService questionChoicesService,
                                     IQuestionsService questionsService,
                                     ConversionService conversionService) {
        this.questionChoicesService = questionChoicesService;
        this.questionsService = questionsService;
        this.conversionService = conversionService;
    }


    /**
     * Get object.
     *
     * @param examId     the exam id
     * @param questionId the question id
     * @param input      the input
     * @param result     the result
     * @return the object
     */
    @GetMapping("")
    public Object get(@Valid @PathVariable long examId, @Valid @PathVariable long questionId, @Valid RetrieveInput input, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        Question question = questionsService.findByExamIdAndId(examId, questionId);
        EntitySpecification<QuestionChoice> specification = new EntitySpecification<>();
        specification.addIfValueNotEmpty(new SearchCriteria("question", question, SearchOperation.EQUAL));
        specification.addIfValueNotEmpty(new SearchCriteria("text", input.getFilterValue(), SearchOperation.MATCH));
        return questionChoicesService.retrieve(specification, PageRequest.of(input.getPageIndex(), input.getPageSize()))
                .map(questionChoice -> conversionService.convert(questionChoice, QuestionChoiceDTO.class));
    }

    /**
     * Delete question object.
     *
     * @param examId     the exam id
     * @param questionId the question id
     * @return the object
     */
    @GetMapping("/count")
    public Object deleteQuestion(@Valid @PathVariable long examId, @Valid @PathVariable long questionId) {
        Question question = questionsService.findByExamIdAndId(examId, questionId);
        EntitySpecification<QuestionChoice> specification = new EntitySpecification<>();
        specification.addIfValueNotEmpty(new SearchCriteria("question", question, SearchOperation.EQUAL));
        return questionChoicesService.count(specification);
    }


    /**
     * Retrieve object.
     *
     * @param examId     the exam id
     * @param questionId the question id
     * @param id         the id
     * @return the object
     */
    @GetMapping("/{id}")
    public Object retrieve(@Valid @PathVariable long examId, @Valid @PathVariable long questionId, @PathVariable long id) {
        return conversionService.convert(questionChoicesService.findByQuestionIdAndId(questionId, id), QuestionChoiceDTO.class);
    }


    /**
     * Create object.
     *
     * @param examId     the exam id
     * @param questionId the question id
     * @param input      the input
     * @param result     the result
     * @return the object
     */
    @PostMapping(value = "", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Object create(@Valid @PathVariable long examId, @Valid @PathVariable long questionId,
                         @RequestBody @Valid CreateInput input, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        QuestionChoice questionChoice = conversionService.convert(input, QuestionChoice.class);
        if (questionChoice == null) {
            throw new QuestionChoiceNotFoundException();
        }
        questionChoice.setQuestion(questionsService.findByExamIdAndId(examId, questionId));
        return conversionService.convert(questionChoicesService.create(questionChoice), QuestionChoiceDTO.class);
    }


    /**
     * Update object.
     *
     * @param examId     the exam id
     * @param questionId the question id
     * @param input      the input
     * @param result     the result
     * @param id         the id
     * @return the object
     */
    @PutMapping("/{id}")
    public Object update(@Valid @PathVariable long examId,
                         @Valid @PathVariable long questionId,
                         @RequestBody @Valid UpdateInput input, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        QuestionChoice questionChoice = questionChoicesService.findByQuestionIdAndId(questionId, id);
        if (input.getText() != null) {
            questionChoice.setText(input.getText());
        }
        questionChoice.setCorrect(input.isCorrect());
        questionChoice.setUpdatedAt(new Date());
        return conversionService.convert(questionChoicesService.update(questionChoice), QuestionChoiceDTO.class);
    }


    /**
     * Delete.
     *
     * @param examId     the exam id
     * @param questionId the question id
     * @param id         the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable long examId, @Valid @PathVariable long questionId,
                       @Valid @PathVariable long id) {
        questionChoicesService.delete(questionChoicesService.findByQuestionIdAndId(questionId, id));
    }
}
