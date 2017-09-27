package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( monochrome = true,
	format = { "pretty", "html: cucumber-html-reports",
		 "json: cucumber-html-reports/cucumber.json" },
		dryRun = false,
		glue = "stepDefinitions",
		tags = {"~@ignore", "@runThis"})


public class RunnerClassIT {

}
