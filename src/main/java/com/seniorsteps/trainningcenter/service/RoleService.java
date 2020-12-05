
package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.model.Role;
import java.util.List;

public interface RoleService {
    
    public List<Role> getList();
    
    public Role getById(int id);
    
    public Role save(Role role);
    
    public Role update(Role role);
    
    public boolean delete(Role role);
    
}
