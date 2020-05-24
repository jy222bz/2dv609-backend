package se.lnu.ems.backend.controllers.api.exams.input;

import org.springframework.lang.Nullable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * A class for the retrieve input.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020 -05-01
 */
public class RetrieveInput {

    /**
     * A private field for the page index.
     */
    @Min(0)
    @Nullable
    private int pageIndex;

    /**
     * A private field for the page size.
     */
    @Min(1)
    @Nullable
    private int pageSize;

    @Nullable
    @Size(max = 255)
    private String filterValue;

    @Nullable
    private String note;

    @Nullable
    @Size(max = 255)
    private String courseCode;

    /**
     * It returns the page index.
     *
     * @return int. page index
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * It sets the page index.
     *
     * @param pageIndex page index.
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * It returns the page size.
     *
     * @return int. page size
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * It sets the page size.
     *
     * @param pageSize page size.
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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
     * Gets course code.
     *
     * @return the course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets course code.
     *
     * @param courseCode the course code
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }


    @Nullable
    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(@Nullable String filterValue) {
        this.filterValue = filterValue;
    }
}