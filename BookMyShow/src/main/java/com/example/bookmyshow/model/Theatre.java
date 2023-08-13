package com.example.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Theatre extends BaseModel {
    @OneToMany
    List<Screen> screens;

    @ManyToOne
    Region region;

    String name;
}
