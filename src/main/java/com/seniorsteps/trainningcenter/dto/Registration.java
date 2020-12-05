/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.trainningcenter.dto;

import com.seniorsteps.trainningcenter.model.Course;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;


public class Registration {
    
    @NotEmpty(message = "This Field Is Required")
    @NotNull(message = "This Field Is Required")
    private String name;
    private String phone;
    private String email;
    
    private Course course;
    private Double price;
    private Double paid;

    public Registration() {
    }

    public Registration(String name, String phone, String email, Course course, Double price, Double paid) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.course = course;
        this.price = price;
        this.paid = paid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }
    
}
