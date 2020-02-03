package VentaPlus;



import org.apache.commons.lang3.RandomStringUtils;

public class StringVal {
	
	protected String randomAlphaNumChar = RandomStringUtils.randomAlphabetic(10);
	protected String randomAlphaChar = RandomStringUtils.randomAlphabetic(6);
	protected String randomNumChar = RandomStringUtils.randomAlphabetic(11);



	//login
		protected String authRoleUser = "cjemblar@gmail.com";
		protected String authRoleUserPassword = "1";
		protected String authRoleAdm = "marvin.posadmin@poss.com";
		protected String authRoleAdmPassword = "1";
		protected String authSuperAdm = "admin@satellite.com.ph";
		protected String authSuperAdmPassword = "admin";
	//Terminal
		protected String Terminalbtn = "//div[@id='q-app']/div/div[3]/button/div[2]/div";
		protected String Terminalfield = "(//input[@type='text'])[2]";
		protected String Terminalsave = "//button[2]/div[2]/div";
	//Login
		protected String Userfield = "//input[@type='text']";
		protected String passField = "//input[@type='password']";
		protected String Loginfield = "//button[@type='button']";
	//User
		protected String UserModule = "//div[@id='q-app']/div/div/main/div[2]/div[3]/div/div/div/i";
		protected String Adduserbtn = "(//button[@type='button'])[20]";
		protected String Email = "//input[@type='text']";
		protected String Firstname = "(//input[@type='text'])[2]";
		protected String Lastname = "(//input[@type='text'])[3]";
		protected String Role = "//div[@id='q-app']/div/div/main/div/div[2]/div/div/div[4]/div/div/div/div";
		protected String Location = "//div[@id='q-app']/div/div/main/div/div[2]/div/div/div[5]/div/div/div/div";
		protected String Contactnumber = "(//input[@type='text'])[4]";
		protected String Password = "//input[@type='password']";
		protected String Confirmpass = "(//input[@type='password'])[2]";
		protected String SaveUserbtn = "(//button[@type='button'])[6]";
//Notif
		protected String Notif = "//div[2]/div[2]/div/div/div";
//LOcation
		protected String Locationmodule = "//div[@id='q-app']/div/div/main/div[2]/div[4]/div/div/div/i";
		protected String AddLocation = "(//button[@type='button'])[12]";
		protected String Locationname = "//input[@type='text']";
		protected String LocationAdd = "(//input[@type='text'])[2]";
		protected String SavelocationBtn = "(//button[@type='button'])[6]";
//Inventory
		protected String Inventorymodule = "//div[@id='q-app']/div/div/main/div[2]/div[2]/div/div";
//Items
		protected String Itemsmodule = "//div[@id='q-app']/div/div/main/div[2]/div/div/div/div/i";
		protected String AddItemBTN = "//div[@id='q-app']/div/div/main/div/div[2]/button/div[2]/i";
		protected String ItemCategory = "//div[@id='q-app']/div/div/main/div/div[2]/div/div/div/div/div/div/div";
		protected String Description = "//input[@type='text']";
		protected String Itemcode = "(//input[@type='text'])[2]";
		protected String Barcode = "(//input[@type='text'])[3]";
		protected String NumExpiry = "(//input[@type='text'])[4]";
		protected String Baseunit = "(//input[@type='text'])[5]";
		protected String MinimumStock = "//div[@id='q-app']/div/div/main/div/div[2]/div/div/div[7]/div";
		protected String Quantity = "//input[@type='number']";
		protected String MinimumStockBaseUnit = "//div[2]/div[2]/div/div/div/div";
		protected String MinimumStockSave = "(//button[@type='button'])[8]";
		protected String ItemSaveBTN = "(//button[@type='button'])[7]";
		protected String AddItemCOnBTN = "(//button[@type='button'])[4]";
		protected String ItemConUnit = "(//input[@type='text'])[8]";
		protected String ItemConValue = "(//input[@type='text'])[9]";
		protected String ItemConSaveBTn = "(//button[@type='button'])[8]";
//Stock 
		//Stockin
		protected String StocksBtn = "//div[@id='q-app']/div/div/main/div[2]/div[2]/div/div/div/i";
		protected String StocksItemCode = "//div[@id='q-app']/div/div/main/div/div/div/div/div[2]/div/div/div/div";
		protected String StocksLocation = "//div[@id='q-app']/div/div/main/div/div/div/div[2]/div[2]/div/div/div/div/div";
		protected String StockINBTN = "//div[@id='q-app']/div/div/main/div/div[2]/div/div/div";
		protected String StocksQTY = "//input[@type='number']";
		protected String StocksUnit = "//div[@id='q-app']/div/div/main/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div/div";
		protected String StockCost = "(//input[@type='number'])[2]";
		protected String SupplierBTN = "(//button[@type='button'])[5]";
		protected String SelectSUPP = "//div[2]/div/div/div/div/div/div/div/input";
		protected String SaveSelectedSupp = "(//button[@type='button'])[9]";
		protected String Applysupp = "//div[@id='q-app']/div/div/main/div/div[2]/div[2]/div/div/div/div[2]/div[5]/div/div/div/div/div/div";
		protected String DRnumber = "(//input[@type='text'])[5]";
		protected String BatchNUmber = "(//input[@type='text'])[6]";
		protected String STOCKIN = "(//button[@type='button'])[6]";
		//Stockout
		protected String StockoutBTN = "//div[@id='q-app']/div/div/main/div/div[2]/div/div/div[2]";
		protected String Stockout = "//div[@id='q-app']/div/div/main/div/div[2]/div[2]/div/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[6]/button/div[2]/i";
		protected String StockoutBaseUnit = "//div[2]/div/div[2]/div/div/div/div/div/div/div";
		protected String StockoutQTY = "//input[@type='number']";
		protected String StockoutReason = "(//input[@type='text'])[4]";
		protected String StockoutSaveBTN = "//text()[.='Save']/ancestor::button[1]";
		
//Product
		protected String POsMOdule = "//div[@id='q-app']/div/div/main/div[2]/div/div/div";
		protected String ProductModule = "//div[@id='q-app']/div/div/main/div[2]/div/div/div/div/i";
		protected String ADDnewProductBTN = "(//button[@type='button'])[11]";
		protected String Deletelocation = "//div[@id='q-app']/div/div/main/div/div[2]/div/div/div/div/div/div[2]/i";
		protected String SelectLocation = "//div[@id='q-app']/div/div/main/div/div[2]/div/div/div/div/div/div/div";
		protected String ProductITemcode = "//input[@type='text']";
		protected String ProductBarcode = "(//input[@type='text'])[2]";
		protected String Productdescription = "(//input[@type='text'])[3]";
		protected String ProductOriginalPrice = "//input[@type='number']";
		protected String VatToggle = "//div[@id='q-app']/div/div/main/div/div[2]/div[5]/div/div/div/div[2]/div";
		protected String AddITemBtn = "(//button[@type='button'])[4]"; 
		protected String SelectItem = "//div/div/div/div/div[2]/table/tbody/tr/td[2]";
		protected String SaveSelectedItem = "//text()[.='ADD ITEMS']/ancestor::button[1]";
		protected String SaveProductBTN = "(//button[@type='button'])[8]";
//Discount
		protected String DiscountPage = "//div[@id='q-app']/div/div/main/div[2]/div[2]/div/div/div/i";
		protected String ADDDiscountBTN = "(//button[@type='button'])[11]";
		protected String SRPWDdiscountName = "//input[@type='text']";
		protected String SRPWDdiscountValue = "//input[@type='number']";
		protected String SaveDISCOUNTBTN = "(//button[@type='button'])[5]";
		protected String OtherDiscount = "//div[@id='q-app']/div/div/main/div/div/div[2]";
		protected String AddOtherDiscount = "(//button[@type='button'])[11]";
		
//Invoice		
		protected String Menu = "//div[@id='q-app']/div/header/div/button/div[2]/i";
		protected String ReportModule = "//div[@id='q-app']/div/header/div/div[2]/aside/div/div/div/div/div[4]/a/div[3]";
		protected String Generatebtn = "//div[text()='GENERATE']";
		protected String Notification = "div[class='q-notification__message col']";
		protected String POS = "//div[@id='q-app']/div/div/main/div[2]/div/div/div/div/i";
		protected String InvoicePage = "//div[@id='q-app']/div/div/main/div[2]/div/div/div/div";
		protected String ItemLookup = "(//button[@type='button'])[6]";
		protected String SelectItemField = "//td[2]";
		protected String SaveItem = "(//button[@type='button'])[18]";
		protected String TenderedAmount = "(//input[@type='text'])[6]";
		protected String CheckoutBTN = "(//button[@type='button'])[15]";
		protected String SRPWDDISCOUNTBTN = "//div[@id='q-app']/div/div/main/div/div[2]/div/div[2]/div/div/div[2]/button/div[2]";
		protected String SelectedSCDiscount = "//div[2]/div/div[2]/div/div[2]/div/div[2]";
		protected String Applydiscount = "(//button[@type='button'])[17]";
		protected String SelectedPWDDiscount = "//div[2]/div[2]/div/span";
		protected String Name = "(//input[@type='text'])[6]";
		protected String IDnumber = "(//input[@type='text'])[7]";
		protected String CreditBtn = "//div[@id='q-app']/div/div/main/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div/div/button/div[2]/div";
//paymentDetails
		protected String Bank = "(//input[@type='text'])[7]";
		protected String CardNUM = "(//input[@type='text'])[8]";
		protected String Owner = "(//input[@type='text'])[9]";
		protected String TransactionCode = "(//input[@type='text'])[10]";
		protected String Amount = "(//input[@type='text'])[12]";
		protected String Save = "//text()[.='Add Payment']/ancestor::button[1]";
		
		
		
		
		
		
				
		
		
		
		
		
		
		
		
		
		
}