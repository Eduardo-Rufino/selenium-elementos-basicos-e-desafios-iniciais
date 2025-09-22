import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAlert {

	
	String url = "https://wcaquino.me/selenium/componentes.html";
	
	@Test
	public void deveInteragirComAlertSimples() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", alert.getText());
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		driver.quit();
	}
	
	@Test
	public void deveInteragirComAlertConfirm() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();
		driver.findElement(By.id("confirm")).click();
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.accept();
		driver.quit();
	}
	
	@Test
	public void deveInteragirComPrompt() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		 
		
		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("12");
		alert.accept();
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
		driver.quit();
	}
	
}
