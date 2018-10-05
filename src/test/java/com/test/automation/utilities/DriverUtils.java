package com.test.automation.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtils {

    private WebDriver driver;

    private ThisRun thisRun = ThisRun.getInstance();

    private static Logger logger = LogManager.getLogger(DriverUtils.class.getName());
    public String browser;

    public DriverUtils(String browser) {
        this.browser = browser;
    }


    private WebDriver instantiateChromeDriver() {
        String driverToBeLoaded = thisRun.getAsString("OS_NAME").contains("Windows") ? "chromedriver_win.exe": "chromedriver_mac";

        System.setProperty("webdriver.chrome.driver", thisRun.getAsString("TEST_RESOURCES")+"/"+driverToBeLoaded);
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().fullscreen();
        return driver;
    }

    private WebDriver instantiateFireFoxDriver() {
        driver = new FirefoxDriver();
        return driver;
    }

    public WebDriver getDriver(String browser) {
        logger.info("Instantiating Driver for browser: "+browser);
        switch (browser.toLowerCase()) {
            case "chrome":
                return instantiateChromeDriver();
            case "firefox":
                return instantiateFireFoxDriver();
             default:
                 throw new InvalidArgumentException("Invalid browser type");
        }
    }

    public void quitBrowser() {
        driver.quit();
    }
}
