package se.lnu.ems.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;
import se.lnu.ems.backend.models.Exam;
@Service
public interface ExamsService {
	
	public List<Exam> retrieve();
	
}
