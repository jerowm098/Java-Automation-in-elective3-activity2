# JAVA AUTOMATION FOR ELECTIVE 3 – LABORATORY ACTIVITY 2
# Automation Exercise UI Test Framework


### Project Overview

This project is a Selenium WebDriver automation framework for https://automationexercise.com. It uses Java, TestNG, Maven, and the Page Object Model (POM) design pattern.


### Group Information

•	Group Members: 

•	Abiera Vincent, 

•	Bayran Ceejay, 

•	Luna, Marc Laurence, 

•	Mallari, Jerome, 

### Project Description
The framework includes:

 •	Browser setup and driver management using WebDriverManager. 
 •	Page objects and action classes for the Automation Exercise website. 
 •	Reusable base test features for reporting, screenshots, and assertions. 
 •	TestNG suite execution with retry support. 

### Technologies Used
•	Java 11
•	Selenium WebDriver
•	TestNG
•	Maven
•	WebDriverManager
•	ExtentReports
•	Apache Commons IO

### How to Run
1. Clone the repository.
2. Open the project in VS Code or your preferred IDE.
3. Run from the terminal:
    o	mvn clean test -Dbrowser=chrome -Dheadless=true
    o	or mvn clean test -Dbrowser=chrome
4. Reports are generated in the Reports/ folder. Each regression execution keeps every test result in the same HTML report, including explicit Passed, Failed, and Skipped entries.

### Project Structure
•	src/main/java/base - Base test and browser utilities.
•	src/main/java/pageObjects - Page object models.
•	src/main/java/pageEvents - Page action classes.
•	src/main/java/utils - Configuration, utilities, listeners, and retry logic.
•	src/test/java - Test classes.

### Notes
•	Verify that the repository is set to Public before submission.
•	Use the testng.xml suite file to execute the full regression test suite.
