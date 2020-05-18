package se.lnu.ems.backend.controllers.api.exams.input;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

/**
 * The type Update input.
 */
public class UpdateInput {

	/**
	 * The date when the exam can be started. The student can only do the exam
	 */
	@Column(name = "start_at")
	@Nullable
	@Future
	private Date startDate;
	
	/**
	 * The date when the exam ends. After this date, the student can 
	 * no longer do the exam.
	 */
	@Column(name = "end_at")
	@Nullable
	@Future
	private Date endDate;
	
	/**
	 *  The class code. For instance, 2DV609.
	 */
	@Column(name = "course_code", length = 32)
	@Nullable
	private String courseCode;
	
	/**
	 *  Credits, also called högskolepoäng in swedish. 
	 */
	@Column(name = "credits")
	@Nullable
	@Min(0)
	@Max(15)
	private float credits;
	
	
	/**
	 * The title of the exam.
	 */
	@Column(name = "title")
	@Nullable
	@Size(min = 0, max = 64)
	private String title;
	
	/**
	 * A note or description of the exam.
	 */
	@Column(name = "note")
	@Nullable
	private String note;

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
     * Gets start date.
     *
     * @return The start date of the exam.
     */
    public Date getStartDate() {
		return startDate;
	}

    /**
     * Sets start date.
     *
     * @param startDate A new start date.
     */
    public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

    /**
     * Gets end date.
     *
     * @return The end date of the exam.
     */
    public Date getEndDate() {
		return endDate;
	}

    /**
     * Sets end date.
     *
     * @param endDate A new end date of the exam.
     */
    public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	

	
	
}
