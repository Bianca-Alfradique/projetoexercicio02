package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroDeProdutosTest {

	@Test
	public void testCadastroDeProdutoComSucesso() {

		// Executando o driver do googlechrome
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver\\chromedriver.exe");

		// Abrindo o navegador (google chrome)
		WebDriver driver = new ChromeDriver();

		// Maximizar o navegador
		driver.manage().window().maximize();

		// Acessar a página Web do Sistema que será testada
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio05");

		// Preencher o nome do produto
		driver.findElement(By.xpath("//*[@id=\"nome\"]")).sendKeys("Notebook Dell");

		// Preencher o preço do produto
		driver.findElement(By.xpath("//*[@id=\"preco\"]")).sendKeys("3500");

		// Preencher o quantidade desejada
		driver.findElement(By.xpath("//*[@id=\"quantidade\"]")).sendKeys("10");

		// Clicar no botão de confirmação de cadastro
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

		// Capturar a mensagem obtida no sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// comparando se a mensagem obtida do sistema é "Produto cadastrado com
		// sucesso."
		assertEquals(mensagem, "Produto cadastrado com sucesso.");

		try {
			// O selenium irá fazer um print da tela e armazenar em memória
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// Salvando o arquivo na pasta
			FileUtils.copyFile(arquivo, new File("c:\\evidencias_test\\Produto cadastrado com sucesso.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Fechar o navagador
		driver.close();
		driver.quit();
	}

}
