import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class DesafioTesteDeNegocio {

	String url = "https://wcaquino.me/selenium/componentes.html";
	
	private WebDriver driver;
	
	@Before
	public void inicializar() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void deveValidarNomeObrigatorio() {		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		alert.accept();
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		alert.accept();
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		alert.accept();		
	}
	
	@Test
	public void deveValitarVeganismo() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		alert.accept();		
	}
	
	@Test
	public void deveValitarEsportista() {
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
	}
	
}
