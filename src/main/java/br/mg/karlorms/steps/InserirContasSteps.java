package br.mg.karlorms.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class InserirContasSteps {

	WebDriver driver;

	@Dado("que estou acessando a aplicacao")
	public void queEstouAcessandoAAplicacao() {
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me");
	}

	@Quando("informo o usuario {string}")
	public void informoOUsuario(String email) {
		driver.findElement(By.xpath("/html/body/div[2]/form/div[1]/input")).sendKeys(email);

	}

	@Quando("a senha {string}")
	public void aSenha(String senha) {
		driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/input")).sendKeys(senha);
	}

	@Quando("seleciono entrar")
	public void selecionoEntrar() {
		driver.findElement(By.xpath("//button")).click();
	}

	@Entao("visualizo a pagina inicial")
	public void visualizoAPaginaInicial() {
		Assert.assertEquals("Bem vindo, karlorms!",
				driver.findElement(By.xpath("//div[@role='alert']")).getText());
	}

	@Quando("seleciono Contas")
	public void selecionoContas() {
		driver.findElement(By.xpath("//div//li[2]//a")).click();
	}

	@Quando("seleciono Adicionar")
	public void selecionoAdicionar() {
		driver.findElement(By.xpath("//a[@href='/addConta']")).click();
	}

	@Quando("informo a conta (.*)$")
	public void informoAConta(String nomeConta) {
		driver.findElement(By.name("nome")).sendKeys(nomeConta);
	}

	@Quando("seleciono Salvar")
	public void selecionoSalvar() {
		driver.findElement(By.xpath("//button")).click();
	}

	@Entao("a conta e inserida com sucesso")
	public void aContaEInseridaComSucesso() {
		Assert.assertEquals("Conta adicionada com sucesso!",
				driver.findElement(By.xpath("//div[@role='alert']")).getText());
	}

	@Entao("sou notificado que o nome da conta e obrigatorio")
	public void souNotificadoQueONomeDaContaEObrigatorio() {
		Assert.assertEquals("Informe o nome da conta", driver.findElement(By.xpath("//div[@role='alert']")).getText());
	}
	
	@Entao("sou notificado que ja existe uma conta com esse nome")
	public void souNotificadoQueJaExisteUmaContaComEsseNome() {
	    Assert.assertEquals("J� existe uma conta com esse nome!", driver.findElement(By.xpath("//div[@role='alert']")).getText());
	}
	
	@Entao("recebo a mensagem {string}")
	public void receboAMensagem(String msg) {
		 Assert.assertEquals(msg, driver.findElement(By.xpath("//div[@role='alert']")).getText());
	}
	
	@After(order = 1, value = "@funcionais")
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/"+ cenario.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(order = 0, value = "@funcionais")
	public void fecharBrowser() {
		driver.quit();
	}

}
