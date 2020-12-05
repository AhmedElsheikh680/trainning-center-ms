/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.Course;
import com.seniorsteps.trainningcenter.model.CourseStudent;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SMARTCS
 */
@Repository
public class CourseStudentDaoImpl extends AbstractDao<CourseStudent> implements CourseStudentDao {

    @Override
    public List<CourseStudent> getList() {
        return findAll();
    }

    @Override
    public List<CourseStudent> getList(Date fromDate, Date toDate, Course course) {
        Criteria criteria  = getCriteria();
        criteria.add(Restrictions.ge("registrationDate", fromDate));
        criteria.add(Restrictions.le("registrationDate", toDate));
        criteria.add(Restrictions.eq("course", course));
        return criteria.list();
                
    }

    @Override
    public CourseStudent getById(int id) {
        return findById(id);
    }

    @Override
    public CourseStudent insert(CourseStudent courseStudent) {
        return save(courseStudent);
    }

    @Override
    public CourseStudent edit(CourseStudent courseStudent) {
        return update(courseStudent);
    }

    @Override
    public boolean remove(CourseStudent courseStudent) {
        return delete(courseStudent);
    }

}
