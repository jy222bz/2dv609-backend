package se.lnu.ems.backend.controllers.api.exams.dto;

import java.util.Date;

/**
 * The type Exam dto.
 */
public class ExamDTO {
    private Long id;
    private String title;
    private String note;
    private Date startAt;
    private Date endAt;
    private Date createdAt;
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
     * Gets created at.
     *
     * @return the created at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public float getCredits() {
        return credits;
    }

    public void setCredits(float credits) {
        this.credits = credits;
    }
}
