package se.lnu.ems.backend.controllers.exams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exceptions.BadRequestException;
import exceptions.InternalServerErrorException;
import se.lnu.ems.backend.models.Error;
import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.services.ExamServiceImpl;
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
	 * Autowired instance of ExamsService
	 */
	@Autowired
	private ExamsService examsService;
	
	/**
	 * When the server received a GET request with the URI /api/v1/exams/id/%id%
	 * then the server responds by transmitting an exam that corresponds with the id %id%.
	 * The data is sent as in JSON format.
	 * 
	 * @param unparsedExamID The unparsed exam ID. The string is parsed to an integer in the method.
	 * @return An HTTP response with response code 200. The body is the exam in JSON format.
	 * @throws InternalServerErrorException If the exam with the ID is not found, an InternalServerErrorException is thrown
	 * @throws BadRequestException If the ID cannot be parsed to to a long, then BadRequestException is thrown.
	 */
	@GetMapping("/id/{id}")
	public ResponseEntity<Exam> getExamByID(@PathVariable("id") String unparsedExamID) throws InternalServerErrorException, BadRequestException {
		
		long examID;
		if(unparsedExamID.matches("^(-|)[0-9]+$")) {
			examID = Long.parseLong(unparsedExamID);
		}else {
			throw new BadRequestException("Exam ID is invalid.");
		}
		
		Exam exam = examsService.retrieveSingleExam(examID);
		return ResponseEntity.ok().body(exam);
	}
	
	/**
	 * When the server receives a GET request with the URI /api/v1/exams/ and the three 
	 * optional parameters: title, note and courseCode, the method takes the union of all
	 * the exams that match the input value in the parameters title, note and courseCode.
	 * Finally the server responds by transmitting an HTTP response with the response code
	 * 200 and the body contains the unions of the lists of exams in JSON format.
	 * 
	 * @param title Title of exams.
	 * @param note Note of exams.
	 * @param courseCode Course code of exams.
	 * @return Returns HTTP response code 200 and list of exams in JSON format.
	 */
	@GetMapping("")
	@ResponseBody
	public ResponseEntity<List<Exam>> getExamsList(@RequestParam(required = false) String title, @RequestParam(required = false) String note, @RequestParam(required = false) String courseCode){	
		List<Exam> examsByTitle = examsService.retrieve("title", title);
		List<Exam> examsByNote = examsService.retrieve("note", note);
		List<Exam> examsByCourseCode = examsService.retrieve("courseCode", courseCode);
		
		// Taking the union of the three exam lists above by adding all the elements 
		// to a HashSet
		Set<Exam> examsSet = new HashSet<>();
		examsSet.addAll(examsByTitle);
		examsSet.addAll(examsByNote);
		examsSet.addAll(examsByCourseCode);
		
		return ResponseEntity.ok().body(new ArrayList<Exam>(examsSet));
	}
	
	
	

}
