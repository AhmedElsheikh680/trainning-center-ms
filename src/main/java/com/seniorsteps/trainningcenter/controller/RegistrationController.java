package com.seniorsteps.trainningcenter.controller;

import com.seniorsteps.trainningcenter.dto.Registration;
import com.seniorsteps.trainningcenter.model.Course;
import com.seniorsteps.trainningcenter.model.CourseStudent;
import com.seniorsteps.trainningcenter.model.User;
import com.seniorsteps.trainningcenter.service.CourseService;
import com.seniorsteps.trainningcenter.service.CourseStudentService;
import com.seniorsteps.trainningcenter.service.RegistrationService;

import com.seniorsteps.trainningcenter.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/process/registration")
public class RegistrationController {

    private static final String pakageName = "process";
    private static final String requestMapping = "/process/registration";

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationService registrationService;
    
    @Autowired
    private CourseStudentService courseStudentService;

    @GetMapping("/new")
    public String getRegistrationPage(ModelMap model) {
        Registration registration = new Registration();
        model.addAttribute("registration", registration);
        return pakageName + "/registration";
    }

    @PostMapping("/new")
    public String saveRegistrationPage(@Valid Registration registration, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return pakageName + "/registration";
        }
        User user = getPrincipal();
        if (user != null) {

            CourseStudent courseStudent = registrationService.save(registration, user);
            if (courseStudent != null) {
                model.addAttribute("msg", "Adding Successfully...");
            } else {
                model.addAttribute("msg", "Error In Adding!!");
            }
        }
        return "redirect:" + requestMapping + "/list";
    }
    
    @GetMapping("/list")
    public String getRegistrationsPage(ModelMap model){
        List<CourseStudent> courseStudents = courseStudentService.getList();
        model.addAttribute("courseStudents", courseStudents);
        return pakageName+"/registrations";
    }

    @ModelAttribute("courses")
    public List<Course> getCourses() {
        return courseService.getList();
    }

    @GetMapping("/getCourse")
    @ResponseBody
    public Course getCourse(@RequestParam(value = "courseId") Integer id) {
        return courseService.getById(id);
    }

    private User getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        }
        if (userName != null) {
            return userService.getByUsername(userName);
        }
        return null;
    }
}
