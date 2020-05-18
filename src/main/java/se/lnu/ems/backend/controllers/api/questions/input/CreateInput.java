package se.lnu.ems.backend.controllers.api.questions.input;

import javax.persistence.Column;

/**
 * The type Create input question.
 */
public class CreateInput {

    /**
     * The type of question text or multi-choice
     */
    @Column(name = "type")
    private int type;

    /**
     * The question's text
     */
    @Column(name = "text")
    private String text;

    /**
     * Description of the question
     */
    @Column(name = "note")
    private String note;

    /**
     * Which exam this question belongs
     */
    private long examId;

    /**
     * Gets type.
     *
     * @return type of the question
     */
    public int getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(int type) {
        this.type = type;
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
     * Gets note.
     *
     * @return note for the question
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
     * Gets exam id.
     *
     * @return exam_id which the question belongs to
     */
    public long getExamId() {
        return examId;
    }

    /**
     * Sets exam id.
     *
     * @param examId the exam id
     */
    public void setExamId(long examId) {
        this.examId = examId;
    }

}
