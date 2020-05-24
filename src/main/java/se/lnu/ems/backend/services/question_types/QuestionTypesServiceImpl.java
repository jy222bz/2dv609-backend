package se.lnu.ems.backend.services.question_types;

import org.springframework.stereotype.Service;
import se.lnu.ems.backend.models.QuestionType;
import se.lnu.ems.backend.repositories.QuestionTypesRepository;
import se.lnu.ems.backend.services.question_types.exceptions.QuestionTypeNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Question types service.
 */
@Service
public class QuestionTypesServiceImpl implements IQuestionTypesService {
    private final QuestionTypesRepository questionTypesRepository;


    /**
     * Instantiates a new Question types service.
     *
     * @param questionTypesRepository the question types repository
     */
    public QuestionTypesServiceImpl(QuestionTypesRepository questionTypesRepository) {
        this.questionTypesRepository = questionTypesRepository;
    }

    @Override
    public List<QuestionType> retrieve() {
        var list = new ArrayList<QuestionType>();
        questionTypesRepository.findAll().forEach(list::add);
        return list;
    }


    @Override
    public QuestionType findById(Long id) {
        return questionTypesRepository.findById(id).orElseThrow(QuestionTypeNotFoundException::new);
    }
}
