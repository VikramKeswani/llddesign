package com.example.bookmyshow.model;

import com.example.bookmyshow.model.enums.Features;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity(name = "shows")
public class Show extends BaseModel {
    Date startTime;

    Date endTime;

    @ManyToOne
    Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // mapping table -> screen_features
    List<Features> features;

    @ManyToOne
    Movie movie;

}
