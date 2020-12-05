package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.Role;
import java.util.List;

public interface RoleDao {

    public List<Role> getList();

    public Role getById(int id);

    public Role insert(Role role);

    public Role edit(Role role);

    public boolean remove(Role role);
}
