package com.space.controller;


import com.space.repository.ShipRepository;
import com.space.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShipController {

    @Autowired
    private ShipService shipService;

    @Autowired
    ShipRepository shipRepository;


    @GetMapping("/ship")
    public String getShip(){
       return shipService.getShip();
    }
}
