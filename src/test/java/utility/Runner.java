package utility;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinition", "appHooks"},
        plugin = {"pretty", "json:target/cucumber-reports/CucumberTestReport.json"},
        monochrome = true
)
public class Runner {
    @AfterClass
    public static void generateReport() {
        System.out.println("Generating Cucumber Report...");
        File reportOutputDirectory = new File("target/cucumber-reports");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-reports/CucumberTestReport.json");

        String buildNumber = "1";
        String projectName = "testAuto";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
        System.out.println("Cucumber Report Generated.");
    }
}
