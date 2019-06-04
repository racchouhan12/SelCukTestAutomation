package com.test.automation.utilities;

import com.deque.axe.AXE;
import com.test.automation.stepdefinitions.Hooks;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class AxeAccessibility {

    private DriverUtils driverUtils;
    private ThisRun thisRun = ThisRun.getInstance();
    private WebDriver driver;
    private static final URL scriptUrl = AxeAccessibility.class.getResource("/axe.min.js");

    private AxeAccessibility(String browser) {
        driverUtils = new DriverUtils(browser);
        driver = driverUtils.getDriver();
    }


    public void testAccessibility() {
       // driver.get("http://localhost:5005");
        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();

        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            assertTrue("No violations found", true);
        } else {
         //   AXE.writeResults(testName.getMethodName(), responseJSON);
            assertTrue(AXE.report(violations), false);
        }
    }

    public void testAccessibilityWithOptions() {
        //driver.get("http://localhost:5005");
        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl)
                .options("{\n" +
                        "  runOnly: {\n" +
                        "    type: \"tag\",\n" +
                        "    values: [\"wcag2aa\"]\n" +
                        "  }\n" +
                        "}")
                .analyze();

        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            assertTrue("No violations found", true);
        } else {
           // AXE.writeResults(testName.getMethodName(), responseJSON);

            assertTrue(AXE.report(violations), false);
        }
    }


    public static void main(String[] args) throws IOException {
       // new Hooks().loadFromPropertiesFile();
        AxeAccessibility axeAccessibility = new AxeAccessibility("Chrome");
        axeAccessibility.testAccessibilityWithOptions();
    }

}
