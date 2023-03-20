package com.tomerharari.trippy.model;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class City extends BaseEntity {
    private String name;
    @Builder
    public City(Long id, String name) {
        super(id);
        this.name = name;
    }
}
