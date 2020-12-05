/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.trainningcenter.converter;

import com.seniorsteps.trainningcenter.model.Course;
import com.seniorsteps.trainningcenter.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter implements Converter<String, Course> {

    @Autowired
    private CourseService courseService;

    @Override
    public Course convert(String idString) {

        Course course = null;
        if (idString != null && !idString.isEmpty()) {
            Integer id = Integer.parseInt(idString);

            course = courseService.getById(id);

        }
        return course;
    }

}
