package se.lnu.ems.backend.controllers.api.student;

import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lnu.ems.backend.controllers.api.exam_students.input.RetrieveInput;
import se.lnu.ems.backend.controllers.api.student.dto.StudentExamDTO;
import se.lnu.ems.backend.controllers.auth.exceptions.UnauthenticatedException;
import se.lnu.ems.backend.errors.common.BadRequestException;
import se.lnu.ems.backend.models.ExamStudent;
import se.lnu.ems.backend.models.User;
import se.lnu.ems.backend.models.UserPrinciple;
import se.lnu.ems.backend.services.common.EntitySpecification;
import se.lnu.ems.backend.services.common.search.SearchCriteria;
import se.lnu.ems.backend.services.common.search.SearchOperation;
import se.lnu.ems.backend.services.exam_sutdents.IExamStudentsService;
import se.lnu.ems.backend.services.users.IUsersService;

import javax.validation.Valid;


@RestController("StudentController")
@RequestMapping("/api/v1/student")
public class StudentController {

    private final IExamStudentsService examStudentsService;

    private final IUsersService usersService;

    private final ConversionService conversionService;

    public StudentController(IExamStudentsService examStudentsService,
                             IUsersService usersService,
                             ConversionService conversionService) {
        this.examStudentsService = examStudentsService;
        this.conversionService = conversionService;
        this.usersService = usersService;
    }


    @GetMapping("/exams")
    public Object get(@Valid RetrieveInput input, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        EntitySpecification<ExamStudent> specification = new EntitySpecification<>();
        specification.addIfValueNotEmpty(new SearchCriteria("user", getCurrentUser(), SearchOperation.EQUAL));
        return examStudentsService.retrieve(specification, PageRequest.of(input.getPageIndex(), input.getPageSize()))
                .map(examStudent -> conversionService.convert(examStudent, StudentExamDTO.class));
    }

    private User getCurrentUser() {
        if (!(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserPrinciple)) {
            throw new UnauthenticatedException();
        }
        UserPrinciple userDetails = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usersService.findById(userDetails.getId());
    }
}
