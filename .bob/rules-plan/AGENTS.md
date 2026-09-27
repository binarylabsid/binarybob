# Project Architecture Rules (Non-Obvious Only)

- Single-package flat architecture: Controller → Service → in-memory HashMap. No repository layer, no JPA.
- `UserService.mockDb` is a `HashMap<Integer, User>` (not `ConcurrentHashMap`) — not thread-safe by design for this demo.
- No DTO layer — `User` model is used directly in the service; the controller returns a `String`, not a response object.
- `UserController` returns plain `String` (not `ResponseEntity`) for the name endpoint — Spring serialises it as `text/plain`.
- The only endpoint is `GET /api/users/{id}/name` — any new endpoint must follow the `/api/` prefix convention.
- Dependency injection is constructor-based via Lombok `@RequiredArgsConstructor` — do not switch to field injection.
