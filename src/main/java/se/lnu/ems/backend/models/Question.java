package se.lnu.ems.backend.models;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Question.
 *
 * @author Sirwan
 */
@Entity
@Table(name = "questions")
public class Question {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The question's text
     */
    @Column()
    private String text;

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
     * Description of the question
     */
    @Column()
    private String note;

    /**
     * Which exam this question belongs
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type")
    private QuestionType questionType;

    /**
     * Constructor
     */
    public Question() {

    }

    /**
     * Constructor with args
     *
     * @param type      the type
     * @param text      the text
     * @param createdAt the created at
     * @param updatedAt the updated at
     * @param note      the note
     * @param exam      the exam
     */
    public Question(String text, Date createdAt, Date updatedAt, String note, Exam exam) {
        this.text = text;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.note = note;
        this.exam = exam;
    }

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
     * Gets text.
     *
     * @return text of the question
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text.
     *
     * @param text the text
     */
    public void setText(String text) {
        this.text = text;
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
     * Gets note.
     *
     * @return note about question
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

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
