# Selenium Automation Framework

Modern web automation framework built with **Java**, **Selenium WebDriver**, **Cucumber** and **Allure Report**, following **Page Object Model (POM)** and **BDD** principles.

Designed to demonstrate scalable automation architecture, maintainability and QA Engineering best practices.

---

# Demo

> 🚧 GIF coming soon

*(Here a GIF will show the complete execution of the framework.)*

---

# Why this project?

This project was created to simulate the architecture of a real-world automation framework rather than a simple collection of automated tests.

The focus is on maintainability, scalability and clean architecture, applying software engineering principles commonly used by QA Automation Engineers.

The framework separates business scenarios, test implementation, page behavior, UI locators, browser interactions and driver management into independent layers.

---

# Highlights

- Selenium WebDriver
- Cucumber BDD
- Page Object Model
- Single Responsibility Principle
- Reusable Page Objects
- Centralized WebDriver Management
- Explicit Wait Strategy
- External Configuration
- Clean Test Architecture
- English BDD Scenarios
- Allure Test Reports
- Automatic Screenshots on Failure
- Execution Environment Information
- Conventional Commits

---

# Architecture

```text
Feature
      │
      ▼
Step Definitions
      │
      ▼
Page Objects
      │
      ▼
Elements
      │
      ▼
BasePage
      │
      ▼
DriverManager
      │
      ▼
Browser
```

Each layer has a single responsibility, making the framework easier to maintain and extend.

| Layer | Responsibility |
| --- | --- |
| Features | Business scenarios |
| Steps | Step implementation |
| Pages | Page behavior |
| Elements | UI locators |
| BasePage | Shared browser actions and synchronization |
| DriverManager | Browser lifecycle |
| Config | Environment configuration |
| Hooks | Test lifecycle and failure evidence |
| Runners | Test suite execution |

---

# Project Structure

```text
selenium-saucedemo
│
├── src
│   │
│   ├── main
│   │   ├── java
│   │   │   └── br.com.gabriela
│   │   │       ├── config
│   │   │       ├── driver
│   │   │       ├── elements
│   │   │       ├── pages
│   │   │       └── utils
│   │   │
│   │   └── resources
│   │       └── config
│   │           └── config.properties
│   │
│   └── test
│       ├── java
│       │   └── br.com.gabriela
│       │       ├── hooks
│       │       ├── runners
│       │       └── steps
│       │
│       └── resources
│           ├── features
│           ├── allure.properties
│           └── environment.properties
│
└── pom.xml
```

---

# Current Automated Scenarios

## Authentication

The authentication suite currently contains **11 automated scenarios**.

- Successful Login
- Invalid Username
- Invalid Password
- Invalid Credentials
- Empty Username
- Empty Password
- Empty Credentials
- Locked User
- Password Mask Validation
- Close Error Message
- Inventory Access Without Authentication

Current execution status:

```text
Test Scenarios: 11
Passed:         11
Failed:         0
Success Rate:   100%
```

---

# Tech Stack

| Tool | Purpose |
| --- | --- |
| Java | Programming Language |
| Selenium WebDriver | Browser Automation |
| Cucumber | BDD |
| Gherkin | Business-readable Test Scenarios |
| JUnit 5 | Test Platform |
| Maven | Dependency Management and Build |
| WebDriverManager | Driver Management |
| Allure Report | Test Reporting |
| Git | Version Control |

---

# Getting Started

## Clone

```bash
git clone https://github.com/gabyfnunes/qa-portfolio.git
```

---

## Enter the project

```bash
cd qa-portfolio/selenium-saucedemo
```

---

## Install dependencies

```bash
mvn clean install
```

---

## Execute tests

To execute the complete test suite:

```bash
mvn clean test
```

You can also run:

```text
CucumberTest.java
```

directly from IntelliJ IDEA.

---

# Configuration

The application URL is stored in:

```text
src/main/resources/config/config.properties
```

Current configuration:

```properties
base.url=https://www.saucedemo.com/
```

This keeps environment-specific information outside the test implementation and makes the framework easier to maintain.

---

# Synchronization Strategy

The framework uses **explicit waits** to synchronize browser interactions with the application state.

Reusable element lookup is centralized in `BasePage` using Selenium's `WebDriverWait` and `ExpectedConditions`.

