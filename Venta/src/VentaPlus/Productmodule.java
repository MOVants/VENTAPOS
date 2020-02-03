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

public class Productmodule extends StringVal {
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
	public void CreateProduct() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(500);
	    driver.findElement(By.xpath(ProductModule)).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(ADDnewProductBTN)).click();
	    Thread.sleep(1000);
	    ProductDetails();
	   // driver.findElement(By.xpath(ProductITemcode)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		//driver.findElement(By.xpath(ProductITemcode)).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(1000);
	    ADDItems();
	    Thread.sleep(1000);
	    SaveProduct();
	    Thread.sleep(1000);
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Create Product  test = Passed!");
		} 
		else {
			System.out.println("Create Product  test = Failed!");
		}
	}
	@Test
	public void CreateProductMissingITemcode() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(500);
	    driver.findElement(By.xpath(ProductModule)).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(ADDnewProductBTN)).click();
	    Thread.sleep(1000);
	    ProductDetails();
	    driver.findElement(By.xpath(ProductITemcode)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(ProductITemcode)).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(1000);
	    ADDItems();
	    Thread.sleep(1000);
	    SaveProduct();
	    Thread.sleep(1000);
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Create Product Missing Item Codetest = Failed!");
		} 
		else {
			System.out.println("Create Product Missing Item Codetest = Passed!");
		}
	}
	@Test
	public void CreateProductMissingBarcode() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(500);
	    driver.findElement(By.xpath(ProductModule)).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(ADDnewProductBTN)).click();
	    Thread.sleep(1000);
	    ProductDetails();
	    driver.findElement(By.xpath(ProductBarcode)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(ProductBarcode)).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(1000);
	    ADDItems();
	    Thread.sleep(1000);
	    SaveProduct();
	    Thread.sleep(1000);
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Create Product Missing Barcode test = Failed!");
		} 
		else {
			System.out.println("Create Product Missing Barcode test = Passed!");
		}
	}
	@Test
	public void CreateProductMissingDescription() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(500);
	    driver.findElement(By.xpath(ProductModule)).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(ADDnewProductBTN)).click();
	    Thread.sleep(1000);
	    ProductDetails();
	    driver.findElement(By.xpath(Productdescription)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(Productdescription)).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(1000);
	    ADDItems();
	    Thread.sleep(1000);
	    SaveProduct();
	    Thread.sleep(1000);
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Create Product Missing Description test = Failed!");
		} 
		else {
			System.out.println("Create Product Missing Description test = Passed!");
		}
	}
	
	@Test
	public void CreateProductMissingPrice() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(500);
	    driver.findElement(By.xpath(ProductModule)).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(ADDnewProductBTN)).click();
	    Thread.sleep(1000);
	    ProductDetails();
	    driver.findElement(By.xpath(ProductOriginalPrice)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(ProductOriginalPrice)).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(1000);
	    ADDItems();
	    Thread.sleep(1000);
	    SaveProduct();
	    Thread.sleep(1000);
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Create Product Missing Price test = Failed!");
		} 
		else {
			System.out.println("Create Product Missing Price test = Passed!");
		}
	}
	@Test
	public void CreateProductNOAddedITems() throws Exception {
		int w=1;
		Terminal();
		Login();
		Thread.sleep(1000);
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(500);
	    driver.findElement(By.xpath(ProductModule)).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(ADDnewProductBTN)).click();
	    Thread.sleep(1000);
	    ProductDetails();
	    Thread.sleep(1000);
	    if (w==1) {
	    	SaveProductBTN="(//button[@type='button'])[6]";
	    }
	    SaveProduct();
	    Thread.sleep(1000);
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Create Product No Added Items test = Failed!");
		} 
		else {
			System.out.println("Create Product No Added Items test = Passed!");
		}
	}
	@Test
	public void MOdifyProductITemcode() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(500);
	    driver.findElement(By.xpath(ProductModule)).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[2]/table/tbody/tr/td[6]/button/div[2]/i")).click();
	    Thread.sleep(1000);
	   
	    driver.findElement(By.xpath(ProductITemcode)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(ProductITemcode)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(ProductITemcode)).sendKeys(RandomStringUtils.randomAlphanumeric(5));
	    Thread.sleep(1000);
	    SaveProduct();
	    Thread.sleep(1000);
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Modify Product Item Code test = Passed!");
		} 
		else {
			System.out.println("Modify Product Item Code test = Failed!");
		}
	}
	@Test
	public void MOdifyProductBarcode() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(500);
	    driver.findElement(By.xpath(ProductModule)).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[2]/table/tbody/tr/td[6]/button/div[2]/i")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(ProductBarcode)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(ProductBarcode)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(ProductBarcode)).sendKeys(RandomStringUtils.randomAlphanumeric(5));
	    Thread.sleep(1000);
	    SaveProduct();
	    Thread.sleep(1000);
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Modify Product BarCode test = Passed!");
		} 
		else {
			System.out.println("Modify Product BarCode test = Failed!");
		}
	}
	@Test
	public void MOdifyProductDescription() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(500);
	    driver.findElement(By.xpath(ProductModule)).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[2]/table/tbody/tr/td[6]/button/div[2]/i")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(Productdescription)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(Productdescription)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(Productdescription)).sendKeys(RandomStringUtils.randomAlphanumeric(5));
	    Thread.sleep(1000);
	    SaveProduct();
	    Thread.sleep(1000);
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Modify Product Description test = Passed!");
		} 
		else {
			System.out.println("Modify Product Description test = Failed!");
		}
	}
	@Test
	public void MOdifyProductPrice() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		driver.findElement(By.xpath(POsMOdule)).click();
		Thread.sleep(500);
	    driver.findElement(By.xpath(ProductModule)).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[2]/table/tbody/tr/td[6]/button/div[2]/i")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(ProductOriginalPrice)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(ProductOriginalPrice)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(ProductOriginalPrice)).sendKeys(RandomStringUtils.randomAlphanumeric(5));
	    Thread.sleep(1000);
	    SaveProduct();
	    Thread.sleep(1000);
	    if (driver.getPageSource().contains("Successful"))

		{
			System.out.println("Modify Product Price test = Passed!");
		} 
		else {
			System.out.println("Modify Product Price test = Failed!");
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
	public void ProductDetails() throws Exception {
		driver.findElement(By.xpath(Deletelocation)).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(SelectLocation)).click();
	    driver.findElement(By.xpath(SelectLocation)).sendKeys(Keys.ARROW_DOWN);
	    driver.findElement(By.xpath(SelectLocation)).sendKeys(Keys.ENTER);
	    driver.findElement(By.xpath(SelectLocation)).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(ProductITemcode)).sendKeys(RandomStringUtils.randomAlphanumeric(5));
	    driver.findElement(By.xpath(ProductBarcode)).sendKeys(RandomStringUtils.randomAlphanumeric(5));
	    driver.findElement(By.xpath(Productdescription)).sendKeys(RandomStringUtils.randomAlphanumeric(5));
	    driver.findElement(By.xpath(ProductOriginalPrice)).sendKeys(RandomStringUtils.randomNumeric(2));
	    driver.findElement(By.xpath(VatToggle)).click();
	}
	public void ADDItems() throws Exception {
		 driver.findElement(By.xpath(AddITemBtn)).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath(SelectItem )).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath(SaveSelectedItem)).click();
	}
	public void SaveProduct() {
		driver.findElement(By.xpath(SaveProductBTN)).click();
	}
}
