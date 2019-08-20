package Venta.pos.com;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CouponModules {
private WebDriver driver;

	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/marvin/eclipse-workspace/checkingServerStatus/libs/chromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void createUserTest() throws Exception {
		driver.get("http://172.16.0.12:8501/#/login");
		driver.manage().getCookies();
		driver.navigate().refresh();
		Thread.sleep(5000);
	}
	
	public void getCokies() {
		driver.manage().getCookies();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}
}
