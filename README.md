# Selenium Automation Framework

<div align="center">

Modern web automation framework built with **Java**, **Selenium WebDriver** and **Cucumber**, following **Page Object Model (POM)** and **BDD** principles.

Designed to demonstrate scalable automation architecture and QA Engineering best practices.

---

![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-43B02A?logo=selenium&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-23D96C?logo=cucumber&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit-5-25A162?logo=junit5&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven)
![GitHub Actions](https://img.shields.io/badge/CI-Planned-lightgrey)

</div>

---

# Demo

> 🚧 GIF coming soon

*(Here a GIF will show the complete execution of the framework.)*

---

# Why this project?

This project was created to simulate the architecture of a real-world automation framework rather than a simple collection of automated tests.

The focus is on maintainability, scalability and clean architecture, applying software engineering principles commonly used by QA Automation Engineers.

---

# Highlights

- Selenium WebDriver
- Cucumber BDD
- Page Object Model
- Single Responsibility Principle
- Reusable Page Objects
- Centralized WebDriver Management
- External Configuration
- Clean Test Architecture
- English BDD Scenarios
- Conventional Commits

---

# Architecture

```
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
|--------|----------------|
| Features | Business scenarios |
| Steps | Step implementation |
| Pages | Page behavior |
| Elements | UI locators |
| BasePage | Shared browser actions |
| DriverManager | Browser lifecycle |
| Config | Environment configuration |

---

# Project Structure

```
selenium-saucedemo
│
├── src
│
├── main
│   ├── config
│   ├── driver
│   ├── elements
│   ├── pages
│   └── utils
│
└── test
    ├── hooks
    ├── runners
    ├── steps
    └── features
```

---

# Current Automated Scenarios

### Authentication

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

---

# Tech Stack

| Tool | Purpose |
|------|----------|
| Java | Programming Language |
| Selenium WebDriver | Browser Automation |
| Cucumber | BDD |
| JUnit 5 | Test Platform |
| Maven | Dependency Management |
| WebDriverManager | Driver Management |
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

```bash
mvn test
```

or run:

```
CucumberTest.java
```

from IntelliJ IDEA.

---

# Configuration

Application URL is stored in

```
src/main/resources/config/config.properties
```

```
base.url=https://www.saucedemo.com/
```

---

# Roadmap

## Framework

- Inventory automation
- Shopping Cart
- Checkout
- Logout
- Tags
- Allure Reports
- Screenshots on Failure
- Logging
- Multi-browser Support
- Parallel Execution
- GitHub Actions

## Portfolio

- REST Assured
- Playwright
- Cypress
- Appium
- JMeter
- Test Documentation

---

# About Me

**Gabriela de Freitas Nunes**

QA Engineer focused on Functional Testing, Test Automation and Quality Engineering.

GitHub:

https://github.com/gabyfnunes

LinkedIn:

*(coming soon)*

---

⭐ If you enjoyed this project, feel free to star the repository.