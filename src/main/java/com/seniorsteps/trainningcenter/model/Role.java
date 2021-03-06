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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name="role"
    ,catalog="trainning_center"
)
public class Role  implements java.io.Serializable {


     private Integer id;
     @NotNull(message = "This Field Is Required")
     @NotEmpty(message = "This Field Is Required")
     private String name;
     private Set<UserRole> userRoles = new HashSet<UserRole>(0);

    public Role() {
    }

    public Role(String name, Set<UserRole> userRoles) {
       this.name = name;
       this.userRoles = userRoles;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="role")
    public Set<UserRole> getUserRoles() {
        return this.userRoles;
    }
    
    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }




}


