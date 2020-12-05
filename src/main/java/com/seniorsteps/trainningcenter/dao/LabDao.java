package com.seniorsteps.trainningcenter.dao;

import com.seniorsteps.trainningcenter.model.Lab;
import java.util.List;

public interface LabDao {

    public List<Lab> getList();

    public Lab getById(int id);

    public Lab insert(Lab lab);

    public Lab edit(Lab lab);

    public boolean remove(Lab lab);
}
