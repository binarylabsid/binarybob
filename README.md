# 🤖 BinaryBob: Enterprise DevSecOps Agent
Welcome to the BinaryBob repository. This project demonstrates a zero-touch DevSecOps workflow utilizing IBM Bob as an autonomous engineering agent.

## 🛠️ Architecture
- `agent.md`: Defines Enterprise Security Standards and SLF4J Audit Logging.
- `skills.md`: Contains automated toolchains for CI/CD pipelines and GitHub CLI (`gh`) Auto-MR execution.

---

## 🎬 OPERATIONAL SOP (For IBM Bob Execution)
*Note for Tech Lead: Use the prompts below to instruct BinaryBob during an active incident.*

### [EXECUTION PROMPT 1 - INCIDENT RESOLUTION]
An incident occurred. Please analyze the most recent exception in the attached terminal. Fix the root cause by adding a proper null check, and inject a SLF4J log "[SECURITY-AUDIT] Payload validated" exactly as instructed in our existing `agent.md` file (DO NOT create a new agent.md or AGENTS.md file). Then, use your Testing Skill from the existing `skills.md` file to generate the isolated test and execute `./mvnw test` in the terminal.

### [EXECUTION PROMPT 2 - PIPELINE & AUTO-MR]
The test passed perfectly in my local terminal! As the Tech Lead, I approve this fix. Now, execute your DevSecOps CI Skill to bootstrap our pipeline. Finally, execute your Auto-MR Skill to push and create the Pull Request autonomously based on the context of the fix.