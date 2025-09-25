import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteFramesEJanelas {

	String url = "https://wcaquino.me/selenium/componentes.html";
	
	private WebDriver driver;
	
	private DSL dsl;
	
	@Before
	public void inicializar() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		//driver.quit();
	}
	
	
	@Test
	public void deveInteragirComFrames() {
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();	
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
	}
	
	@Test
	public void deveInteragirComJanelas() {
		String windowHandle = driver.getWindowHandle();
		
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.close();
		driver.switchTo().window(windowHandle);
		driver.findElement(By.tagName("textarea")).sendKeys("e agora?");
	}
	
	@Test
	public void deveInteragirComJanelaSemTitulo() {
		driver.findElement(By.id("buttonPopUpHard")).click();
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("E agora?");
	}
	
	@Test
	public void deveInteragirComFrameEscondido() {
		WebElement frame = driver.findElement(By.id("frame2"));	
		//dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.entrarFrame("frame2");		
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
	}
	
}
