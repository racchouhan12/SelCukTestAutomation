package com.test.automation.utilities;


import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reporter {

    public static void main(String[] arg) {

        System.out.println("Inside Reporter..........");
        String reportsDir = ThisRun.getInstance().sessionState.get("REPORT_PATH").toString();
        System.out.println(reportsDir);
        File reportOutputDirectory = new File(reportsDir);

        List<String> jsonReportFiles = getListOfJsonReports(reportOutputDirectory);;

        if (jsonReportFiles.size() == 0) {
            throw new RuntimeException("ERROR - NO json reporter available to create HTML report");
        }

        try {
            Configuration configuration = createReportBuilderConfiguration(reportOutputDirectory);

            ReportBuilder reportBuilder = new ReportBuilder(jsonReportFiles, configuration);
            reportBuilder.generateReports();
            System.out.println("\n\tHTML Reports are available here - $reportsDir");
        } catch (Exception e) {
            System.out.println("ERROR in creating consolidated reporter - $e");
        }
    }

    private static Configuration createReportBuilderConfiguration(File reportOutputDirectory) {
        Configuration configuration = new Configuration(reportOutputDirectory, "Demo Project");
        return configuration;
    }

    private static List<String> getListOfJsonReports(File reportOutputDirectory) {
        List<File> jsonReportFiles =
                Arrays.asList(reportOutputDirectory.listFiles());

        List<String> files = jsonReportFiles.stream().map( file -> file.getAbsolutePath())
                .filter(file -> file.endsWith(".json"))
                .collect(Collectors.toList());

        return  files;

    }
}
