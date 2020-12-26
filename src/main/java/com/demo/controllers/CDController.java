package com.demo.controllers;


import com.demo.entities.CD;
import com.demo.services.CDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CDController {
    @Autowired
    CDService cdService;

    @PostMapping("/cd/create")
    public @ResponseBody
    CD createCD(@RequestBody CD cd) {
        cdService.saveCD(cd);
        return cd;
    }
    @PutMapping("/cd/update")
    public @ResponseBody CD updateCD(@RequestBody CD cd) {
        cdService.saveCD(cd);
        return cd;
    }
    @GetMapping("/cd/all")
    public @ResponseBody List<CD> findAllCds(){
        return cdService.findAllCds();
    }
}

