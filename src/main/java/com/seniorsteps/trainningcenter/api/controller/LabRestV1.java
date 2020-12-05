package com.seniorsteps.trainningcenter.api.controller;

import com.seniorsteps.trainningcenter.model.Lab;
import com.seniorsteps.trainningcenter.service.LabService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/lab")
public class LabRestV1 {

    @Autowired
    private LabService labService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<Lab> getLabById(@PathVariable Integer id) {

        Lab lab = labService.getById(id);
        if (lab != null) {
            return new ResponseEntity<Lab>(lab, HttpStatus.OK);
        } else {
            return new ResponseEntity<Lab>(lab, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Lab>> getAllLabs() {
        List<Lab> labs = labService.getList();
        return new ResponseEntity<List<Lab>>(labs, HttpStatus.OK);

    }

    @PostMapping("/saveLab")
    public ResponseEntity<Lab> createLab(@RequestBody Lab lab) {
        lab = labService.save(lab);
        return new ResponseEntity<Lab>(lab, HttpStatus.OK);
    }

    @PostMapping("/updateLab")
    public ResponseEntity<Lab> updateLab(@RequestBody Lab lab){
        lab = labService.update(lab);
        return new ResponseEntity<Lab>(lab, HttpStatus.OK);
    }
    
    @PostMapping("/deleteLab")
    public ResponseEntity<Boolean> deleteLab(@RequestBody Lab lab){
        boolean deleted = labService.delete(lab);
        return new ResponseEntity<Boolean>(deleted, HttpStatus.OK);
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
