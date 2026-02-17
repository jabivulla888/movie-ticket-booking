package com.xyz.booking.repository;

import com.xyz.booking.model.Seat;
import com.xyz.booking.model.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findByShowId(Long showId);

    List<Seat> findByShowIdAndStatus(Long showId, SeatStatus status);

    Optional<Seat> findByShowIdAndSeatNumber(Long showId, String seatNumber);
}
