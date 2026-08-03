package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        if (driver == null) {
            System.out.println("Driver is null, cannot take screenshot.");
            return null;
        }

        String dateName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + dateName + ".png";
        File finalDestination = new File(destination);

        try {
            FileUtils.copyFile(source, finalDestination);
            System.out.println("Screenshot saved successfully at: " + destination);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

        return destination;
    }
}