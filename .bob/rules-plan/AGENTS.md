# Project Architecture Rules (Non-Obvious Only)

- **Single-layer architecture**: there is no service interface — `UserController` depends directly on `UserService` (concrete class), not an abstraction. Keep this pattern for existing code; introduce interfaces only for new significant components.
- **No persistence**: the mock data store is initialised once in `UserService`'s constructor and lives only for the JVM lifetime — any "write" operations will reset on restart.
- **Flat package**: everything lives in `com.binarylabsid.demo`. Component scanning relies on `DemoApplication` being in this package — never move the main class.
- **Spring Boot 4.x**: uses the `spring-boot-starter-webmvc` stack (not the reactive `webflux`); `webmvc-test` is the correct test slice dependency.
- **Lombok annotation processor is explicit**: `pom.xml` declares Lombok as an `annotationProcessorPath` in both `default-compile` and `default-testCompile` executions — required because of Spring Boot 4 Maven plugin changes. Do not remove either execution block.
- **No security layer**: there is no Spring Security on the classpath — all endpoints are publicly accessible by design for this demo.
