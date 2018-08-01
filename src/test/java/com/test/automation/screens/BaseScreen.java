package com.test.automation.screens;

import com.test.automation.utilities.ThisRun;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseScreen {

    final WebDriver driver;

    protected BaseScreen() {
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
