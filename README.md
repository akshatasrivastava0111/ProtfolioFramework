# Manav Automation Framework

A practical Java automation framework for browser and REST API testing. It favors clear boundaries and reliable test behavior over ornamental abstractions.

## Stack

Java 21 bytecode, Maven, Selenium WebDriver, TestNG, Rest Assured, Jackson, Allure, SLF4J and Logback. WebDriverManager supplies local browser drivers.

## Architecture

```text
Tests -> Pages / API clients -> driver, specifications, configuration, utilities
```

UI tests use Page Objects, so locators and interactions remain outside tests. API tests call focused clients, which apply shared request configuration and endpoints. `ConfigurationManager` is the single runtime-property boundary. `DriverFactory` owns a `ThreadLocal<WebDriver>` for safe parallel execution.

## Layout

```text
stark-automation-framework/
├── .github/workflows/automation.yml
├── src/main/java/com/stark/automation/{api,config,core,pages,utils}
├── src/main/resources/{config,logback.xml}
├── src/test/java/com/stark/automation/{api,base,dataproviders,listeners,ui}
├── src/test/resources/test-data/{api,ui}
├── api-tests.xml
├── ui-tests.xml
├── testng.xml
└── pom.xml
```

## Prerequisites and setup

Install JDK 21+ and Maven 3.9+; Git is needed only to clone the repository. Browser binaries for Chrome, Firefox, or Edge must be installed for UI execution. Clone the repository, then run Maven from its root.

## Configuration

`src/main/resources/config` holds `qa`, `staging`, and `production` property files. QA is the default. Command-line values always override the selected file:

```bash
mvn test -Denv=staging -Dbrowser=firefox -Dheadless=true
```

Supported browsers are `chrome`, `firefox`, and `edge`. Invalid environments and browsers fail with clear framework exceptions.

## Running tests

```bash
mvn clean compile
mvn clean test                 # combined suite
mvn test -Papi                 # API suite
mvn test -Pui -Dbrowser=edge -Dheadless=true
mvn test -Denv=qa -Dbrowser=firefox -Dheadless=true
```

The supplied TestNG suite runs methods in parallel with two threads. Adjust `parallel` and `thread-count` in the suite XML to suit local capacity; driver instances remain isolated per thread.

## Test targets

UI tests exercise [Sauce Demo](https://www.saucedemo.com/), a public demo storefront using its documented demonstration account. API tests use [DummyJSON](https://dummyjson.com/), a mock REST API; its write/delete endpoints simulate changes and do not mutate a real production system.

## Data, reporting, and reliability

JSON files under `src/test/resources/test-data` are parsed through `TestDataReader` and supplied via readable TestNG DataProviders. Failure screenshots are saved under `target/screenshots` and attached to Allure when a UI driver is available. API response bodies are attached to Allure. Generate a local report after a run with `allure serve target/allure-results` (requires the Allure command-line tool).

The retry analyzer retries only failed tests and defaults to one retry in QA/staging. Set `-Dretry.count=0` when investigating failures; retries are diagnostics, never a stability substitute.

## CI

GitHub Actions runs on pushes and pull requests, executes API and headless UI suites with Java 21, and preserves Surefire, Allure, and screenshot artifacts.

## Future improvements

- Dockerized browser runs or Selenium Grid
- Contract and database testing
- Visual regression checks
- Environment secrets through CI secret stores
