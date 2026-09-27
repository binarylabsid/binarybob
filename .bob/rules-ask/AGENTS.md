# Project Documentation Rules (Non-Obvious Only)

- **`agent.md` (lowercase) is the legacy guidance file** — the canonical file is now `AGENTS.md` in the project root.
- **`skills.md` contains hard behavioural contracts**, not suggestions — the three skills (Testing, DevSecOps CI, Auto-MR) define exact command sequences and file shapes that must be followed literally.
- **No database exists** — `UserService` uses a plain `HashMap` seeded in the constructor; questions about persistence, migrations, or schemas do not apply to this project.
- **Log output is intentionally silent** — `application.properties` sets all loggers to WARN; the absence of startup INFO logs is by design, not a misconfiguration.
- **Spring Boot version is 4.0.8** (not 3.x) — some SB4 APIs differ from SB3 docs; prefer official SB4 references.
- **`banner.txt`** is the custom ASCII startup banner — it is purely cosmetic.
