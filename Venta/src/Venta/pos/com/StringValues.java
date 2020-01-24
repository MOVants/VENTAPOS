package Venta.pos.com;

import org.apache.commons.lang3.RandomStringUtils;

public class StringValues {
	
	protected String randomAlphaNumChar = RandomStringUtils.randomAlphabetic(10);
	protected String randomAlphaChar = RandomStringUtils.randomAlphabetic(6);
	protected String randomNumChar = RandomStringUtils.randomAlphabetic(11);

//login
	protected String authRoleUser = "cjemblar@gmail.com";
	protected String authRoleUserPassword = "1";
	protected String authRoleAdm = "marvin.posadmin@pos.com";
	protected String authRoleAdmPassword = "1";
	protected String authSuperAdm = "admin@satellite.com.ph";
	protected String authSuperAdmPassword = "admin";

// Item notif message
	protected String getItemSuccess = "//div[2]/div[2]/div/div/div";
	protected String getItemError = "//div[text()='Please review fields again.']";
	
// Create SNPWD Discount
	
	protected String getDescountSuccess = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]";
	protected String getDescountError = "//div[text()='Please review fields again.']";	
	protected String sRPWDDiscountCreateBtn = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/button[1]";
	protected String discountBtn = "//text()[contains(.,'Discounts')]/ancestor::div[1]";
	protected String savePWDSrDiscountBtn = "//text()[.='SAVE']/ancestor::button[1]";
	protected String sRPWDEditBtn = "//div[@id='q-app']/div/div/main/div[2]/div/div/div/div/div/div[2]/table/tbody/tr/td[4]/button/div[2]/i";

// Create Other Discount
	protected String newOtherDiscBtn = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/button[1]";
	protected String otherDiscNameField = "//input[@type='text'][@class='q-field__native']";	
	protected String otherDiscField = "//input[@type='number'][@class='q-field__native']";
	protected String saveOtherDiscDetailsBtn = "//text()[.='SAVE']/ancestor::button[1]";
	protected String otherDiscTab = "(.//*[normalize-space(text()) and normalize-space(.)='Other Discounts'])[1]/following::div[1]";
	

// Item Modules
	protected String itemsMngtHomeBtn = "//span[contains(text(),'Items')]";
	protected String emailField = "//input[@type='text']";
	protected String passwordField = "//input[@placeholder='Password']";
	protected String btnLogin = "//text()[contains(.,'LOGIN')]/ancestor::button[1]";
	protected String createItemBtn = "(//button[@type='button'])[11]";
	protected String itemCodeField = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	protected String itemDescField = "(//input[@type='text'])[2]";
	protected String originalPriceField = "//input[@type='number']";
	protected String barcodeField = "(//input[@type='text'])[3]";
	protected String vatableSwitch= "//div[@id='q-app']/div/div/main/div/div[2]/div[4]/div/div/div/div[2]/div";
	protected String discountField = "(//input[@type='text'])[4]";
	protected String saveItemBtn ="//text()[.='SAVE']/ancestor::button[1]";
	protected String discountNameField = "//input[@type='text'][@class='q-field__native']";
	protected String discountPercentField = "//input[@type='number'][@class='q-field__native']";
	
// Users Modules
	protected String userTabBtn = "//div[@id='q-app']/div/div/main/div[2]/div[5]/div/div/div";
	protected String addNewUserBtn = "//div[@id='q-app']/div/div/main/div/div[2]/button/div[2]/i";
	protected String emailFeild = "input[type=text][class='q-field__native']";
	protected String firstNameField = "(//input[@type='text'])[2]";
	protected String lastNameField = "(//input[@type='text'])[3]";
	protected String roleDrpDwn = "div[class='q-field__native row items-center']";
	protected String selectUserRole = "(.//*[normalize-space(text()) and normalize-space(.)='SAVE'])[1]/following::div[15]";
	protected String contactNumField = "(//input[@type='text'])[4]";
	protected String passField = "//input[@type='password']";
	protected String rePassField = "(//input[@type='password'])[2]";
	protected String saveUserBtn = "(//button[@type='button'])[5]";
	
	
//Invoice
	protected String Invoicebtn = "//div[@id='q-app']/div/div/main/div[2]/div/div/div";
	protected String Itemlookup= "(//button[@type='button'])[5]";
	protected String ItemCheckbox = "//td[5]/div/div/div";
	protected String ItemCheckboxsave = "(//button[@type='button'])[17]";
	protected String Amountfield = "(//input[@type='text'])[6]";
	protected String Checkoutbtn = "button[class='q-btn inline q-btn-item non-selectable q-mb-xs full-width block q-btn--standard q-btn--rectangle bg-red text-white q-focusable q-hoverable']	";
	protected String Menu = "//div[@id='q-app']/div/header/div/button/div[2]/i";
	protected String ReportModule = "//div[@id='q-app']/div/header/div/div[2]/aside/div/div/div/div/div[4]/a/div[3]";
	protected String Generatebtn = "//div[text()='GENERATE']";
	protected String Notif = "div[class='q-notification__message col']";
	protected String Scpwddiscountbtn = "//div[@id='q-app']/div/div/main/div/div[2]/div/div[2]/div/div/div[2]/button/div[2]";
	protected String Applydiscount = "//text()[.='APPLY']/ancestor::button[1]";
	protected String pwdDiscount = "//div[2]/div[2]/div/span";
	protected String scDiscount = "div[class='q-card q-ma-xs seniorDiscountButton']";
	protected String srpwdName = "(//input[@type='text'])[6]";
	protected String srpwdID = "(//input[@type='text'])[7]";
	
	//Credit
	protected String Creditbtn = "//div[@id='q-app']/div/div/main/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div/div/button/div[2]/div";
	protected String Bank = "(//input[@type='text'])[7]";
	protected String Paymentnumber = "(//input[@type='text'])[8]";
	protected String Ownername = "(//input[@type='text'])[9]";
	protected String Transactioncode = "(//input[@type='text'])[10]";
	protected String CreditAmount = "(//input[@type='text'])[12]";
	protected String Addpaymentbtn = "//text()[.='Add Payment']/ancestor::button[1]";
	//debit
	protected String Debitbtn = "//div[@id='q-app']/div/div/main/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div/div/button[2]/div[2]/div";
	
//debit and Check amount
	protected String DebitCheckamount = "(//input[@type='text'])[11]";
	//check
	protected String Checkbtn = "//div[@id='q-app']/div/div/main/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div/div/button[3]/div[2]/div";
	//ZeroRated
	protected String ZeroRatedbtn = "//div[@id='q-app']/div/div/main/div/div[2]/div/div[2]/div/div/div/button/div[2]";
	protected String CustomernameField = "(//input[@type='text'])[2]";
	

}