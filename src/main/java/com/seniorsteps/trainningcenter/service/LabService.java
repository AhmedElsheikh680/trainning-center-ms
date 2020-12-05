
package com.seniorsteps.trainningcenter.service;

import com.seniorsteps.trainningcenter.model.Lab;
import java.util.List;

public interface LabService {
    
    public List<Lab> getList();
    
    public Lab getById(int id);
    
    public Lab save(Lab lab);
    
    public Lab update(Lab lab);
    
    public boolean delete(Lab lab);
    
}
