package se.lnu.ems.backend.services;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.data.domain.Pageable;

import exceptions.InternalServerErrorException;
import se.lnu.ems.backend.models.Exam;


public interface ExamsService {
	
	public List<Exam> retrieve(Pageable pageable);
	public List<Exam> retrieve(String field, String value);
	public List<Exam> retrieve(Pageable pageable, Predicate<? super Exam> predicate);
	public Exam retrieveSingleExam(long id) throws InternalServerErrorException;
	public Exam create(Exam exam);
	public void update(Exam exam);
	public void delete(Exam exam);
	
}
