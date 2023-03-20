package com.tomerharari.trippy.bootstrap;

import com.tomerharari.trippy.model.City;
import com.tomerharari.trippy.model.Person;
import com.tomerharari.trippy.model.Trip;
import com.tomerharari.trippy.repositories.CityRepository;
import com.tomerharari.trippy.repositories.PersonRepository;
import com.tomerharari.trippy.services.TripService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    private final TripService tripService;
    private final CityRepository cityRepository;
    private final PersonRepository personRepository;

    public DataLoader(TripService tripService, CityRepository cityRepository, PersonRepository personRepository) {
        this.tripService = tripService;
        this.cityRepository = cityRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        Person person = Person.builder().id(1L).build();
//        person.toString();

        Set<Person> members = new HashSet<>();
        members.add(personRepository.save(Person.builder().id(1L).firstName("tomer").lastName("harari").build()));
        members.add(personRepository.save(Person.builder().id(2L).firstName("jonathan").lastName("kraidman").build()));

        Set<City> destinations = new HashSet<>();
        destinations.add(cityRepository.save(City.builder().id(1L).name("Madrid").build()));
        destinations.add(cityRepository.save(City.builder().id(2L).name("Paris").build()));
        System.out.println(destinations.size() + "!!!!!");
        City origin = cityRepository.save(City.builder().id(3L).name("Brooklyn").build());

        Trip trip = tripService.save(
                Trip.builder().id(1L)
                .name("First Trip")
                .members(members)
                .destinations(destinations)
                .origin(origin).build());
        System.out.println(trip.getMembers().size());
        System.out.println(trip.getDestinations().size());

        System.out.println("WE ARE IN DATA LOADER");

    }
}
