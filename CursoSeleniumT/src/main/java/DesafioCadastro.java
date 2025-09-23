import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioCadastro {

	String url = "https://wcaquino.me/selenium/componentes.html";
	
	private DSL dsl;
	
	private WebDriver driver;
	
	@Before
	public void inicializar() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	
	@Test
	public void deveFazerCadastroCompleto() {
		dsl.escreve("elementosForm:nome", "Eduardo");		
		dsl.escreve("elementosForm:sobrenome", "Rufino");	
		dsl.clicaRadio("elementosForm:sexo:0");		
		dsl.clicaRadio("elementosForm:comidaFavorita:0");		
		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");		
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		
		
		dsl.escreve("elementosForm:sugestoes", "Aprender Selenium com Java!");
		
		dsl.clicarBotao("elementosForm:cadastrar");
		
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertEquals("Nome: Eduardo", driver.findElement(By.id("descNome")).getText());
		Assert.assertEquals("Sobrenome: Rufino", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Carne", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: O que eh esporte?", driver.findElement(By.id("descEsportes")).getText());
		Assert.assertEquals("Sugestoes: Aprender Selenium com Java!", driver.findElement(By.id("descSugestoes")).getText());
	}
	
}
