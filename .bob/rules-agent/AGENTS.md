# Project Coding Rules (Non-Obvious Only)

- **No null-guard in `UserService.getUserDisplayName()`** — adding a missing-ID check is the most likely bug fix needed; return a sensible default or throw a mapped exception rather than letting NPE surface as a 500.
- **All classes live in one flat package** (`com.binarylabsid.demo`) — do not create sub-packages unless explicitly asked.
- **Constructor injection only** — use Lombok `@RequiredArgsConstructor`; never add `@Autowired` fields or setters.
- **Lombok on every model** — annotate with `@Data @Builder @NoArgsConstructor @AllArgsConstructor`; do not write getters/setters manually.
- **Tests must be pure Mockito** — `@ExtendWith(MockitoExtension.class)` + `@Mock` + `@InjectMocks`; do NOT load a Spring context (`@SpringBootTest`) in unit tests.
- **Test directory is empty** (`src/test/java/com/binarylabsid/demo/.gitkeep`) — new test classes go there.
- **After writing any test, run `./mvnw test` immediately** to verify it passes (required by skills.md).
- **Auto-MR skill** — when fixing a bug end-to-end, execute the full `chmod +x mvnw → git checkout -b → commit → push → gh pr create --fill` sequence from `skills.md`.
- **CI workflow** must have exactly 3 steps as defined in skills.md; do not add extra steps.
