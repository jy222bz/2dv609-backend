package se.lnu.ems.backend.controllers.api.exams.input;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * A class for the retrieve input.
 *
 * @author Jacob Yousif
 * @version 1.0
 * @since 2020-05-01
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

    @Min(0)
    @Nullable
    private int id;
    
    @Nullable
    private String title;
    
    @Nullable
    private String note;
    
    @Nullable
    private String courseCode;
   
    /**
     * It returns the page index.
     *
     * @return int.
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
     * @return int.
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
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public int getId() {
    	return id;
    }
    
    public String getTitle() {
    	return title;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public String getNote() {
    	return note;
    }
    
    public void setNote(String note) {
    	this.note = note;
    }
    
    public String getCourseCode() {
    	return courseCode;
    }
    
    public void setCourseCode(String courseCode) {
    	this.courseCode = courseCode;
    }
    
    
}