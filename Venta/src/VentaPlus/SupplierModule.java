package VentaPlus;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SupplierModule extends StringVal {
	private WebDriver driver;
	static String browser;

	public void setBrowser() {
		browser = "Chrome";
	}
	public void browserConfig () {

		if (browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver","/home/christopher/git/VENTAPOS/Venta/libs/chromeDriver/chromedriver"); 
			driver = new FirefoxDriver();
		}else if (browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver","/home/christopher/git/VENTAPOS/Venta/libs/chromeDriver/chromedriver");
			driver = new ChromeDriver();
		}
	}
	@Before
	public void setUp() throws Exception {
		setBrowser();
		browserConfig();
		driver.get("http://172.16.0.12:8501");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void CreateSupplier() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div[3]/div[2]/div/div")).click();
		Thread.sleep(1000);
	    driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(RandomStringUtils.randomAlphabetic(3));
	    driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
		String str = driver.findElement(By.xpath(Notif)).getText();
		Thread.sleep(1000);
		if (str.contains("Successfully"))

		{
			System.out.println("Create Supplier test = Passed!");
		} else {
			System.out.println("Create Supplier test = Failed!");
		}
		}
	@After
	public void tearDown() throws Exception {
		driver.quit();

	}
	public void Terminal() throws Exception {
		driver.findElement(By.xpath(Terminalbtn)).click();
	    driver.findElement(By.xpath(Terminalfield )).sendKeys("10001");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(Terminalsave)).click();
	}
	public void Login()  {
		driver.findElement(By.xpath(Userfield)).sendKeys(authSuperAdm);
		driver.findElement(By.xpath(passField)).sendKeys(authSuperAdmPassword);
		driver.findElement(By.xpath(Loginfield)).click();
		}
	public void InventoryModule() {
		driver.findElement(By.xpath(Inventorymodule)).click();
	}
}

