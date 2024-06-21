package co.com.example.automation.hooks;

import co.com.example.automation.helpers.Browsers;
import co.com.example.automation.utils.ExtentReportManager;
import co.com.example.automation.utils.WebDriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    private static ExtentReports extent = ExtentReportManager.initializeReport();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void setUp(Scenario scenario) {
        driver = WebDriverFactory.getDriver(Browsers.CHROME);
        extentTest = extent.createTest(scenario.getName(), scenario.getId());
        test.set(extentTest);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            driver.quit();
        }
        if (scenario.isFailed()) {
            test.get().log(Status.FAIL, "Scenario failed");
        } else {
            test.get().log(Status.PASS, "Scenario passed");
        }

        ExtentReportManager.flushReport();
    }
    public static ExtentTest getTest() {
        return test.get();
    }
}