Conceptually:

```java
wait.until(
    ExpectedConditions.visibilityOfElementLocated(locator)
);
```

This avoids fixed waits such as:

```java
Thread.sleep();
```

and helps reduce flaky tests caused by page loading, redirects or delayed element rendering.

---

# Allure Report

The project uses **Allure Report** to provide detailed and visual information about each test execution.

The report includes:

- Test execution status
- Cucumber scenarios
- Individual Gherkin steps
- Execution duration
- Failure details
- Stack traces
- Execution environment information
- Screenshots automatically attached to failed scenarios

---

## Generate Test Results

First, execute the tests:

```bash
mvn clean test
```

The Allure result files are automatically generated at:

```text
target/allure-results
```

---

## Open the Allure Report

After executing the tests, generate and open the report with:

```bash
allure serve target/allure-results
```

Allure will generate a local report and automatically open it in the default browser.

---

## Allure Commandline

To generate and open reports locally, **Allure Commandline** must be installed and available in the system PATH.

You can verify the installation with:

```bash
allure --version
```

Once configured, the normal execution flow is:

```bash
mvn clean test
allure serve target/allure-results
```

---

# Execution Environment

Execution environment information is automatically included in the Allure report.

Current configuration:

```text
Browser:     Chrome
Environment: QA
OS:          Windows
Java:        25
Framework:   Selenium + Cucumber
```

The configuration is stored in:

```text
src/test/resources/environment.properties
```

During the Maven test lifecycle, this file is automatically copied to:

```text
target/allure-results/environment.properties
```

Because this process is handled by Maven, the environment information is recreated automatically even after:

```bash
mvn clean test
```

---

# Screenshots on Failure

When a scenario fails, the framework automatically captures a screenshot before closing the browser.

The screenshot is attached directly to the corresponding scenario in the Allure report.

The execution flow is:

```text
Scenario execution
       │
       ▼
Scenario fails
       │
       ▼
Screenshot captured
       │
       ▼
Screenshot attached to Allure
       │
       ▼
WebDriver terminated
```

This provides visual evidence of the application state at the exact moment of failure and makes debugging easier.

Screenshots are captured only when a scenario fails, avoiding unnecessary report attachments for successful executions.

---

# Test Lifecycle

Cucumber Hooks are responsible for actions executed after each scenario.

The current teardown strategy:

1. Checks whether the scenario failed
2. Captures a screenshot when necessary
3. Attaches the evidence to Allure
4. Terminates the WebDriver session

This guarantees that failure evidence is collected **before** the browser is closed.

---

# Roadmap

## Framework

- [x] Selenium WebDriver Setup
- [x] Page Object Model
- [x] Centralized Driver Management
- [x] External Configuration
- [x] Cucumber BDD
- [x] Authentication Automation
- [x] Explicit Wait Strategy
- [x] Allure Reports
- [x] Screenshots on Failure
- [x] Execution Environment Information
- [ ] Inventory Automation
- [ ] Product Sorting
- [ ] Shopping Cart
- [ ] Checkout
- [ ] Complete E2E Purchase Flow
- [ ] Logout
- [ ] Cucumber Tags
- [ ] Logging
- [ ] Multi-browser Support
- [ ] Parallel Execution
- [ ] GitHub Actions
- [ ] CI/CD Pipeline
- [ ] Docker Execution

## Portfolio

- [ ] REST Assured
- [ ] Playwright
- [ ] Cypress
- [ ] Appium
- [ ] JMeter
- [ ] Test Documentation

---

# Next Steps

The next phase of this project will expand the automated coverage beyond authentication.

The planned e-commerce automation flow is:

```text
Authentication
      │
      ▼
Inventory
      │
      ▼
Products
      │
      ▼
Shopping Cart
      │
      ▼
Checkout
      │
      ▼
Order Confirmation
```

This will evolve the project from an authentication-focused suite into a complete e-commerce automation framework.

---

# About Me

**Gabriela de Freitas Nunes**

QA Engineer focused on **Functional Testing, Test Automation and Quality Engineering**.

GitHub:

https://github.com/gabyfnunes

LinkedIn:

https://www.linkedin.com/in/gabriela-de-freitas-nunes/

---

⭐ If you enjoyed this project, feel free to star the repository.