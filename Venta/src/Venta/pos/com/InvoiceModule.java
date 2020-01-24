package Venta.pos.com;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvoiceModule extends StringValues {
	static WebDriver driver;
	static String browser;

	public void setBrowser() {
		browser = "Chrome";
	}
	public void browserConfig () {

		if (browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver","/home/christopher/eclipse-workspace/Selinium/LIBRARY/chromeDriver/chromedriver"); 
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
	public void Invoice() throws Exception {
		toAdmLogin();
		InvoiceModulebtn();
		InvoiceSteps();
		tenderedAmount();
		Thread.sleep(2000);
		Checkout();
		Thread.sleep(1000);
		String str = driver.findElement(By.cssSelector(Notif)).getText();
		//System.out.print(str);
		int x=1;
		int y=0;
		String[] result=new String[12];
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=29; i<=40; i++) {
		
		result[y]=Character.toString(str.charAt(i+x));
		stringBuilder.append(result[y]);
		
		}
		//System.out.println(stringBuilder);
		Thread.sleep(5000);
		toReport();
		
		Thread.sleep(1000);
		if (driver.getPageSource().contains(stringBuilder)){
			
			System.out.println("Invoice Test = Passed!");
		} else {
			System.out.println("Invoice  Test = Failed!");
		}
	}

	@Test
	public void InvoiceSrDiscount() throws Exception {
		toAdmLogin();
		InvoiceModulebtn();
		InvoiceSteps();
		tenderedAmount();
		toSRDiscount();
		Srdetails();
		Thread.sleep(3000);
		Checkout();
		Thread.sleep(1000);
		String str = driver.findElement(By.cssSelector(Notif)).getText();
		//System.out.print(str);
		int x=1;
		int y=0;
		String[] result=new String[12];
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=29; i<=40; i++) {
		
		result[y]=Character.toString(str.charAt(i+x));
		stringBuilder.append(result[y]);
		
		}
		//System.out.println(stringBuilder);
		Thread.sleep(5000);
		toReport();
		
		Thread.sleep(1000);
		if (driver.getPageSource().contains(stringBuilder)){
			
			System.out.println("Invoice SrDiscount Test = Passed!");
		} else {
			System.out.println("Invoice SrDiscount Test = Failed!");
		}
				
	}
		@Test
		public void InvoicePWDDiscount() throws Exception {
			toAdmLogin();
			InvoiceModulebtn();
			InvoiceSteps();
			tenderedAmount();
			toPwddiscount();
			Srdetails();
			Thread.sleep(3000);
			/*driver.findElement(By.xpath(Bank)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(2000);
			driver.findElement(By.xpath(Bank)).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/input[1]")).sendKeys(RandomStringUtils.randomNumeric(3));
			Thread.sleep(2000);*/
			//driver.findElement(By.xpath("//text()[.='CHECKOUT']/ancestor::button[1]")).click();
			Checkout();
			Thread.sleep(3000);
			String str = driver.findElement(By.cssSelector(Notif)).getText();
			//System.out.print(str);
			int x=1;
			int y=0;
			String[] result=new String[12];
			StringBuilder stringBuilder = new StringBuilder();
			for(int i=29; i<=40; i++) {
			
			result[y]=Character.toString(str.charAt(i+x));
			stringBuilder.append(result[y]);
			
			}
			//System.out.println(stringBuilder);
			Thread.sleep(5000);
			toReport();
			
			Thread.sleep(1000);
			if (driver.getPageSource().contains(stringBuilder)){
				
				System.out.println("Invoice PWDDiscount Test = Passed!");
			} else {
				System.out.println("Invoice PWDDiscount Test = Failed!");
			}
		}
			@Test
			public void InvoiceOtherDiscount() throws Exception {
				toAdmLogin();
				InvoiceModulebtn();
				InvoiceSteps();
				tenderedAmount();
				toOtherdiscount();
				Thread.sleep(3000);
				Checkout();
				Thread.sleep(1000);
				String str = driver.findElement(By.cssSelector(Notif)).getText();
				//System.out.print(str);
				int x=1;
				int y=0;
				String[] result=new String[12];
				StringBuilder stringBuilder = new StringBuilder();
				for(int i=29; i<=40; i++) {
				
				result[y]=Character.toString(str.charAt(i+x));
				stringBuilder.append(result[y]);
				
				}
				//System.out.println(stringBuilder);
				Thread.sleep(5000);
				toReport();
				
				Thread.sleep(1000);
				if (driver.getPageSource().contains(stringBuilder)){
					
					System.out.println("Invoice SrDiscount Test = Passed!");
				} else {
					System.out.println("Invoice SrDiscount Test = Failed!");
				}	
			}
		
			@Test
			public void InvoiceCredit() throws Exception {
				toAdmLogin();
				InvoiceModulebtn();
				InvoiceSteps();
				CreditBtn();
				Paymentinfo();
				Creditamount();
				Thread.sleep(1000);
				AddpaymentBtn();
				Thread.sleep(2000);
				Checkout();
				Thread.sleep(1000);
				String str = driver.findElement(By.cssSelector(Notif)).getText();
				//System.out.print(str);
				int x=1;
				int y=0;
				String[] result=new String[12];
				StringBuilder stringBuilder = new StringBuilder();
				for(int i=29; i<=40; i++) {

					result[y]=Character.toString(str.charAt(i+x));
					stringBuilder.append(result[y]);

				}
				//System.out.println(stringBuilder);
				Thread.sleep(5000);
				toReport();

				Thread.sleep(1000);
				if (driver.getPageSource().contains(stringBuilder)){

					System.out.println("Invoice Credit Test = Passed!");
				} else {
					System.out.println("Invoice Credit Test = Failed!");
				}

			}
@Test
public void Invoicedebit() throws Exception {
toAdmLogin();
InvoiceModulebtn();
InvoiceSteps();
DebitBtn();
Paymentinfo();
DebitandCheckamount();
AddpaymentBtn();
Thread.sleep(2000);
Checkout();
Thread.sleep(1000);
String str = driver.findElement(By.cssSelector(Notif)).getText();
//System.out.print(str);
int x=1;
int y=0;
String[] result=new String[12];
StringBuilder stringBuilder = new StringBuilder();
for(int i=29; i<=40; i++) {

result[y]=Character.toString(str.charAt(i+x));
stringBuilder.append(result[y]);

}
//System.out.println(stringBuilder);
Thread.sleep(5000);
toReport();

Thread.sleep(1000);
if (driver.getPageSource().contains(stringBuilder)){

System.out.println("Invoice DEBIT Test = Passed!");
} else {
System.out.println("Invoice DEBIT Test = Failed!");
}
}

@Test
public void Invoicecheck() throws Exception {
toAdmLogin();
InvoiceModulebtn();
InvoiceSteps();
CheckBtn();
Paymentinfo();
DebitandCheckamount();
AddpaymentBtn();
Thread.sleep(2000);
Checkout();
Thread.sleep(1000);
String str = driver.findElement(By.cssSelector(Notif)).getText();
//System.out.print(str);
int x=1;
int y=0;
String[] result=new String[12];
StringBuilder stringBuilder = new StringBuilder();
for(int i=29; i<=40; i++) {

result[y]=Character.toString(str.charAt(i+x));
stringBuilder.append(result[y]);

}
//System.out.println(stringBuilder);
Thread.sleep(5000);
toReport();

Thread.sleep(1000);
if (driver.getPageSource().contains(stringBuilder)){

System.out.println("Invoice Check Test = Passed!");
} else {
System.out.println("Invoice Check Test = Failed!");
}


	}
@Test
public void InvoiceCreditmissingBank() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	CreditBtn();
	Paymentinfo();
	Creditamount();
	driver.findElement(By.xpath(Bank)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(Bank)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Issuing Bank is required.")){

		System.out.println("Invoice Credit Missing Bank Test = Passed!");
	} else {
		System.out.println("Invoice Credit Missing Bank Test = Failed!");
	}

}

