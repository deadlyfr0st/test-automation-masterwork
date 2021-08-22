#Test automation masterwork
Testing the Community Wiki page.\
The application can be accessed by clicking on the link below:
[Community Wiki] (http://test-automation-wiki2.greenfox.academy)

*Read description in other languages: [Hungarian](README.md), [English](README.en.md).*

---
## Manual test cases
A description of the manual test cases can be found at the following link:\
[Test documentation] (https://docs.google.com/spreadsheets/d/1qGWCf2IpK-5bKLUf3cfcBtrDLPi3BzlE4_qjTqdzZg0/edit?usp=sharing)

---
## Project information
The project was written in JAVA with JDK8, in IntelliJ IDEA development environment, using Gradle project structure and Selenium WebDriver.
The tests are run with JUnit5 and AssertJ.

The completed tests are currently running in Google Chrome, but are compatible with the following browsers:
- Google Chrome
- Mozilla Firefox
- Microsoft Edge

You can change the browser you want to use in the "src/test/resources/test.properties" file.\
Rewrite the keyword `chrome` to `firefox`.\
If no `firefox` or `chrome` is included in the file, the default browser will be Microsoft Edge. 

#### Features tested:
- Registration
- Login/Logout
- Data listing
- Navigate multi-page data lists
- Create new wiki pages
- Modify created wiki pages
- Save data to a file

---
## Running automated tests
- Clone the repository to your computer
- Open the cloned gradle project with Intellij IDEA
- Click the "Terminal" tab at the bottom of the IntelliJ window
- Enter `gradlew clean test`
- Press "Enter"

## Create and access test report after previously run tests
- Click the "Terminal" tab at the bottom of the IntelliJ window
- Type `gradlew allureServe`
- Press "Enter"

This command creates the report and opens it in your default browser.

---
### Additional information for running tests and creating a test report

If the commands described above do not work, try putting the following in front of the commands: `./`\
e.g., `./gradlew clean test`
