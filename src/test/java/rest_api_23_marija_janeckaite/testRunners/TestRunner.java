package rest_api_23_marija_janeckaite.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
        "json:target/cucumber-reports/CucumberTestReport.json", // 1:48h
        "junit:target/cucumber-reports/report.xml"},
        features = {"src/test/resources/features"},
        glue = {"rest_api_23_marija_janeckaite/stepDefinitions"}
)
public class TestRunner {
}
