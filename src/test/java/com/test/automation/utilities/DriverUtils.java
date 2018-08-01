package com.test.automation.utilities;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtils {

    private WebDriver driver;

    ThisRun thisRun = ThisRun.getInstance();

    public String browser;

    public DriverUtils(String browser) {
        this.browser = browser;
    }


    private WebDriver instantiateChromeDriver() {
        System.setProperty("webdriver.chrome.driver", thisRun.getAsString("TEST_RESOURCES")+"/chromedriver");
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
