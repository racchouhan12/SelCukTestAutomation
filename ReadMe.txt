About Project

It is Selenium - Cucumber (BDD) project will be used to automate web application.
Project has Page Object model as its design pattern.


Pre-requisites:

1. Java8 or higher should be installed.
2. Set JAVA_HOME
3. Install maven and set MAVEN_HOME
4. Add JAVA_HOME and MAVEN_HOME in your Path variable.

Framework structure:

1. Project is a maven project.
2. Our framework code lies mainly in src/test folder.
3. Project has three layer approach or calling:
    feature -> stepdefinitions -> businessflows -> screens

    i.      feature -> It is test/resources. It will contain all feature files (.feature).
    ii.     stepdefinitions -> This folder has java files which contains step definitions corresponding in feature file.
    iii.    businessflows -> This folder has java files which contains which contains business logic or assertions
    iv.     screens -> This folder has java files which perform actual actions on the web browser.

4. In resources there are couple of more files like .exe, .properties.
5. In CommonProperties.properties we are passing browser name it will have more keys as framework expands.
6. We have utilities package which contains utilities for driver, reporting and maintaing session state of objects(ThisRun.java)
7. Call flows are as follows:
    i. run commands:
        a. mvn clean
        b. mvn install or mvn test
    ii. Now execution will begin

        Call hierarchy are as follows:

        Runcuckes
            |
        Hooks: [ThisRun.java will be called in Hooks itself and driver intialization and other Keys are setup here]
            |
        features
            |
        stepdefinitions
            |
        businessflows
            |
        screens

 Rules to be followed:

 1. We should not call screens directly from stepdefinitions call hierarchy should be maintained (stepdefinitions -> businessflows -> screens).
 2. All assertions should be done in businessflows only
 3. Mutiple businessflows can be called from stepdefinitions

 How to run Test:

 1. To run specific scenarios use command : run=@foo mvn test -PRunTest (For MAC)
    For Windows you might need to use
    a. set run=@foo
    b. mvn test -PRunTest
 2. To run all scenarios use command : mvn test -PRunTest

 Note: In both cases scenarios with tags @wip or @failing will be ignored.
