
package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.model.Course;
import com.seniorsteps.trainningcenter.model.Lab;
import java.util.List;

public interface CourseService {
    
    public List<Course> getList();
    
    public List<Course> getList(Lab lab);
    
    public Course getById(int id);
    
    public Course save(Course course);
    
    public Course update(Course course);
    
    public boolean delete(Course course);
    
}
