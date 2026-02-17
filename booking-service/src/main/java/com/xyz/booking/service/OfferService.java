package com.xyz.booking.service;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class OfferService {

    public double applyOffers(int seatCount, double pricePerSeat, LocalTime showTime) {

        double totalAmount = seatCount * pricePerSeat;

        // Offer 1: 50% discount on the 3rd ticket
        if (seatCount >= 3) {
            totalAmount -= pricePerSeat * 0.5;
        }

        // Offer 2: 20% discount on afternoon shows (12 PM – 4 PM)
        if (isAfternoonShow(showTime)) {
            totalAmount *= 0.8;
        }

        return totalAmount;
    }

    private boolean isAfternoonShow(LocalTime showTime) {
        return !showTime.isBefore(LocalTime.of(12, 0))
                && !showTime.isAfter(LocalTime.of(16, 0));
    }
}
