# AGENTS.md

This file provides guidance to agents when working with code in this repository.

## Project: BinaryBob — IBM Bob 2.0 Hackathon Entry
Spring Boot 4.0.8 / Java 21 demo app (`com.binarylabsid.demo`). No database — data lives in an in-memory `HashMap` inside `UserService`.

## Commands
```bash
./mvnw clean package          # build
./mvnw spring-boot:run        # run dev server
./mvnw test                   # run all tests
./mvnw -Dtest=ClassName test  # run a single test class
./mvnw -Dtest=Class#method test  # run a single test method
```

## Code Style & Conventions (from agent.md + skills.md)
- **Persona**: Act as an elite DevSecOps + Senior Java Spring Boot engineer.
- **Null safety**: Always write defensive code with proper null-checks and exception handling. `UserService.getUserDisplayName()` currently lacks an `Optional` guard — new service methods must not repeat this pattern.
- **Logging**: Use `@Slf4j` (Lombok). All critical bug fixes **must** include `log.warn("[SECURITY-AUDIT] ...")` entries.
- **Lombok**: All models use `@Data @Builder @NoArgsConstructor @AllArgsConstructor`. Controllers use `@RequiredArgsConstructor` for injection (no `@Autowired`).
- **Log level**: `application.properties` suppresses INFO globally — only WARN/ERROR appear at runtime.
- **Human-in-the-loop**: Require explicit approval before any CI/CD or Git operations.

## Testing (from skills.md)
- Framework: JUnit 5 — no test files exist yet; they go under `src/test/java/com/binarylabsid/demo/`.
- All unit tests **must** use `@ExtendWith(MockitoExtension.class)`, `@Mock`, and `@InjectMocks` (no Spring context loading).
- Test dependency is `spring-boot-starter-webmvc-test` (not `spring-boot-starter-test`).

## CI/CD Skill (from skills.md)
When generating a workflow: target JDK 21, run `mvn clean test`, include SAST/SCA steps (GitHub CodeQL).
Auto-MR branch naming convention: `fix/<dynamic-issue-name>`.
