package com.example.bookmyshow.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class SeatType extends BaseModel {
    String name;
}
