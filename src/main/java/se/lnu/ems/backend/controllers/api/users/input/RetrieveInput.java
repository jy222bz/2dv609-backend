package se.lnu.ems.backend.controllers.api.users.input;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
    @NotNull
    @Min(0)
    private int pageIndex;

    /**
     * A private field for the page size.
     */
    @NonNull
    @Min(1)
    private int pageSize;

    private String filterValue;

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

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }
}
