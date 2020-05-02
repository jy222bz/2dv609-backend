package se.lnu.ems.backend.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author Hamza
 * @see EMS Design Document -> Figure 10
 * @since 2020-05-01
 * 
 * <p>
 * Implementation of the conceptual model according to the design of the exam component, see
 * Figure 10 in the EMS Design Document.
 * </p>
 * 
 */
@Entity
@Table(name = "exams")
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * The creation date of the exam. 
	 */
	@Column(name = "created_at")
	private Date createdAt;
	
	/**
	 * The date when the exam can be started. The student can only do the exam
	 */
	@Column(nullable = false, name = "start_at")
	private Date startDate;
	
	/**
	 * The date when the exam ends. After this date, the student can 
	 * no longer do the exam.
	 */
	@Column(nullable = false, name = "end_at")
	private Date endDate;
	
	
	/**
	 *  The class code. For instance, 2DV609.
	 */
	/*
	@Column(nullable = false, name = "class_code")
	private String classCode;
	*/
	/**
	 *  Credits, also called högskolepoäng in swedish. 
	 */
	/*
	@Column(nullable = false)
	private float credits;
	*/
	/**
	 * The title of the exam.
	 */
	@Column(length = 64, name = "title")
	private String title;
	
	public Exam() {}
	
	
	/**
	 * @return Title of the exam.
	 */
	public String getTitle() {
		return title;
	}
	
	
	/**
	 * @param A new title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	/*
	 * More getters & setters to be implemented
	 */
	
	
}
