package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"json:target/cucumber.json",
                "pretty", "summary", "html:target/default-html-reports"},
        features = "src/test/resources/Features",
        monochrome = false,
        glue = "StepDefinitions",
        dryRun = false,
        tags = "@transferMoneyOtherAccount"
)

public class CukesRunner {
}
