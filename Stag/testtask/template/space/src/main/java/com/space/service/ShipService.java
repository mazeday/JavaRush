package com.space.service;

import org.springframework.stereotype.Service;

@Service
public class ShipService implements ShipServiceImp {

    public String getShip(){
        return "ship";
    }

}
