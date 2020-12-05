
package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.model.Student;
import java.util.List;

public interface StudentService {
    
    public List<Student> getList();
    
    public Student getById(int id);
    
    public Student save(Student student);
    
    public Student update(Student student);
    
    public boolean delete(Student student);
    
}
