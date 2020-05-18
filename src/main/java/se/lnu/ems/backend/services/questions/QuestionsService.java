package se.lnu.ems.backend.services.questions;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se.lnu.ems.backend.models.Question;
import se.lnu.ems.backend.repositories.QuestionsRepository;
import se.lnu.ems.backend.services.questions.exceptions.QuestionNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionsService implements IQuestionsService {

    private final QuestionsRepository questionsRepository;

    public QuestionsService(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    @Override
    public List<Question> retrieve(Pageable pageable) {
        List<Question> questions = new ArrayList<>();
        questionsRepository.findAll().forEach(questions::add);
        return questions;
    }

    @Override
    public Question findById(long id) {
        return questionsRepository.findById(id).orElseThrow(QuestionNotFoundException::new);
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
}
