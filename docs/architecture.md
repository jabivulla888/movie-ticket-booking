# Movie Ticket Booking Platform – Architecture

## 1. Overview
The Movie Ticket Booking Platform is designed as a **microservices-based system** that supports both:

- **B2C**: End customers browsing movies and booking tickets
- **B2B**: Theatre partners managing shows and seat inventory

The architecture emphasizes **scalability, fault isolation, and clear separation of concerns**.

---

## 2. High-Level Architecture


---

## 3. Services Description

### 3.1 Show Service (Read-Optimized)
**Responsibilities**
- Browse shows by movie, city, date
- Expose show timings and theatres
- Pagination & caching enabled

**Key Characteristics**
- Read-heavy
- Stateless
- Cached responses (Redis / Spring Cache)

---

### 3.2 Booking Service (Write-Heavy)
**Responsibilities**
- Seat locking & availability
- Booking confirmation & cancellation
- Pricing and offer application
- Transaction management

**Core Entities**
- Show
- Seat
- Booking

**Seat Lifecycle**


---

### 3.3 Offer Service
**Responsibilities**
- Centralized discount logic
- Easily extensible for new offers

**Current Offers**
- 50% discount on the 3rd ticket
- 20% discount on afternoon shows (12 PM – 4 PM)

## 4. Data Architecture

### 4.1 Database Strategy
- Each microservice owns its database
- No shared databases between services
- Booking Service uses relational DB (H2 / MySQL / PostgreSQL)

### 4.2 Entity Relationships (Logical)

## 5. Booking Flow (Sequence)


---

## 6. Concurrency & Consistency

- Seat locking handled via:
  - DB transactions (current)
  - Redis-based distributed locks (future)
- Avoids double booking
- Uses optimistic locking strategy where applicable

---

## 7. Non-Functional Requirements

### Scalability
- Stateless services
- Horizontal scaling via containers

### Performance
- Caching for show browsing
- Read/write separation

### Reliability
- Service isolation
- Transactional boundaries in booking

### Extensibility
- New offers via OfferService
- New payment providers without core changes

---

## 8. Technology Stack

- **Language**: Java
- **Framework**: Spring Boot
- **Database**: H2 (demo), MySQL/PostgreSQL (prod)
- **Caching**: Redis (planned)
- **API Docs**: Swagger/OpenAPI
- **Build Tool**: Maven
- **Deployment**: Docker + Cloud (future)

---

## 9. Assumptions & Notes

- UI layer is excluded (API-only system)
- Payment service is mocked / assumed
- Focus is on architecture and core logic
- Security (OAuth/JWT) can be added later

---

## 10. Future Enhancements

- Event-driven architecture (Kafka)
- Saga pattern for booking & payment
- Dynamic pricing
- Recommendation engine
- Multi-language & multi-currency support
- 
