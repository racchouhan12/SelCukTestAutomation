package com.test.automation.scripts;

import com.test.automation.helpers.KEYS;
import com.test.automation.utilities.ThisRun;
import org.apache.commons.lang3.ArrayUtils;

public class RuntimeScripts {
    private static ThisRun thisRun = ThisRun.getInstance();
    private static final String FEATURE_FILE_PATH = thisRun.getAsString(KEYS.FEATURE_FILES_PATH.name());

    public RuntimeScripts() {

    }

    private static String getRunTag() {
        return System.getenv("run");
    }

    private static String[] getExcludeTags() {
        String[] excludeTags = {"~@wip", "~@failing"};
        return excludeTags;
    }

    private static void generateHTMLReports() {
        com.test.automation.utilities.Reporter.main(null);
    }

    private static String[] getCucumberOptions() {

        String[] commonOptions = {
                "--glue",
                "com.test.automation.stepdefinitions",
                "--tags",
                getExcludeTags()[0],
                "--tags",
                getExcludeTags()[1],
                "--plugin",
                "pretty",
                "--plugin",
                "html:reports/html",
                "--plugin",
                "json:reports/cucumber.json",
                FEATURE_FILE_PATH
        };
        if (getRunTag() != null) {
            System.out.println("Running all Scenarios: with tags: " +getRunTag() + " (except @wip, @failing)......" );
            String[] runtag =  {"--tags", getRunTag()};
            return ArrayUtils.addAll(runtag, commonOptions);

        }
            System.out.println("Running all Scenarios except @wip, @failing...");
            return commonOptions;

    }

    public static void main(String[] argv) throws Throwable {
        byte exitstatus = cucumber.api.cli.Main.run(getCucumberOptions(), Thread.currentThread().getContextClassLoader());
        generateHTMLReports();
        System.exit(exitstatus);
    }
}
