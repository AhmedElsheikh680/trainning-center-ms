/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.Course;
import com.seniorsteps.trainningcenter.model.Lab;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SMARTCS
 */
@Repository
public class CourseDaoImpl extends AbstractDao<Course> implements CourseDao {

    @Override
    public List<Course> getList() {
        return findAll();
    }

    @Override
    public Course getById(int id) {
        return findById(id);
    }

    @Override
    public Course insert(Course course) {
        return save(course);
    }

    @Override
    public Course edit(Course course) {
        return update(course);
    }

    @Override
    public boolean remove(Course course) {
        return delete(course);
    }

    public List<Course> getList(Lab lab) {
        Criteria criteria = getCriteria();

        criteria.add(Restrictions.eq("lab", lab));
        List<Course> couerse = criteria.list();

        return couerse;
    }

}
