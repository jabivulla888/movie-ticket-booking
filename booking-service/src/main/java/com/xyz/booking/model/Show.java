package com.xyz.booking.model;

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

    private double pricePerSeat;

    private int totalSeats;
    private int availableSeats;

    public Show() {
    }

    public Show(Long movieId,
                String theatreName,
                String city,
                LocalDate showDate,
                LocalTime showTime,
                double pricePerSeat,
                int totalSeats) {

        this.movieId = movieId;
        this.theatreName = theatreName;
        this.city = city;
        this.showDate = showDate;
        this.showTime = showTime;
        this.pricePerSeat = pricePerSeat;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public Long getId() {
        return id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void reduceAvailableSeats(int seats) {
        if (availableSeats < seats) {
            throw new IllegalStateException("Not enough seats available");
        }
        this.availableSeats -= seats;
    }

    public void increaseAvailableSeats(int seats) {
        this.availableSeats += seats;
    }
}
