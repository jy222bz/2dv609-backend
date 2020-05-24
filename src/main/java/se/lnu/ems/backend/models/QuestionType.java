package se.lnu.ems.backend.models;

import javax.persistence.*;
import java.util.Date;

/**
 * An interface for the Question Type.
 *
 * @author Osama Zarraa
 * @version 1.0
 * @since 2020 -05-24
 */
@Entity
@Table(name = "question_types")
public class QuestionType {

    /**
     * A private field for the identification of the role.
     * It is auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * A private field for the name of the role.
     */
    private String name;

    /**
     * A private field for the note.
     */
    private String note;

    /**
     * A private field for the date of creation.
     */
    private Date createdAt;

    /**
     * A private field for the date of update.
     */
    private Date updatedAt;

    /**
     * It returns the Id.
     *
     * @return Long. id
     */
    public Long getId() {
        return id;
    }

    /**
     * It sets the Id.
     *
     * @param id the id of the role.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * It returns the date of creation.
     *
     * @return Date. created at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * It sets the date of creation.
     *
     * @param createdAt the date of creation
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * It returns the date of the update.
     *
     * @return Date. updated at
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * It sets the the date of the update.
     *
     * @param updatedAt the date of the update.
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * It returns the name of the role.
     *
     * @return String. name
     */
    public String getName() {
        return name;
    }

    /**
     * It sets teh name of the role.
     *
     * @param name the name of the role.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * It returns the note.
     *
     * @return String. note
     */
    public String getNote() {
        return note;
    }

    /**
     * It sets the note.
     *
     * @param note the note.
     */
    public void setNote(String note) {
        this.note = note;
    }
}
