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

public class LocationModule extends StringVal {
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
	public void CreateLocation() throws Exception {
		Terminal();
		Login();
		LocationBtn();
		ADDLocationBTn();
		LocationDetails();
		SaveLocation();
	   	Thread.sleep(1000);
	   	String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Create Location test = Passed!");
		} else {
			System.out.println("Create Location test = Failed!");
		}
	}
	@Test
	public void CreateLocationMissingName() throws Exception {
		Terminal();
		Login();
		LocationBtn();
		ADDLocationBTn();
		LocationDetails();
		driver.findElement(By.xpath(Locationname)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(Locationname)).sendKeys(Keys.BACK_SPACE);
		SaveLocation();
	   	Thread.sleep(1000);
	   	String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Create Location Missing Name test = Failed!");
		} else {
			System.out.println("Create Location Missing Name test = Passed!");
		}
	}
	@Test
	public void CreateLocationMissingADD() throws Exception {
		Terminal();
		Login();
		LocationBtn();
		ADDLocationBTn();
		LocationDetails();
		driver.findElement(By.xpath(LocationAdd)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(LocationAdd)).sendKeys(Keys.BACK_SPACE);
		SaveLocation();
	   	Thread.sleep(1000);
	   	String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Create Location Missing Address test = Failed!");
		} else {
			System.out.println("Create Location Missing Address test = Passed!");
		}
	}
	@Test
	public void ModifyLocationname() throws Exception {
		Terminal();
		Login();
		LocationBtn();
		ModifyBtn();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Locationname)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(Locationname)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(Locationname)).sendKeys(RandomStringUtils.randomAlphabetic(5));
		SaveLocation();
	   	Thread.sleep(1000);
	   	String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Modify Location Name test = Passed!");
		} else {
			System.out.println("Modify Location Name test = Failed!");
		}
	}
	@Test
	public void ModifyLocationAddress() throws Exception {
		Terminal();
		Login();
		LocationBtn();
		ModifyBtn();
		driver.findElement(By.xpath(LocationAdd)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(LocationAdd)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(LocationAdd)).sendKeys(RandomStringUtils.randomAlphabetic(5));
		SaveLocation();
	   	Thread.sleep(1000);
	   	String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Modify Location Address test = Passed!");
		} else {
			System.out.println("Modify Location Address test = Failed!");
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
	public void LocationBtn() {
		driver.findElement(By.xpath(Locationmodule)).click();
	}
	public void LocationDetails() throws Exception {
		
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(Locationname)).sendKeys(RandomStringUtils.randomAlphabetic(5));
	    driver.findElement(By.xpath(LocationAdd)).sendKeys(RandomStringUtils.randomAlphabetic(5));
		
	}
	public void SaveLocation() {
		 driver.findElement(By.xpath(SavelocationBtn)).click();
	}
	public void ADDLocationBTn() {
		driver.findElement(By.xpath(AddLocation)).click();
	}
	public void ModifyBtn() {
		driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[2]/table/tbody/tr/td[4]/button/div[2]/i")).click();
	}
}
	
	
	
	
	
	
	