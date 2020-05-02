package se.lnu.ems.backend.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import se.lnu.ems.backend.models.Exam;
import se.lnu.ems.backend.repositories.ExamsRepository;
import se.lnu.ems.backend.repositories.UsersRepository;

@Service
public class ExamServiceImpl implements ExamsService{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ExamsRepository examRepository;
	
	@Override
	public List<Exam> retrieve(Pageable pageable) {
		List<Exam> exams = new ArrayList<>();
		examRepository.findAll(pageable).forEach(exams::add);
		return exams;
	}
	
}
