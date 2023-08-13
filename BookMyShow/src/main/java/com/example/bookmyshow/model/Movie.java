package com.example.bookmyshow.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity
public class Movie extends BaseModel {
    String name;

}
