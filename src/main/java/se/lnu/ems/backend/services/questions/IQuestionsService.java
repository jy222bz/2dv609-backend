package se.lnu.ems.backend.services.questions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se.lnu.ems.backend.models.Question;
import se.lnu.ems.backend.services.common.EntitySpecification;

public interface IQuestionsService {
    Page<Question> retrieve(EntitySpecification<Question> specification, Pageable pageable);

    Question findById(long id);

    Question create(Question question);

    Question update(Question question);

    void delete(Question question);
}
