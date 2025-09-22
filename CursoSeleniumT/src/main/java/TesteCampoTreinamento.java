import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
	String url = "https://wcaquino.me/selenium/componentes.html";
	
	@Test
	public void testeTextField() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		//driver.findElement(By.id("elementosForm:nome")).getAttribute("value");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void deveInteragirComTextArea() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste");
		//driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value");
		Assert.assertEquals("Teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void testeRadioButton() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		//driver.findElement(By.id("elementosForm:sexo:0")).isSelected();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}
	
	@Test
	public void testeCheckBox() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://wcaquino.me/selenium/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		//driver.findElement(By.id("elementosForm:sexo:0")).isSelected();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.quit();
	}
	
	@Test
	public void testeCombo() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		//combo.selectByIndex(2);
		//combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau completo");
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		driver.quit();
	}
	
	@Test
	public void testeVerificaValoresCombo() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option:options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
	}
	
	@Test
	public void testeVerificaValoresComboMuitiplo() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		allSelectOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectOptions.size());
		
		driver.quit();
	}
	
	@Test
	public void testeBotao() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		WebElement botao =  driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
	}
	
	@Test
	// @Ignore
	public void testeLink() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.linkText("Voltar")).click();
		
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		//Assert.fail();
		
		driver.quit();
	}
	
	@Test
	public void testeTexto() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		
		//Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.tagName("span")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		
		driver.quit();
	}

}
