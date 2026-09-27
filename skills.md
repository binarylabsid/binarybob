# BinaryBob Automated Skills
1. **Testing Skill:** Generate JUnit 5 tests. They MUST be fully isolated using `@ExtendWith(MockitoExtension.class)`, `@Mock`, and `@InjectMocks`. Do not execute the test.
2. **DevSecOps CI Skill:** Initialize `.github/workflows/ci.yml`. It MUST trigger on `pull_request` to `main`. The YAML job must contain 3 fast steps: Setup JDK 21, run `mvn clean test`, and add an echo step `run: echo "SAST and SCA Security Scans Passed (Mocked for Demo)"`.
3. **Auto-MR Skill:** Autonomously execute these commands sequentially in the terminal based on the context of the fix: 
   `git checkout -b fix/<dynamic-issue-name>`
   `git add .`
   `git commit -m "fix: <descriptive-message>"`
   `git push -u origin HEAD`
   `gh pr create --fill`