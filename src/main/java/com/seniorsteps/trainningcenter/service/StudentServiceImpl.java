
package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.dao.StudentDao;
import com.seniorsteps.trainningcenter.model.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getList() {
        return studentDao.getList();
    }

    @Override
    public Student getById(int id) {
        return studentDao.getById(id);
    }

    @Override
    public Student save(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public Student update(Student student) {
        return studentDao.edit(student);
    }

    @Override
    public boolean delete(Student student) {
        return studentDao.remove(student);
    }
    
    
}
