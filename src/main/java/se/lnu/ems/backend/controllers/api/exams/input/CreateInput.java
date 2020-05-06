package se.lnu.ems.backend.controllers.api.exams.input;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateInput {

	/**
	 * The date when the exam can be started. The student can only do the exam
	 */
	@Column(name = "start_at")
	@NotNull
	@Future
	private Date startDate;
	
	/**
	 * The date when the exam ends. After this date, the student can 
	 * no longer do the exam.
	 */
	@Column(name = "end_at")
	@NotNull
	@Future
	private Date endDate;
	
	/**
	 *  The class code. For instance, 2DV609.
	 */
	@Column(name = "course_code", length = 32)
	@NotNull
	private String courseCode;
	
	/**
	 *  Credits, also called högskolepoäng in swedish. 
	 */
	@Column(name = "credits")
	@NotNull
	@Min(0)
	@Max(15)
	private float credits;
	
	
	/**
	 * The title of the exam.
	 */
	@Column(name = "title")
	@NotNull
	@Size(min = 0, max = 64)
	private String title;
	
	/**
	 * A note or description of the exam.
	 */
	@Column(name = "note")
	@NotNull
	private String note;
	
	/**
	 * @return Title of the exam.
	 */
	public String getTitle() {
		return title;
	}
	
	
	/**
	 * @param title A new title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return The start date of the exam.
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * @param startDate A new start date.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * @return The end date of the exam.
	 */
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * @param endDate A new end date of the exam.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * @return The note/description of the exam.
	 */
	public String getNote() {
		return note;
	}
	
	/**
	 * @param note A new note/description of the exam.
	 */
	public void setNote(String note) {
		this.note = note;
	}
	
	/**
	 * @return Credits(högskolepoäng) corresponding to the exam.
	 */
	public float getCredits() {
		return credits;
	}
	
	/**
	 * @param credits New amount of credits for the exam.
	 */
	public void setCredits(float credits) {
		this.credits = credits;
	}
	
	/**
	 * @return The class code of the course.
	 */
	public String getCourseCode() {
		return courseCode;
	}
	
	
	/**
	 * @param courseCode A new course code.
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	

	
}
