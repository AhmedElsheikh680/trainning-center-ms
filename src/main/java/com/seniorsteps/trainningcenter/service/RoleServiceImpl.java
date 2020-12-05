
package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.dao.RoleDao;
import com.seniorsteps.trainningcenter.model.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getList() {
        return roleDao.getList();
    }

    @Override
    public Role getById(int id) {
        return roleDao.getById(id);
    }

    @Override
    public Role save(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public Role update(Role role) {
        return roleDao.edit(role);
    }

    @Override
    public boolean delete(Role role) {
        return roleDao.remove(role);
    }
    
    
}
