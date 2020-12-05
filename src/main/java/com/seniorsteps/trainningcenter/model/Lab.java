package com.seniorsteps.trainningcenter.model;
// Generated Oct 31, 2020 10:16:07 AM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Lab generated by hbm2java
 */
@Entity
@Table(name = "lab",
         catalog = "trainning_center"
)
public class Lab implements java.io.Serializable {

    private Integer id;
    private String name;
    private Integer capacity;
    
    @JsonIgnore
    private Set<Course> courses = new HashSet<Course>(0);

    public Lab() {
    }

    public Lab(String name, Integer capacity, Set<Course> courses) {
        this.name = name;
        this.capacity = capacity;
        this.courses = courses;
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

    @Column(name = "name", length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "capacity")
    public Integer getCapacity() {
        return this.capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lab")
    public Set<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

}