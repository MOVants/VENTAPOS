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

public class UserInterface extends StringVal {
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
	public void Invoice() throws Exception {
		Terminal();
		Login();
		driver.findElement(By.xpath(POS)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(InvoicePage)).click();
		Thread.sleep(1000);
		InvoiceSteps();
	    Thread.sleep(500);
	    Tendered();
	    Thread.sleep(500);
	    Checkout();
		Thread.sleep(2000);
		String str = driver.findElement(By.cssSelector(Notification)).getText();
		//System.out.print(str);
		if (str.contains("Successfully"))

		{
			System.out.println("Invoice test = Passed!");
		} else {
			System.out.println("Invoice test = Failed!");
		}
		
	}
	@Test
	public void InvoiceSRDiscount() throws Exception {
		Terminal();
		Login();
		driver.findElement(By.xpath(POS)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(InvoicePage)).click();
		Thread.sleep(1000);
		InvoiceSteps();
	    Thread.sleep(500);
	    Tendered();
	    Thread.sleep(500);
	    SRdiscount();
	    Discountdetails();
	    Thread.sleep(500);
	    Checkout();
		Thread.sleep(2000);
		String str = driver.findElement(By.cssSelector(Notification)).getText();
		//System.out.print(str);
		if (str.contains("Successfully"))

		{
			System.out.println("Invoice SRDiscount test = Passed!");
		} else {
			System.out.println("Invoice SRDiscount test = Failed!");
		}
		
	}
	@Test
	public void InvoicePWDDiscount() throws Exception {
		Terminal();
		Login();
		driver.findElement(By.xpath(POS)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(InvoicePage)).click();
		Thread.sleep(1000);
		InvoiceSteps();
	    Thread.sleep(500);
	    Tendered();
	    Thread.sleep(500);
	    PWDdiscount();
	    Discountdetails();
	    Thread.sleep(500);
	    Checkout();
		Thread.sleep(2000);
		String str = driver.findElement(By.cssSelector(Notification)).getText();
		//System.out.print(str);
		if (str.contains("Successfully"))

		{
			System.out.println("Invoice PWD Discount test = Passed!");
		} else {
			System.out.println("Invoice PWD Discount test = Failed!");
		}
		
	}
	@Test
	public void InvoiceOtherDiscount() throws Exception {
		Terminal();
		Login();
		driver.findElement(By.xpath(POS)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(InvoicePage)).click();
		Thread.sleep(1000);
		InvoiceSteps();
	    Thread.sleep(500);
	    Tendered();
	    Thread.sleep(500);
	    Otherdiscount();
	    
	    Thread.sleep(500);
	    Checkout();
		Thread.sleep(2000);
		String str = driver.findElement(By.cssSelector(Notification)).getText();
		//System.out.print(str);
		if (str.contains("Successfully"))

		{
			System.out.println("Invoice Other Discount test = Passed!");
		} else {
			System.out.println("Invoice Other Discount test = Failed!");
		}
		
	}
	@Test
	public void InvoiceCredit() throws Exception {
		Terminal();
		Login();
		driver.findElement(By.xpath(POS)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(InvoicePage)).click();
		Thread.sleep(1000);
		InvoiceSteps();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(CreditBtn)).click();
	    Paymentdetails();
	    Thread.sleep(500);
	    SavePayment();
	    Thread.sleep(500);
	    CheckoutBTN = "//text()[.='CHECKOUT']/ancestor::button[1]";
	    
	    Checkout();
		Thread.sleep(2000);
		String str = driver.findElement(By.cssSelector(Notification)).getText();
		//System.out.print(str);
		if (str.contains("Successfully"))

