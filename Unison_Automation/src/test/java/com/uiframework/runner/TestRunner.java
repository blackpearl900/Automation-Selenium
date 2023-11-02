package com.uiframework.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Functional Or @Negative",
        features = "src/test/Features",
        glue = { "com.uiframework.common", "com.uiframework.steps", "com.uiframework.runner", "com.inovalon.cucumber.common"},
        publish = true,
        plugin = { "pretty", "json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/cucumberreport.html"},
        monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

}
