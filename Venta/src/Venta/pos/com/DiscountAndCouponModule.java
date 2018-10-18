package Venta.pos.com;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiscountAndCouponModule extends StringValues {
	  WebDriver driver;
	  private String baseUrl;

	  
	  @Before
	  public void setUp() throws Exception {
//		  System.setProperty("webdriver.gecko.driver","/home/marvin/Documents/Selinium/geckodriver"); 
//	    driver = new FirefoxDriver();
		  System.setProperty("webdriver.chrome.driver", "/home/marvin/Documents/Selinium/chromedriver");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  baseUrl = "http://172.16.0.12:8589/#/login";
		  driver.get(baseUrl);
	  }
	  
	  @Test
	  public void LoginTest() throws Exception {
		  toAdmLogin();
		  System.out.println("Login test = Passed!");
	  }
	 
	  @Test
	  public void createPWDDiscountTest() throws Exception {
		  toAdmLogin();
		  discountAndCouponMngtBtn();
		  Thread.sleep(1000);
		  createPWDSeniorDiscBtn();
		  Thread.sleep(1000);
		  setPWDSeniorDiscDetails();
		  saveDiscountDetails();
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
		  discountAndCouponMngtBtn();
		  Thread.sleep(1000);
		  createPWDSeniorDiscBtn();
		  Thread.sleep(1000);
		  setPWDSeniorDiscDetails();
		  driver.findElement(By.xpath(discountNameField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		  driver.findElement(By.xpath(discountNameField)).sendKeys(Keys.BACK_SPACE);
		  saveDiscountDetails();
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
		  discountAndCouponMngtBtn();
		  Thread.sleep(1000);
		  createPWDSeniorDiscBtn();
		  Thread.sleep(1000);
		  setPWDSeniorDiscDetails();
		  driver.findElement(By.xpath(discountPercentField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		  driver.findElement(By.xpath(discountPercentField)).sendKeys(Keys.BACK_SPACE);
		  driver.findElement(By.xpath(discountPercentField)).sendKeys(RandomStringUtils.randomNumeric(2));
		  saveDiscountDetails();
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
		  discountAndCouponMngtBtn();
		  Thread.sleep(1000);
		  selectPWDSeniorDisctoModify();
		  String discountName = driver.findElement(By.xpath(discountNameField)).getText();
		  Thread.sleep(1000);
		  modifySrPWDDiscountDetails();
		  
		  saveDiscountDetails();
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
		  discountAndCouponMngtBtn();
		  Thread.sleep(1000);
		  selectPWDSeniorDisctoModify();
		  driver.findElement(By.xpath(discountNameField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		  driver.findElement(By.xpath(discountNameField)).sendKeys(Keys.BACK_SPACE);
		  driver.findElement(By.xpath(discountNameField)).sendKeys(RandomStringUtils.randomNumeric(8));
		  String discountName = driver.findElement(By.xpath(discountNameField)).getText();
		  saveDiscountDetails();
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
		  discountAndCouponMngtBtn();
		  Thread.sleep(1000);
		  selectPWDSeniorDisctoModify();
		  driver.findElement(By.xpath(discountPercentField)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		  driver.findElement(By.xpath(discountPercentField)).sendKeys(Keys.BACK_SPACE);
		  driver.findElement(By.xpath(discountPercentField)).sendKeys(RandomStringUtils.randomNumeric(8));
		  String discountName = driver.findElement(By.xpath(discountNameField)).getText();
		  saveDiscountDetails();
		  Thread.sleep(1000);
		  String str = driver.findElement(By.xpath(getDescountSuccess)).getText();
		  if (str.contains(discountName)) {
				System.out.println("Modify SR/PWD Discount Percent Field  Test = Passed!");
			} else {
				System.out.println("Modify SR/PWD Discount Percent Field  Test = Failed!");
			}
	  }	  
	  
	  
	  
	private void saveDiscountDetails() {
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


	private void createPWDSeniorDiscBtn() {
		driver.findElement(By.xpath(sRPWDDiscountCreateBtn)).click();
	}

	private void discountAndCouponMngtBtn() {
		driver.findElement(By.xpath(discountAndCouponMngtBtn)).click();
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
