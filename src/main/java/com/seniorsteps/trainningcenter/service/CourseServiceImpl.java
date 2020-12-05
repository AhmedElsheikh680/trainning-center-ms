
package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.dao.CourseDao;
import com.seniorsteps.trainningcenter.model.Course;
import com.seniorsteps.trainningcenter.model.Lab;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getList() {
        return courseDao.getList();
    }
      @Override
    public List<Course> getList(Lab lab) {
        return courseDao.getList(lab);
    }

    @Override
    public Course getById(int id) {
        return courseDao.getById(id);
    }

    @Override
    public Course save(Course course) {
        return courseDao.insert(course);
    }

    @Override
    public Course update(Course course) {
        return courseDao.edit(course);
    }

    @Override
    public boolean delete(Course course) {
        return courseDao.remove(course);
    }

  
    
    
}