@Test
public void InvoiceCreditmissingPaymentnum() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	CreditBtn();
	Paymentinfo();
	Creditamount();
	driver.findElement(By.xpath(Paymentnumber)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(Paymentnumber)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Credit Card Number is required.")){

		System.out.println("Invoice Credit Missing Credit Card Number Test = Passed!");
	} else {
		System.out.println("Invoice Credit Missing Credit Card Number Test = Failed!");
	}

}
@Test
public void InvoiceCreditmissingOwner() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	CreditBtn();
	Paymentinfo();
	Creditamount();
	driver.findElement(By.xpath(Ownername)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(Ownername)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Credit Card Owner is required.")){

		System.out.println("Invoice Credit Missing Credit Card Owner Test = Passed!");
	} else {
		System.out.println("Invoice Credit Missing Credit Card Owner Test = Failed!");
	}
}
@Test
public void InvoiceCreditmissingTransactioncode() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	CreditBtn();
	Paymentinfo();
	Creditamount();
	driver.findElement(By.xpath(Transactioncode)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(Transactioncode)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Transaction Code is required.")){

		System.out.println("Invoice Credit Missing Transaction Code Test = Passed!");
	} else {
		System.out.println("Invoice Credit Missing Transaction Code Test = Failed!");
	}
}
@Test
public void InvoiceCreditmissingAmount() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	CreditBtn();
	Paymentinfo();
	Creditamount();
	driver.findElement(By.xpath(CreditAmount)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(CreditAmount)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Amount is required.")){

		System.out.println("Invoice Credit Missing Amount Test = Passed!");
	} else {
		System.out.println("Invoice Credit Missing Amount Test = Failed!");
	}
}
@Test
public void InvoicedebitmissingBank() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	DebitBtn();
	Paymentinfo();
	DebitandCheckamount();
	driver.findElement(By.xpath(Bank)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(Bank)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Issuing Bank is required.")){

		System.out.println("Invoice Debit Missing Bank Test = Passed!");
	} else {
		System.out.println("Invoice Debit Missing Bank Test = Failed!");
	}
}
@Test
public void InvoiceDebitmissingPaymentnum() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	DebitBtn();
	Paymentinfo();
	DebitandCheckamount();
	driver.findElement(By.xpath(Paymentnumber)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(Paymentnumber)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Debit Card Number is required.")){

		System.out.println("Invoice Debit Missing Debit Card Number Test = Passed!");
	} else {
		System.out.println("Invoice Debit Missing Debit Card Number Test = Failed!");
	}

}
@Test
public void InvoiceDebitmissingOwner() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	DebitBtn();
	Paymentinfo();
	DebitandCheckamount();
	driver.findElement(By.xpath(Ownername)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(Ownername)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Debit Card Owner is required.")){

		System.out.println("Invoice Debit Missing Debit Card Owner Test = Passed!");
	} else {
		System.out.println("Invoice Debit Missing Debit Card Owner Test = Failed!");
	}

}
@Test
public void InvoiceDebitmissingTransactioncode() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	DebitBtn();
	Paymentinfo();
	DebitandCheckamount();
	driver.findElement(By.xpath(Transactioncode)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(Transactioncode)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Transaction Code is required.")){

		System.out.println("Invoice Debit Missing Transaction Code Test = Passed!");
	} else {
		System.out.println("Invoice Debit Missing Transaction Code Test = Failed!");
	}

}
@Test
public void InvoiceDebitmissingAmount() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	DebitBtn();
	Paymentinfo();
	DebitandCheckamount();
	driver.findElement(By.xpath(DebitCheckamount)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(DebitCheckamount)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Amount is required.")){

		System.out.println("Invoice Debit Missing Amount Test = Passed!");
	} else {
		System.out.println("Invoice Debit Missing Amount Code Test = Failed!");
	}

}
@Test
public void InvoiceCheckmissingBank() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	CheckBtn();
	Paymentinfo();
	DebitandCheckamount();
	driver.findElement(By.xpath(Bank)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(Bank)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Issuing Bank is required.")){

		System.out.println("Invoice Check Missing Bank Test = Passed!");
	} else {
		System.out.println("Invoice Check Missing Bank Test = Failed!");
	}
}
@Test
public void InvoiceCheckmissingPaymentnum() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	CheckBtn();
	Paymentinfo();
	DebitandCheckamount();
	driver.findElement(By.xpath(Paymentnumber)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(Paymentnumber)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Account Number is required.")){

		System.out.println("Invoice Check Missing Account Number Test = Passed!");
	} else {
		System.out.println("Invoice Check Missing Account Number Test = Failed!");
	}

}
@Test
public void InvoiceCheckmissingOwner() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	CheckBtn();
	Paymentinfo();
	DebitandCheckamount();
	driver.findElement(By.xpath(Ownername)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(Ownername)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Account Name is required.")){

		System.out.println("Invoice Check Missing Account Name Test = Passed!");
	} else {
		System.out.println("Invoice Check Missing Account Name Test = Failed!");
	}

}
@Test
public void InvoiceCheckmissingTransactioncode() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	CheckBtn();
	Paymentinfo();
	DebitandCheckamount();
	driver.findElement(By.xpath(Transactioncode)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(Transactioncode)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Check Number is required.")){

		System.out.println("Invoice Check Missing Check Number Test = Passed!");
	} else {
		System.out.println("Invoice Check Missing Check Number Test = Failed!");
	}

}
@Test
public void InvoiceCheckmissingAmount() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	CheckBtn();
	Paymentinfo();
	DebitandCheckamount();
	driver.findElement(By.xpath(DebitCheckamount)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(DebitCheckamount)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	AddpaymentBtn();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Amount is required.")){

		System.out.println("Invoice Check Missing Amount Test = Passed!");
	} else {
		System.out.println("Invoice Check Missing Amount Code Test = Failed!");
	}

}
@Test
public void InvoiceZeroRated() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	tenderedAmount();
	ZeroRated();
	Thread.sleep(2000);
	Checkout();
	Thread.sleep(1000);
	String str = driver.findElement(By.cssSelector(Notif)).getText();
	//System.out.print(str);
	int x=1;
	int y=0;
	String[] result=new String[12];
	StringBuilder stringBuilder = new StringBuilder();
	for(int i=29; i<=40; i++) {
	
	result[y]=Character.toString(str.charAt(i+x));
	stringBuilder.append(result[y]);
	
	}
	//System.out.println(stringBuilder);
	Thread.sleep(5000);
	toReport();
	
	Thread.sleep(1000);
	if (driver.getPageSource().contains(stringBuilder)){
		
		System.out.println("Invoice Zero Rated Test = Passed!");
	} else {
		System.out.println("Invoice Zero Rated Test = Failed!");
	}
}
@Test
public void InvoiceSave() throws Exception {
	toAdmLogin();
	InvoiceModulebtn();
	InvoiceSteps();
	Thread.sleep(1000);
	toSave();
	Thread.sleep(1000);
	if (driver.getPageSource().contains("Successfully")){
		
		System.out.println("Invoice Save Test = Passed!");
	} else {
		System.out.println("Invoice Save Test = Failed!");
	}
}










	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	public void InvoiceSteps() throws Exception {
		driver.findElement(By.xpath(Itemlookup)).click();
		Thread.sleep(500);
	    driver.findElement(By.xpath(ItemCheckbox)).click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath(ItemCheckboxsave)).click();
	    
	    
	    
	}
	public void InvoiceModulebtn(){
		driver.findElement(By.xpath(Invoicebtn)).click();
		
		
	}
	public void Checkout(){
		driver.findElement(By.cssSelector(Checkoutbtn)).click();
		
		
	}
	public void toReport() throws Exception{
		 driver.findElement(By.xpath(Menu)).click();
		    driver.findElement(By.xpath(ReportModule)).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath(Generatebtn)).click();
		
		
	}
	private void toAdmLogin() {
		driver.findElement(By.xpath(emailField)).sendKeys(authRoleUser);
		driver.findElement(By.xpath(passwordField)).sendKeys(authRoleUserPassword);
		driver.findElement(By.xpath(btnLogin)).click();
}
	private void toSRDiscount() throws Exception {
	driver.findElement(By.xpath(Scpwddiscountbtn)).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(scDiscount)).click();
	driver.findElement(By.xpath(Applydiscount)).click();
	}
	private void tenderedAmount() throws Exception {
	Thread.sleep(1000);
    driver.findElement(By.xpath(Amountfield)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
    driver.findElement(By.xpath(Amountfield)).sendKeys(Keys.BACK_SPACE);
    
    driver.findElement(By.xpath(Amountfield)).sendKeys(RandomStringUtils.randomNumeric(3));
}
	private void Srdetails() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(srpwdName)).sendKeys(RandomStringUtils.randomAlphabetic(5));
		Thread.sleep(1000);
	    driver.findElement(By.xpath(srpwdID)).sendKeys(RandomStringUtils.randomNumeric(3));
	}
	private void toPwddiscount() throws Exception {
		driver.findElement(By.xpath(Scpwddiscountbtn)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(pwdDiscount)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Applydiscount)).click();
		}
	private void toOtherdiscount() throws Exception {
		driver.findElement(By.xpath(Scpwddiscountbtn)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[4]/div/div[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Applydiscount)).click();
		}
	private void CreditBtn() throws Exception {
		driver.findElement(By.xpath(Creditbtn)).click();
		
		
		}
	private void AddpaymentBtn() throws Exception {
		driver.findElement(By.xpath(Addpaymentbtn)).click();
	}

