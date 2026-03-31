# Project Setup and Code Coverage Report

## Environment Setup
The project is a Java-based application built using Apache Maven.  
Java JDK was installed first to support both Maven and SonarQube execution.

Maven was then installed and configured using environment variables so that the project could be built and tested using standard Maven commands.

---

## SonarQube Setup Using Docker
Instead of installing SonarQube manually, Docker was used to simplify the setup.

Docker was installed and a SonarQube container was started using the official SonarQube LTS image.  
The container runs locally and exposes the SonarQube dashboard on port `9000`.

Once the container was running, the SonarQube web interface was accessed through the browser and an authentication token was generated for Maven integration.

---

## Maven Project Configuration
The project uses a standard Maven structure.

The `pom.xml` file was updated to:
- Set the Java version
- Add the JaCoCo plugin for test coverage
- Add the SonarQube Maven plugin for static code analysis

All project source code and test code were placed inside the Maven `src/main/java` and `src/test/java` directories.

---

## Running Tests and Generating Coverage
Unit tests were executed using Maven.

JaCoCo was configured to automatically generate a coverage report after tests were run.  
The coverage report was generated inside the `target` directory and verified locally.

---

## SonarQube Analysis
After tests and coverage generation, the SonarQube analysis was executed using Maven.

The analysis command sent:
- Source code
- Test results
- Code coverage data

to the local SonarQube server running in Docker.

---

## Viewing Results
After the analysis completed successfully, the project appeared on the SonarQube dashboard.

From the dashboard, the following metrics were reviewed:
- Code coverage
- Bugs
- Code smells
- Maintainability issues

This helped verify that the code met basic quality and coverage standards.
