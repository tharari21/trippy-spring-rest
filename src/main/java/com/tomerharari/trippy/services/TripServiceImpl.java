package com.tomerharari.trippy.services;


import com.tomerharari.trippy.model.City;
import com.tomerharari.trippy.model.Person;
import com.tomerharari.trippy.model.Trip;
import com.tomerharari.trippy.repositories.TripRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }
    @Override
    public Set<Trip> findAll() {
        Set<Trip> trips = new HashSet<>();
        tripRepository.findAll().forEach(trips::add);
        return trips;
    }

    @Override
    public Trip save(Trip object) {
        if (object == null) return null;


        return tripRepository.save(object);
    }
    @Override
    public Trip findById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

}
