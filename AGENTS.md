# AGENTS.md

This file provides guidance to agents when working with code in this repository.

## Project: BinaryBob — IBM Bob Hackathon Demo
Spring Boot 4.0.8 · Java 21 · Lombok · Maven (no database — all data is a hardcoded `HashMap` in `UserService`).

## Commands
```bash
./mvnw clean install           # build + all tests
./mvnw test                    # run all tests
./mvnw test -Dtest=ClassName   # run a single test class
./mvnw spring-boot:run         # start dev server
```

## Architecture
- All classes live in a **single flat package**: `com.binarylabsid.demo` — no sub-packages.
- "Database" = `private final Map<Integer, User> mockDb = new HashMap<>()` seeded in the `UserService` constructor with 4 hardcoded users.
- No persistence layer, no JPA, no repositories.
- REST endpoint: `GET /api/users/{id}/name` → returns uppercased display name.

## Critical Gotchas
- `UserService.getUserDisplayName()` does **no null check** — calling with an unknown ID throws `NullPointerException`. Any new lookup methods must guard with `Optional` or an explicit null check.
- Logging is suppressed to WARN+ in `application.properties` (Indonesian comment: "silence all INFO logs"). Do not rely on INFO logs during development.

## Code Style
- **Lombok everywhere**: models use `@Data @Builder @NoArgsConstructor @AllArgsConstructor`; services/controllers use `@RequiredArgsConstructor` for constructor injection (never `@Autowired`); services use `@Slf4j` for logging.
- No explicit constructor injection — Lombok `@RequiredArgsConstructor` handles it.
- `Integer` (boxed) used for IDs, not primitive `int`.
- No error handling or `@ExceptionHandler` currently exists — add one rather than leaving NPE-prone methods bare.

## Testing
- Test directory (`src/test/java/com/binarylabsid/demo/`) exists but contains only `.gitkeep` — **no tests written yet**.
- Test dependency is `spring-boot-starter-webmvc-test` (MockMvc-based), not the plain JUnit starter.
