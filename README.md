# UI Test Cucumber IKEA

Automated UI test project for [ikea.com/dk/da](https://www.ikea.com/dk/da/), built with Spring Boot, Selenium and Cucumber (BDD).

## Tech stack

- **Java 21**
- **Spring Boot 4.1.0**
- **Selenium WebDriver 4.31.0** (Chrome, headless)
- **Cucumber 7** + JUnit Platform Suite (Cucumber-JVM)
- **AssertJ**

## Project structure

The test code is organised in four layers:

```
🔵 Feature layer (Cucumber)      - test description in Gherkin
src/test/resources/features/*.feature

🟡 Step Definitions              - translate Gherkin -> Java, hold assertions
src/test/java/...steps/Hooks.java                - browser lifecycle (@Before/@After)
src/test/java/...steps/HomepageSteps.java
src/test/java/...steps/LisaboTableSteps.java

🟢 Page Objects (POM)            - Selenium logic per page
src/test/java/...pages/BasePage.java             - shared driver/wait + cookie banner
src/test/java/...pages/HomePage.java
src/test/java/...pages/LisaboTablePage.java

⚙️ Utils                         - driver, wait, config
src/test/java/...utils/DriverManager.java        - WebDriver lifecycle (ThreadLocal)
src/test/java/...utils/WaitHelper.java           - WebDriverWait wrappers
src/test/java/...utils/Config.java               - base URL and timeouts
```

Plus the supporting wiring:

```
src/main/java/...UiTestCucumberIkeaApplication.java   - Spring Boot application entry point
src/test/java/...RunCucumberTest.java                  - Cucumber runner (JUnit Platform Suite)
src/test/java/...CucumberSpringConfiguration.java      - Cucumber + Spring integration
```

## Test scenarios

The `ikea_homepage.feature` file contains:

1. **Open the IKEA Denmark homepage** – checks the page title and the visibility of the cookie consent banner.
2. **Search for a product** – enters a query ("BILLY") into the search box and verifies that the results contain the searched term.

## Requirements

- Java 21 (JDK)
- **Google Chrome** installed (Selenium launches it in headless mode)
- Internet connection (tests run against the live ikea.com site)

Maven is not required locally – the project includes the Maven Wrapper (`mvnw` / `mvnw.cmd`).

## Running the tests

### Windows

```bash
mvnw.cmd test
```

### Linux / macOS

```bash
./mvnw test
```

Tests run in headless Chrome. Test results (Surefire reports) are written to `target/surefire-reports`.

## Running the application

```bash
./mvnw spring-boot:run
```