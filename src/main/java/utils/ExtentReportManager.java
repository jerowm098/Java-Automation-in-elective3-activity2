package utils;

import java.io.File;

public class ExtentReportManager {

    public static void checkReportsFolder() {
        File reportsFolder = new File(System.getProperty("user.dir") + "/reports");
        if (!reportsFolder.exists()) {
            reportsFolder.mkdirs();
        }
    }
}