# AGENTS.md

This file provides guidance to agents when working with code in this repository.

## Project: BinaryBob — IBM Bob Hackathon Demo
Spring Boot 4.0.8 + Java 21 + Lombok + Maven. No database — all data lives in an in-memory `HashMap` inside `UserService`.

## Commands
```bash
./mvnw clean install          # build + all tests
./mvnw test                   # run all tests
./mvnw test -Dtest=ClassName  # run a single test class
./mvnw spring-boot:run        # start dev server (WARN-level logs only)
chmod +x mvnw                 # required before first run on Linux/Mac
```

## Architecture
All classes are in a single flat package `com.binarylabsid.demo` — no sub-packages.
- `User.java` — Lombok `@Data @Builder @NoArgsConstructor @AllArgsConstructor` model
- `UserService.java` — `@Slf4j @Service`; owns the in-memory `mockDb = new HashMap<>()`
- `UserController.java` — `@RestController @RequiredArgsConstructor`; injects service via constructor
- Single endpoint: `GET /api/users/{id}/name` → returns `name.toUpperCase()` as plain `String`

**Gotcha:** `UserService.getUserDisplayName()` calls `.get(userId).getName()` with no null-check — accessing a non-existent ID will throw `NullPointerException`.

## Code Style
- All dependency injection via constructor (Lombok `@RequiredArgsConstructor`) — never `@Autowired`
- Lombok is mandatory for models (`@Data`, `@Builder`, `@NoArgsConstructor`, `@AllArgsConstructor`) and service logging (`@Slf4j`)
- No dedicated exception handler exists — errors propagate as 500s
- `application.properties` suppresses all INFO logs globally; only WARN/ERROR visible at runtime

## Testing (from skills.md)
- Tests MUST use `@ExtendWith(MockitoExtension.class)` + `@Mock` + `@InjectMocks` — no Spring context loading
- Test files go in `src/test/java/com/binarylabsid/demo/` (currently only a `.gitkeep` placeholder)
- After generating a test, autonomously run `./mvnw test` to verify it passes

## Automated Skills (from skills.md)
Three pre-defined skills must be followed exactly when triggered:

**Testing Skill:** Generate JUnit 5 tests with `@ExtendWith(MockitoExtension.class)`, `@Mock`, `@InjectMocks`. Run `./mvnw test` to verify.

**DevSecOps CI Skill:** Create `.github/workflows/ci.yml` triggering on `pull_request` to `main` with exactly 3 steps:
1. Setup JDK 21
2. `mvn clean test`
3. `echo "SAST and SCA Security Scans Passed (Mocked for Demo)"`

**Auto-MR Skill:** Run these commands sequentially:
```bash
chmod +x mvnw
git checkout -b fix/<dynamic-issue-name>
git add .
git commit -m "fix: <descriptive-message>"
git push -u origin HEAD
gh pr create --fill
```
