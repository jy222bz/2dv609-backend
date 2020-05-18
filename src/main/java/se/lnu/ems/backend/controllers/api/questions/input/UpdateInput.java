package se.lnu.ems.backend.controllers.api.questions.input;

import javax.persistence.Column;

/**
 * The type Update input.
 */
public class UpdateInput {
	
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
	private long exam_id;

    /**
     * Gets type.
     *
     * @return the type
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
     * @return the text
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
     * Gets exam id.
     *
     * @return the exam id
     */
    public long getExam_id() {
		return exam_id;
	}

    /**
     * Sets exam id.
     *
     * @param exam_id the exam id
     */
    public void setExam_id(long exam_id) {
		this.exam_id = exam_id;
	}


}
