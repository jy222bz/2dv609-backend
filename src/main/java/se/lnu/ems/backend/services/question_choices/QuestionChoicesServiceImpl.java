package se.lnu.ems.backend.services.question_choices;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se.lnu.ems.backend.models.QuestionChoice;
import se.lnu.ems.backend.repositories.QuestionChoicesRepository;
import se.lnu.ems.backend.services.common.EntitySpecification;
import se.lnu.ems.backend.services.question_choices.exceptions.QuestionChoiceNotFoundException;

/**
 * The type Question choices service.
 */
@Service
public class QuestionChoicesServiceImpl implements IQuestionChoicesService {

    private final QuestionChoicesRepository questionChoicesRepository;


    /**
     * Instantiates a new Question choices service.
     *
     * @param questionChoicesRepository the question choices repository
     */
    public QuestionChoicesServiceImpl(QuestionChoicesRepository questionChoicesRepository) {
        this.questionChoicesRepository = questionChoicesRepository;
    }

    @Override
    public Page<QuestionChoice> retrieve(EntitySpecification<QuestionChoice> specification, Pageable pageable) {
        return questionChoicesRepository.findAll(specification, pageable);
    }

    @Override
    public QuestionChoice findById(long id) {
        return questionChoicesRepository.findById(id).orElseThrow(QuestionChoiceNotFoundException::new);
    }

    @Override
    public QuestionChoice findByQuestionIdAndId(long questionId, long id) {
        QuestionChoice questionChoice = questionChoicesRepository.findById(id).orElseThrow(QuestionChoiceNotFoundException::new);
        if (questionChoice.getQuestion().getId() != questionId) {
            throw new QuestionChoiceNotFoundException();
        }
        return questionChoice;
    }

    @Override
    public QuestionChoice create(QuestionChoice questionChoice) {
        return questionChoicesRepository.save(questionChoice);
    }

    @Override
    public QuestionChoice update(QuestionChoice questionChoice) {
        return questionChoicesRepository.save(questionChoice);
    }

    @Override
    public void delete(QuestionChoice questionChoice) {
        questionChoicesRepository.delete(questionChoice);
    }

    @Override
    public long count(EntitySpecification<QuestionChoice> specification) {
        return questionChoicesRepository.count(specification);
    }
}
