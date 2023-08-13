package com.example.bookmyshow.repositories;

import com.example.bookmyshow.model.Show;
import com.example.bookmyshow.model.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {

    List<ShowSeatType> findAllByShow(Show show);
}
