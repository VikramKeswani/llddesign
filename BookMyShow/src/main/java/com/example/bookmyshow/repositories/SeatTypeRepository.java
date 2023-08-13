package com.example.bookmyshow.repositories;

import com.example.bookmyshow.model.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType,Long> {
}
