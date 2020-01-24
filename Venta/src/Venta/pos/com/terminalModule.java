package Venta.pos.com;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;

public class terminalModule {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/christopher/eclipse-workspace/Selinium/LIBRARY/chromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void creatediscount() throws Exception {
		driver.get("http://172.16.0.12:8589/");
		driver.findElement(By.xpath("//input[@type='text'][@placeholder='Email']")).sendKeys("admin@satellite.com.ph");
		driver.findElement(By.xpath("//input[@type='password'][@placeholder='Password']")).sendKeys("admin");
		driver.findElement(By.xpath("//text()[contains(.,'LOGIN')]/ancestor::button[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[3]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Reports'])[1]/following::input[1]")).sendKeys(RandomStringUtils.randomAlphanumeric(8) + " " + RandomStringUtils.randomAlphanumeric(8) );
		driver.findElement(By.xpath("//input[@type='number'][@class='q-field__native']")).sendKeys("50");
		driver.findElement(By.xpath("//text()[.='SAVE']/ancestor::button[1]")).click();
		Thread.sleep(2000);
		if (driver.getPageSource().contains("Successfully")) {
			System.out.println("QA Passaed");
		}
	}
	
	@Test
	public void creatediscountEmptyName() throws Exception {
		driver.get("http://172.16.0.12:8589/");
		driver.findElement(By.xpath("//input[@type='text'][@placeholder='Email']")).sendKeys("admin@satellite.com.ph");
		driver.findElement(By.xpath("//input[@type='password'][@placeholder='Password']")).sendKeys("admin");
		driver.findElement(By.xpath("//text()[contains(.,'LOGIN')]/ancestor::button[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[3]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='number'][@class='q-field__native']")).sendKeys("50");
		driver.findElement(By.xpath("//text()[.='SAVE']/ancestor::button[1]")).click();
		Thread.sleep(2000);
		if (driver.getPageSource().contains("required")) {
			System.out.println("QA Passaed");
		} else {
			System.out.println("QA Failed");
		}
	}
	
	@Test
	public void creatediscountEmptyDiscField() throws Exception {
		driver.get("http://172.16.0.12:8589/");
		driver.findElement(By.xpath("//input[@type='text'][@placeholder='Email']")).sendKeys("admin@satellite.com.ph");
		driver.findElement(By.xpath("//input[@type='password'][@placeholder='Password']")).sendKeys("admin");
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[3]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Reports'])[1]/following::input[1]")).sendKeys(RandomStringUtils.randomAlphanumeric(8) + " " + RandomStringUtils.randomAlphanumeric(8) );
	
		driver.findElement(By.xpath("//text()[.='SAVE']/ancestor::button[1]")).click();
		Thread.sleep(2000);
		if (driver.getPageSource().contains("required")) {
			System.out.println("QA Passaed");
		} else {
			System.out.println("QA Failed");
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}
}
