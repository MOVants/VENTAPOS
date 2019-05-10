package Venta.pos.com;

public class StringValues {

//login
	protected String authUser = "marvin.posuser@pos.com";
	protected String authUsrPassword = "1";
	protected String authAdm = "admin@satellite.com.ph";
	protected String authAdmPassword = "admin";

// Item notif message
	protected String getItemSuccess = "//text()[.='Successfully created item.']/ancestor::div[1]";
	protected String getItemError = "//div[text()='Please review fields again.']";
	
// Create SNPWD Discount
	
	protected String getDescountSuccess = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]";
	protected String getDescountError = "//div[text()='Please review fields again.']";	
	protected String sRPWDDiscountCreateBtn = "//div[text()='ADD NEW SENIOR/PWD DISCOUNT']";
	protected String discountBtn = "//text()[contains(.,'Discounts')]/ancestor::div[1]";
	protected String savePWDSrDiscountBtn = "//div[text()='SAVE']";
	protected String sRPWDEditBtn = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/button[1]";

// Create Other Discount
	protected String newOtherDiscBtn = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/button[1]";
	protected String otherDiscNameField = "//input[@type='text'][@class='q-field__native']";	
	protected String otherDiscField = "//input[@type='number'][@class='q-field__native']";
	protected String saveOtherDiscDetailsBtn = "//text()[.='SAVE']/ancestor::button[1]";
	protected String otherDiscTab = "(.//*[normalize-space(text()) and normalize-space(.)='Other Discounts'])[1]/following::div[1]";
	

// Item Modules
	protected String itemsMngtHomeBtn = "//span[contains(text(),'Items')]";
	protected String emailField = "//input[@placeholder='Email']";
	protected String passwordField = "//input[@placeholder='Password']";
	protected String btnLogin = "//text()[contains(.,'LOGIN')]/ancestor::button[1]";
	protected String createItemBtn = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/button[1]/div[2]";
	protected String itemCodeField = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	protected String itemDescField = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	protected String originalPriceField = "//input[@type='number'][@class='col q-input-target q-no-input-spinner']";
	protected String barcodeField = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	protected String vatableSwitch= "//div[@class='q-toggle-handle row flex-center']";
	protected String discountField = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	protected String saveItemBtn ="//text()[.='SAVE']/ancestor::button[1]";
	protected String discountNameField = "//input[@type='text'][@class='col q-input-target q-no-input-spinner']";
	protected String discountPercentField = "//input[@type='number'][@class='col q-input-target q-no-input-spinner']";
	
// Users Modules
	protected String userTabBtn = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[1]/div[1]";
	protected String addNewUserBtn = "//div[text()='ADD NEW']";
	protected String emailFeild = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	protected String firstNameField = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	protected String lastNameField = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	protected String roleDrpDwn = "*[class='q-icon q-if-control material-icons']";
	protected String selectUserRole = "(.//*[normalize-space(text()) and normalize-space(.)='SAVE'])[1]/following::div[15]";
	protected String contactNumField = "/html[1]/body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]";
	protected String passField = "(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::input[1]";
	protected String rePassField = "(.//*[normalize-space(text()) and normalize-space(.)='Confirm Password'])[1]/following::input[1]";
	protected String saveUserBtn = "//div[text()='SAVE']";
	
	public StringValues() {
		super();
	}

}