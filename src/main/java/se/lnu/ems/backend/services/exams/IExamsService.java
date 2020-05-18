package se.lnu.ems.backend.services.exams;

import org.springframework.data.domain.Pageable;
import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.services.common.EntitySpecification;

import java.util.List;


public interface IExamsService {
    List<Exam> retrieve(Pageable pageable, EntitySpecification<Exam> specification);

    Exam findById(long id);

    Exam create(Exam exam);

    Exam update(Exam exam);

    void delete(Exam exam);
}
