# Project Documentation Context (Non-Obvious Only)

- The project root contains `agent.md` (lowercase), `skills.md`, and `README.MD` (uppercase extension) alongside a standard `README.md` — the uppercase one is separate content.
- "No database" means literally no H2, no JPA, no Flyway — the entire persistence layer is a seeded `HashMap` in `UserService`.
- `application.properties` suppresses all INFO logs project-wide (comments are in Indonesian: "Bungkam semua log INFO").
- The test directory exists but is intentionally empty (`.gitkeep` only) — there are currently zero test implementations.
- Spring Boot 4.0.8 is used — this is a preview/milestone release, not a GA release. Some Spring Boot 3.x docs may not apply.
