# Selenium Learning - Test Automation Project

A modern test automation framework built with **Selenium**, **TestNG**, and **Allure Reports** for automating tests on [Automation Exercise](https://automationexercise.com/).

## Project Overview

This project demonstrates a professional-grade automation testing framework using the **Page Object Model (POM)** design pattern. It provides automated test cases for user registration and account management workflows with detailed reporting capabilities.

## Tech Stack

- **Selenium WebDriver** (v4.18.1) - Web automation
- **TestNG** (v7.9.0) - Test framework
- **Allure Reports** (v2.25.0) - Test reporting
- **WebDriverManager** (v5.6.3) - Automatic driver management
- **Java** (v25) - Programming language
- **Maven** - Build and dependency management
- **SLF4J** - Logging

## Project Structure

```
src/test/java/
├── base/
│   └── BaseTest.java                    # Base class for all tests
├── logic/
│   ├── base/
│   │   └── BasePage.java                # Base page object class
│   ├── pages/                           # Page object models
│   │   ├── AccountCreatedPage.java
│   │   ├── AccountInformationPage.java
│   │   ├── HeaderComponent.java
│   │   ├── HomePage.java
│   │   └── LoginSignupPage.java
│   └── utils/                           # Utility classes
│       ├── AdPopupUtils.java            # Ad popup handling
│       ├── CookieUtils.java             # Cookie management
│       └── TestDataUtils.java           # Test data generation
└── tests/
    └── RegisterAndDeleteUser.java       # Test cases

src/test/resources/
└── testng.xml                           # TestNG configuration

target/
├── allure-results/                      # Allure test results
└── surefire-reports/                    # Maven Surefire reports
```

## Test Cases

### Implemented Tests

1. **RegisterAndDeleteUser** (`RegisterAndDeleteUser.java`)
   - Register a new user account
   - Fill account information and address details
   - Verify account creation
   - Delete account after testing

## Features

✅ **Page Object Model** - Clean separation between test logic and page interactions  
✅ **Automatic WebDriver Management** - WebDriverManager handles browser driver setup  
✅ **Allure Reporting** - Beautiful HTML test reports with screenshots and logs  
✅ **Utility Classes** - Reusable helpers for common operations (cookies, popups, data generation)  
✅ **TestNG Framework** - Flexible test execution and parametrization support  
✅ **Logging** - SLF4J integration for detailed logging  

## Prerequisites

- Java 17
- Maven 3.6+
- Chrome/Firefox/Edge browser (for test execution)

## Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Selenium-Learning
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Verify setup**
   ```bash
   mvn test -v
   ```

## Running Tests

### Run all tests
```bash
mvn clean test
```

### Run specific test
```bash
mvn clean test -Dtest=RegisterAndDeleteUser
```

### Run with custom configuration
```bash
mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml
```

## Viewing Reports

### Generate Allure Report
```bash
mvn allure:report
```

### Open Allure Report
```bash
mvn allure:serve
```

This will open an interactive HTML report in your default browser displaying:
- Test execution timeline
- Test results overview
- Failure details
- Screenshots and logs

## Project Configuration

### Maven POM
- **Source/Target Java Version**: 25
- **Maven Surefire Plugin** (v3.2.5) - Runs tests via TestNG
- **Allure Maven Plugin** (v2.12.0) - Report generation

### TestNG Suite
Configuration file: `src/test/resources/testng.xml`
- Defines test suite name: "Automation Exercise Suite"
- Specifies test classes to execute
- Integrates Allure listeners for reporting

## Page Object Classes

### BasePage
Parent class for all page objects providing common WebDriver operations and element interaction methods.

### HomePage
Interactions with the home page including navigation to signup/login.

### LoginSignupPage
User registration and login functionality.

### AccountInformationPage
User account detail form filling.

### AccountCreatedPage
Account creation confirmation page.

### HeaderComponent
Navigation header including user login status and account deletion.

## Utility Classes

### CookieUtils
- `acceptCookiesIfPresent(driver)` - Accepts cookies if cookie banner appears

### AdPopupUtils
- `killAdIfPresent(driver)` - Closes ad popups during test execution

### TestDataUtils
- `generateEmail()` - Generates unique test email addresses

## Build Artifacts

After running tests, generated files are located in the `target/` directory:
- `allure-results/` - Allure report data
- `surefire-reports/` - Test execution reports
- `classes/` - Compiled classes

## Known Issues & TODOs

- ⚠️ Fix @Step annotation for Allure Reports display
- 📝 Expand test cases to cover additional scenarios from Automation Exercise

## Contributing

When adding new tests:
1. Create test class in `src/test/java/tests/`
2. Extend `BaseTest` class
3. Use existing Page Objects or create new ones following POM pattern
4. Add test method with `@Test` annotation
5. Update `testng.xml` with new test class

## Resources

- [Automation Exercise Test Cases](https://automationexercise.com/test_cases)
- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Allure Reports Documentation](https://docs.qameta.io/allure/)
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)

## License

This project is for educational purposes.

---

**Last Updated**: February 2026

---

**ToDo**

1. Fix @Step annotation for Allure reports
2. Follow with test cases