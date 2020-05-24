package se.lnu.ems.backend.services.questions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se.lnu.ems.backend.models.Question;
import se.lnu.ems.backend.repositories.QuestionsRepository;
import se.lnu.ems.backend.services.common.EntitySpecification;
import se.lnu.ems.backend.services.questions.exceptions.QuestionNotFoundException;

/**
 * The type Questions service.
 */
@Service
public class QuestionsServiceImpl implements IQuestionsService {

    private final QuestionsRepository questionsRepository;

    /**
     * Instantiates a new Questions service.
     *
     * @param questionsRepository the questions repository
     */
    public QuestionsServiceImpl(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    @Override
    public Page<Question> retrieve(EntitySpecification<Question> specification, Pageable pageable) {
        return questionsRepository.findAll(specification, pageable);
    }

    @Override
    public Question findById(long id) {
        return questionsRepository.findById(id).orElseThrow(QuestionNotFoundException::new);
    }

    @Override
    public Question findByExamIdAndId(long examId, long id) {
        Question question = questionsRepository.findById(id).orElseThrow(QuestionNotFoundException::new);
        if (question.getExam().getId() != examId) {
            throw new QuestionNotFoundException();
        }
        return question;
    }

    @Override
    public Question create(Question question) {
        return questionsRepository.save(question);
    }

    @Override
    public Question update(Question question) {
        return questionsRepository.save(question);
    }

    @Override
    public void delete(Question question) {
        questionsRepository.delete(question);
    }

    @Override
    public long count(EntitySpecification<Question> specification) {
        return questionsRepository.count(specification);
    }
}
