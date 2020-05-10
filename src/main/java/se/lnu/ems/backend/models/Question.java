package se.lnu.ems.backend.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sirwan
 *
 */
@Entity
@Table(name = "questions")
public class Question {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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
	 * The date the question was created 
	 */
	@Column(name = "createdAt")
	private Date createdAt;
	
	/**
	 * The date the question was updated
	 */
	@Column(name = "updatedAt")
	private Date updatedAt;
	
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
	 * Constructor 
	 */
	public Question() {

	}

	/**
	 * Constructor with args
	 * 
	 * @param id
	 * @param type
	 * @param text
	 * @param createdAt
	 * @param updatedAt
	 * @param note
	 * @param exam_id
	 */
	public Question(int type, String text, Date createdAt, Date updatedAt, String note, long exam_id) {
		super();
		this.type = type;
		this.text = text;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.note = note;
		this.exam_id= exam_id;
	}

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the type of question
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
	 * @return the date in which the question was created
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the date in which the question was updated
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return note about question
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
