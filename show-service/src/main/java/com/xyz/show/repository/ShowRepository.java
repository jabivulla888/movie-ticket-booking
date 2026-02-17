package com.xyz.show.repository;

import com.xyz.show.model.Show;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ShowRepository extends JpaRepository<Show, Long> {

    Page<Show> findByMovieIdAndCityIgnoreCaseAndShowDate(
            Long movieId,
            String city,
            LocalDate showDate,
            Pageable pageable
    );
}
