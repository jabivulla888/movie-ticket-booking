package com.xyz.booking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seats",
       uniqueConstraints = @UniqueConstraint(columnNames = {"show_id", "seat_number"}))
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "show_id", nullable = false)
    private Long showId;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;   // e.g. A1, A2, B10

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    public Seat() {
        this.status = SeatStatus.AVAILABLE;
    }

    public Seat(Long showId, String seatNumber) {
        this.showId = showId;
        this.seatNumber = seatNumber;
        this.status = SeatStatus.AVAILABLE;
    }

    public Long getId() {
        return id;
    }

    public Long getShowId() {
        return showId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
