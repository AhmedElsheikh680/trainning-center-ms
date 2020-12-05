package com.seniorsteps.trainningcenter.model;
// Generated Oct 31, 2020 10:16:07 AM by Hibernate Tools 4.3.1


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
 * Student generated by hbm2java
 */
@Entity
@Table(name="student"
    ,catalog="trainning_center"
)
public class Student  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String phone;
     private String email;
     private Set<CourseStudent> courseStudents = new HashSet<CourseStudent>(0);

    public Student() {
    }

    public Student(String name, String phone, String email, Set<CourseStudent> courseStudents) {
       this.name = name;
       this.phone = phone;
       this.email = email;
       this.courseStudents = courseStudents;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="phone", length=45)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="email", length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    public Set<CourseStudent> getCourseStudents() {
        return this.courseStudents;
    }
    
    public void setCourseStudents(Set<CourseStudent> courseStudents) {
        this.courseStudents = courseStudents;
    }




}


