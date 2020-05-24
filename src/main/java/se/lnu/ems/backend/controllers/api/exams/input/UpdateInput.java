package se.lnu.ems.backend.controllers.api.exams.input;

import org.springframework.lang.Nullable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * The type Update input.
 */
public class UpdateInput {

	/**
	 * The date when the exam can be started. The student can only do the exam
	 */
	@Nullable
	private Date startAt;
	
	/**
	 * The date when the exam ends. After this date, the student can 
	 * no longer do the exam.
	 */
	@Nullable
	private Date endAt;
	
	/**
	 *  The class code. For instance, 2DV609.
	 */
	@Nullable
	private String courseCode;
	
	/**
	 *  Credits, also called högskolepoäng in swedish. 
	 */
	@Nullable
	@Min(0)
	@Max(15)
	private Float credits;
	
	
	/**
	 * The title of the exam.
	 */
	@Nullable
	@Size(max = 64)
	private String title;
	
	/**
	 * A note or description of the exam.
	 */
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
    public Date getStartAt() {
		return startAt;
	}

    /**
     * Sets start date.
     *
     * @param startAt A new start date.
     */
    public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}

    /**
     * Gets end date.
     *
     * @return The end date of the exam.
     */
    public Date getEndAt() {
		return endAt;
	}

    /**
     * Sets end date.
     *
     * @param endAt A new end date of the exam.
     */
    public void setEndAt(Date endAt) {
		this.endAt = endAt;
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
    public Float getCredits() {
		return credits;
	}

    /**
     * Sets credits.
     *
     * @param credits New amount of credits for the exam.
     */
    public void setCredits(Float credits) {
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
