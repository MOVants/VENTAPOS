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

public class ItemModule extends StringVal {
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
	public void CreateItem() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(1000);
		Itemsmodule();
		Thread.sleep(1000);
		AddItemBtn();
		Thread.sleep(1000);
		Itemdetails();
		MinimumStocks();
		Thread.sleep(1000);
		MinimumStocksSaveBtn();
		Thread.sleep(1000);
		AdditemCon();
		Thread.sleep(1000);
		SaveItemBtn();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Create Item test = Passed!");
		} else {
			System.out.println("Create Item test = Failed!");
		}
	}
	
	@Test
	public void CreateItemmissingDescription() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(1000);
		Itemsmodule();
		Thread.sleep(1000);
		AddItemBtn();
		Thread.sleep(1000);
		Itemdetails();
		driver.findElement(By.xpath(Description)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(Description)).sendKeys(Keys.BACK_SPACE);
		MinimumStocks();
		Thread.sleep(1000);
		MinimumStocksSaveBtn();
		Thread.sleep(1000);
		AdditemCon();
		Thread.sleep(1000);
		SaveItemBtn();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Create Item Missing Description test = Failed!");
		} else {
			System.out.println("Create Item Missing Description test = Passed!");
		}
	}
	@Test
	public void CreateItemmissingBarcode() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(1000);
		Itemsmodule();
		Thread.sleep(1000);
		AddItemBtn();
		Thread.sleep(1000);
		Itemdetails();
		driver.findElement(By.xpath(Barcode)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(Barcode)).sendKeys(Keys.BACK_SPACE);
		MinimumStocks();
		Thread.sleep(1000);
		MinimumStocksSaveBtn();
		Thread.sleep(1000);
		AdditemCon();
		Thread.sleep(1000);
		SaveItemBtn();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))
	
		{
			System.out.println("Create Item Missing Barcode test = Failed!");
		} else {
			System.out.println("Create Item Missing Barcode test = Passed!");
		}
	}
	
	@Test
	public void CreateItemmissingItemcode() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(1000);
		Itemsmodule();
		Thread.sleep(1000);
		AddItemBtn();
		Thread.sleep(1000);
		Itemdetails();
		driver.findElement(By.xpath(Itemcode)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(Itemcode)).sendKeys(Keys.BACK_SPACE);
		MinimumStocks();
		Thread.sleep(1000);
		MinimumStocksSaveBtn();
		Thread.sleep(1000);
		AdditemCon();
		Thread.sleep(1000);
		SaveItemBtn();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Create Item Missing Itemcode test = Failed!");
		} else {
			System.out.println("Create Item Missing Itemcode test = Passed!");
		}
	}
	
	@Test
	public void CreateItemmissingBaseUnit() throws Exception {
		int x=1;
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(1000);
		Itemsmodule();
		Thread.sleep(1000);
		AddItemBtn();
		Thread.sleep(1000);
		Itemdetails();
		driver.findElement(By.xpath(Baseunit)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(Baseunit)).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		if (x==1) {
			ItemSaveBTN="(//button[@type='button'])[6]";	
		}
		SaveItemBtn();
		Thread.sleep(1000);
		x=0;
		String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Create Item Missing BaseUnit test = Failed!");
		} else {
			System.out.println("Create Item Missing BaseUnit test = Passed!");
		}
		
	}
	
	@Test
	public void CreateItemmissingMinimumStock() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(1000);
		Itemsmodule();
		Thread.sleep(1000);
		AddItemBtn();
		Thread.sleep(1000);
		Itemdetails();
		Thread.sleep(1000);
		AdditemCon();
		Thread.sleep(1000);
		SaveItemBtn();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Create Item Missing Minimum Stock test = Passed!");
		} else {
			System.out.println("Create Item Missing MinimumStock test = Failed!");
		}
	}
	
	@Test
	public void CreateItemmissingItemCon() throws Exception {
		int y=1;
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(1000);
		Itemsmodule();
		Thread.sleep(1000);
		AddItemBtn();
		Thread.sleep(1000);
		Itemdetails();
		Thread.sleep(1000);
		MinimumStocks();
		Thread.sleep(1000);
		MinimumStocksSaveBtn();
		if (y==1) {
			ItemSaveBTN="(//button[@type='button'])[6]";	
		}
		Thread.sleep(1000);
		SaveItemBtn();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Create Item Missing Item Conversion test = Passed!");
		} else {
			System.out.println("Create Item Missing Item Conversion test = Failed!");
		}
	}
	@Test
	public void ModifyItemDescription() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(1000);
		Itemsmodule();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[2]/table/tbody/tr/td[5]/button/div[2]/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Description)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(Description)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(Description)).sendKeys(RandomStringUtils.randomAlphabetic(5));
		SaveItemBtn();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Modify Item Description test = Passed!");
		} else {
			System.out.println("Modify Item Description test = Failed!");
		}
	}
	@Test
	public void ModifyItemBarcode() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(1000);
		Itemsmodule();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[2]/table/tbody/tr/td[5]/button/div[2]/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Barcode)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(Barcode)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(Barcode)).sendKeys(RandomStringUtils.randomAlphabetic(5));
		SaveItemBtn();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Modify Item Barcode test = Passed!");
		} else {
			System.out.println("Modify Item Barcode test = Failed!");
		}
	}
	@Test
	public void ModifyItemcode() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(1000);
		Itemsmodule();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[2]/table/tbody/tr/td[5]/button/div[2]/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Itemcode)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(Itemcode)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(Itemcode)).sendKeys(RandomStringUtils.randomAlphabetic(5));
		SaveItemBtn();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Modify Item Code test = Passed!");
		} else {
			System.out.println("Modify Item Code test = Failed!");
		}
	}
	@Test
	public void ModifyItemExpiry() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(1000);
		Itemsmodule();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[2]/table/tbody/tr/td[5]/button/div[2]/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(NumExpiry)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(NumExpiry)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath(NumExpiry)).sendKeys(RandomStringUtils.randomNumeric(2));
		SaveItemBtn();
		Thread.sleep(1000);
		String str = driver.findElement(By.xpath(Notif)).getText();
		if (str.contains("Successfully"))

		{
			System.out.println("Modify Item Expiry test = Passed!");
		} else {
			System.out.println("Modify Item Expiry test = Failed!");
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
	
    public void Itemsmodule() {
    	driver.findElement(By.xpath(Itemsmodule)).click();
    }
    public void AddItemBtn() {
    	driver.findElement(By.xpath(AddItemBTN)).click();
    }
    public void Itemdetails() throws Exception {
    	driver.findElement(By.xpath(ItemCategory)).click();
    	for (int x=1; x<=3; x++) {
    		driver.findElement(By.xpath(ItemCategory)).sendKeys(Keys.ARROW_DOWN);
    	if (x==3){
    		driver.findElement(By.xpath(ItemCategory)).sendKeys(Keys.ENTER);	
    	}
    	Thread.sleep(500);
    	}
    	driver.findElement(By.xpath(Description)).sendKeys(RandomStringUtils.randomAlphanumeric(6));
        driver.findElement(By.xpath(Itemcode)).sendKeys(RandomStringUtils.randomAlphanumeric(6));
        driver.findElement(By.xpath(Barcode)).sendKeys(RandomStringUtils.randomAlphanumeric(6));
        driver.findElement(By.xpath(NumExpiry)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.xpath(NumExpiry)).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath(NumExpiry)).sendKeys(RandomStringUtils.randomNumeric(2));
        driver.findElement(By.xpath(Baseunit)).sendKeys(RandomStringUtils.randomAlphabetic(3));
            
    }
    public void MinimumStocks() throws Exception {
    	driver.findElement(By.xpath(MinimumStock)).click();
        driver.findElement(By.xpath(Quantity)).sendKeys(RandomStringUtils.randomNumeric(2));
        driver.findElement(By.xpath(MinimumStockBaseUnit)).click();
        driver.findElement(By.xpath(MinimumStockBaseUnit)).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath(MinimumStockBaseUnit)).sendKeys(Keys.ENTER);
         }
    public void MinimumStocksSaveBtn() {
    	driver.findElement(By.xpath(MinimumStockSave)).click();
    }
    public void SaveItemBtn() {
    	driver.findElement(By.xpath(ItemSaveBTN)).click();
    }
    public void AdditemCon() throws Exception {
    	Thread.sleep(1000);
		driver.findElement(By.xpath(AddItemCOnBTN)).click();
	    driver.findElement(By.xpath(ItemConUnit)).sendKeys(RandomStringUtils.randomAlphabetic(3));
	    driver.findElement(By.xpath(ItemConValue)).sendKeys(RandomStringUtils.randomNumeric(3));
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(ItemConSaveBTn)).click();
	}
}
	
	
	
	
	
	