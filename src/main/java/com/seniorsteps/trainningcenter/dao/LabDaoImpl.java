/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.Lab;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SMARTCS
 */
@Repository
public class LabDaoImpl extends AbstractDao<Lab> implements LabDao {

    @Override
    public List<Lab> getList() {
        return findAll();
    }

    @Override
    public Lab getById(int id) {
        return findById(id);
    }

    @Override
    public Lab insert(Lab lab) {
        return save(lab);
    }

    @Override
    public Lab edit(Lab lab) {
        return update(lab);
    }

    @Override
    public boolean remove(Lab lab) {
        return delete(lab);
    }
    
}
