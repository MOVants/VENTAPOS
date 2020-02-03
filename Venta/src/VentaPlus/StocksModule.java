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

public class StocksModule extends StringVal {
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
	public void StockIn() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(500);
		StocksBTN();
		Thread.sleep(1000);
		ItemandLocationSelection();
		String Value = (driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[3]/div[2]/div[2]/div[2]")).getText());  
		//System.out.print(Value);
		StockINBTN();
		StockinDetails();
		AddSupplier();
        STOCKINSAVE();
        Thread.sleep(500);
        String Value2 = (driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[3]/div[2]/div[2]/div[2]")).getText());
    	if (Value!=Value2) 

		{
			System.out.println("Stock in test = Passed!");
		} 
		else {
			System.out.println("Stock in test = Failed!");
		}
		
	}
	@Test
	public void StockInMissingQTY() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(500);
		StocksBTN();
		Thread.sleep(1000);
		ItemandLocationSelection();
		StockINBTN();
		StockinDetails();
		driver.findElement(By.xpath(StocksQTY)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(StocksQTY)).sendKeys(Keys.BACK_SPACE);
		AddSupplier();
        STOCKINSAVE();
        Thread.sleep(500);
    	
		if (driver.getPageSource().contains("Successfully"))

		{
			System.out.println("Stock in Missing QTY test = Failed!");
		} 
		else {
			System.out.println("Stock in Missing QTY test = Passed!");
		}
		
	}
	@Test
	public void StockInMissingCost() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(500);
		StocksBTN();
		Thread.sleep(1000);
		ItemandLocationSelection();
		StockINBTN();
		StockinDetails();
		driver.findElement(By.xpath(StockCost)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(StockCost)).sendKeys(Keys.BACK_SPACE);
		AddSupplier();
        STOCKINSAVE();
        Thread.sleep(500);
    	
		if (driver.getPageSource().contains("Successfully"))

