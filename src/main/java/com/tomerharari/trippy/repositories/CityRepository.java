package com.tomerharari.trippy.repositories;

import com.tomerharari.trippy.model.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
}
