# AGENTS.md

This file provides guidance to agents when working with code in this repository.

## Project: BinaryBob — IBM Bob Hackathon Demo
Spring Boot 4.0.8 + Java 21 + Lombok + Maven. All classes live flat in `com.binarylabsid.demo` — no sub-packages.

## Commands
```bash
./mvnw clean install          # build + all tests
./mvnw test                   # run all tests
./mvnw test -Dtest=ClassName  # run a single test class
./mvnw spring-boot:run        # start dev server (WARN-level logs only)
```

## Data Layer
- No database. Data lives in an in-memory `HashMap<Integer, User>` initialised directly in the `UserService` constructor (not `@PostConstruct`).
- Seed data: IDs 1–4 with fixed names. `getUserDisplayName()` does **no null-check** — calling with an unknown ID throws `NullPointerException`.

## Code Style
- Lombok: models use `@Data @Builder @NoArgsConstructor @AllArgsConstructor`; services use `@Slf4j`; controllers use `@RequiredArgsConstructor` for constructor injection.
- No explicit error handling in controllers — exceptions propagate to Spring's default handler.
- `Integer` (boxed) used for IDs, not `int`.

## Skills (skills.md)
Three automated skills are defined in [`skills.md`](skills.md):
1. **Testing Skill** — Generate JUnit 5 tests with `@ExtendWith(MockitoExtension.class)`, `@Mock`, `@InjectMocks`. Do **not** execute the test.
2. **DevSecOps CI Skill** — Create `.github/workflows/ci.yml` triggered on PR to `main` with 3 steps: JDK 21 setup, `mvn clean test`, mocked SAST/SCA echo.
3. **Auto-MR Skill** — Run `chmod +x mvnw`, create a fix branch, commit, push, and open a PR via `gh pr create --fill`.
