# Project Coding Rules (Non-Obvious Only)

- All source classes are flat in `com.binarylabsid.demo` — do NOT create sub-packages.
- Data seeding happens in `UserService` constructor; never add `@PostConstruct` or a separate init method.
- `getUserDisplayName()` returns `name.toUpperCase()` with no null guard — any new method touching `mockDb` must handle missing keys explicitly.
- Lombok annotation order on models: `@Data @Builder @NoArgsConstructor @AllArgsConstructor` (all four together).
- Use boxed `Integer` for IDs everywhere — the controller `@PathVariable` and map key are both `Integer`.
- Tests MUST use `@ExtendWith(MockitoExtension.class)` + `@Mock` + `@InjectMocks` (see skills.md Testing Skill). Do not use Spring context (`@SpringBootTest`) for unit tests.
- Run single test: `./mvnw test -Dtest=ClassName` (no `#methodName` syntax needed for single-class runs).
- `spring-boot-starter-webmvc-test` is the test dependency (not the usual `spring-boot-starter-test`).
