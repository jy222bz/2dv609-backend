package se.lnu.ems.backend.controllers.api.exams;

import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.lnu.ems.backend.controllers.api.exams.dto.ExamDTO;
import se.lnu.ems.backend.controllers.api.exams.input.CreateInput;
import se.lnu.ems.backend.controllers.api.exams.input.RetrieveInput;
import se.lnu.ems.backend.controllers.api.exams.input.UpdateInput;
import se.lnu.ems.backend.errors.common.BadRequestException;
import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.services.common.EntitySpecification;
import se.lnu.ems.backend.services.common.search.SearchCriteria;
import se.lnu.ems.backend.services.common.search.SearchOperation;
import se.lnu.ems.backend.services.exams.IExamsService;

import javax.validation.Valid;
import java.util.Date;

/**
 * RestController for the exam component.
 *
 * @author Hamza
 */
@RestController("ExamsController")
@RequestMapping("/api/v1/exams")
public class ExamsController {

    /**
     * Instance of ExamsService
     */
    private final IExamsService examsService;

    /**
     * Instance of ConversionService
     */
    private final ConversionService conversionService;

    /**
     * Instantiates a new Exams controller.
     *
     * @param examsService      the exams service
     * @param conversionService the conversion service
     */
    public ExamsController(IExamsService examsService, ConversionService conversionService) {
        this.examsService = examsService;
        this.conversionService = conversionService;
    }

    /**
     * When the server receives a GET request with the URI /api/v1/exams and three optional
     * parameters: title, note and courseCode, the method takes the intersection of all the
     * exams that match the input value in the parameters. The server responds by transmitting
     * an HTTP response code 200 and the body contains the intersection of all the exams.
     * <p>
     * For instance, suppose the server receives GET request with the URI
     * /api/v1/exams/?title=Exam&courseCode=1DV609
     * The response will be a list of all exams such that contain the word "Exam" in the title
     * and contain the word "1DV609" in the course code.
     *
     * @param input  The retrieved input values from the parameters.
     * @param result The validation result of the input values.
     * @return HTTP response code 200 and a list of exams in JSON format
     */
    @GetMapping("")
    public Object get(RetrieveInput input, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException(result.getAllErrors());
        }
        EntitySpecification<Exam> specification = new EntitySpecification<>();
        specification.addIfValueNotEmpty(new SearchCriteria("title", input.getFilterValue(), SearchOperation.MATCH));
        specification.addIfValueNotEmpty(new SearchCriteria("courseCode", input.getCourseCode(), SearchOperation.MATCH));
        specification.addIfValueNotEmpty(new SearchCriteria("note", input.getNote(), SearchOperation.MATCH));
        return examsService.retrieve(specification, PageRequest.of(input.getPageIndex(), input.getPageSize()))
                .map(exam -> conversionService.convert(exam, ExamDTO.class));
    }


    /**
     * When a POST request with the URI api/v1/exams is sent to the server,
     * the body which contains the exam in JSON format is converted to an exam object
     * and then added to the exam repository through exam service.
     * The response is an HTTP response code 200 with the exam as a body.
     *
     * @param input  Input of exam fields and values in JSON format
     * @param result The binding result to check for validation errors
     * @return HTTP response 200 OK and exam in JSON format
     */
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Exam> create(@RequestBody @Valid CreateInput input, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequestException("Input values are invalid.", result.getAllErrors());
        }
        Exam exam = examsService.create(conversionService.convert(input, Exam.class));
        return ResponseEntity.accepted().body(exam);
    }

    /**
     * When the server receives an PUT request with the URI /update/%id% and the request
     * body of exam fields and values in JSON format, the fields that are not null are updated
     * in the exam with the given id %id%. The HTTP response is 200 OK and the exam in JSON
     * format.
     *
     * @param input  The request body of an exam in JSON format.
     * @param result The binding result for validating input values.
     * @param id     The id of the exam given in the URI.
     * @return HTTP response code 200 OK and the updated exam in JSON format.
     * @implNote There were some problems sending PUT requests, hence the request method and response body annotation.
     */
    @PutMapping(value = "/{id}", consumes = "application/json")
    public Object update(@RequestBody @Valid UpdateInput input, BindingResult result, @PathVariable("id") @Valid long id) {
        if (result.hasErrors()) {
            throw new BadRequestException("Unable to update exam.", result.getAllErrors());
        }
        Exam exam = examsService.findById(id);
        if (input.getTitle() != null) {
            exam.setTitle(input.getTitle());
        }
        if (input.getCourseCode() != null) {
            exam.setCourseCode(input.getCourseCode());
        }
        if (input.getCredits() != null) {
            exam.setCredits(input.getCredits());
        }
        if (input.getStartAt() != null) {
            exam.setStartAt(input.getStartAt());
        }
        if (input.getEndAt() != null) {
            exam.setEndAt(input.getEndAt());
        }
        if (input.getNote() != null) {
            exam.setNote(input.getNote());
        }
        exam.setUpdatedAt(new Date());
        return conversionService.convert(examsService.update(exam), ExamDTO.class);
    }

    /**
     * When a DELETE request is sent to the server with the URI delete/%id%, the id
     * %id% in the URI is used along with the exam service to delete the exam.
     *
     * @param id The id of the exam
     * @implNote There were some problems sending DELETE requests, hence the request method and response body annotation.
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExam(@PathVariable long id) {
        examsService.delete(examsService.findById(id));
    }

    @GetMapping(value = "/{id}")
    public ExamDTO retrieve(@PathVariable long id) {
        return conversionService.convert(examsService.findById(id), ExamDTO.class);
    }
}
