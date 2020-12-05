
package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.model.User;
import java.util.List;

public interface UserService {
    
    public List<User> getList();
    
    public User getById(int id);
    
    public User save(User user);
    
    public User update(User user);
    
    public boolean delete(User user);
    
    public User getByUsername(String username);
}
