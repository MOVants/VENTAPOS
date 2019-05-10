package Venta.pos.com;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DiscountModule extends StringValues {
	static WebDriver driver;
	static String browser;

	public void setBrowser() {
		browser = "Chrome";
	}
	public void browserConfig () {

		if (browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver","/home/marvin/git/VENTAPOS/Venta/libs/geckoDriver/geckodriver"); 
			driver = new FirefoxDriver();
		}else if (browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/marvin/git/VENTAPOS/Venta/libs/chromeDriver/chromedriver");
			driver = new ChromeDriver();
		}
	}

	@Before
	public void setUp() throws Exception {
		setBrowser();
		browserConfig();
		driver.get("http://172.16.0.12:8589");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	

	@Test
	public void LoginTest() throws Exception {
		toAdmLogin();
		System.out.println("Login test = Passed!");
	}

	@Test
	public void createPWDDiscountTest() throws Exception {
		toAdmLogin();
		todiscounts();
		Thread.sleep(1000);
		newPWDSeniorDiscBtn();
		Thread.sleep(1000);
		setPWDSeniorDiscDetails();
		saveSNPWDDiscountDetails();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getDescountSuccess)).getText();
		if (str.contains("Successfully")) {
			System.out.println("Create SR/PWD discount test = Passed!");
		}else {
			System.out.println("Create SR/PWD discount test = Failed!");
		}

		//		  Assert.assertEquals(str, "Successfully created discount.");
		//		  Assert.assertTrue(str.contains("Successfully"));
		//		    if (str.equals("Successfully created discount."))
		//			{
		//				System.out.println("Create SR/PWD discount test = Passed!");
		//			} else {
		//				System.out.println("Create SR/PWD discount test = Failed!");
		//			}
	}

	@Test
	public void emptyPWDDiscountNameFieldTest() throws Exception{
		toAdmLogin();
		todiscounts();
		Thread.sleep(1000);
		newPWDSeniorDiscBtn();
		Thread.sleep(1000);
		setPWDSeniorDiscDetails();
		driver.findElement(By.xpath(discountNameField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(discountNameField)).sendKeys(Keys.BACK_SPACE);
		saveSNPWDDiscountDetails();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getDescountError)).getText();
		if (str.contains("Please review fields again.")) {
			System.out.println("Empty SR/PWD Discount Name Field Test = Passed!");
		}else {
			System.out.println("Empty SR/PWD Discount Name Field Test = Failed!");
		}
	}


	@Test
	public void emptyPWDDiscountPercentFieldTest() throws Exception{
		toAdmLogin();
		todiscounts();
		Thread.sleep(1000);
		newPWDSeniorDiscBtn();
		Thread.sleep(1000);
		setPWDSeniorDiscDetails();
		driver.findElement(By.xpath(discountPercentField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(discountPercentField)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(discountPercentField)).sendKeys(RandomStringUtils.randomNumeric(2));
		saveSNPWDDiscountDetails();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getDescountError)).getText();
		if (str.contains("Please review fields again.")) {
			System.out.println("Empty SR/PWD Discount Percent Field Test = Passed!");
		} else {
			System.out.println("Empty SR/PWD Discount Percent Field Test = Failed!");
		}
	}

	@Test
	public void modifyPWDDiscountTest() throws Exception{
		toAdmLogin();
		todiscounts();
		Thread.sleep(1000);
		selectPWDSeniorDisctoModify();
		String discountName = driver.findElement(By.xpath(discountNameField)).getText();
		Thread.sleep(1000);
		modifySrPWDDiscountDetails();

		saveSNPWDDiscountDetails();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getDescountSuccess)).getText();
		if (str.contains(discountName)) {
			System.out.println("Modify SR/PWD Discount Test = Passed!");
		} else {
			System.out.println("Modify SR/PWD Discount Test = Failed!");
		}
	}

	@Test
	public void modifyPWDDiscountNameFieldTest() throws Exception{
		toAdmLogin();
		todiscounts();
		Thread.sleep(1000);
		selectPWDSeniorDisctoModify();
		driver.findElement(By.xpath(discountNameField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(discountNameField)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(discountNameField)).sendKeys(RandomStringUtils.randomNumeric(8));
		String discountName = driver.findElement(By.xpath(discountNameField)).getText();
		saveSNPWDDiscountDetails();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getDescountSuccess)).getText();
		if (str.contains(discountName)) {
			System.out.println("Modify SR/PWD Discount Name Field  Test = Passed!");
		} else {
			System.out.println("Modify SR/PWD Discount Name Field  Test = Failed!");
		}
	}	  

	@Test
	public void modifyPWDDiscountPercentFieldTest() throws Exception{
		toAdmLogin();
		todiscounts();
		Thread.sleep(1000);
		selectPWDSeniorDisctoModify();
		driver.findElement(By.xpath(discountPercentField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(discountPercentField)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(discountPercentField)).sendKeys(RandomStringUtils.randomNumeric(8));
		String discountName = driver.findElement(By.xpath(discountNameField)).getText();
		saveSNPWDDiscountDetails();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getDescountSuccess)).getText();
		if (str.contains(discountName)) {
			System.out.println("Modify SR/PWD Discount Percent Field  Test = Passed!");
		} else {
			System.out.println("Modify SR/PWD Discount Percent Field  Test = Failed!");
		}
	}	  
	
	
	@Test
	public void createOtherDiscount() throws InterruptedException {
		toAdmLogin();
		todiscounts();
		Thread.sleep(2000);
		toOtherDiscountMngt();
		Thread.sleep(1000);
		newOtherDiscountBtn();
		Thread.sleep(1000);
		setOtherDiscountDetails();
		saveOtherDicDetails();
		Thread.sleep(1000);
		if (driver.getPageSource().contains("Successfully")) {
			System.out.println("Create Other Discount - QA Passed");
		}else {
			System.out.println("Create Other Discount - QA Failed");
		}
		
	}

	private void newOtherDiscountBtn() {
		driver.findElement(By.xpath(newOtherDiscBtn)).click();
		
	}
	private void setOtherDiscountDetails() throws InterruptedException {
		driver.findElement(By.xpath(otherDiscNameField)).sendKeys(RandomStringUtils.randomAlphanumeric(5)+ " " + RandomStringUtils.randomAlphanumeric(5));
		driver.findElement(By.xpath(otherDiscField)).sendKeys(RandomStringUtils.randomNumeric(2));
	}
	private void saveOtherDicDetails() {
		driver.findElement(By.xpath(saveOtherDiscDetailsBtn)).click();
		
	}
	private void toOtherDiscountMngt() {
		driver.findElement(By.xpath(otherDiscTab)).click();
		
	}
	private void saveSNPWDDiscountDetails() {
		driver.findElement(By.xpath(savePWDSrDiscountBtn)).click();	
	}

	private void setPWDSeniorDiscDetails() {
		driver.findElement(By.xpath(discountNameField)).sendKeys(RandomStringUtils.randomAlphanumeric(8));
		driver.findElement(By.xpath(discountPercentField)).sendKeys(RandomStringUtils.randomNumeric(2));
	}
	
	private void selectPWDSeniorDisctoModify() {
		driver.findElement(By.xpath(sRPWDEditBtn)).click();

	}

	private void modifySrPWDDiscountDetails() {
		driver.findElement(By.xpath(discountNameField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(discountNameField)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(discountNameField)).sendKeys(RandomStringUtils.randomNumeric(2));
		driver.findElement(By.xpath(discountPercentField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(discountPercentField)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(discountPercentField)).sendKeys(RandomStringUtils.randomNumeric(2));
	}


	private void newPWDSeniorDiscBtn() {
		driver.findElement(By.xpath(sRPWDDiscountCreateBtn)).click();
	}

	private void todiscounts() {
		driver.findElement(By.xpath(discountBtn)).click();
	}

	private void toAdmLogin() {
		driver.findElement(By.xpath(emailField)).sendKeys(authAdm);
		driver.findElement(By.xpath(passwordField)).sendKeys(authAdmPassword);
		driver.findElement(By.xpath(btnLogin)).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}
}
