# Project Architecture Rules (Non-Obvious Only)

- **Intentionally flat structure** — one package, four files; architectural proposals should stay minimal and avoid layering (no `repository`, `dto`, `exception` packages) unless the task explicitly requires it.
- **In-memory state is not thread-safe** — `HashMap` in `UserService` has no synchronisation; concurrent write scenarios are out of scope for this demo.
- **No error-handling layer** — there is no `@ControllerAdvice` or `@ExceptionHandler`; all unhandled exceptions bubble as HTTP 500. Any plan that adds endpoints must account for this gap.
- **Single endpoint contract** — `GET /api/users/{id}/name` returns a plain `String` (not JSON); adding new endpoints should follow the same plain-return pattern unless JSON is explicitly needed.
- **skills.md defines immutable workflow contracts** — the CI workflow shape (exactly 3 steps) and the Auto-MR command sequence are fixed; plans must not alter them.
- **No external dependencies beyond Lombok + Spring Web** — adding a database, security, or other starter requires explicit discussion; keep the dep footprint minimal for the hackathon demo.
