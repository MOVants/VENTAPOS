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

public class Usermodule extends StringVal {
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
	public void CreateUser() throws Exception {
	Terminal();
	Login();
	Usermodule(); 
	Adduser();
	Thread.sleep(1000);
	Userdetails();
	SaveUserBtn();
	Thread.sleep(1000);
    String str = driver.findElement(By.xpath(Notif)).getText();
	if (str.contains("Successfully"))

	{
		System.out.println("Create User test = Passed!");
	} else {
		System.out.println("Create User test = Failed!");
	}
	}
	@Test
	public void CreateUserMissingEmail() throws Exception {
	Terminal();
	Login();
	Usermodule(); 
	Adduser();
	Thread.sleep(1000);
	Userdetails();
	Thread.sleep(1000);
	driver.findElement(By.xpath(Email)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	driver.findElement(By.xpath(Email)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	SaveUserBtn();
	Thread.sleep(1000);
    String str = driver.findElement(By.xpath(Notif)).getText();
	if (str.contains("Successfully"))

	{
		System.out.println("Create User Missing Email test = Failed!");
	} else {
		System.out.println("Create User Missing Email test = Passed!");
	}

	}
	@Test
	public void CreateUserMissingFistname() throws Exception {
	Terminal();
	Login();
	Usermodule(); 
	Adduser();
	Thread.sleep(1000);
	Userdetails();
	Thread.sleep(1000);
	driver.findElement(By.xpath(Firstname)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	driver.findElement(By.xpath(Firstname)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	SaveUserBtn();
	Thread.sleep(1000);
    String str = driver.findElement(By.xpath(Notif)).getText();
	if (str.contains("Successfully"))

	{
		System.out.println("Create User Missing Firstname test = Failed!");
	} else {
		System.out.println("Create User Missing Firstname test = Passed!");
	}

	}
	@Test
	public void CreateUserMissingLastname() throws Exception {
	Terminal();
	Login();
	Usermodule(); 
	Adduser();
	Thread.sleep(1000);
	Userdetails();
	Thread.sleep(1000);
	driver.findElement(By.xpath(Lastname)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	driver.findElement(By.xpath(Lastname)).sendKeys(Keys.BACK_SPACE);
	Thread.sleep(1000);
	SaveUserBtn();
	Thread.sleep(1000);
    String str = driver.findElement(By.xpath(Notif)).getText();
	if (str.contains("Successfully"))

	{
		System.out.println("Create User Missing Lastname test = Failed!");
	} else {
		System.out.println("Create User Missing Lastname test = Passed!");
	}

	}

@Test
public void CreateUserMissingContactnum() throws Exception {
Terminal();
Login();
Usermodule(); 
Adduser();
Thread.sleep(1000);
Userdetails();
Thread.sleep(1000);
driver.findElement(By.xpath(Contactnumber)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
driver.findElement(By.xpath(Contactnumber)).sendKeys(Keys.BACK_SPACE);
Thread.sleep(1000);
SaveUserBtn();
Thread.sleep(1000);
String str = driver.findElement(By.xpath(Notif)).getText();
if (str.contains("Successfully"))

{
	System.out.println("Create User Missing Contactnumber test = Failed!");
} else {
	System.out.println("Create User Missing Contactnumber test = Passed!");
}

}

@Test
public void CreateUserMissingPassword() throws Exception {
Terminal();
Login();
Usermodule(); 
Adduser();
Thread.sleep(1000);
Userdetails();
Thread.sleep(1000);
driver.findElement(By.xpath(Password)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
driver.findElement(By.xpath(Password)).sendKeys(Keys.BACK_SPACE);
Thread.sleep(1000);
SaveUserBtn();
Thread.sleep(1000);
String str = driver.findElement(By.xpath(Notif)).getText();
if (str.contains("Successfully"))

{
	System.out.println("Create User Missing Password test = Failed!");
} else {
	System.out.println("Create User Missing Password test = Passed!");
}

}

@Test
public void CreateUserMissingConfirmPass() throws Exception {
Terminal();
Login();
Usermodule(); 
Adduser();
Thread.sleep(1000);
Userdetails();
Thread.sleep(1000);
driver.findElement(By.xpath(Confirmpass)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
driver.findElement(By.xpath(Confirmpass)).sendKeys(Keys.BACK_SPACE);
Thread.sleep(1000);
SaveUserBtn();
Thread.sleep(1000);
String str = driver.findElement(By.xpath(Notif)).getText();
if (str.contains("Successfully"))

{
	System.out.println("Create User Missing Confirmpass test = Failed!");
} else {
	System.out.println("Create User Missing Confirmpass test = Passed!");
}

}
@Test
public void CreateUserWrongConfirmPass() throws Exception {
Terminal();
Login();
Usermodule(); 
Adduser();
Thread.sleep(1000);
Userdetails();
Thread.sleep(1000);
driver.findElement(By.xpath(Confirmpass)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
driver.findElement(By.xpath(Confirmpass)).sendKeys(Keys.BACK_SPACE);
driver.findElement(By.xpath(Confirmpass)).sendKeys("1");
Thread.sleep(1000);
SaveUserBtn();
Thread.sleep(1000);
String str = driver.findElement(By.xpath(Notif)).getText();
if (str.contains("Successfully"))

{
	System.out.println("Create User Wrong Confirmpass test = Failed!");
} else {
	System.out.println("Create User Wrong Confirmpass test = Passed!");
}

}
@Test
public void MOdifyEmail() throws Exception {
Terminal();
Login();
Usermodule(); 
Adduser();
Thread.sleep(1000);
Userdetails();
Thread.sleep(1000);
driver.findElement(By.xpath(Email)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
driver.findElement(By.xpath(Email)).sendKeys(Keys.BACK_SPACE);
driver.findElement(By.xpath(Email)).sendKeys(RandomStringUtils.randomAlphanumeric(6)+"@"+"venta.com");
Thread.sleep(1000);
SaveUserBtn();
Thread.sleep(1000);
String str = driver.findElement(By.xpath(Notif)).getText();
if (str.contains("Successfully"))

{
	System.out.println("Create User Modify Email test = Passed!");
} else {
	System.out.println("Create User Modify Email test = Failed!");
}

}
@Test
public void MOdifyFirstname() throws Exception {
Terminal();
Login();
Usermodule(); 
Adduser();
Thread.sleep(1000);
Userdetails();
Thread.sleep(1000);
driver.findElement(By.xpath(Firstname)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
driver.findElement(By.xpath(Firstname)).sendKeys(Keys.BACK_SPACE);
driver.findElement(By.xpath(Firstname)).sendKeys(RandomStringUtils.randomAlphabetic(5));
Thread.sleep(1000);
SaveUserBtn();
Thread.sleep(1000);
String str = driver.findElement(By.xpath(Notif)).getText();
if (str.contains("Successfully"))

{
	System.out.println("Create User Modify Firstname test = Passed!");
} else {
	System.out.println("Create User Modify Firstname test = Failed!");
}

}
@Test
public void MOdifyLastname() throws Exception {
Terminal();
Login();
Usermodule(); 
Adduser();
Thread.sleep(1000);
Userdetails();
Thread.sleep(1000);
driver.findElement(By.xpath(Lastname)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
driver.findElement(By.xpath(Lastname)).sendKeys(Keys.BACK_SPACE);
driver.findElement(By.xpath(Lastname)).sendKeys(RandomStringUtils.randomAlphabetic(5));
Thread.sleep(1000);
SaveUserBtn();
Thread.sleep(1000);
String str = driver.findElement(By.xpath(Notif)).getText();
if (str.contains("Successfully"))

{
	System.out.println("Create User Modify Lastname test = Passed!");
} else {
	System.out.println("Create User Modify Lastname test = Failed!");
}

}
@Test
public void CreateAdmin() throws Exception {
Terminal();
Login();
Usermodule(); 
Adduser();
Thread.sleep(1000);
Userdetails();
Thread.sleep(1000);
driver.findElement(By.xpath(Role)).click();
driver.findElement(By.xpath(Role)).sendKeys(Keys.ARROW_DOWN);  
driver.findElement(By.xpath(Role)).sendKeys(Keys.ARROW_DOWN);
driver.findElement(By.xpath(Role)).sendKeys(Keys.ENTER); 
Thread.sleep(1000);
SaveUserBtn();
Thread.sleep(1000);
String str = driver.findElement(By.xpath(Notif)).getText();
if (str.contains("Successfully"))

{
	System.out.println("Create User Create Admin test = Passed!");
} else {
	System.out.println("Create User Create Admin test = Failed!");
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
	public void Usermodule()  {
	driver.findElement(By.xpath(UserModule)).click();
	}
	public void Adduser(){
	driver.findElement(By.xpath(Adduserbtn)).click();     
	}
	public void Userdetails() throws Exception {
		driver.findElement(By.xpath(Email)).sendKeys(RandomStringUtils.randomAlphanumeric(6)+"@"+"venta.com");
	    driver.findElement(By.xpath(Firstname)).sendKeys(RandomStringUtils.randomAlphabetic(5));
	    driver.findElement(By.xpath(Lastname)).sendKeys(RandomStringUtils.randomAlphabetic(5));
	    driver.findElement(By.xpath(Role)).click();
	    driver.findElement(By.xpath(Role)).sendKeys(Keys.ARROW_DOWN);              
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(Role)).sendKeys(Keys.ENTER); 
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(Location)).click();
	    for (int x=1; x<=3; x++) {
	    	driver.findElement(By.xpath(Location)).sendKeys(Keys.ARROW_UP);
	    	if (x==3){
	    		driver.findElement(By.xpath(Location)).sendKeys(Keys.ENTER);
	    	}
	    }
	    driver.findElement(By.xpath(Contactnumber)).sendKeys(RandomStringUtils.randomNumeric(11));
	    
	    driver.findElement(By.xpath(Password)).sendKeys(RandomStringUtils.randomAlphanumeric(6));
	    String pass=driver.findElement(By.xpath(Password)).getAttribute("value");
	    driver.findElement(By.xpath(Confirmpass)).sendKeys(pass);
	    
	}
	public void SaveUserBtn() {
		driver.findElement(By.xpath(SaveUserbtn)).click();
	}
	public void AdditemCon() {
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[8]")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[9]")).click();
	    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
	}
}
