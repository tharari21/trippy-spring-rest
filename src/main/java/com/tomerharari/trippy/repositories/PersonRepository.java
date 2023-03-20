package com.tomerharari.trippy.repositories;

import com.tomerharari.trippy.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
