
package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.dto.CourseStudentReportDto;
import com.seniorsteps.trainningcenter.model.Course;
import com.seniorsteps.trainningcenter.model.CourseStudent;
import java.util.Date;
import java.util.List;

public interface CourseStudentService {
    
    public List<CourseStudent> getList();
    
    public List<CourseStudent> getList(Date fromDate, Date toDate, Course course);
    
    public List<CourseStudent> getList(CourseStudentReportDto courseStudentReportDto);
    
    public CourseStudent getById(int id);
    
    public CourseStudent save(CourseStudent courseStudent);
    
    public CourseStudent update(CourseStudent courseStudent);
    
    public boolean delete(CourseStudent courseStudent);
    
}
