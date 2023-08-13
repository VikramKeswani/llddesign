package com.example.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Region extends BaseModel {
    int regionId;

    String regionName;

    @OneToMany
    List<Theatre> theatreList;
}
