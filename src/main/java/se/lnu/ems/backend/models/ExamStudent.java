package se.lnu.ems.backend.models;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Exam student.
 */
@Entity
@Table(name = "exam_students")
public class ExamStudent {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The date the question was created
     */
    @Column()
    private Date createdAt;

    /**
     * The date the question was updated
     */
    @Column()
    private Date updatedAt;

    /**
     * Which exam this question belongs
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Gets id.
     *
     * @return id id
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
     * Gets created at.
     *
     * @return the date in which the question was created
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

    /**
     * Gets updated at.
     *
     * @return the date in which the question was updated
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets updated at.
     *
     * @param updatedAt the updated at
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    /**
     * Gets exam.
     *
     * @return the exam
     */
    public Exam getExam() {
        return exam;
    }

    /**
     * Sets exam.
     *
     * @param exam the exam
     */
    public void setExam(Exam exam) {
        this.exam = exam;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
