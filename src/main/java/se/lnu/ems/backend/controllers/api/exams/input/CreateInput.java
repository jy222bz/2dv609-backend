package se.lnu.ems.backend.controllers.api.exams.input;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * The type Create input.
 */
public class CreateInput {

    /**
     * The date when the exam can be started. The student can only do the exam
     */
    @NotNull
    @Future
    private Date startAt;

    /**
     * The date when the exam ends. After this date, the student can
     * no longer do the exam.
     */
    @NotNull
    @Future
    private Date endAt;

    /**
     * The class code. For instance, 2DV609.
     */
    @Size(min = 1, max = 255)
    @NotNull
    private String courseCode;

    /**
     * Credits, also called högskolepoäng in swedish.
     */
    @NotNull
    @Min(0)
    @Max(15)
    private float credits;


    /**
     * The title of the exam.
     */
    @NotNull
    @Size(min = 1, max = 255)
    private String title;

    /**
     * A note or description of the exam.
     */
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
