package Venta.pos.com;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class updasad extends StringValues {
	static WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/marvin/git/VENTAPOS/Venta/libs/chromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	

	@Test
	public void LoginTest() throws Exception {
		driver.get("http://172.16.0.12:8501/#/");
//		Thread.sleep(2000);
//		for (String handle : driver.getWindowHandles()) {
//			driver.switchTo().window(handle);
//		}
		driver.findElement(By.name("Update POS Terminal")).click();
		driver.findElement(By.xpath("//input[@type='text'][@class='q-field__native q-placeholder']")).sendKeys("100011");
		driver.findElement(By.xpath("//div[text()='OK']")).click();
		
		Thread.sleep(4000);
	}
	
	@Test
	public void LoginTestd() throws Exception {
		driver.get("http://172.16.0.12:8501/#/");
		driver.findElement(By.xpath(emailField)).sendKeys(authAdm);
		driver.findElement(By.xpath(passwordField)).sendKeys(authAdmPassword);
		driver.findElement(By.xpath(btnLogin)).click();
		driver.findElement(By.xpath("//i[text()='phonelink_setup']")).click();
		Thread.sleep(1000);
		for (int i = 0; i < 5; i++){
			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/canvas[1]")).click();
			  Thread.sleep(1000);
			}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='password'][@class='q-field__native q-placeholder']")).sendKeys("10001");
		driver.findElement(By.xpath("//div[text()='OK']")).click();
		driver.navigate().refresh();
		Thread.sleep(5000);
	}



	@After
	public void tearDown() throws Exception {
		driver.quit();

	}
}
