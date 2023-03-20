package com.tomerharari.trippy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Person extends BaseEntity{
    private String firstName;
    private String lastName;
    @JsonIgnore
    @ManyToMany(mappedBy = "members")
    private Set<Trip> trips = new HashSet<>();
    @Builder
    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void addTrip(Trip trip) {
        trips.add(trip);
    }
}
