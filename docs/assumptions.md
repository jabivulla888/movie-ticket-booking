# Assumptions & Design Notes

This document outlines the assumptions made while designing and implementing the Movie Ticket Booking Platform.  
These assumptions help clarify scope decisions and simplify the solution for demonstration and interview purposes.

---

## 1. Scope Assumptions

- The solution focuses on **backend services only**.
- UI (Web/Mobile) is **out of scope** and replaced by REST APIs.
- Only core booking and browsing flows are implemented.
- Advanced features are documented but not fully implemented.

---

## 2. Service Architecture Assumptions

- The platform follows a **microservices architecture**.
- Each service owns its **own database** (no shared schema).
- Inter-service communication is assumed to be **REST-based**.
- API Gateway is conceptual and not implemented.

---

## 3. Data & Persistence Assumptions

- **H2 in-memory database** is used for demo and local testing.
- In production, this can be replaced with **MySQL/PostgreSQL**.
- Database schema is auto-generated via JPA/Hibernate.
- Data persistence across restarts is not required for demo.

---

## 4. Booking & Seat Management Assumptions

- Seats are **show-specific**, not global.
- Seat lifecycle follows:


- Seat locking is currently handled using **database transactions**.
- Redis-based distributed locking is planned but not implemented.

---

## 5. Offer & Pricing Assumptions

- Offers are applied **after seat selection and before payment**.
- Only two offers are implemented:
- 50% discount on the 3rd ticket
- 20% discount for afternoon shows (12 PM – 4 PM)
- Offers are stackable and applied sequentially.
- No coupon codes or user-specific offers are considered.

---

## 6. Payment Assumptions

- Payment service is assumed to be **external**.
- Payment success/failure is mocked conceptually.
- No payment gateway integration is implemented.

---

## 7. Security Assumptions

- Authentication and authorization are **out of scope**.
- User identity is assumed to be available via request parameters.
- Role-based access (admin/theatre/user) is not enforced.

---

## 8. Performance & Scalability Assumptions

- Show browsing is **read-heavy** and cacheable.
- Booking is **write-heavy** and transactional.
- Horizontal scaling is assumed via stateless services.
- Load balancing is handled externally (cloud / infra).

---

## 9. Error Handling Assumptions

- Basic runtime exceptions are used for simplicity.
- Global exception handling can be added via `@ControllerAdvice`.
- Retry and circuit breaker patterns are not implemented.

---

## 10. Future Enhancements (Out of Scope)

- Redis-based seat locking
- Event-driven architecture (Kafka)
- Saga pattern for booking & payment
- Dynamic pricing
- Recommendation engine
- Multi-language & multi-currency support

---

## 11. Reviewer Notes

- Some components are intentionally simplified to focus on **core architecture and logic**.
- Incomplete areas are documented and can be discussed during technical review.



















