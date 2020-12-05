package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.dao.CourseStudentDao;
import com.seniorsteps.trainningcenter.dto.CourseStudentReportDto;
import com.seniorsteps.trainningcenter.model.Course;
import com.seniorsteps.trainningcenter.model.CourseStudent;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseStudentServiceImpl implements CourseStudentService {

    @Autowired
    private CourseStudentDao courseStudentDao;

    @Override
    public List<CourseStudent> getList() {
        return courseStudentDao.getList();
    }

    @Override
    public List<CourseStudent> getList(Date fromDate, Date toDate, Course course) {
        return courseStudentDao.getList();
    }

    @Override
    public List<CourseStudent> getList(CourseStudentReportDto courseStudentReportDto) {
        if(courseStudentReportDto !=null && courseStudentReportDto.getFromDate() !=null 
                && courseStudentReportDto.getToDate() !=null){
            return courseStudentDao.getList(courseStudentReportDto.getFromDate(), courseStudentReportDto.getToDate(), courseStudentReportDto.getCourse());
        }
        return null;
    }

    @Override
    public CourseStudent getById(int id) {
        return courseStudentDao.getById(id);
    }

    @Override
    public CourseStudent save(CourseStudent courseStudent) {
        return courseStudentDao.insert(courseStudent);
    }

    @Override
    public CourseStudent update(CourseStudent courseStudent) {
        return courseStudentDao.edit(courseStudent);
    }

    @Override
    public boolean delete(CourseStudent courseStudent) {
        return courseStudentDao.remove(courseStudent);
    }

}
