package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources"
        , glue = {"glue"},
        plugin = {"pretty", "html:target/cucumberReport.html", "json:target/cucumber-report.json"},
        tags = "@test_id01"
)
public class TestRunner {


}