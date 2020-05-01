package se.lnu.ems.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.services.ExamsService;

@RestController
@RequestMapping("/api/exam")
public class ExamsController {
	
	ExamsService examService;
	
	@GetMapping("/exam")
	public Exam getExam() {
		//return examService.getMockExam();
		return null;
	}
	
}
