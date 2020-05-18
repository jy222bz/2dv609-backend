package se.lnu.ems.backend.services.questions;

import org.springframework.data.domain.Pageable;
import se.lnu.ems.backend.models.Question;

import java.util.List;

public interface IQuestionsService {
    List<Question> retrieve(Pageable pageable);

    Question findById(long id);

    Question create(Question question);

    Question update(Question question);

    void delete(Question question);
}
