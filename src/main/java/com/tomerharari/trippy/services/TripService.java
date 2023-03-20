package com.tomerharari.trippy.services;

import com.tomerharari.trippy.model.Person;
import com.tomerharari.trippy.model.Trip;
import org.springframework.stereotype.Service;

import java.util.Set;
public interface TripService {
    Set<Trip> findAll();
    Trip findById(Long id);
    Trip save(Trip object);
}
