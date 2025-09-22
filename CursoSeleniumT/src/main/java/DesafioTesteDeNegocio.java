import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class DesafioTesteDeNegocio {

	String url = "https://wcaquino.me/selenium/componentes.html";
	
	@Test
	public void deveValidarNomeObrigatorio() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		alert.accept();
		driver.quit();
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		alert.accept();
		driver.quit();
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		alert.accept();		
		driver.quit();
	}
	
	@Test
	public void deveValitarVeganismo() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		alert.accept();		
		driver.quit();
	}
	
	@Test
	public void deveValitarEsportista() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("O que eh esporte?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		alert.accept();		
		driver.quit();
	}
	
}
