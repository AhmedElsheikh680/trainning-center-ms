package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.Course;
import com.seniorsteps.trainningcenter.model.CourseStudent;
import java.util.Date;
import java.util.List;

public interface CourseStudentDao {

    public List<CourseStudent> getList();

    public List<CourseStudent> getList(Date fromDate, Date toDate, Course course);

    public CourseStudent getById(int id);

    public CourseStudent insert(CourseStudent courseStudent);

    public CourseStudent edit(CourseStudent courseStudent);

    public boolean remove(CourseStudent courseStudent);
}
