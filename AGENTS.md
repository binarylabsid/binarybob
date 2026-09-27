# AGENTS.md

This file provides guidance to agents when working with code in this repository.

## Project: BinaryBob — IBM Bob Hackathon Demo
Spring Boot 4.x + Java 21 + Lombok + Maven. No database — data lives in an in-memory `HashMap` inside `UserService`.

## Commands
```bash
./mvnw clean install          # build + all tests
./mvnw test                   # run all tests
./mvnw test -Dtest=ClassName  # run a single test class
./mvnw spring-boot:run        # start dev server (WARN-level logs only)
```
> On Windows use `mvnw.cmd` instead of `./mvnw`.

## Non-obvious project rules (from agent.md + skills.md)

### Mandatory SLF4J audit logging
Every critical fix **must** emit a log line at WARN or higher using the exact marker:
```java
log.warn("[SECURITY-AUDIT] <message>");
```
The `@Slf4j` Lombok annotation is already the standard; add it to any class that doesn't have it.

### Null-safety is mandatory (not optional)
`UserService.getUserDisplayName()` calls `.getName()` directly on a raw `HashMap.get()` — this NPEs on unknown IDs. All fixes must add a null-check (return `Optional` or throw a typed exception) before the chain.

### Test isolation contract (from skills.md)
JUnit 5 tests **must** use `@ExtendWith(MockitoExtension.class)` + `@Mock` + `@InjectMocks`. Do NOT use Spring context (`@SpringBootTest`) for unit tests — the project convention is pure Mockito isolation.  
Test files belong in: `src/test/java/com/binarylabsid/demo/`

### Lombok annotation stack for model classes
Use exactly `@Data @Builder @NoArgsConstructor @AllArgsConstructor` together. Do not pick a subset; the constructor pattern is required by the builder.

### Dependency injection via constructor (Lombok)
Controllers/services use `@RequiredArgsConstructor` — do NOT add `@Autowired` fields. All injected dependencies must be `private final`.

### Logging level: WARN globally
`application.properties` suppresses INFO/DEBUG for all Spring packages. Service-level logs must be WARN or ERROR to appear at runtime.

### CI/CD pipeline convention (from skills.md)
When bootstrapping `.github/workflows/ci.yml`:
- Trigger: `pull_request` to `main` only
- Three steps: Setup JDK 21 → `mvn clean test` → echo SAST mock step
- No deploy step — this is a demo pipeline

### Auto-MR branch naming
Branches follow `fix/<dynamic-issue-name>` (lowercase kebab). PR is created with `gh pr create --fill` (requires GitHub CLI).

## Package structure
All classes live flat in `com.binarylabsid.demo` — no sub-packages. Keep new classes in the same package unless the project grows.
