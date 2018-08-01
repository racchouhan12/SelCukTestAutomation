package com.test.automation.utilities;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class ThisRun {
    private static ThisRun ourInstance;
    public HashMap<String, Object> sessionState = new HashMap<>();

    public static ThisRun getInstance() {

        if (ourInstance == null) {
            return ourInstance = new ThisRun();
        }
        return ourInstance;
    }

    private ThisRun() {
        sessionState.clear();
        sessionState.put("PROJECT_PATH", System.getProperty("user.dir"));
        sessionState.put("TEST_RESOURCES", getAsString("PROJECT_PATH")+"/src/test/resources");
        sessionState.put("REPORT_PATH", getAsString("PROJECT_PATH")+"/reports");
    }

    public void add(String key, Object value) {
        sessionState.put(key, value);
    }

    public Object get(String key) {
        return sessionState.get(key);
    }

    public String getAsString(String key) {
        return sessionState.get(key).toString();
    }

    public WebDriver driver() {
        return (WebDriver) sessionState.get("DRIVER");
    }

}
