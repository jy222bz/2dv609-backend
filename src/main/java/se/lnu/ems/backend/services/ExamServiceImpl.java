package se.lnu.ems.backend.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import exceptions.BadRequestException;
import exceptions.InternalServerErrorException;
import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.repositories.ExamsRepository;
import se.lnu.ems.backend.repositories.UsersRepository;

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
	 * @param pageable
	 * @param predicate
	 * @return
	 */
	public List<Exam> retrieve(Pageable pageable, Predicate<? super Exam> predicate){
		List<Exam> exams = new ArrayList<>();
		examRepository.findAll(pageable).filter(predicate).forEach(exams::add);
		return exams;
	}
	
	/**
	 * @param id The id of the exam.
	 * @return Returns a single exam. This is due to the uniqueness of IDs.
	 */
	@Override
	public Exam retrieveSingleExam(long id) throws InternalServerErrorException{		
		return examRepository.findById(id).orElseThrow(() -> new InternalServerErrorException("ID not found"));
	}
	
	
	
}
