package com.keypointTask.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json","rerun:target/rerun.txt",
                "html:target/default-html-reports" },
        features = "src/test/resources/features" ,
        glue = "com/keypointTask/StepDefinitions",
        dryRun = false,
        tags = "@wip"
)

public class CukesRunner {

}
