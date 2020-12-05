package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.dto.Registration;
import com.seniorsteps.trainningcenter.model.CourseStudent;
import com.seniorsteps.trainningcenter.model.Student;
import com.seniorsteps.trainningcenter.model.User;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseStudentService courseStudentService;

    //1- insert into student
    //2- insert into courseStudent
    @Override
    public CourseStudent save(Registration registration, User user) {
        CourseStudent courseStudent = null;
        if (registration.getName() != null && registration.getCourse() != null && user != null) {
            Student student = new Student();
            student.setName(registration.getName());
            student.setPhone(registration.getPhone());
            student.setEmail(registration.getEmail());
            student = studentService.save(student);
            if (student != null) {
                courseStudent = new CourseStudent();
                courseStudent.setStudent(student);
                courseStudent.setCourse(registration.getCourse());
                courseStudent.setPrice(registration.getPrice());
                courseStudent.setPaid(registration.getPaid());
                double rest = registration.getPrice() - registration.getPaid();
                courseStudent.setRest(rest);
                courseStudent.setDiscount(0.0);
                courseStudent.setUser(user);
                courseStudent.setRegistrationDate(new Date());
                courseStudent = courseStudentService.save(courseStudent);
            }

        }
        return courseStudent;
    }

}
