/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.UserRole;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SMARTCS
 */
@Repository
public class UserRoleDaoImpl extends AbstractDao<UserRole> implements UserRoleDao {

    @Override
    public List<UserRole> getList() {
        return findAll();
    }

    @Override
    public UserRole getById(int id) {
        return findById(id);
    }

    @Override
    public UserRole insert(UserRole userUserRole) {
        return save(userUserRole);
    }

    @Override
    public UserRole edit(UserRole userUserRole) {
        return update(userUserRole);
    }

    @Override
    public boolean remove(UserRole userUserRole) {
        return delete(userUserRole);
    }
    
}
