# amazon-automation

The repo hosts the test framework and tests for amazon.in.

The test framework is based on Selenium. Following are important features of the framework

Page Object Model & Action (POMA) based test implementation
Customized test reports
TestNG
Maven


Command to run -  
mvn clean test -DTestNGSuiteFile=testng.xml -Dbrowser="Edge" -DtestDataFile="testData1.json"

-Dbrowser can be one of the following - Chrome, Edge, Firefox, Safari
-DtestDataFile can be used to pass different test data to the suite

View reports by navigating to extent-reports -> extent-report.html

