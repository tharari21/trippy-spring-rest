package com.tomerharari.trippy.controllers;

import com.tomerharari.trippy.model.Person;
import com.tomerharari.trippy.model.Trip;
import com.tomerharari.trippy.services.TripService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips/{tripId}/members")
public class TripMemberController {
    private final TripService tripService;

    public TripMemberController(TripService tripService) {
        this.tripService = tripService;
    }

    @ModelAttribute
    public Trip getTrip(@PathVariable Long tripId) {
        return tripService.findById(tripId);
    }
    @PostMapping
    public Trip addMember(@ModelAttribute Trip trip, @RequestBody Person person) {
        trip.addMember(person);
        return trip;
    }
}
