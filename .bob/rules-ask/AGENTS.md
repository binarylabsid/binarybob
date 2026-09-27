# Project Documentation Rules (Non-Obvious Only)

- `agent.md` and `skills.md` in the project root are the canonical persona and automation rules — not README.MD.
- `README.MD` is upper-case `.MD`; tooling that expects `.md` (lowercase) will miss it.
- All classes are in a single flat package `com.binarylabsid.demo` — there are no sub-packages (no `controller/`, `service/`, `model/` sub-directories).
- `application.properties` silences INFO logs globally — log output during development will appear minimal by design, not because logging is broken.
- The test directory `src/test/java/com/binarylabsid/demo/` exists but contains no test files yet; skills.md specifies what they must look like when added.
- `spring-boot-starter-webmvc-test` (not the usual `spring-boot-starter-test`) is the test dependency — verify this before referencing test utilities.
