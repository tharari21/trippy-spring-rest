package com.tomerharari.trippy.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Trip extends BaseEntity {
    private String name;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="trip_members",
            joinColumns = @JoinColumn(name="trip_id"),
            inverseJoinColumns = @JoinColumn(name="member_id"))
    private Set<Person> members  = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City origin;
    @OneToMany(mappedBy="id", cascade = CascadeType.PERSIST)
    private Set<City> destinations = new HashSet<>();
    @Builder
    public Trip(Long id, String name, Set<Person> members, City origin, Set<City> destinations) {
        super(id);
        this.name = name;
        this.members = members;
        this.origin = origin;
        this.destinations = destinations;
    }
    public void addMember(Person person) {
        members.add(person);
        person.addTrip(this);
    }
}
