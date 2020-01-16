package com.space.service;


import com.space.model.Ship;
import com.space.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ShipService implements ShipServiceImp {

    @Autowired
    private ShipRepository shipRepository;

    @Override
    public Ship getById(long id) {
        Optional<Ship> optional = shipRepository.findById(id);
        return optional.get();
    }

    @Override
    public List<Ship> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void saveShip(Ship ship) {
        shipRepository.save(ship);
    }

    @Override
    public void add(Ship ship) {
        shipRepository.save(ship);
    }

    @Override
    public void delete(Long id) {
        shipRepository.deleteById(id);
    }

    @Override
    public Ship update(long id, Ship ship) {
        return null;
    }

    @Override
    public boolean isParamsValid(Ship ship) {
        if (ship.getName().isEmpty() || ship.getPlanet().isEmpty() || ship.getSpeed() == 0 ||
                ship.getProdDate().getYear() < 0 || ship.getCrewSize() == 0 || ship.getShipType().name().isEmpty())
            return false;
        if ((ship.getName().length() > 50 || ship.getPlanet().length() > 50) ||
                (ship.getProdDate().getYear() + 1900 < 2800 || ship.getProdDate().getYear() + 1900 > 3019) ||
                (ship.getSpeed() < 0.01 || ship.getSpeed() > 0.99) ||
                (ship.getCrewSize() < 1 || ship.getCrewSize() > 9999)) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isParamsNull(Ship ship) {
        return ship.getName() == null || ship.getPlanet() == null || ship.getShipType() == null || ship.getProdDate() == null ||
                ship.getSpeed() == null || ship.getCrewSize() == null;
    }

    @Override
    public boolean isExist(long id) {
        return shipRepository.existsById(id);
    }

    /*
    public String getShip(){
        return "ship";
    }
     */

}
