package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
//@CucumberOptions(  monochrome = true,
//        features = "src/test/resources/Features/",
//        format = { "pretty","html: cucumber-html-reports",
//                "json: cucumber-html-reports/cucumber.json" },
//        glue = "StepDefinitions" )

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features\\",
        glue = {"StepDefinitions"},
        monochrome = true,
        plugin = {"pretty", "html:target/HtmlReports"}
)
public class TestRunner {

}
