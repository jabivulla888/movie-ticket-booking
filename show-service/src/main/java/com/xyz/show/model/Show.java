package com.xyz.show.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long movieId;
    private String theatreName;
    private String city;

    private LocalDate showDate;
    private LocalTime showTime;

    private int availableSeats;

    public Show() {}

    public Show(Long movieId, String theatreName, String city,
                LocalDate showDate, LocalTime showTime, int availableSeats) {
        this.movieId = movieId;
        this.theatreName = theatreName;
        this.city = city;
        this.showDate = showDate;
        this.showTime = showTime;
        this.availableSeats = availableSeats;
    }

    public Long getId() { return id; }
    public Long getMovieId() { return movieId; }
    public String getTheatreName() { return theatreName; }
    public String getCity() { return city; }
    public LocalDate getShowDate() { return showDate; }
    public LocalTime getShowTime() { return showTime; }
    public int getAvailableSeats() { return availableSeats; }
}
