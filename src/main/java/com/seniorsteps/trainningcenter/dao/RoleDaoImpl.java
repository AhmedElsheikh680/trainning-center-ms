/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.Role;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SMARTCS
 */
@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {

    @Override
    public List<Role> getList() {
        return findAll();
    }

    @Override
    public Role getById(int id) {
        return findById(id);
    }

    @Override
    public Role insert(Role role) {
        return save(role);
    }

    @Override
    public Role edit(Role role) {
        return update(role);
    }

    @Override
    public boolean remove(Role role) {
        return delete(role);
    }
    
}
