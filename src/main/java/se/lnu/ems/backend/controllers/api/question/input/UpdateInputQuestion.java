package se.lnu.ems.backend.controllers.api.question.input;

import javax.persistence.Column;

public class UpdateInputQuestion {
	
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getExam_id() {
		return exam_id;
	}

	public void setExam_id(long exam_id) {
		this.exam_id = exam_id;
	}


}
