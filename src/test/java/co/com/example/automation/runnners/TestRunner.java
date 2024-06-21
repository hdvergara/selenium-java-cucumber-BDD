package co.com.example.automation.runnners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features"
        , glue = {"co/com/example/automation/stepsdefinitions", "co/com/example/automation/hooks"}
        , plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
