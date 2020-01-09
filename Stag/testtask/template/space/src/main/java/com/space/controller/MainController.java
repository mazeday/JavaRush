package com.space.controller;


import com.space.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;

@Controller
public class MainController {

    @Autowired
    private MainService service;


    @GetMapping("/ship")
    public String getShip(){
       return service.getShip();
    }
}
