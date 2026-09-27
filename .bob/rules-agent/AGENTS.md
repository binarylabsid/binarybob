# Project Coding Rules (Non-Obvious Only)

- All source classes are in a single flat package `com.binarylabsid.demo` — do not create sub-packages unless explicitly asked.
- The "database" is `Map<Integer, User> mockDb` in `UserService` constructor — new entities go there, not to any repository or JPA layer.
- `UserService.getUserDisplayName()` has no null guard — any new service method that calls `mockDb.get(id)` MUST wrap in `Optional` or null-check before dereferencing.
- Use `@RequiredArgsConstructor` (Lombok) for all constructor injection — never write explicit constructors or use `@Autowired`.
- Models must carry all four Lombok annotations: `@Data @Builder @NoArgsConstructor @AllArgsConstructor`.
- Use `Integer` (boxed) for ID fields, not `int`.
- No `@ExceptionHandler` or `ControllerAdvice` exists — add one when introducing error-prone endpoints.
- Test class names must match exactly for `-Dtest=ClassName` single-test runs.
