package se.lnu.ems.backend.models;

import java.util.Date;

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
	 * The last update of the exam. Whenever a field in an exam updates, this field is
	 * also updated to the current time stamp.
	 */
	@Column(nullable = false, name = "updated_at")
	private Date lastUpdateDate;
	
	/**
	 *  The class code. For instance, 2DV609.
	 */
	@Column(nullable = false, name = "course_code", length = 32)
	private String courseCode;
	
	/**
	 *  Credits, also called högskolepoäng in swedish. 
	 */
	@Column(nullable = false, name = "credits")
	private float credits;
	
	/**
	 * The title of the exam.
	 */
	@Column(nullable = false, length = 64, name = "title")
	private String title;
	
	/**
	 * A note or description of the exam.
	 */
	@Column(name = "note")
	private String note;
	
	/**
	 * Default constructor
	 */
	public Exam() {}
	
	/**
	 * 
	 * Constructor takes the fields that are nullable. When an exam is created these fields
	 * must be assigned a value.
	 * 
	 * @param createdAt The current time stamp. 
	 * @param startDate The date when the exam starts.
	 * @param endDate The date when the exam ends.
	 * @param credits Amount of credits the exam corresponds to.
	 * @param courseCode The course code.
	 */
	public Exam(Date createdAt, Date startDate, Date endDate, float credits, String courseCode) {
		setCreatedAt(createdAt);
		setStartDate(startDate);
		setEndDate(endDate);
		setCredits(credits);
		setCourseCode(courseCode);
		setLastUpdateDate(createdAt);
	}
	
	/**
	 * 
	 * Constructor takes all the fields.
	 * 
	 * @param createdAt The current time stamp. 
	 * @param startDate The date when the exam starts.
	 * @param endDate The date when the exam ends.
	 * @param credits Amount of credits the exam corresponds to.
	 * @param courseCode The course code.
	 * @param title The title of the exam
	 * @param note Note or description of the exam.
	 */
	public Exam(Date createdAt, Date startDate, Date endDate, float credits, String courseCode, String title, String note) {
		this(createdAt, startDate, endDate, credits, courseCode);
		setTitle(title);
		setNote(note);
	}
	
	
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
	 * @return Creation date of the exam. 
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * @param createdAt A new creation date. 
	 */
	private void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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
	 * @return The last update date of the exam. 
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	
	/**
	 * @param lastUpdateDate A new last update date. Any change to the exam shall update the date.
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
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
	
	/**
	 * @return the ID of the exam.
	 */
	public long getID() {
		return id;
	}
	
}
