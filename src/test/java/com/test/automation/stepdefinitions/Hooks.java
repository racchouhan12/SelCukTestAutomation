package com.test.automation.stepdefinitions;

import com.test.automation.utilities.DriverUtils;
import com.test.automation.utilities.ThisRun;
import com.test.automation.helpers.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    ThisRun thisRun  = ThisRun.getInstance();
    DriverUtils driverUtils;
    WebDriver driver;

    @Before
    public void setup() throws IOException {
        loadProperties();
        addDriverProperties();
    }

    private void loadProperties() throws IOException {
        FileInputStream fileStream =
                new FileInputStream(thisRun.get("TEST_RESOURCES") + "/CommonProperties.properties");
        Properties commonProperties = new Properties();
        commonProperties.load(fileStream);
        thisRun.add(KEYS.BROWSER, commonProperties.getProperty("BROWSER"));
    }

    private void addDriverProperties() {
        driverUtils = new DriverUtils(thisRun.getAsString("BROWSER"));
        driver = driverUtils.getDriver(driverUtils.browser);
        thisRun.add(KEYS.DRIVER, driver);
    }

    @After
    public void tearDown() {
        driverUtils.quitBrowser();
    }

}
