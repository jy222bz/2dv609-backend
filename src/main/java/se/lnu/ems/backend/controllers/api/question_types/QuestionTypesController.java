package se.lnu.ems.backend.controllers.api.question_types;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lnu.ems.backend.services.question_types.IQuestionTypesService;


/**
 * The type Question types controller.
 */
@RestController("QuestionTypesController")
@RequestMapping("/api/v1/question_types")
public class QuestionTypesController {


    private final IQuestionTypesService questionTypesService;

    /**
     * Instantiates a new Question types controller.
     *
     * @param questionTypesService the question types service
     */
    public QuestionTypesController(IQuestionTypesService questionTypesService) {
        this.questionTypesService = questionTypesService;
    }


    /**
     * Get object.
     *
     * @return the object
     */
    @GetMapping("")
    public Object get() {
        return questionTypesService.retrieve();
    }
}
