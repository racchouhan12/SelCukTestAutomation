package com.test.automation.utilities;

import com.test.automation.helpers.KEYS;
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
        add(KEYS.PROJECT_PATH, System.getProperty("user.dir"));
        add(KEYS.TEST_RESOURCES, getAsString("PROJECT_PATH")+"/src/test/resources");
        add(KEYS.REPORT_PATH, getAsString("PROJECT_PATH")+"/reports");
    }

    public void add(String key, Object value) {
        sessionState.put(key, value);
    }

    public void add(KEYS key, Object value) {
        add(key.name(), value);
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
