# 🤖 BinaryBob: Enterprise DevSecOps Agent
Welcome to the BinaryBob repository. This project demonstrates a zero-touch DevSecOps workflow utilizing IBM Bob as an autonomous engineering agent.

## 🛠️ Architecture
- `agent.md`: Defines Enterprise Security Standards and SLF4J Audit Logging.
- `skills.md`: Contains automated toolchains for CI/CD, CodeQL SAST/SCA, and GitHub CLI (`gh`) Auto-MR execution.

---

## 🎬 OPERATIONAL SOP (For IBM Bob Execution)
*Note for Tech Lead: Use the prompts below to instruct BinaryBob during an active incident.*

### [EXECUTION PROMPT 1 - INCIDENT RESOLUTION]
An incident occurred. Please analyze the most recent exception in the attached terminal. Fix the root cause following our agent.md DevSecOps standards, and use your Testing Skill from skills.md to generate the isolated test in the correct `src/test/java/com/binarylabsid/demo/` directory.

### [EXECUTION PROMPT 2 - PIPELINE & AUTO-MR]
The test passed perfectly! As the Tech Lead, I approve this fix. Now, apply the audit log per agent.md. Next, execute your DevSecOps CI/CD Skill to bootstrap our pipeline with SAST and SCA. Finally, execute your Auto-MR Skill to push and create the Pull Request autonomously.