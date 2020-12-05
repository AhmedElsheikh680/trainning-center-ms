/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.trainningcenter.dto;

import com.seniorsteps.trainningcenter.model.Course;
import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 *
 * @author SMARTCS
 */
public class CourseStudentReportDto {
    
    @NotNull
    private Date fromDate;
    
    @NotNull
    private Date toDate;
    private Course course;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
}