		{
			System.out.println("Invoice Credit test = Passed!");
		} else {
			System.out.println("Invoice Credit test = Failed!");
		}
		
	}
	@Test
	public void InvoiceCreditMissingBank() throws Exception {
		Terminal();
		Login();
		driver.findElement(By.xpath(POS)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(InvoicePage)).click();
		Thread.sleep(1000);
		InvoiceSteps();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(CreditBtn)).click();
	    Paymentdetails();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(Bank)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    driver.findElement(By.xpath(Bank)).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(500);
	    SavePayment();
	    Thread.sleep(500);
	    
		if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Invoice Credit Missing Bank test = Failed!");
		} 
		else {
			System.out.println("Invoice Credit Missing Bank test = Passed!");
		}
		
	}
	@Test
	public void InvoiceCreditMissingCardNumber() throws Exception {
		Terminal();
		Login();
		driver.findElement(By.xpath(POS)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(InvoicePage)).click();
		Thread.sleep(1000);
		InvoiceSteps();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(CreditBtn)).click();
	    Paymentdetails();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(CardNUM)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    driver.findElement(By.xpath(CardNUM)).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(500);
	    SavePayment();
	    Thread.sleep(500);
	    
		if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Invoice Credit Card Number test = Failed!");
		} 
		else {
			System.out.println("Invoice Credit Card Number test = Passed!");
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
		driver.findElement(By.xpath(Userfield)).sendKeys(authRoleUser);
		driver.findElement(By.xpath(passField)).sendKeys(authRoleUserPassword);
		driver.findElement(By.xpath(Loginfield)).click();
		}	
	public void Checkout() {
		driver.findElement(By.xpath(CheckoutBTN)).click();
	}
	public void Tendered() {
		 driver.findElement(By.xpath(TenderedAmount)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		    driver.findElement(By.xpath(TenderedAmount)).sendKeys(Keys.BACK_SPACE);
		    driver.findElement(By.xpath(TenderedAmount)).sendKeys(RandomStringUtils.randomNumeric(3));
	}
	public void InvoiceSteps() throws Exception {
		driver.findElement(By.xpath(ItemLookup)).click();
		Thread.sleep(500);
	    driver.findElement(By.xpath(SelectItemField)).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(SaveItem)).click();
	}
	public void SRdiscount() throws Exception {
		 driver.findElement(By.xpath(SRPWDDISCOUNTBTN)).click(); 
		    Thread.sleep(500);
		    driver.findElement(By.xpath(SelectedSCDiscount)).click();
		    Thread.sleep(500);
		    driver.findElement(By.xpath(Applydiscount)).click();
	}
	public void Discountdetails() {
		driver.findElement(By.xpath(Name)).sendKeys(RandomStringUtils.randomAlphabetic(5));
	    driver.findElement(By.xpath(IDnumber)).sendKeys(RandomStringUtils.randomAlphabetic(5));
	}
	public void PWDdiscount() throws Exception {
		 driver.findElement(By.xpath(SRPWDDISCOUNTBTN)).click(); 
		    Thread.sleep(500);
		    driver.findElement(By.xpath(SelectedPWDDiscount)).click();
		    Thread.sleep(500);
		    driver.findElement(By.xpath(Applydiscount)).click();
	}
	public void Otherdiscount() throws Exception {
		 driver.findElement(By.xpath(SRPWDDISCOUNTBTN)).click(); 
		    Thread.sleep(500);
		    driver.findElement(By.xpath("//div[4]/div/div[2]")).click();
		    Thread.sleep(500);
		    driver.findElement(By.xpath(Applydiscount)).click();
	}
	public void Paymentdetails() throws Exception {
		driver.findElement(By.xpath(Bank)).sendKeys(RandomStringUtils.randomAlphabetic(3));
	    Thread.sleep(500);
	    driver.findElement(By.xpath(CardNUM)).sendKeys(RandomStringUtils.randomNumeric(5));
	    Thread.sleep(500);
	    driver.findElement(By.xpath(Owner)).sendKeys(RandomStringUtils.randomAlphabetic(6));
	    Thread.sleep(500);
	    driver.findElement(By.xpath(TransactionCode)).sendKeys(RandomStringUtils.randomNumeric(8));
	    Thread.sleep(500);
	    driver.findElement(By.xpath(Amount)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    driver.findElement(By.xpath(Amount)).sendKeys(Keys.BACK_SPACE);
	    driver.findElement(By.xpath(Amount)).sendKeys(RandomStringUtils.randomNumeric(3));
	    
	    
	}
	public void SavePayment() {
		driver.findElement(By.xpath(Save)).click();
	}
}








	