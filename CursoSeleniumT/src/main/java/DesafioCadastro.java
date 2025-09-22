import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioCadastro {

	String url = "https://wcaquino.me/selenium/componentes.html";
	
	@Test
	public void deveFazerCadastroCompleto() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Eduardo");
		
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Rufino");
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));		
		Select select = new Select(element);		
		select.selectByVisibleText("Superior");
		
		element = driver.findElement(By.id("elementosForm:esportes"));
		select = new Select(element);
		select.selectByVisibleText("O que eh esporte?");
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Aprender Selenium com Java!");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertEquals("Nome: Eduardo", driver.findElement(By.id("descNome")).getText());
		Assert.assertEquals("Sobrenome: Rufino", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Carne", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: O que eh esporte?", driver.findElement(By.id("descEsportes")).getText());
		Assert.assertEquals("Sugestoes: Aprender Selenium com Java!", driver.findElement(By.id("descSugestoes")).getText());
		
		driver.quit();
	}
	
}
