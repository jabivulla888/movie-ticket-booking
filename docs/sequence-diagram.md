# Sequence Diagrams – Movie Ticket Booking Platform

This document describes key system interactions using sequence-style flows.
(Actual UML diagrams can be generated from these flows if required.)

---

## 1. Browse Shows Flow (Read Scenario)

### Scenario
User selects a movie, city, and date to browse available theatres and show timings.

### Sequence


### Notes
- Read-only flow
- Cached at Show Service layer
- Pagination supported

---

## 2. Seat Locking & Booking Flow (Write Scenario)

### Scenario
User selects seats and books tickets for a show.

### Sequence


---

## 3. Booking Cancellation Flow

### Scenario
User cancels a previously confirmed booking.

### Sequence


---

## 4. Bulk Booking Flow (Optional)

### Scenario
Corporate or bulk ticket booking.

### Sequence


---

## 5. Failure & Rollback Flow

### Scenario
Payment fails after seat locking.

### Sequence


---

## 6. Concurrency Handling Flow

### Scenario
Two users attempt to book the same seat.

### Sequence


### Notes
- Prevents double booking
- Redis-based distributed locking planned for scale

---

## 7. Notes for Reviewers

- Diagrams are represented textually for simplicity.
- Can be converted into UML diagrams using tools like:
  - PlantUML
  - Draw.io
  - Lucidchart
- Focus is on **business flow clarity**, not UI interactions.

- 



