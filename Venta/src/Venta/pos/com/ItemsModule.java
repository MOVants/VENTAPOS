package Venta.pos.com;


import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.Before;

public class ItemsModule extends StringValues{
	private WebDriver driver;
	static String browser;

	public void setBrowser() {
		browser = "Chrome";
	}
	public void browserConfig () {

		if (browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/christopher/eclipse-workspace/Selinium/LIBRARY/chromeDriver/chromedriver"); 
			driver = new FirefoxDriver();
		}else if (browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/christopher/eclipse-workspace/Selinium/LIBRARY/chromeDriver/chromedriver");
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
	public void createItemTest() throws Exception {
		toAdmLogin();
		itemsHomeBtn();
		createNewItemBtn();
		Thread.sleep(1000);
		setItemDetails();
		toSaveItem();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getItemSuccess)).getText();
		if (str.contains("Successfully")) {
			System.out.println("Create Item Test = Passed!");
		} else {
			System.out.println("Create Item Test = Failed!");
		}
	}

	@Test
	public void emptyItemCodeFieldTest() throws Exception {
		toAdmLogin();
		itemsHomeBtn();
		createNewItemBtn();
		Thread.sleep(1000);
		setItemDetails();
		driver.findElement(By.xpath(itemCodeField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(itemCodeField)).sendKeys(Keys.BACK_SPACE);
		toSaveItem();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getItemError)).getText();
		if (str.contains("Please review fields again."))
		{
			System.out.println("Empty Item Code Field Test = Passed!");
		} else {
			System.out.println("Empty Item Code Field Test = Failed!");
		}
	}

	@Test
	public void emptyItemDescFieldTest() throws Exception {
		toAdmLogin();
		itemsHomeBtn();
		createNewItemBtn();
		Thread.sleep(1000);
		setItemDetails();
		driver.findElement(By.xpath(itemDescField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(itemDescField)).sendKeys(Keys.BACK_SPACE);
		toSaveItem();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getItemError)).getText();
		if (str.contains("Please review fields again."))
		{
			System.out.println("Empty Item Description Field Test = Passed!");
		} else {
			System.out.println("Empty Item Description Field Test = Failed!");
		}
	}

	@Test
	public void emptyItemBarcodeFieldTest() throws Exception {
		toAdmLogin();
		itemsHomeBtn();
		createNewItemBtn();
		Thread.sleep(1000);
		setItemDetails();
		driver.findElement(By.xpath(barcodeField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(barcodeField)).sendKeys(Keys.BACK_SPACE);
		toSaveItem();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getItemError)).getText();
		if (str.contains("Please review fields again."))
		{
			System.out.println("Empty Item Barcode Field Test = Passed!");
		} else {
			System.out.println("Empty Item Barcode Field Test = Failed!");
		}
	}

	@Test
	public void vatableItemSwitchOffTest() throws Exception {
		toAdmLogin();
		itemsHomeBtn();
		createNewItemBtn();
		Thread.sleep(1000);
		setItemDetails();
		driver.findElement(By.xpath(vatableSwitch)).click();
		toSaveItem();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getItemSuccess)).getText();
		if (str.contains("Successfully created item."))
		{
			System.out.println("Vatable Item Switch Off Test = Passed!");
		} else {
			System.out.println("Vatable Item Switch Off Test = Failed!");
		}
	}
	@Test
	public void noDiscountApplyTest() throws Exception{
		toAdmLogin();
		itemsHomeBtn();
		createNewItemBtn();
		Thread.sleep(1000);
		setItemDetails();
		driver.findElement(By.xpath(discountField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(discountField)).sendKeys(Keys.BACK_SPACE);
		toSaveItem();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(getItemSuccess)).getText();
		if (str.contains("Successfully created item."))
		{
			System.out.println("No Discount Apply Test = Passed!");
		} else {
			System.out.println("No Discount Apply Test = Failed!");
		}
	}

	private void toSaveItem() {
		driver.findElement(By.xpath(saveItemBtn)).click();
	}

	private void createNewItemBtn() {
		driver.findElement(By.xpath(createItemBtn)).click();
	}

	public void setItemDetails() {
		driver.findElement(By.xpath(itemCodeField)).sendKeys(RandomStringUtils.randomAlphanumeric(3));
		driver.findElement(By.xpath(itemDescField)).sendKeys(RandomStringUtils.randomAlphanumeric(10));
		driver.findElement(By.xpath(barcodeField)).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(By.xpath(originalPriceField)).sendKeys(RandomStringUtils.randomNumeric(3));
		driver.findElement(By.xpath(discountField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(discountField)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(discountField)).sendKeys(RandomStringUtils.randomNumeric(2));
		driver.findElement(By.xpath(vatableSwitch)).click();
		
	}

	private void itemsHomeBtn()throws Exception {
		driver.findElement(By.xpath(itemsMngtHomeBtn)).click();
		Thread.sleep(1000);
	}


	private void toAdmLogin() {
		driver.findElement(By.xpath(emailField)).sendKeys(authSuperAdm);
		driver.findElement(By.xpath(passwordField)).sendKeys(authSuperAdmPassword);
		driver.findElement(By.xpath(btnLogin)).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}
}

