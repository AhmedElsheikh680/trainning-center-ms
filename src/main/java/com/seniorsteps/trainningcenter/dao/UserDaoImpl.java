/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SMARTCS
 */
@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    @Override
    public List<User> getList() {
        return findAll();
    }

    @Override
    public User getById(int id) {
        return findById(id);
    }

    @Override
    public User insert(User user) {
        return save(user);
    }

    @Override
    public User edit(User user) {
        return update(user);
    }

    @Override
    public boolean remove(User user) {
        return delete(user);
    }

    @Override
    public User findByUsername(String username) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }
    
}
