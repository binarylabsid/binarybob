# Project Documentation Rules (Non-Obvious Only)

- `agent.md` (lowercase, in root) is the legacy guidance file — `AGENTS.md` supersedes it.
- `skills.md` defines three automated workflows (Testing, CI, Auto-MR) that agents are expected to follow verbatim.
- `application.properties` suppresses all INFO logs intentionally — the app appears silent on startup by design.
- The test directory (`src/test/java/.../demo/`) contains only a `.gitkeep` — there are no existing tests to reference as examples.
- `DemoApplication.java` is a single-line class body (no line breaks) — that is intentional style for the entry point only.
