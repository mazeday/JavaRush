package com.space.controller;


import com.space.model.Ship;
import com.space.repository.ShipRepository;
import com.space.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShipController {

    @Autowired
    private ShipService shipService;

    @Autowired
    ShipRepository shipRepository;

    //CREATE
    @RequestMapping(value = "rest/ships", method = RequestMethod.POST)
    public ResponseEntity createShip(@RequestBody Ship ship) {

    }


    @GetMapping("/ship")
    public String getShip(){
       return shipService.getShip();
    }
}
