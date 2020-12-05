package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.UserRole;
import java.util.List;

public interface UserRoleDao {

    public List<UserRole> getList();

    public UserRole getById(int id);

    public UserRole insert(UserRole userRole);

    public UserRole edit(UserRole userRole);

    public boolean remove(UserRole userRole);
}
