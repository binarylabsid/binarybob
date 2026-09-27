# Project Architecture Rules (Non-Obvious Only)

- The entire app is intentionally flat: one package, four files (Application, Controller, Service, Model). Any new feature should follow this pattern unless there's a strong reason to diverge.
- There is no persistence — adding a real database requires introducing JPA/H2 or similar from scratch; do not assume any ORM scaffolding exists.
- `UserService` is the sole data owner; the `mockDb` HashMap is the authoritative store. Any new domain entity needs its own analogous service with a seeded map.
- No global error handling exists — new REST endpoints that can throw (e.g., unknown ID lookups) need a `@ControllerAdvice` added as part of the feature, not separately.
- Spring Boot 4.0.8 is used (milestone/pre-GA); plan for possible API differences vs. Spring Boot 3.x stable documentation.
- Logging is suppressed to WARN+ globally — do not plan features that depend on INFO-level log observability without changing `application.properties`.
