# UI Test Cucumber IKEA

Projekt testów automatycznych UI dla strony [ikea.com/dk/da](https://www.ikea.com/dk/da/), oparty na Spring Boot, Selenium i Cucumber (BDD).

## Stack technologiczny

- **Java 21**
- **Spring Boot 4.1.0**
- **Selenium WebDriver 4.31.0** (Chrome, headless)
- **Cucumber 7** + JUnit Platform Suite (Cucumber-JVM)
- **AssertJ**

## Struktura projektu

```
src/main/java/...UiTestCucumberIkeaApplication.java   - klasa startowa Spring Boot
src/test/resources/features/ikea_homepage.feature     - scenariusze testowe (Gherkin)
src/test/java/...steps/IkeaHomepageSteps.java          - kroki Cucumber (Selenium)
src/test/java/...RunCucumberTest.java                  - runner Cucumber (JUnit Platform Suite)
src/test/java/...CucumberSpringConfiguration.java      - integracja Cucumber + Spring
```

## Scenariusze testowe

Plik `ikea_homepage.feature` zawiera:

1. **Otwarcie strony głównej IKEA Denmark** – sprawdzenie tytułu strony oraz widoczności bannera zgody na cookies.
2. **Wyszukiwanie produktu** – wpisanie zapytania ("BILLY") w wyszukiwarkę i weryfikacja, że wyniki zawierają szukaną frazę.

## Wymagania

- Java 21 (JDK)
- Zainstalowana przeglądarka **Google Chrome** (Selenium uruchamia ją w trybie headless)
- Połączenie z internetem (testy odpytują realną stronę ikea.com)

Maven nie jest wymagany lokalnie – projekt zawiera Maven Wrapper (`mvnw` / `mvnw.cmd`).

## Uruchamianie testów

### Windows

```bash
mvnw.cmd test
```

### Linux / macOS

```bash
./mvnw test
```

Testy uruchomią się w przeglądarce Chrome w trybie headless. Wyniki testów (raporty Surefire) znajdą się w katalogu `target/surefire-reports`.

## Uruchamianie aplikacji

```bash
./mvnw spring-boot:run
```