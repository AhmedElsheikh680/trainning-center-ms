package com.seniorsteps.trainningcenter.model;
// Generated Oct 17, 2020 12:38:14 PM by Hibernate Tools 4.3.1

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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user_app",
         catalog = "trainning_center"
)
public class User implements java.io.Serializable {

    private Integer id;
    @NotNull(message = "This Field Is Required")
    @NotEmpty(message = "This Field Is Required")
    private String name;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Set<CourseStudent> courseStudents = new HashSet<CourseStudent>(0);
    private Set<Payment> payments = new HashSet<Payment>(0);
    private Set<UserRole> userRoles = new HashSet<UserRole>(0);

    public User() {
    }

    public User(String name, String username, String password, String phone, String email, Set<CourseStudent> courseStudents, Set<Payment> payments, Set<UserRole> userRoles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.courseStudents = courseStudents;
        this.payments = payments;
        this.userRoles = userRoles;
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

    @Column(name = "username", length = 45)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", length = 45)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "phone", length = 45)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "email", length = 45)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<CourseStudent> getCourseStudents() {
        return this.courseStudents;
    }

    public void setCourseStudents(Set<CourseStudent> courseStudents) {
        this.courseStudents = courseStudents;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Payment> getPayments() {
        return this.payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    public Set<UserRole> getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

}
