package se.lnu.ems.backend.controllers.api.exam_students;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.lnu.ems.backend.controllers.api.exam_students.dto.ExamStudentDTO;
import se.lnu.ems.backend.controllers.api.exam_students.input.CreateInput;
import se.lnu.ems.backend.controllers.api.exam_students.input.RetrieveInput;
import se.lnu.ems.backend.errors.common.BadRequestException;
import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.models.ExamStudent;
import se.lnu.ems.backend.models.User;
import se.lnu.ems.backend.services.common.EntitySpecification;
import se.lnu.ems.backend.services.common.search.SearchCriteria;
import se.lnu.ems.backend.services.common.search.SearchOperation;
import se.lnu.ems.backend.services.exam_sutdents.IExamStudentsService;
import se.lnu.ems.backend.services.exams.IExamsService;
import se.lnu.ems.backend.services.users.IUsersService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


/**
 * The type Questions controller.
 */
@RestController("StudentsController")
@RequestMapping("/api/v1/exams/{examId}/students")
public class StudentsController {

    private final IExamStudentsService examStudentsService;

    private final IUsersService usersService;

    private final IExamsService examsService;

    private final ConversionService conversionService;

    public StudentsController(IExamStudentsService examStudentsService,
                              IExamsService examsService,
                              IUsersService usersService,
                              ConversionService conversionService) {
        this.examStudentsService = examStudentsService;
        this.examsService = examsService;
        this.usersService = usersService;
        this.conversionService = conversionService;
    }


    @GetMapping("")
    public Object get(@Valid @PathVariable long examId, @Valid RetrieveInput input, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        Exam exam = examsService.findById(examId);
        EntitySpecification<ExamStudent> specification = new EntitySpecification<>();
        specification.addIfValueNotEmpty(new SearchCriteria("exam", exam, SearchOperation.EQUAL));
        return examStudentsService.retrieve(specification, PageRequest.of(input.getPageIndex(), input.getPageSize()))
                .map(question -> conversionService.convert(question, ExamStudentDTO.class));
    }

    @GetMapping("/available")
    public Object getAvailable(@Valid @PathVariable long examId) {
        Exam exam = examsService.findById(examId);
        List<User> users = usersService.findAvailableStudents(exam.getId());
        return conversionService.convert(users,
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ExamStudentDTO.class))
        );
    }

    @GetMapping("/count")
    public Object count(@Valid @PathVariable long examId) {
        Exam exam = examsService.findById(examId);
        EntitySpecification<ExamStudent> specification = new EntitySpecification<>();
        specification.addIfValueNotEmpty(new SearchCriteria("exam", exam, SearchOperation.EQUAL));
        return examStudentsService.count(specification);
    }


    @PostMapping(value = "", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Object create(@Valid @PathVariable long examId, @RequestBody @Valid CreateInput input, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        ExamStudent examStudent = new ExamStudent();
        examStudent.setUser(usersService.findById(input.getUserId()));
        examStudent.setExam(examsService.findById(examId));
        examStudent.setCreatedAt(new Date());
        examStudent.setUpdatedAt(new Date());
        return conversionService.convert(examStudentsService.create(examStudent), ExamStudentDTO.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable long examId, @Valid @PathVariable long id) {
        examStudentsService.delete(examStudentsService.findByExamIdAndId(examId, id));
    }
}
