package se.lnu.ems.backend.controllers.api.exams;

import java.util.Date;
import java.util.List;


import javax.validation.Valid;

import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import exceptions.BadRequestException;
import exceptions.InternalServerErrorException;
import se.lnu.ems.backend.controllers.api.exams.input.CreateInput;
import se.lnu.ems.backend.controllers.api.exams.input.RetrieveInput;
import se.lnu.ems.backend.controllers.api.exams.input.UpdateInput;
import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.services.ExamsService;

/**
 * RestController for the exam component.
 * 
 * @author Hamza
 *
 */
@RestController
@RequestMapping("/api/v1/exams/")
public class ExamsController {
	
	/**
	 * Instance of ExamsService
	 */
	private ExamsService examsService;
	
	/**
	 * Instance of ConversionService
	 */
	private ConversionService conversionService;
	
	public ExamsController(ExamsService examsService, ConversionService conversionService) {
		this.examsService = examsService;
		this.conversionService = conversionService;
	}
	
	/**
	 * 
	 * When the server receives a GET request with the URI /api/v1/exams and three optional
	 * parameters: title, note and courseCode, the method takes the union of all the exams
	 * that match the input value in the parameters. The server responds by transmitting an 
	 * HTTP response code 200 and the body contains the union of all the exams.
	 * 
	 * For instance, suppose the server receives GET request with the URI 
	 * /api/v1/exams/?title=Exam&courseCode=1DV609
	 * The response will be a list of all exams such that either contain the word "Exam" in 
	 * the title or contain the word "1DV609" in the course code. 
	 * 
	 * @param input The retrieved input values from the parameters.
	 * @param result The validation result of the input values.
	 * @return HTTP response code 200 and a list of exams in JSON format
	 * @throws InternalServerErrorException
	 * @throws BadRequestException
	 */
	@GetMapping("/union")
	public ResponseEntity<List<Exam>> getUnionExamResponse(RetrieveInput input, BindingResult result) throws InternalServerErrorException, BadRequestException {
		if(result.hasErrors()) {
			throw new InternalServerErrorException("The input is invalid.");
		}
		return ResponseEntity.ok().body(
				examsService.retrieve(
						PageRequest.of(input.getPageIndex(), input.getPageSize()), 
						(Exam e) -> (input.getTitle() != null && !input.getTitle().isBlank() ? e.getTitle().toLowerCase().contains(input.getTitle().toLowerCase() + "") : false) ||
									(input.getCourseCode() != null && !input.getCourseCode().isBlank() ? e.getCourseCode().toLowerCase().contains(input.getCourseCode().toLowerCase() + "") : false) ||
									(input.getNote() != null && !input.getNote().isBlank() ? e.getNote().toLowerCase().contains(input.getNote().toLowerCase()) : false)		
						));
	}
	/**
	 * 
	 * When the server receives a GET request with the URI /api/v1/exams and three optional
	 * parameters: title, note and courseCode, the method takes the intersection of all the 
	 * exams that match the input value in the parameters. The server responds by transmitting 
	 * an HTTP response code 200 and the body contains the intersection of all the exams.
	 * 
	 * For instance, suppose the server receives GET request with the URI 
	 * /api/v1/exams/?title=Exam&courseCode=1DV609
	 * The response will be a list of all exams such that contain the word "Exam" in the title 
	 * and contain the word "1DV609" in the course code.
	 * 
	 * @param input The retrieved input values from the parameters.
	 * @param result The validation result of the input values.
	 * @return HTTP response code 200 and a list of exams in JSON format
	 * @throws InternalServerErrorException
	 * @throws BadRequestException
	 */
	@GetMapping("/intersect")
	public ResponseEntity<List<Exam>> getIntersectionExamResponse(RetrieveInput input, BindingResult result) throws InternalServerErrorException, BadRequestException{
		if(result.hasErrors()) {
			throw new InternalServerErrorException("The input is invalid.");
		}
		return ResponseEntity.ok().body(
				examsService.retrieve(
						PageRequest.of(input.getPageIndex(), input.getPageSize()), 
						(Exam e) -> (input.getTitle() != null && !input.getTitle().isBlank() ? e.getTitle().toLowerCase().contains(input.getTitle().toLowerCase() + "") : true) &&
									(input.getCourseCode() != null && !input.getCourseCode().isBlank() ? e.getCourseCode().toLowerCase().contains(input.getCourseCode().toLowerCase() + "") : true) &&
									(input.getNote() != null && !input.getNote().isBlank() ? e.getNote().toLowerCase().contains(input.getNote().toLowerCase()) : true)		
						));
	}
	

	
	/**
	 * When a POST request with the URI api/v1/exams/create is sent to the server,
	 * the body which contains the exam in JSON format is converted to an exam object
	 * and then added to the exam repository through exam service.
	 * The response is an HTTP response code 200 with the exam as a body.
	 * @param input Input of exam fields and values in JSON format
	 * @param result The binding result to check for validation errors
	 * @return HTTP response 200 OK and exam in JSON format
	 * @throws InternalServerErrorException
	 */
	@PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Exam> createExam(@RequestBody @Valid CreateInput input, BindingResult result) throws InternalServerErrorException{
		if(result.hasErrors()) {
			throw new InternalServerErrorException("Input values are invalid.");
		}
		Exam exam = examsService.create(conversionService.convert(input, Exam.class));
		return ResponseEntity.accepted().body(exam);
		
	}
	
