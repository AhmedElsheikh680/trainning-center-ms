
package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.dao.UserRoleDao;
import com.seniorsteps.trainningcenter.model.UserRole;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    
    @Autowired
    private UserRoleDao userUserRoleDao;

    @Override
    public List<UserRole> getList() {
        return userUserRoleDao.getList();
    }

    @Override
    public UserRole getById(int id) {
        return userUserRoleDao.getById(id);
    }

    @Override
    public UserRole save(UserRole userUserRole) {
        return userUserRoleDao.insert(userUserRole);
    }

    @Override
    public UserRole update(UserRole userUserRole) {
        return userUserRoleDao.edit(userUserRole);
    }

    @Override
    public boolean delete(UserRole userUserRole) {
        return userUserRoleDao.remove(userUserRole);
    }
    
    
}