		{
			System.out.println("Stock in Missing COST test = Failed!");
		} 
		else {
			System.out.println("Stock in Missing COST test = Passed!");
		}
		
	}
	@Test
	public void StockInMissingSUPPLIER() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(500);
		StocksBTN();
		Thread.sleep(1000);
		ItemandLocationSelection();
		StockINBTN();
		StockinDetails();
        STOCKINSAVE();
        Thread.sleep(500);
    	
		if (driver.getPageSource().contains("Successfully"))

		{
			System.out.println("Stock in Missing SUPPLIER test = Failed!");
		} 
		else {
			System.out.println("Stock in Missing SUPPLIER test = Passed!");
		}
		
	}
	@Test
	public void StockInMissingDRNUmber() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(500);
		StocksBTN();
		Thread.sleep(1000);
		ItemandLocationSelection();
		StockINBTN();
		StockinDetails();
		driver.findElement(By.xpath(DRnumber)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(DRnumber)).sendKeys(Keys.BACK_SPACE);
		AddSupplier();
        STOCKINSAVE();
        Thread.sleep(500);
    	
		if (driver.getPageSource().contains("Successfully"))

		{
			System.out.println("Stock in Missing DR Number test = Failed!");
		} 
		else {
			System.out.println("Stock in Missing DR Number test = Passed!");
		}
		
	}
	@Test
	public void StockInMissingBatchNumber() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(500);
		StocksBTN();
		Thread.sleep(1000);
		ItemandLocationSelection();
		String Value = (driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[3]/div[2]/div[2]/div[2]")).getText());
		StockINBTN();
		StockinDetails();
		driver.findElement(By.xpath(BatchNUmber)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(BatchNUmber)).sendKeys(Keys.BACK_SPACE);
		AddSupplier();
        STOCKINSAVE();
        Thread.sleep(500);
        String Value2 = (driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[3]/div[2]/div[2]/div[2]")).getText()); 
        if (Value!=Value2) 


		{
			System.out.println("Stock in Missing Batch Number test = Passed!");
		} 
		else {
			System.out.println("Stock in Missing Batch Number test = Failed!");
		}
		
	}
	@Test
	public void StockOUT() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(500);
		StocksBTN();
		Thread.sleep(1000);
		ItemandLocationSelection();
		String Value = (driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[3]/div[2]/div[2]/div[2]")).getText());
		Thread.sleep(1000);
		StockOUtField();
		Thread.sleep(500);
		StockoutItemField();
		Thread.sleep(500);
		StockOUtBaseUNIT();
		Thread.sleep(500);
		StockOUTdetails();
	    Thread.sleep(1000);
	    STOCKOUTBTN();
	    Thread.sleep(2000);
	    String Value2 = (driver.findElement(By.xpath("//div[@id='q-app']/div/div/main/div/div/div/div[3]/div[2]/div[2]/div[2]")).getText());
	    if (Value!=Value2) 

		{
			System.out.println("Stock OUT test = Passed!");
		} 
		else {
			System.out.println("Stock OUT test = Failed!");
		}
	}
	@Test
	public void StockOUTmissingBaseUnit() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(500);
		StocksBTN();
		Thread.sleep(1000);
		ItemandLocationSelection();
		Thread.sleep(1000);
		StockOUtField();
		Thread.sleep(500);
		StockoutItemField();
		Thread.sleep(500);
		StockOUTdetails();
	    Thread.sleep(1000);
	    STOCKOUTBTN();
	    Thread.sleep(2000);
		if (driver.getPageSource().contains("successful"))

		{
			System.out.println("Stock OUT Missing Base Unit test = Failed!");
		} 
		else {
			System.out.println("Stock OUT Missing Base Unit test = Passed!");
		}
	}
	@Test
	public void StockOUTmissingQTY() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(500);
		StocksBTN();
		Thread.sleep(1000);
		ItemandLocationSelection();
		Thread.sleep(1000);
		StockOUtField();
		Thread.sleep(500);
		StockoutItemField();
		Thread.sleep(500);
		StockOUtBaseUNIT();
		Thread.sleep(500);
		StockOUTdetails();
		driver.findElement(By.xpath(StockoutQTY)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(StockoutQTY)).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(1000);
	    STOCKOUTBTN();
	    Thread.sleep(2000);
		if (driver.getPageSource().contains("successful"))

		{
			System.out.println("Stock OUT Missing Quantity test = Failed!");
		} 
		else {
			System.out.println("Stock OUT Missing Quantity test = Passed!");
		}
	}
	@Test
	public void StockOUTmissingReason() throws Exception {
		Terminal();
		Login();
		Thread.sleep(1000);
		InventoryModule();
		Thread.sleep(500);
		StocksBTN();
		Thread.sleep(1000);
		ItemandLocationSelection();
		Thread.sleep(1000);
		StockOUtField();
		Thread.sleep(500);
		StockoutItemField();
		Thread.sleep(500);
		StockOUtBaseUNIT();
		Thread.sleep(500);
		StockOUTdetails();
		driver.findElement(By.xpath(StockoutReason)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath(StockoutReason)).sendKeys(Keys.BACK_SPACE);
	    Thread.sleep(1000);
	    STOCKOUTBTN();
	    Thread.sleep(2000);
		if (driver.getPageSource().contains("successful"))

		{
			System.out.println("Stock OUT Missing Base Unit test = Failed!");
		} 
		else {
			System.out.println("Stock OUT Missing Base Unit test = Passed!");
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
	public void StocksBTN() {
		driver.findElement(By.xpath(StocksBtn)).click();
	}
	public void StockINBTN() {
		driver.findElement(By.xpath(StockINBTN)).click();
	}
	public void STOCKINSAVE(){
		driver.findElement(By.xpath(STOCKIN)).click();
	}
	public void StockinDetails() throws Exception {
		Thread.sleep(500);
        driver.findElement(By.xpath(StocksQTY)).sendKeys(RandomStringUtils.randomNumeric(1));
        driver.findElement(By.xpath(StocksUnit)).click();
    	for (int z=0; z<=1; z++) {
    		driver.findElement(By.xpath(StocksUnit)).sendKeys(Keys.ARROW_DOWN);
    	if (z==1){
    		driver.findElement(By.xpath(StocksUnit)).sendKeys(Keys.ENTER);
    		}
    	Thread.sleep(500);
    	}
    	driver.findElement(By.xpath(StockCost)).sendKeys(RandomStringUtils.randomNumeric(2));
    	Thread.sleep(500);    	    
        driver.findElement(By.xpath(DRnumber)).sendKeys(RandomStringUtils.randomNumeric(12));
        driver.findElement(By.xpath(BatchNUmber)).sendKeys(RandomStringUtils.randomNumeric(2));
	}
	public void ItemandLocationSelection() throws InterruptedException {
	driver.findElement(By.xpath(StocksItemCode)).click();
	for (int x=1; x<=3; x++) {
		driver.findElement(By.xpath(StocksItemCode)).sendKeys(Keys.ARROW_DOWN);
	if (x==3){
		driver.findElement(By.xpath(StocksItemCode)).sendKeys(Keys.ENTER);
		}
   	Thread.sleep(500);
	}
	   driver.findElement(By.xpath(StocksLocation)).click();
	for (int y=1; y<=3; y++) {
		driver.findElement(By.xpath(StocksLocation)).sendKeys(Keys.ARROW_DOWN);
	if (y==3){
		driver.findElement(By.xpath(StocksLocation)).sendKeys(Keys.ENTER);
		}
   	}
	}
	public void AddSupplier() throws Exception {
		driver.findElement(By.xpath(SupplierBTN)).click();
    	Thread.sleep(500);
		driver.findElement(By.xpath(SelectSUPP)).click();
        for (int v=0; v<=1; v++) {
    		driver.findElement(By.xpath(SelectSUPP)).sendKeys(Keys.ARROW_DOWN);
    	if (v==1){
    		driver.findElement(By.xpath(SelectSUPP)).sendKeys(Keys.ENTER);
    		driver.findElement(By.xpath(SelectSUPP)).click();
    		}
    	Thread.sleep(500);
    	}
        driver.findElement(By.xpath(SaveSelectedSupp)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(Applysupp)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(Applysupp)).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        driver.findElement(By.xpath(Applysupp)).sendKeys(Keys.ENTER);
	}
	public void STOCKOUTBTN() {
		driver.findElement(By.xpath(StockoutSaveBTN)).click();
	}
	public void StockOUtField() {
		driver.findElement(By.xpath(StockoutBTN)).click();
	}
	public void StockoutItemField() {
		driver.findElement(By.xpath(Stockout)).click();
	}
	public void StockOUtBaseUNIT() throws Exception {
		driver.findElement(By.xpath(StockoutBaseUnit)).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(StockoutBaseUnit)).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(500);
		driver.findElement(By.xpath(StockoutBaseUnit)).sendKeys(Keys.ENTER);
	}
	public void StockOUTdetails() {
		driver.findElement(By.xpath(StockoutQTY)).sendKeys(RandomStringUtils.randomNumeric(2));
	    driver.findElement(By.xpath(StockoutReason)).sendKeys(RandomStringUtils.randomAlphabetic(5));
	}
} 

