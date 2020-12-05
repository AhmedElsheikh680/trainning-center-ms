/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.Course;
import com.seniorsteps.trainningcenter.model.Lab;
import java.util.List;

/**
 *
 * @author SMARTCS
 */
public interface CourseDao {

     public List<Course> getList();
    
    public Course getById(int id);
    
    public Course insert(Course course);
    
    public Course edit(Course course);
    
    public boolean remove(Course course);
    
     List<Course> getList(Lab lab);

}
