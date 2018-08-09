package com.test.automation.utilities;


import java.io.File;

public class FileUtils {

    public static boolean createFolder(String nameOfFolder) {
        File file = new File(nameOfFolder);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created: " + nameOfFolder);
                return true;
            } else {
                System.out.println("Failed to create directory!");
                return false;
            }
        }
        return false;
    }

}
