package se.lnu.ems.backend.controllers.api.questions.input;

import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

/**
 * The type Create input question.
 */
public class CreateInput {

    /**
     * The type of question text or multi-choice
     */
    @NotNull
    private Long type;

    /**
     * The question's text
     */
    @NotNull
    private String text;

    /**
     * Description of the question
     */
    @Nullable
    private String note;


    /**
     * Gets type.
     *
     * @return type of the question
     */
    public Long getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(Long type) {
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

}
