package com.example.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User extends BaseModel {
    String email;

    @OneToMany(mappedBy = "user")
    List<Booking> bookings;

    String name;

    String password;
}
