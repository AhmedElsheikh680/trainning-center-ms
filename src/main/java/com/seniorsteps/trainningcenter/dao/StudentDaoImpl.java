/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.Student;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SMARTCS
 */
@Repository
public class StudentDaoImpl extends AbstractDao<Student> implements StudentDao {

    @Override
    public List<Student> getList() {
        return findAll();
    }

    @Override
    public Student getById(int id) {
        return findById(id);
    }

    @Override
    public Student insert(Student student) {
        return save(student);
    }

    @Override
    public Student edit(Student student) {
        return update(student);
    }

    @Override
    public boolean remove(Student student) {
        return delete(student);
    }
    
}
