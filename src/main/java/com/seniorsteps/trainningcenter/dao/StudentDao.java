package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.Student;
import java.util.List;

public interface StudentDao {

    public List<Student> getList();

    public Student getById(int id);

    public Student insert(Student student);

    public Student edit(Student student);

    public boolean remove(Student student);
}
