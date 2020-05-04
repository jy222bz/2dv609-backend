package se.lnu.ems.backend.services;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import exceptions.BadRequestException;
import exceptions.InternalServerErrorException;
import se.lnu.ems.backend.models.Exam;

@Service
public interface ExamsService {
	
	public List<Exam> retrieve(Pageable pageable);
	public List<Exam> retrieve(String field, String value);
	public Exam retrieveSingleExam(long id) throws InternalServerErrorException, BadRequestException;
	
}
