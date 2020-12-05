
package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.dao.LabDao;
import com.seniorsteps.trainningcenter.model.Lab;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LabServiceImpl implements LabService {
    
    @Autowired
    private LabDao labDao;

    @Override
    public List<Lab> getList() {
        return labDao.getList();
    }

    @Override
    public Lab getById(int id) {
        return labDao.getById(id);
    }

    @Override
    public Lab save(Lab lab) {
        return labDao.insert(lab);
    }

    @Override
    public Lab update(Lab lab) {
        return labDao.edit(lab);
    }

    @Override
    public boolean delete(Lab lab) {
        return labDao.remove(lab);
    }
    
    
}
