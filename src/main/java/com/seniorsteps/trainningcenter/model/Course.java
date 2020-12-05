package com.seniorsteps.trainningcenter.model;
// Generated Oct 31, 2020 10:16:07 AM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Course generated by hbm2java
 */
@Entity
@Table(name = "course",
        catalog = "trainning_center"
)
public class Course implements java.io.Serializable {

    private Integer id;
    private Lab lab;
    private String name;
    private Integer hours;
    private Double price;
    private Date startDate;
    private Date endDate;

    @JsonIgnore
    private Set<CourseConstructor> courseConstructors = new HashSet<CourseConstructor>(0);

    @JsonIgnore
    private Set<CourseStudent> courseStudents = new HashSet<CourseStudent>(0);

    public Course() {
    }

    public Course(Lab lab) {
        this.lab = lab;
    }

    public Course(Lab lab, String name, Integer hours, Double price, Date startDate, Date endDate, Set<CourseConstructor> courseConstructors, Set<CourseStudent> courseStudents) {
        this.lab = lab;
        this.name = name;
        this.hours = hours;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseConstructors = courseConstructors;
        this.courseStudents = courseStudents;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lab_id", nullable = false)
    public Lab getLab() {
        return this.lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    @Column(name = "name", length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "hours")
    public Integer getHours() {
        return this.hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Column(name = "price", precision = 22, scale = 0)
    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", length = 10)
    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", length = 10)
    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    public Set<CourseConstructor> getCourseConstructors() {
        return this.courseConstructors;
    }

    public void setCourseConstructors(Set<CourseConstructor> courseConstructors) {
        this.courseConstructors = courseConstructors;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    public Set<CourseStudent> getCourseStudents() {
        return this.courseStudents;
    }

    public void setCourseStudents(Set<CourseStudent> courseStudents) {
        this.courseStudents = courseStudents;
    }

}
