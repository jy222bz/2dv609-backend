package se.lnu.ems.backend.models;

import javax.persistence.*;
import java.util.Date;

/**
 * A class for the User.
 * This class contains annotations for database purposes.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * A private field for the identification of the user.
     * It is auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * A private field for the e-mail.
     */
    private String email;

    /**
     * A private field for the first name.
     */
    private String firstName;

    /**
     * A private field for the last name.
     */
    private String lastName;

    /**
     * A private field for the password.
     */
    private String password;

    /**
     * A private field for the date of creation.
     */
    private Date createdAt;

    /**
     * A private field for the date of update.
     */
    private Date updatedAt;

    /**
     * A private field for the note.
     */
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    /**
     * A constructor, to construct an object.
     */
    public User() {
        /* No need for parameters.*/
    }

    /**
     * It returns the identification of the user.
     *
     * @return Long id
     */
    public Long getId() {
        return id;
    }

    /**
     * It sets the identification of the user.
     *
     * @param id the user's Id.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * it returns the first name of the user.
     *
     * @return String first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * It sets the first name of the user.
     *
     * @param firstName the first name of the user.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * It returns the last name of the user.
     *
     * @return String. last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * It sets the last name of the user.
     *
     * @param lastName the last name of the user.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * It returns the essential information of the user as String.
     *
     * @return String.
     */
    @Override
    public String toString() {
        return String.format("User[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
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
     * It sets the date of the update.
     *
     * @param updatedAt the date of the update.
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * It returns the time of the creation.
     *
     * @return Date. created at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * It sets the time of the creation.
     *
     * @param createdAt the time of creation.
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    /**
     * It returns the e-mail.
     *
     * @return String. email
     */
    public String getEmail() {
        return email;
    }

    /**
     * It sets the e-mail.
     *
     * @param email the e-mail of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * It returns the password.
     *
     * @return String. password
     */
    public String getPassword() {
        return password;
    }

    /**
     * It sets the password.
     *
     * @param password the password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * It returns the role.
     *
     * @return Role. role
     */
    public Role getRole() {
        return role;
    }

    /**
     * It sets the role.
     *
     * @param role the role.
     */
    public void setRole(Role role) {
        this.role = role;
    }
}
