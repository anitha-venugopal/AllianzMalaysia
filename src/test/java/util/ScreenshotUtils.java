package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testName) {
        // Format timestamp safely for filenames
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Screenshot directory
        String dir = "./screenshots/";
        new File(dir).mkdirs();  // create directory if not exists

        // Full path of the screenshot
        String path = dir + testName + "_" + timestamp + ".png";

        // Take screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(path));
            System.out.println("📸 Screenshot saved: " + path);
        } catch (IOException e) {
            System.out.println("❌ Failed to save screenshot!");
            e.printStackTrace();
        }

        return path;
    }
}