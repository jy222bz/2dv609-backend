package se.lnu.ems.backend.controllers.api.exam_students.input;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * The type Retrieve input.
 */
public class RetrieveInput {
    /**
     * A private field for the page index.
     */
    @NotNull
    @Min(0)
    private int pageIndex;

    /**
     * A private field for the page size.
     */
    @NonNull
    @Min(1)
    private int pageSize;


    /**
     * Gets page index.
     *
     * @return the page index
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * Sets page index.
     *
     * @param pageIndex the page index
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * Gets page size.
     *
     * @return the page size
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Sets page size.
     *
     * @param pageSize the page size
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
