package utils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import reports.ExtentManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {

        public static String captureScreenshot(WebDriver driver, String screenshotName) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);

            String folderPath = "test-output/screenshots";
            String fileName = screenshotName + "_" + System.currentTimeMillis() + ".png";
            String destPath = folderPath + "/" + fileName;

            try {
                Files.createDirectories(Paths.get(folderPath));
                Files.copy(srcFile.toPath(), Paths.get(destPath));
                System.out.println("Screenshot saved: " + destPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "screenshots/" + fileName;
        }
        public static void attachStepScreenshot(WebDriver driver, String screenshotName, String message) {
            String path = captureScreenshot(driver, screenshotName);
            ExtentTest test = ExtentManager.getTest();

            String relativePath = "./screenshots/" + new File(path).getName();

            String htmlLog = message + "<br><img src='" + relativePath + "' height='400' width='800'/>";
            test.log(Status.INFO, htmlLog);
        }
    }

