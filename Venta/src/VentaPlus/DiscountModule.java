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

	public class DiscountModule extends StringVal {
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
		public void CreateDiscount() throws Exception {
			Terminal();
			Login();
			driver.findElement(By.xpath(POsMOdule)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(DiscountPage)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(ADDDiscountBTN)).click();
			Thread.sleep(1000);
			DiscountDetails();
		    Thread.sleep(1000);
		    DiscountSaveBTN();
		    Thread.sleep(1000); 
		    if (driver.getPageSource().contains("Successful"))

			{
				System.out.println("Create Discount  test = Passed!");
			} 
			else {
				System.out.println("Create Discount  test = Failed!");
			}
}
	
	@Test
	public void CreateDiscountMissingName() throws Exception {
		Terminal();
		Login();
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(DiscountPage)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(ADDDiscountBTN)).click();
		Thread.sleep(1000);
		DiscountDetails();
		driver.findElement(By.xpath(SRPWDdiscountName)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(SRPWDdiscountName)).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(1000);
	    DiscountSaveBTN();
	    Thread.sleep(1000); 
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Create Discount Missing Name  test = Failed!");
		} 
		else {
			System.out.println("Create Discount Missing Name test = Passed!");
		}
}
	
	@Test
	public void CreateDiscountMissingValue() throws Exception {
		Terminal();
		Login();
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(DiscountPage)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(ADDDiscountBTN)).click();
		Thread.sleep(1000);
		DiscountDetails();
		driver.findElement(By.xpath(SRPWDdiscountValue)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(SRPWDdiscountValue)).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(1000);
	    DiscountSaveBTN();
	    Thread.sleep(1000); 
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Create Discount Missing Value  test = Failed!");
		} 
		else {
			System.out.println("Create Discount Missing Value test = Passed!");
		}
}
	@Test
	public void CreateOtherDiscount() throws Exception {
		Terminal();
		Login();
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(DiscountPage)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OtherDiscount)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AddOtherDiscount)).click();
		Thread.sleep(1000);
		DiscountDetails();
	    Thread.sleep(1000);
	    DiscountSaveBTN();
	    Thread.sleep(1000); 
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Create Discount  test = Passed!");
		} 
		else {
			System.out.println("Create Discount  test = Failed!");
		}
}
	@Test
	public void CreateOtherDiscountmissingname() throws Exception {
		Terminal();
		Login();
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(DiscountPage)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OtherDiscount)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AddOtherDiscount)).click();
		Thread.sleep(1000);
		DiscountDetails();
		driver.findElement(By.xpath(SRPWDdiscountName)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(SRPWDdiscountName)).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(1000);
	    DiscountSaveBTN();
	    Thread.sleep(1000); 
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Create Discount Missing Name test = Failed!");
		} 
		else {
			System.out.println("Create Discount Missing Name test = Passed!");
		}
}
	@Test
	public void CreateOtherDiscountmissingValue() throws Exception {
		Terminal();
		Login();
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(DiscountPage)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OtherDiscount)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(AddOtherDiscount)).click();
		Thread.sleep(1000);
		DiscountDetails();
		driver.findElement(By.xpath(SRPWDdiscountValue)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(SRPWDdiscountValue)).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(1000);
	    DiscountSaveBTN();
	    Thread.sleep(1000); 
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Create Discount Missing Value test = Failed!");
		} 
		else {
			System.out.println("Create Discount Missing Value test = Passed!");
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
		public void DiscountDetails() throws Exception {
			
		    driver.findElement(By.xpath(SRPWDdiscountName)).sendKeys(RandomStringUtils.randomAlphanumeric(5));
		    Thread.sleep(1000);
		    driver.findElement(By.xpath(SRPWDdiscountValue)).sendKeys(RandomStringUtils.randomNumeric(2));
		}
		public void DiscountSaveBTN() {
		    driver.findElement(By.xpath(SaveDISCOUNTBTN)).click();

		}
	}
