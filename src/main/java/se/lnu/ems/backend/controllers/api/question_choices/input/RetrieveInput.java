package se.lnu.ems.backend.controllers.api.question_choices.input;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

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

    @Nullable
    private String filterValue;


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

    /**
     * Gets filter value.
     *
     * @return the filter value
     */
    public String getFilterValue() {
        return filterValue;
    }

    /**
     * Sets filter value.
     *
     * @param filterValue the filter value
     */
    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }
}
