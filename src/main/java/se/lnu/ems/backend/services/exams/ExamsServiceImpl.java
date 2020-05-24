package se.lnu.ems.backend.services.exams;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.repositories.ExamsRepository;
import se.lnu.ems.backend.services.common.EntitySpecification;
import se.lnu.ems.backend.services.exams.exceptions.ExamInvalidEndDateException;
import se.lnu.ems.backend.services.exams.exceptions.ExamNotFoundException;

/**
 * This class is a service implementation of the exam service interface.
 * The exam service class provides the controllers CRUD methods of the exam repository.
 *
 * @author Hamza
 * @since 2020-04-02
 */
@Service
public class ExamsServiceImpl implements IExamsService {

    /**
     * An instance of the exam repository.
     */
    private final ExamsRepository examsRepository;

    public ExamsServiceImpl(ExamsRepository examsRepository) {
        this.examsRepository = examsRepository;
    }

    /**
     * Retrieves certain exams that meet the paging restrictions.
     *
     * @param pageable A set of exams to be retrieved.
     * @return A list of exams that meet the paging restrictions.
     */
    @Override
    public Page<Exam> retrieve(EntitySpecification<Exam> specification, Pageable pageable) {
        return examsRepository.findAll(specification, pageable);
    }

    /**
     * @param id The id of the exam.
     * @return Returns a single exam. This is due to the uniqueness of IDs.
     */
    @Override
    public Exam findById(long id) {
        return examsRepository.findById(id).orElseThrow(ExamNotFoundException::new);
    }

    /**
     * @param exam Exam to be saved in the exam repository.
     * @return The exam that is saved to the exam repository.
     */
    @Override
    public Exam create(Exam exam) {
        // check dates
        if (exam.getEndAt().getTime() < exam.getStartAt().getTime()) {
            throw new ExamInvalidEndDateException();
        }
        return examsRepository.save(exam);
    }

    /**
     * @param exam Exam to be deleted from the exam repository.
     */
    @Override
    public void delete(Exam exam) {
        examsRepository.delete(exam);
    }

    /**
     * @param exam Exam to be updated from the exam repository.
     */
    @Override
    public Exam update(Exam exam) {
        return examsRepository.save(exam);
    }

}
