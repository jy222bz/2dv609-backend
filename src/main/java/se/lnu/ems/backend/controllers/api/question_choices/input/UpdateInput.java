package se.lnu.ems.backend.controllers.api.question_choices.input;

import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

/**
 * The type Update input.
 */
public class UpdateInput {
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

    @NotNull
    private boolean correct;

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
     * Is correct boolean.
     *
     * @return the boolean
     */
    public boolean isCorrect() {
        return correct;
    }

    /**
     * Sets correct.
     *
     * @param correct the correct
     */
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
