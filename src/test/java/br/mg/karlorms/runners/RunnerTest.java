package br.mg.karlorms.runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "br.mg.karlorms.steps",
		tags = "@unitarios",
		plugin = {"pretty", "html:target/report-html"},
		monochrome = false,
		dryRun = false,
		snippets = SnippetType.CAMELCASE)
public class RunnerTest {

}
