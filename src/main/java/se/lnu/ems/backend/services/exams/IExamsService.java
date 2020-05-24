package se.lnu.ems.backend.services.exams;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.services.common.EntitySpecification;


public interface IExamsService {
    Page<Exam> retrieve(EntitySpecification<Exam> specification, Pageable pageable);

    Exam findById(long id);

    Exam create(Exam exam);

    Exam update(Exam exam);

    void delete(Exam exam);
}
