package com.xyz.booking.service;

import com.xyz.booking.model.*;
import com.xyz.booking.repository.BookingRepository;
import com.xyz.booking.repository.SeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;

    public BookingService(BookingRepository bookingRepository,
                          SeatRepository seatRepository) {
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
    }

    /**
     * Step 1: Lock seats (DB level – Redis can be added later)
     */
    @Transactional
    public void lockSeats(Long showId, List<String> seatNumbers) {

        for (String seatNumber : seatNumbers) {
            Seat seat = seatRepository
                    .findByShowIdAndSeatNumber(showId, seatNumber)
                    .orElseThrow(() -> new RuntimeException("Seat not found: " + seatNumber));

            if (seat.getStatus() != SeatStatus.AVAILABLE) {
                throw new RuntimeException("Seat not available: " + seatNumber);
            }

            seat.setStatus(SeatStatus.LOCKED);
            seatRepository.save(seat);
        }
    }

    /**
     * Step 2: Confirm booking after payment success
     */
    @Transactional
    public Booking confirmBooking(Long userId,
                                  Long showId,
                                  List<String> seatNumbers,
                                  double pricePerSeat) {

        double totalAmount = seatNumbers.size() * pricePerSeat;

        for (String seatNumber : seatNumbers) {
            Seat seat = seatRepository
                    .findByShowIdAndSeatNumber(showId, seatNumber)
                    .orElseThrow(() -> new RuntimeException("Seat not found"));

            if (seat.getStatus() != SeatStatus.LOCKED) {
                throw new RuntimeException("Seat not locked: " + seatNumber);
            }

            seat.setStatus(SeatStatus.BOOKED);
            seatRepository.save(seat);
        }

        Booking booking = new Booking(
                userId,
                showId,
                seatNumbers.size(),
                totalAmount
        );

        return bookingRepository.save(booking);
    }

    /**
     * Step 3: Cancel booking
     */
    @Transactional
    public void cancelBooking(Long bookingId, Long showId, List<String> seatNumbers) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);

        for (String seatNumber : seatNumbers) {
            Seat seat = seatRepository
                    .findByShowIdAndSeatNumber(showId, seatNumber)
                    .orElseThrow(() -> new RuntimeException("Seat not found"));

            seat.setStatus(SeatStatus.AVAILABLE);
            seatRepository.save(seat);
        }
    }
}
