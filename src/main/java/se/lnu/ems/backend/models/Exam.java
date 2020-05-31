package se.lnu.ems.backend.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The type Exam.
 *
 * @author Hamza
 * @since 2020 -05-01 <p> Implementation of the conceptual model according to the design of the exam component, see Figure 10 in the EMS Design Document. </p>
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
	@Column()
	private Date createdAt;
	
	/**
	 * The date when the exam can be started. The student can only do the exam
	 */
	@Column(nullable = false)
	private Date startAt;
	
	/**
	 * The date when the exam ends. After this date, the student can 
	 * no longer do the exam.
	 */
	@Column(nullable = false)
	private Date endAt;
	
	/**
	 * The last update of the exam. Whenever a field in an exam updates, this field is
	 * also updated to the current time stamp.
	 */
	@Column(nullable = false)
	private Date updatedAt;
	
	/**
	 *  The class code. For instance, 2DV609.
	 */
	@Column(nullable = false, length = 32)
	private String courseCode;
	
	/**
	 *  Credits, also called högskolepoäng in swedish. 
	 */
	@Column(nullable = false)
	private float credits;
	
	/**
	 * The title of the exam.
	 */
	@Column(nullable = false)
	private String title;
	
	/**
	 * A note or description of the exam.
	 */
	@Column()
	private String note;

	/**
	 * Default constructor
	 */
	public Exam() {}

	/**
	 * Constructor takes the fields that are nullable. When an exam is created these fields
	 * must be assigned a value.
	 *
	 * @param createdAt  The current time stamp.
	 * @param startAt    The date when the exam starts.
	 * @param endAt      The date when the exam ends.
	 * @param credits    Amount of credits the exam corresponds to.
	 * @param courseCode The course code.
	 */
	public Exam(Date createdAt, Date startAt, Date endAt, float credits, String courseCode) {
		setCreatedAt(createdAt);
		setStartAt(startAt);
		setEndAt(endAt);
		setCredits(credits);
		setCourseCode(courseCode);
		setUpdatedAt(createdAt);
	}

	/**
	 * Constructor takes all the fields.
	 *
	 * @param createdAt  The current time stamp.
	 * @param startAt    The date when the exam starts.
	 * @param endAt      The date when the exam ends.
	 * @param credits    Amount of credits the exam corresponds to.
	 * @param courseCode The course code.
	 * @param title      The title of the exam
	 * @param note       Note or description of the exam.
	 */
	public Exam(Date createdAt, Date startAt, Date endAt, float credits, String courseCode, String title, String note) {
		this(createdAt, startAt, endAt, credits, courseCode);
		setTitle(title);
		setNote(note);
	}


	/**
	 * Gets title.
	 *
	 * @return Title of the exam.
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * Sets title.
	 *
	 * @param title A new title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * Gets created at.
	 *
	 * @return Creation date of the exam.
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * @param createdAt A new creation date. 
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets start at.
	 *
	 * @return The start date of the exam.
	 */
	public Date getStartAt() {
		return startAt;
	}

	/**
	 * Sets start at.
	 *
	 * @param startAt A new start date.
	 */
	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}

	/**
	 * Gets end at.
	 *
	 * @return The end date of the exam.
	 */
	public Date getEndAt() {
		return endAt;
	}

	/**
	 * Sets end at.
	 *
	 * @param endAt A new end date of the exam.
	 */
	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}

	/**
	 * Gets updated at.
	 *
	 * @return The last update date of the exam.
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Sets updated at.
	 *
	 * @param updatedAt A new last update date. Any change to the exam shall update the date.
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * Gets note.
	 *
	 * @return The note/description of the exam.
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Sets note.
	 *
	 * @param note A new note/description of the exam.
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * Gets credits.
	 *
	 * @return Credits(högskolepoäng) corresponding to the exam.
	 */
	public float getCredits() {
		return credits;
	}

	/**
	 * Sets credits.
	 *
	 * @param credits New amount of credits for the exam.
	 */
	public void setCredits(float credits) {
		this.credits = credits;
	}

	/**
	 * Gets course code.
	 *
	 * @return The class code of the course.
	 */
	public String getCourseCode() {
		return courseCode;
	}


	/**
	 * Sets course code.
	 *
	 * @param courseCode A new course code.
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
