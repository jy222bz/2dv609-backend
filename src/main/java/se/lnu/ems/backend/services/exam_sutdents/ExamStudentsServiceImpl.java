package se.lnu.ems.backend.services.exam_sutdents;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se.lnu.ems.backend.models.ExamStudent;
import se.lnu.ems.backend.repositories.ExamStudentsRepository;
import se.lnu.ems.backend.services.common.EntitySpecification;
import se.lnu.ems.backend.services.exam_sutdents.exceptions.StudentNotFoundException;
import se.lnu.ems.backend.services.questions.exceptions.QuestionNotFoundException;


/**
 * The type Exam students service.
 */
@Service
public class ExamStudentsServiceImpl implements IExamStudentsService {

    private final ExamStudentsRepository examStudentsRepository;


    /**
     * Instantiates a new Exam students service.
     *
     * @param examStudentsRepository the exam students repository
     */
    public ExamStudentsServiceImpl(ExamStudentsRepository examStudentsRepository) {
        this.examStudentsRepository = examStudentsRepository;
    }

    @Override
    public Page<ExamStudent> retrieve(EntitySpecification<ExamStudent> specification, Pageable pageable) {
        return examStudentsRepository.findAll(specification, pageable);
    }

    @Override
    public ExamStudent findById(long id) {
        return examStudentsRepository.findById(id).orElseThrow(QuestionNotFoundException::new);
    }

    @Override
    public ExamStudent findByExamIdAndId(long examId, long id) {
        ExamStudent examStudent = examStudentsRepository.findById(id).orElseThrow(StudentNotFoundException::new);
        if (examStudent.getExam().getId() != examId) {
            throw new StudentNotFoundException();
        }
        return examStudent;
    }

    @Override
    public ExamStudent create(ExamStudent examStudent) {
        return examStudentsRepository.save(examStudent);
    }

    @Override
    public void delete(ExamStudent examStudent) {
        examStudentsRepository.delete(examStudent);
    }

    @Override
    public long count(EntitySpecification<ExamStudent> specification) {
        return examStudentsRepository.count(specification);
    }
}
