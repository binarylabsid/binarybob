# BinaryBob Automated Skills
1. **Testing Skill:** Generate JUnit 5 tests. They MUST be fully isolated using `@ExtendWith(MockitoExtension.class)`, `@Mock`, and `@InjectMocks` to ensure lightning-fast unit testing.
2. **DevSecOps CI/CD Skill:** Initialize `.github/workflows/ci.yml` that sets up JDK 21, and run the test natively using interactive WSL command: `wsl -- bash -ic "cd /home/dev/binarybob && chmod +x mvnw && ./mvnw test"`. It MUST include standard SAST & SCA security scan steps.
3. **Auto-MR Skill:** Autonomously execute these commands sequentially in the terminal: 
   `git checkout -b fix/<dynamic-issue-name>`
   `git add .`
   `git commit -m "fix: <descriptive-message>"`
   `git push -u origin HEAD`
   `gh pr create --fill`