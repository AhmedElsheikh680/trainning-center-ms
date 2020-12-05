
package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.model.UserRole;
import java.util.List;

public interface UserRoleService {
    
    public List<UserRole> getList();
    
    public UserRole getById(int id);
    
    public UserRole save(UserRole userRole);
    
    public UserRole update(UserRole userRole);
    
    public boolean delete(UserRole userRole);
    
}
