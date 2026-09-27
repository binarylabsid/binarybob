# agent.md

This file provides guidance to agents when working with code in this repository.

## Project: BinaryBob — IBM Bob Hackathon Demo
Spring Boot 4.0.8 + Java 21 + Lombok + Maven. No database — data lives in an in-memory `HashMap` initialised in the `UserService` constructor (not `@PostConstruct`).

## Commands
```bash
./mvnw clean install          # build + all tests
./mvnw test                   # run all tests
./mvnw test -Dtest=ClassName  # run a single test class
./mvnw spring-boot:run        # start dev server (WARN-level logs only)