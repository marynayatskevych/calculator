# Unit Tests for Calculator-1.0.jar

## Task Description

| Task Requirement | Completed              |
|---|------------------------|
| Add Calculator-1.0.jar to project reference |  pow.xml               |
| Write tests using any testing framework (JUnit or TestNG) | JUnit                  |
| Each class should test only one method of the library | ✅                      |
| Tests pre-conditions and post-conditions should be implemented with appropriate annotations | @BeforeEach @AfterEach |
| Run tests in IDE | ✅                      |
| Create parametrized tests (data-driven approach) | ✅                      |
| Configure and execute tests in parallel mode | junit-platform.properties |

---

## Acceptance criteria


1. A separate Unit Test class exists for each method of Calculator-1.0.jar.
2. JUnit or TestNG is used in home task.
3. Tests have pre-conditions and post-conditions.
4. Screenshots with results of running in IDE are available.

---

## Test Report Generation
The test report was generated using Maven Surefire Report Plugin.
`The report file is located at: target/reports/surefire.html`

---

## Library Integration

- The file `Calculator-1.0.jar` was added to the `libs` directory.
- It was connected to the project via `pom.xml`.

```xml
<dependency>
    <groupId>com.example</groupId>
    <artifactId>calculator-jar</artifactId>
    <version>1.0</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/libs/calculator-1.0.jar</systemPath>
</dependency>
```
---

## Parallel Test Execution

Parallel execution in this project is implemented using:

1. Configuration File `src/test/resources/junit-platform.properties`contains the following settings:
```junit.jupiter.execution.parallel.enabled=true junit.jupiter.execution.parallel.config.strategy=dynamic```
2. Each test class is annotated with: @Execution(ExecutionMode.CONCURRENT)
