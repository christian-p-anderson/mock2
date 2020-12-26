package com.demo.services;

import com.demo.entities.CD;
import com.demo.repos.CDRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CDService {

    @Autowired
    private CDRepo cdRepo;

    public CD saveCD(CD cd) {
        cdRepo.save(cd);
        return cd;
    }
    public CD findCD(Long id) {
        return cdRepo.findCDById(id);
    }
    public CD findCDByTitle(String title) {
        return cdRepo.findCDByTitle(title);
    }

    public List<CD> findAllCds() {
        return cdRepo.findAll();
    }
}
