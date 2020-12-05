
package com.seniorsteps.trainningcenter.service;


import com.seniorsteps.trainningcenter.dto.Registration;
import com.seniorsteps.trainningcenter.model.CourseStudent;
import com.seniorsteps.trainningcenter.model.User;
import java.util.List;

public interface RegistrationService {

    public CourseStudent save(Registration registration, User user);
    
}
