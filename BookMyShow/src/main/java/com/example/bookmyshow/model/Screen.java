package com.example.bookmyshow.model;

import com.example.bookmyshow.model.enums.Features;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Screen extends BaseModel {
    String name;
    @OneToMany
    List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    List<Features> features;

    @OneToMany
    List<Show> shows;

    @ManyToOne
    Theatre theatre;
}
