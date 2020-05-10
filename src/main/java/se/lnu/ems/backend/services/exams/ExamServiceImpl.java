package se.lnu.ems.backend.services.exams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.repositories.ExamsRepository;
import se.lnu.ems.backend.services.exams.exceptions.*;

/**
 * This class is a service implementation of the exam service interface. 
 * The exam service class provides the controllers CRUD methods of the exam repository.
 * 
 * @author Hamza
 * @since 2020-04-02
 * 
 */
@Service
public class ExamServiceImpl implements ExamsService{
	
	/**
	 * An autowired instance of the exam repository.
	 */
	@Autowired
	ExamsRepository examRepository;
	
	/**
	 * Retrieves certain exams that meet the paging restrictions.
	 * @param pageable A set of exams to be retrieved.
	 * @return A list of exams that meet the paging restrictions.
	 */
	@Override
	public List<Exam> retrieve(Pageable pageable) {
		List<Exam> exams = new ArrayList<>();
		examRepository.findAll(pageable).forEach(exams::add);
		return exams;
	}
	
	/**
	 * @param field A field of either title, note or courseCode.
	 * @param value A matching or containing value for some exam's field in the exam repository.
	 * @return The list of exam that contain the value argument in either the title, note or course code.
	 * @deprecated
	 */
	public List<Exam> retrieve(String field, String value){
		if(field.equals("title")) {
			return examRepository.findByTitle(value);
		}else if(field.equals("courseCode")) {
			return examRepository.findByCourseCode(value);
		}else if(field.equals("note")) {
			return examRepository.findByNote(value);
		}else {
			return null; // FIX: Should return an empty collection according to SonarLint.
		}
	}
	/**
	 * 
	 * Retrieves exams that meet the paging restrictions. The exams are then filtered
	 * according to the given predicate.
	 * 
	 * @param pageable Paging restrictions.
	 * @param predicate Predicate for filtering.
	 * @return a list of exams that meet the paging restrictions and the predicate.
	 */
	public List<Exam> retrieve(Pageable pageable, Predicate<? super Exam> predicate){
		return examRepository.findAll(pageable).filter(predicate).get().collect(Collectors.toList());
	}
	
	/**
	 * @param id The id of the exam.
	 * @return Returns a single exam. This is due to the uniqueness of IDs.
	 */
	@Override
	public Exam retrieveSingleExam(long id) throws InternalServerErrorException{		
		return examRepository.findById(id).orElseThrow(() -> new InternalServerErrorException("ID not found"));
	}
	
	/**
	 * @param exam Exam to be saved in the exam repository.
	 * @return The exam that is saved to the exam repository.
	 */
	@Override
	public Exam create(Exam exam) {
		return examRepository.save(exam);
	}
	
	/**
	 * @param exam Exam to be deleted from the exam repository.
	 * @return void
	 */
	@Override
	public void delete(Exam exam) {
		examRepository.delete(exam);
	}
	/**
	 * @param exam Exam to be updated from the exam repository.
	 * @return void
	 */
	@Override
	public void update(Exam exam) {
		examRepository.save(exam);
	}
	
}
