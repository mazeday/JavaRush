package com.space.service;

import com.space.model.Ship;

import java.awt.print.Pageable;
import java.util.List;

public interface ShipServiceImp {

    Ship getById(long id);
    List<Ship> findAll(Pageable pageable);
    void saveShip(Ship ship);

    void add(Ship ship);
    void delete(Long id);
    Ship update (long id, Ship ship);

    boolean isParamsValid(Ship ship);
    boolean isParamsNull(Ship ship);
    boolean isExist(long id);

}
