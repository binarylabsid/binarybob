# Binarylabs ID Automated Skills
1. **Testing Skill:** Generate or update JUnit 5 tests. They MUST be fully isolated using `@ExtendWith(MockitoExtension.class)`, `@Mock`, and `@InjectMocks`.
2. **DevSecOps CI/CD Skill:** Initialize `.github/workflows/ci.yml` that sets up JDK 21, runs `mvn clean test`, and includes standard SAST & SCA security scan steps (e.g., GitHub CodeQL).
3. **Auto-MR Skill:** Autonomously execute these commands in sequence in the terminal: 
   `git checkout -b fix/<dynamic-issue-name>`
   `git add .`
   `git commit -m "fix: <descriptive-message>"`
   `git push -u origin HEAD`
   `gh pr create --fill`