package com.tomerharari.trippy.repositories;

import com.tomerharari.trippy.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
