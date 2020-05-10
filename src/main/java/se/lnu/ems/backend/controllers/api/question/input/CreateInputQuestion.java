package se.lnu.ems.backend.controllers.api.question.input;

import javax.persistence.Column;

public class CreateInputQuestion {

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
	 * @return type of the question
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return text of the question
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return note for the question
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return exam_id which the question belongs to
	 */
	public long getExam_id() {
		return exam_id;
	}

	/**
	 * @param exam_id
	 */
	public void setExam_id(long exam_id) {
		this.exam_id = exam_id;
	}

}
