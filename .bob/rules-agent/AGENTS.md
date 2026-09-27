# Project Coding Rules (Non-Obvious Only)

- **No repository layer**: `UserService` holds data in `private final Map<Integer, User> mockDb` — there is no JPA/DB. Any new data access must extend this map, not introduce a repository bean.
- **Unsafe lookup**: `mockDb.get(userId).getName()` has no null guard — any new service method must use `Optional.ofNullable(mockDb.get(userId)).orElseThrow(...)`.
- **Lombok annotation stack for models**: always `@Data @Builder @NoArgsConstructor @AllArgsConstructor` together; omitting `@NoArgsConstructor` breaks Jackson deserialization even though there is no Jackson usage today.
- **Security audit logging is mandatory**: every bug-fix commit must add `log.warn("[SECURITY-AUDIT] ...")` via the `@Slf4j` logger — this is a project persona rule, not optional style.
- **Dependency injection**: use `@RequiredArgsConstructor` (Lombok) on all Spring beans — never field-inject with `@Autowired`.
- **Test isolation**: unit tests must be pure Mockito (`@ExtendWith(MockitoExtension.class)`) — do not load a Spring context in tests.
- **Human approval gate**: never autonomously run `git push` or `gh pr create` — these require explicit user confirmation per `agent.md`.
