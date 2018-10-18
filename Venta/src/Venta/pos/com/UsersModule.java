package Venta.pos.com;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class UsersModule extends StringValues {
  WebDriver driver;
  private String baseUrl;

  
  @Before
  public void setUp() throws Exception {
//	  System.setProperty("webdriver.gecko.driver","/home/marvin/Documents/Selinium/geckodriver"); 
//    driver = new FirefoxDriver();
	  System.setProperty("webdriver.chrome.driver", "/home/marvin/Documents/Selinium/chromedriver");
	  driver = new ChromeDriver();
	  baseUrl = "http://172.16.0.12:8589";
	  driver.manage().window().maximize();
	  driver.get(baseUrl + "/#/login");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
 
  @Test
  public void createUserTest() throws Exception {
	  toAdmLogin();
	  usersTab();
	  setCashierDetails();
	  toSaveCashier();
	  Thread.sleep(1000);
	 String str = driver.findElement(By.xpath(getItemSuccess)).getText();
	    if (str.contains("Successfully"))
	 
		{
			System.out.println("Create user test = Passed!");
		} else {
			System.out.println("Create user test = Failed!");
		}
  }

  @Test
  public void emptyEmailTest() throws Exception {
	  toAdmLogin();
	  usersTab();
	  setCashierDetails();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(emailField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	  driver.findElement(By.xpath(emailField)).sendKeys(Keys.BACK_SPACE);
	  toSaveCashier();
	  Thread.sleep(1000);
	  String str = driver.findElement(By.xpath(getItemError)).getText();
	    if (str.contains("Please review fields again."))
	 
		{
			System.out.println("Empty Email test = Passed!");
		} else {
			System.out.println("Empty Email test = Failed!");
		}
  }
  
  @Test
  public void emptyNameTest() throws Exception {
	  toAdmLogin();
	  usersTab();
	  setCashierDetails();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(firstNameField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	  driver.findElement(By.xpath(firstNameField)).sendKeys(Keys.BACK_SPACE);
	  toSaveCashier();
	  Thread.sleep(1000);
	  String str = driver.findElement(By.xpath(getItemError)).getText();
	    if (str.contains("Please review fields again."))
	 
		{
			System.out.println("Empty Name Field test = Passed!");
		} else {
			System.out.println("Empty Name Field test = Failed!");
		}
  }
  
  @Test
  public void emptyLastNameTest() throws Exception {
	  toAdmLogin();
	  usersTab();
	  setCashierDetails();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(lastNameField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	  driver.findElement(By.xpath(lastNameField)).sendKeys(Keys.BACK_SPACE);
	  toSaveCashier();
	  Thread.sleep(1000);
	  String str = driver.findElement(By.xpath(getItemError)).getText();
	    if (str.equals("Please review fields again."))
	 
		{
			System.out.println("Empty Last Name Field test = Passed!");
		} else {
			System.out.println("Empty Last Name Field test = Failed!");
		}
  }
  
  @Test
  public void emptyContactNumberTest() throws Exception {
	  toAdmLogin();
	  usersTab();
	  setCashierDetails();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(contactNumField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	  driver.findElement(By.xpath(contactNumField)).sendKeys(Keys.BACK_SPACE);
	  toSaveCashier();
	  Thread.sleep(1000);
	  String str = driver.findElement(By.xpath(getItemError)).getText();
	    if (str.contains("Please review fields again."))
	 
		{
			System.out.println("Empty Contact Number Field test = Passed!");
		} else {
			System.out.println("Empty Contact Number Field test = Failed!");
		}
  }
  
  @Test
  public void emptyPasswordTest() throws Exception {
	  toAdmLogin();
	  usersTab();
	  setCashierDetails();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(passField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	  driver.findElement(By.xpath(passField)).sendKeys(Keys.BACK_SPACE);
	  toSaveCashier();
	  Thread.sleep(1000);
	  String str = driver.findElement(By.xpath(getItemError)).getText();
	    if (str.equals("Please review fields again."))
	 
		{
			System.out.println("Empty Password Field test = Passed!");
		} else {
			System.out.println("Empty Password Field test = Failed!");
		}
  }
  
  @Test
  public void emptyRePasswordTest() throws Exception {
	  toAdmLogin();
	  usersTab();
	  addNewUser();
	  setCashierDetails();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(rePassField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	  driver.findElement(By.xpath(rePassField)).sendKeys(Keys.BACK_SPACE);
	  toSaveCashier();
	  Thread.sleep(1000);
	  String str = driver.findElement(By.xpath(getItemError)).getText();
	    if (str.contains("Please review fields again."))
	 
		{
			System.out.println("Empty Re-enter Password Field test = Passed!");
		} else {
			System.out.println("Empty Re-enter Password Field test = Failed!");
		}
  }
   
  
private void addNewUser() {
	 driver.findElement(By.xpath(addNewUserBtn)).click();
}

private void usersTab() {
	driver.findElement(By.xpath(userTabBtn)).click();
}
private void setCashierDetails() throws InterruptedException {
	Thread.sleep(1000);
	  driver.findElement(By.xpath(emailField)).sendKeys(RandomStringUtils.randomAlphanumeric(6)+"@"+RandomStringUtils.randomAlphanumeric(3)+".com");
	  driver.findElement(By.xpath(firstNameField)).sendKeys(RandomStringUtils.randomAlphabetic(5));
	  driver.findElement(By.xpath(lastNameField)).sendKeys(RandomStringUtils.randomAlphabetic(5));
	  driver.findElement(By.cssSelector(roleDrpDwn)).click();
	  Thread.sleep(1000);
	  for (String handle : driver.getWindowHandles()) {
		    driver.switchTo().window(handle);
		    }
	  driver.findElement(By.xpath(selectUserRole)).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(contactNumField)).sendKeys(RandomStringUtils.randomNumeric(11));
	  driver.findElement(By.xpath(passField)).sendKeys("1");
	  driver.findElement(By.xpath(rePassField)).sendKeys("1");
}

private void toSaveCashier(){
	driver.findElement(By.xpath(saveUserBtn)).click();
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
