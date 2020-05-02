package se.lnu.ems.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.services.ExamServiceImpl;
import se.lnu.ems.backend.services.ExamsService;

@RestController
@RequestMapping("/api/v1/exams/")
public class ExamsController {
	
	@Autowired
	private ExamsService examsService;
	
	
	@GetMapping("/")
	public List<Exam> getExam() {
		return examsService.retrieve(PageRequest.of(0, 2));
	}
	
}
