package com.space.repository;

import com.space.model.Ship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ShipRepository extends PagingAndSortingRepository<Ship, Long> {

    Page<Ship> findAll(Pageable pageable);


}
