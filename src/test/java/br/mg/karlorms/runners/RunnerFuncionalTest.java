package br.mg.karlorms.runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "br.mg.karlorms.steps",
		tags = "@funcionais",
		plugin = {"pretty", "html:target/report-html"},
		monochrome = false,
		dryRun = false,
		snippets = SnippetType.CAMELCASE)
public class RunnerFuncionalTest {
	
static WebDriver driver;
	
	@BeforeClass
	public static void reset(){
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me");
		driver.findElement(By.id("email")).sendKeys("karlorms@gmail.com");
		driver.findElement(By.name("senha")).sendKeys("karlorms");
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}

}