private void DebitBtn() throws Exception {
	driver.findElement(By.xpath(Debitbtn)).click();
   
   
   
	}
private void CheckBtn() throws Exception {
driver.findElement(By.xpath(Checkbtn)).click();


}
private void Paymentinfo() {
driver.findElement(By.xpath(Bank)).sendKeys("BPI");
driver.findElement(By.xpath(Paymentnumber)).sendKeys(RandomStringUtils.randomNumeric(3));
driver.findElement(By.xpath(Ownername)).sendKeys(RandomStringUtils.randomAlphabetic(5));
driver.findElement(By.xpath(Transactioncode)).sendKeys(RandomStringUtils.randomNumeric(3));
}
private void Creditamount() throws Exception {
driver.findElement(By.xpath(CreditAmount)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
Thread.sleep(2000);
driver.findElement(By.xpath(CreditAmount)).sendKeys(Keys.BACK_SPACE);
driver.findElement(By.xpath(CreditAmount)).sendKeys(RandomStringUtils.randomNumeric(4));
}
private void DebitandCheckamount() throws Exception {
driver.findElement(By.xpath(DebitCheckamount)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(DebitCheckamount)).sendKeys(Keys.BACK_SPACE);
	driver.findElement(By.xpath(DebitCheckamount)).sendKeys(RandomStringUtils.randomNumeric(4));
}
private void ZeroRated() {
driver.findElement(By.xpath(ZeroRatedbtn)).click();
driver.findElement(By.xpath(CustomernameField)).sendKeys(RandomStringUtils.randomAlphabetic(5));
}
private void toSave() {
	driver.findElement(By.xpath("(//button[@type='button'])[13]")).click();
driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys(RandomStringUtils.randomAlphabetic(5));
driver.findElement(By.xpath("//div[4]/button[2]/div[2]/div")).click();
}
}

	


	