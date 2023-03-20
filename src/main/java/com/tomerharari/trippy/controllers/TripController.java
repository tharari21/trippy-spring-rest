package com.tomerharari.trippy.controllers;

import com.tomerharari.trippy.model.Trip;
import com.tomerharari.trippy.services.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public Set<Trip> getTrips() {
        tripService.findAll().forEach(trip -> {
            System.out.println(trip.getDestinations().size());
            System.out.println(trip.getMembers().size());
            trip.getMembers().forEach(member -> System.out.println(member.getFirstName()));
        });
        return tripService.findAll();
    }
    public Trip createTrip(@RequestBody Trip trip) {
        Trip savedTrip = tripService.save(trip);
        return savedTrip;

    }

}
