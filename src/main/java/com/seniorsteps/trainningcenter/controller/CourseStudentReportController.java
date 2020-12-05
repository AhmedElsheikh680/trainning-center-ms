
package com.seniorsteps.trainningcenter.controller;

import com.seniorsteps.trainningcenter.dto.CourseStudentReportDto;
import com.seniorsteps.trainningcenter.model.Course;
import com.seniorsteps.trainningcenter.model.CourseStudent;
import com.seniorsteps.trainningcenter.service.CourseService;
import com.seniorsteps.trainningcenter.service.CourseStudentService;
import com.seniorsteps.trainningcenter.service.ReportService;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report/courseStudent")
public class CourseStudentReportController {
    
    private static final String packageName="report/";
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private CourseStudentService courseStudentService;
    
    @Autowired
    private ReportService reportService;
    
    
    @GetMapping("")
    public String getReportPage(ModelMap model){
        CourseStudentReportDto courseStudentReportDto = new CourseStudentReportDto();
        courseStudentReportDto.setFromDate(new Date());
        courseStudentReportDto.setToDate(new Date());
        model.addAttribute("courseStudentReportDto", courseStudentReportDto);
        return packageName+"courseStudentReport";
    }
    
    @PostMapping("")
    public String viewReport(@Valid CourseStudentReportDto courseStudentReportDto, BindingResult result, HttpServletResponse httpServletResponse){
        if(result.hasErrors()){
            return packageName+"/courseStudentReport";
        }
//        System.out.println("From: " + courseStudentReportDto.getFromDate());
//        System.out.println("To: " + courseStudentReportDto.getToDate());
        List<CourseStudent> courseStudents = courseStudentService.getList(courseStudentReportDto);
   
        reportService.generateReport(null, courseStudents, httpServletResponse);
//        System.out.println("Size: "+courseStudents.size());
        return null;
    }
    @ModelAttribute("courses")
    public List<Course> getCourses(){
        return courseService.getList();
    }
}
