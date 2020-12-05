package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.User;
import java.util.List;

public interface UserDao {

    public List<User> getList();

    public User getById(int id);

    public User insert(User user);

    public User edit(User user);

    public boolean remove(User user);
    
    public User findByUsername(String username);
}
