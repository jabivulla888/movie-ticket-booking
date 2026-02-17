package com.xyz.booking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long showId;

    private int seatCount;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private double totalAmount;

    private LocalDateTime createdAt;

    public Booking() {
        this.createdAt = LocalDateTime.now();
        this.status = BookingStatus.PENDING;
    }

    public Booking(Long userId, Long showId, int seatCount, double totalAmount) {
        this.userId = userId;
        this.showId = showId;
        this.seatCount = seatCount;
        this.totalAmount = totalAmount;
        this.status = BookingStatus.CONFIRMED;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getShowId() {
        return showId;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
