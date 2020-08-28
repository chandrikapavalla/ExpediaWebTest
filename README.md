# ExpediaWebTest
Testing the Web UI of Expedia application using Selenium with TestNG Framework 
Testing the Web UI of Expedia application using Selenium with TestNG Framework

Introduction:
This Test Automation Framework is created using Java + Selenium Web Driver + TestNG. Which can be used 
across different web based applications. In this approach, the endeavor is to build a lot of applications independent
reusable components so that they can directly used for another web application without spending any extra effort. With this
framework in place, whenever we need to automate a web based application, we would not need to start from scratch, but use the
application independent components to the extent possible and create application specific components for the specific needs.

Prerequisites:
Java jdk-1.6 or higher Apache Maven 3 or higher

Execution:
Clone the repository. Import the project to Eclipse workspace We have ExpediaTestAutomation\src\main\resources\testng.xml 
Right click on testng.xml and click on run as 1 TestNG Suite..

Logging:
log4j configured to capture the test execution logs Configuration file is located at ExpediaTestAutomation\src\main\resources\log4j.properties

Screenshot:
Most of the time we think to Capture Screenshot in WebDriver when some kind of error or exception 
surfaces while practicing testing, to resolve the same the framework has a method. getScreenshot() is used to indicates
driver to capture a screenshot and store.

Reporting:
The framework produce index.html report. It resides in the same 'ExpediaTestAutomation\test-output' folder. 
This reports gives the link to all the different component of the TestNG reports like Groups & Reporter Output. 
On clicking these will display detailed descriptions of execution. You can find emailable-report.html from
ExpediaTestAutomation\test-output to email the test reports. As this is a html report you can open it with browser.
you can find Extent.html which are ExtentReports that gives details of execution.As this is a html report you can open it with browser.
