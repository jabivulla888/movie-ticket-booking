package com.xyz.show.service;

import com.xyz.show.model.Show;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowService {

    private static final List<Show> SHOWS = Arrays.asList(
            new Show(1L, 101L, "PVR Orion", "Bangalore",
                    LocalDate.now(), LocalTime.of(15, 0), 120),

            new Show(2L, 101L, "INOX Malleshwaram", "Bangalore",
                    LocalDate.now(), LocalTime.of(18, 30), 80),

            new Show(3L, 102L, "PVR Forum", "Chennai",
                    LocalDate.now(), LocalTime.of(14, 0), 100)
    );

    public List<Show> getShows(Long movieId, String city, LocalDate date) {

        return SHOWS.stream()
                .filter(show -> show.getMovieId().equals(movieId))
                .filter(show -> show.getCity().equalsIgnoreCase(city))
                .filter(show -> show.getShowDate().equals(date))
                .collect(Collectors.toList());
    }
}
