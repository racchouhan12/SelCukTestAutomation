package com.test.automation.screens;

import com.test.automation.utilities.ThisRun;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseScreen {

    final WebDriver driver;
    protected static Logger logger = LogManager.getLogger(BaseScreen.class.getName());

    protected BaseScreen() {
        logger.debug("BaseScreen intialized...");
        ThisRun thisRun = ThisRun.getInstance();
        driver = thisRun.driver();

    }

    protected void openURL(String URL) {
        driver.get(URL);
    }

    protected void sendText(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }
}