	/**
	 * When a GET/DELETE request is sent to the server with the URI delete/%id%, the id
	 * %id% in the URI is used along with the exam service to delete the exam.
	 *
	 * @implNote There were some problems sending DELETE requests, hence the request method and response body annotation.
	 * 
	 * @param id The id of the exam
	 * @return HTTP response 200 OK and the exam in JSON format
	 * @throws InternalServerErrorException
	 *
	 */
	@RequestMapping(method = {RequestMethod.DELETE, RequestMethod.GET}, value = "/delete/{id}", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<Exam> deleteExam(@PathVariable long id) throws InternalServerErrorException{
		Exam exam = examsService.retrieveSingleExam(id);
		examsService.delete(exam);
		return ResponseEntity.ok().body(exam);
	}
	
	/**
	 * When the server receives an PUT/GET request with the URI /update/%id% and the request 
	 * body of exam fields and values in JSON format, the fields that are not null are updated
	 * in the exam with the given id %id%. The HTTP response is 200 OK and the exam in JSON 
	 * format.
	 * 
	 * @implNote  There were some problems sending PUT requests, hence the request method and response body annotation.
	 *  
	 * @param input The request body of an exam in JSON format.
	 * @param result The binding result for validating input values.
	 * @param id The id of the exam given in the URI.
	 * @return HTTP response code 200 OK and the updated exam in JSON format.
	 * @throws InternalServerErrorException
	 */
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.GET}, value = "/update/{id}", consumes = "application/json")
	public @ResponseBody ResponseEntity<Exam> update(@RequestBody @Valid UpdateInput input, BindingResult result, @PathVariable("id") @Valid long id) throws InternalServerErrorException {
		if(result.hasErrors()) {
			throw new InternalServerErrorException("Unable to update exam.");
		}		
		
		// Temporary solution
		// Revise 
		Exam exam = examsService.retrieveSingleExam(id);
		
		if(input.getCourseCode() != null) {
			exam.setCourseCode(input.getCourseCode());
		}
		if(input.getCredits() >= 0 && input.getCredits() <= 15) {
			exam.setCredits(input.getCredits());
		}
		if(input.getEndDate() != null) {
			exam.setEndDate(input.getEndDate());
		}
		if(input.getStartDate() != null) {
			exam.setStartDate(input.getStartDate());
		}
		if(input.getTitle() != null) {
			exam.setTitle(input.getTitle());
		}
		if(input.getNote() != null) {
			exam.setNote(input.getNote());
		}
		exam.setLastUpdateDate(new Date());
		
		examsService.update(exam);
		return ResponseEntity.ok().body(examsService.retrieveSingleExam(id));
		
	}
}
