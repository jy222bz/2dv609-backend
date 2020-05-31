package se.lnu.ems.backend.controllers.api.student.dto;

import java.util.Date;

/**
 * The type Exam dto.
 */
public class StudentExamDTO {
    private Long id;
    private String title;
    private String note;
    private Date startAt;
    private Date endAt;
    private String courseCode;
    private float credits;

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

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets note.
     *
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets note.
     *
     * @param note the note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Gets start at.
     *
     * @return the start at
     */
    public Date getStartAt() {
        return startAt;
    }

    /**
     * Sets start at.
     *
     * @param startAt the start at
     */
    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    /**
     * Gets end at.
     *
     * @return the end at
     */
    public Date getEndAt() {
        return endAt;
    }

    /**
     * Sets end at.
     *
     * @param endAt the end at
     */
    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    /**
     * Gets course code.
     *
     * @return the course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets course code.
     *
     * @param courseCode the course code
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Gets credits.
     *
     * @return the credits
     */
    public float getCredits() {
        return credits;
    }

    /**
     * Sets credits.
     *
     * @param credits the credits
     */
    public void setCredits(float credits) {
        this.credits = credits;
    }
}
