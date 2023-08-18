package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class PassportInformationPage extends WebBasePage {
	WebDriver driver;
	String pattern = "MM/dd/yyyy";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);

	static String reportname;
	static String Activestatus;
	static String InActivestatus;
	static String visaNumber;

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	CompanySetupUserPage companySetupUserPage = new CompanySetupUserPage(driver);

	public PassportInformationPage(WebDriver driver) {
		super(driver, "Passport Information Page");
		this.driver = driver;
	}

	public void clickFullMenuDropDown() {
		staticWait(2000);
		click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 30);

	}

	public void clickOnGeneralLink() {
		staticWait(2000);
		click(By.xpath("//li[@data-name='General']/span"), "General Link", 30);

	}

	public void clickOnPassportInformationPage() {
		staticWait(2000);
		click(By.xpath("//a[contains(text(),'Passport Information')]"), "Passport Information", 30);
		try {
			WebElement passport = driver.findElement(By.xpath("//div/span[contains(text(),'Passport')]"));
			if (passport.isDisplayed()) {
				logger.info("Passport listing page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Passport listing page not opened");
		}
	}

	public void clickOnAddPassportPage() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/span/a[@id='aAddPassport']"), " Add Passport", 30);
		try {
			WebElement addPassport = driver.findElement(By.xpath("//div/h5[contains(text(),'Add Passport Details')]"));
			if (addPassport.isDisplayed()) {
				logger.info("Add Passport page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Add Passport page not opened");
		}
	}

	public void clickOnSaveButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Save']"), "Save Button", 30);

	}

	public void clickOnCancelButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Cancel']"), "Cancel Button", 30);

	}

	public void VerifyMandatoryFieldValidation() {

		int i = 0;

		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div/span[contains(text(),'is required')]"), 45);
		String[] expectedValue = { "User Name", "Passport Number", "Nationality", "Place of Issue", "Issue Date",
				"Expiry Date", "Date of Birth", "Gender", "Status" };
		for (Object expected : expectedValue) {
			WebElement asterikField = findElementVisibility(By.xpath(
					"//label[text()='" + expected + "']/ancestor::div[@class='col-lg-6']/descendant::span[text()='*']"),
					45);

			if (asterikField != null) {
				getTest().log(LogStatus.PASS, "The Asterisk symbol is displayed for" + expected + " field");
				logger.info("The Asterisk symbol is displayed for " + expected + " field");

			} else {
				getTest().log(LogStatus.FAIL, "The Asterisk symbol is not displayed for" + expected + " field");
				logger.info("The Asterisk symbol is not displayed for " + expected + " field");

			}

			List<WebElement> expectedElements = errorMessageLocator;
			for (WebElement element : expectedElements) {
				i++;
				actualText = element.getText();
				expectedText = expected.toString();

				if (actualText.indexOf(expectedText) != -1) {
					getTest().log(LogStatus.PASS,
							"Error message for \"" + expected + "\" field is displayed as expected");
					logger.info("Error message for \"" + expected + "\" field is displayed as expected");
					i = 0;
					break;
				} else if (i == expectedValue.length && !element.getText().contains(expectedText)) {
					getTest().log(LogStatus.FAIL, "Error message for \"" + expected + "\" field is not displayed");
					logger.info("Error message for \"" + expected + "\" field is displayed as expected");
					takeScreenshot(expectedText);
				}
			}

		}
	}

	public void selectUserName() {
		staticWait(2000);

		selectValueWithText(By.xpath("//select[@id='UserId']"),
				prop.getProperty("userFirstName") + " " + companySetupUserPage.userNAame, "User Name", 25);
	}

	public void enterPassportNumber() {
		staticWait(2000);
		Random random = new Random();
		int random1 = random.nextInt(100000000);
		String passportNumber = String.valueOf(random1);
		enter(By.xpath("//tg-input/input[@id='PassportNumber']"), "Passport Number " + passportNumber,
				"Passport Number", 20);
	}

	public void selectNationality() {
		staticWait(2000);

		selectValueWithText(By.xpath("//select[@id='Nationality']"), prop.getProperty("nationality"), "Nationality",
				25);
	}

	public void enterPlaceOfIssue() {
		staticWait(2000);

		enter(By.xpath("//tg-input/input[@id='PlaceOfIssue']"), prop.getProperty("placeOfIssue"), "Place Of Issue", 20);
	}

	public void clickOnIssueDate() {
		staticWait(2000);
		click(By.xpath(
				"//tg-input/input[@name='IssueDate']/ancestor::div[@class='form-group']/descendant::div[@data-original-title='Select Date']/span"),
				"Issue Date", 30);

	}

	public void clickOnExpiryDate() {
		staticWait(2000);
		click(By.xpath(
				"//tg-input/input[@name='ExpiryDate']/ancestor::div[@class='form-group']/descendant::div[@data-original-title='Select Date']/span"),
				"Expiry Date", 30);

	}

	public void enterdateOfBirth() {
		staticWait(2000);

		enter(By.xpath("//div/tg-input/input[@id='DateOfBirth']"), datevalue, "Date Of Birth", 20);
	}

	public void uploadDocument() {

		driver.findElement(By.xpath(
				"//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']/label[@for='flFile']"))
				.click();

		// put path to your image in a clipboard
		StringSelection ss = new StringSelection(
				"C:\\Users\\aanand\\Desktop\\workspace_aman\\Expense-Module\\src\\main\\resources\\testfiles\\ItemTypeSample.xls");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot;
		try {
			robot = new Robot();

			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(90);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnPlusicon() {
		staticWait(2000);
		clickByJavascript(By.xpath("//span/a[@id='addmailBlackListed']"), "+ icon", 30);

	}

	public void clickOnRemove() {
		staticWait(2000);
		clickByJavascript(By.xpath("(//div/span/a[@data-original-title='Remove'])[last()]"), "Remove button", 30);

	}

	public void validateNotifyMessage() {
		staticWait(1000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Passport successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Passport successfully not added'");
			e.printStackTrace();
		}

	}

	public void clickOnUserNameSearchFilter() {
		staticWait(2000);
		click(By.xpath("//a/span[text()='User Name']"), "Search By User Name", 30);

	}

	public void enterUserNameInSerachByUserNameTextField() {
		staticWait(2000);
		enter(By.xpath("//div/input[@id='search']"),
				prop.getProperty("userFirstName") + " " + companySetupUserPage.userNAame, "User Name", 30);

	}

	public void clickOnSearchButton() {
		staticWait(2000);
		click(By.xpath("//span/a[@data-original-title='Click here to search']"), "Search Button", 30);
		String userName = prop.getProperty("userFirstName") + " " + companySetupUserPage.userNAame;
		WebElement passportListingPage = driver
				.findElement(By.xpath("//table/tbody/tr/td/a[contains(text(),'" + userName + "')]"));
		if (passportListingPage.isDisplayed()) {
			logger.info("User Name is displayed in Passport Listing page");
		} else {
			logger.info("User Name isn't displayed in Passport Listing page");

		}
	}

	public void clickOnStatusSearchFilter() {
		staticWait(2000);
		click(By.xpath("//a/span[text()='Status']"), "Search By Status", 30);

	}

	public void enterStatusInSerachByStatusTextField() {
		staticWait(2000);
		enter(By.xpath("//div/input[@placeholder='Search']"), "Active", "User Name", 30);
		staticWait(1000);
		click(By.xpath("//label[text()='Active']"), "Active radoi button", 30);
	}

	public void clickOnActionButton() {
		staticWait(3000);
		click(By.xpath("//a[@class='cht-collapse']/i[@id='arrow-rotate']"), "Close Communication Popup", 30);
		WebElement actionButton = driver
				.findElement(By.xpath("//td[@class='text-center mobile-action']/span[@class='actions mobileaction']"));
		Actions action = new Actions(driver);
		action.moveToElement(actionButton).click().perform();
		logger.info("Action Button Clicked");

	}

	public void clickOnEditButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//span/a[@data-original-title='Click here to edit Passport']"), "Edit Button", 30);
		WebElement updatePage = driver.findElement(By.xpath("//div/h5[text()='Edit Passport Details']"));
		if (updatePage.isDisplayed()) {
			logger.info("Edit Passport Details page opend successfully");
		} else {
			logger.info("Edit Passport Details page not opend successfully");
		}
	}

	public void clickOnUpdateButton() {
		staticWait(2000);
		clickByJavascript(
				By.xpath("//div[@id='divshowadddata']/form[@id='fileupload']//a[@data-original-title='Update']"),
				"Update Button", 30);

	}

	public void validateNotifyMessageForUpdate() {
		staticWait(1000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Passport has been successfully updated')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Passport hasn't been successfully updated");
			e.printStackTrace();
		}

	}

	public void clickOnViewPassportButton() {
		staticWait(3000);
		click(By.xpath("//a[@data-original-title='View Passport Details']"), "View Passport Button", 30);
		WebElement passportDetails = driver.findElement(By.xpath("//div/span[contains(text(),'User Name')]"));
		if (passportDetails.isDisplayed()) {
			logger.info("Passport Details displayed successfully");
			click(By.xpath("//a[@data-original-title='Back to list']"), "Back to list", 30);
		} else {
			logger.info("Passport Details not displayed successfully");
		}
	}

	public void clickOnViewVisaButton() {
		staticWait(3000);
		click(By.xpath("//a[@data-original-title='View  Visa Details']"), "'View  Visa Button", 30);
		WebElement visaDetails = driver.findElement(By.xpath("//div/span[contains(text(),'Visa Details')]"));
		if (visaDetails.isDisplayed()) {
			logger.info("Visa Details Page displayed successfully");

		} else {
			logger.info("Visa Details page not displayed successfully");
		}
	}

	public void clickOnAddVisaDetails() {
		staticWait(2000);
		clickByJavascript(By.xpath("//span/a[@id='aAddVisa']"), "Add Visa Button", 30);
		WebElement visaDetailsPage = driver.findElement(By.xpath("//div/h5[contains(text(),'Add Visa Details')]"));
		if (visaDetailsPage.isDisplayed()) {
			logger.info("Add Visa Details Page displayed successfully");

		} else {
			logger.info("Add Visa Details page not displayed successfully");
		}
	}

	public void VerifyMandatoryFieldValidationOfVisaDetailsPage() {

		int i = 0;

		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//span[contains(text(),'is required')]"),
				45);
		String[] expectedValue = { "Visa Number", "Valid for Country", "From ", "To ", "No of Entry",
				"Control Number" };
		for (Object expected : expectedValue) {
			WebElement asterikField = findElementVisibility(By.xpath(
					"//label[text()='" + expected + "']/ancestor::div[@class='col-lg-6']/descendant::span[text()='*']"),
					45);

			if (asterikField != null) {
				getTest().log(LogStatus.PASS, "The Asterisk symbol is displayed for" + expected + " field");
				logger.info("The Asterisk symbol is displayed for " + expected + " field");

			} else {
				getTest().log(LogStatus.FAIL, "The Asterisk symbol is not displayed for" + expected + " field");
				logger.info("The Asterisk symbol is not displayed for " + expected + " field");

			}

			List<WebElement> expectedElements = errorMessageLocator;
			for (WebElement element : expectedElements) {
				i++;
				actualText = element.getText();
				expectedText = expected.toString();

				if (actualText.indexOf(expectedText) != -1) {
					getTest().log(LogStatus.PASS,
							"Error message for \"" + expected + "\" field is displayed as expected");
					logger.info("Error message for \"" + expected + "\" field is displayed as expected");
					i = 0;
					break;
				} else if (i == expectedValue.length && !element.getText().contains(expectedText)) {
					getTest().log(LogStatus.FAIL, "Error message for \"" + expected + "\" field is not displayed");
					logger.info("Error message for \"" + expected + "\" field is displayed as expected");
					takeScreenshot(expectedText);
				}
			}

		}
	}

	public void enterVisaNumber() {
		staticWait(2000);
		Random random = new Random();
		int random1 = random.nextInt(100000000);
		visaNumber = String.valueOf(random1);
		enter(By.xpath("//tg-input/input[@id='VisaNumber']"), visaNumber, "Visa Number", 20);
	}

	public void selectCountry() {
		staticWait(2000);

		selectValueWithText(By.xpath("//select[@id='VaidForCountry']"), prop.getProperty("country"), "Country", 25);
	}

	public void clickOnFromDate() {
		staticWait(2000);
		click(By.xpath("//div[contains(@data-target,'FromDate')]/span"), "Select From Date", 30);

	}

	public void clickOnToDate() {
		staticWait(2000);
		Calendar calendar = Calendar.getInstance();
		// System.out.println("Current Date = " + calendar.getTime());
		// Add 6 months from current date
		calendar.add(Calendar.MONTH, +6);
		Date newdate = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
		String strDate = dateFormat.format(newdate);
		System.out.println("Updated Date = " + calendar.getTime());
		click(By.xpath("//div[contains(@data-target,'ToDate')]/span"), "Select To Date", 30);
		staticWait(1000);
		clickByJavascript(By.xpath("//table/tbody/tr/td/a[@title='Clear selection']"), "Clear selection", 30);
		staticWait(1000);
		enter(By.xpath("//tg-input/input[@id='ToDate']"), strDate, "To Date", 20);
	}

	public void enterViasDescription() {
		staticWait(2000);
		enter(By.xpath("//tg-textarea/textarea[@name='Comments']"), prop.getProperty("Description"), "Description", 30);

	}

	public void enterControlNumber() {
		staticWait(2000);
		enter(By.xpath("//tg-input/input[@id='ControlNumber']"), visaNumber, "Control number", 30);

	}

	public void addAttachment() {

		driver.findElement(By.xpath(
				"//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']/label[@for='flFile']"))
				.click();

		// put path to your image in a clipboard
		StringSelection ss = new StringSelection(
				"C:\\Users\\aanand\\Desktop\\workspace_aman\\Expense-Module\\src\\main\\resources\\testfiles\\ItemTypeSample.xls");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot;
		try {
			robot = new Robot();

			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(90);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnClear() {
		staticWait(2000);
		clickByJavascript(By.xpath("//a[@title='Clear']"), "Clear Button", 30);

	}

	public void clickOnUserGuide() {
		staticWait(2000);
		click(By.xpath("(//div/span/a[text()='User Guide'])[last()]"), "User Guide Open", 30);
		click(By.xpath("(//div/span/a[text()='User Guide'])[last()]"), "User Guide Closed", 30);

	}

	public void validateNotifyMessageForVisa() {
		staticWait(1000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Visa successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Visa successfully not added");
			e.printStackTrace();
		}

	}

	public void clickOnVisaNameSearchFilter() {
		staticWait(2000);
		click(By.xpath("//a/span[text()='Visa Number']"), "Search By Visa Number", 30);

	}

	public void enterVisaNumberInSerachByVisaNumberTextField() {
		staticWait(2000);
		enter(By.xpath("//div/input[@id='search']"), visaNumber, "Visa Number", 30);

	}

	public void clickOnSearchButtonOfVisaDetails() {
		staticWait(2000);
		click(By.xpath("//span/a[@data-original-title='Click here to search']"), "Search Button", 30);

		WebElement passportListingPage = driver
				.findElement(By.xpath("//table/tbody/tr/td/span[contains(text(),'" + visaNumber + "')]"));
		if (passportListingPage.isDisplayed()) {
			logger.info("Visa Number is displayed in Passport Listing page");
		} else {
			logger.info("Visa Number isn't displayed in Passport Listing page");

		}
	}

	public void clickOnStatusSearchFilterOfVisa() {
		staticWait(2000);
		click(By.xpath("//a/span[text()='Status']"), "Search By Status", 30);

	}

	public void enterStatusInSerachByStatusTextFieldOfVisa() {
		staticWait(2000);
		enter(By.xpath("//div/input[@placeholder='Search']"), "Active", "User Name", 30);
		staticWait(1000);
		click(By.xpath("//label[text()='Active']"), "Active radoi button", 30);
	}

	public void clickOnEDitVisa() {
		staticWait(2000);
		clickByJavascript(By.xpath("//td/a[@data-original-title='Click here to edit Visa']"), "Edit Visa Details", 30);

		try {
			WebElement visa = driver.findElement(By.xpath("//div/h5[contains(text(),'Edit Visa Details')]"));
			if (visa.isDisplayed()) {
				logger.info("Edit Visa Details page is displayed ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Edit Visa Details page not displayed");
		}
	}

	public void clickOnCheckBox() {
		staticWait(2000);
		click(By.xpath("//div[@class='custom-control custom-checkbox']"), "Check Box", 30);

	}

	public void clickOnDelete() {
		staticWait(2000);
		clickByJavascript(By.xpath("//a[@data-original-title='Delete']"), "Delete Button", 30);

	}

	public void clickOnConfirmation() {
		staticWait(2000);
		click(By.xpath("//button[@title='OK']"), "OK Button", 30);

	}

	public void clickOnBackToPassportList() {
		staticWait(2000);
		click(By.xpath("//a[@data-original-title='Back To Passport list']"), "Back To Passport list", 30);

	}

	public void userNmaeAscending() {
		userNameSorting("ascending");
	}

	public void UserNameDescending() {
		userNameSorting("descending");
	}

	public void userNameSorting(String order) {
		List<String> actualSortedArray = new ArrayList<>();

		clickByJavascript(By.xpath("//table/thead/tr/th/span[@id='UserName']"), "User Name", 20);

		List<WebElement> titleLocators = findMultipleElement(
				By.xpath("//table[@id='tblProjectList']//tbody//tr//td[2]/a"), 30);
		for (WebElement titleName : titleLocators) {
			actualSortedArray.add(titleName.getText().trim());
		}

		if (order.equalsIgnoreCase("ascending")) {
			verifyAscendingOrder(actualSortedArray, "userName");
		} else if (order.equalsIgnoreCase("descending")) {
			verifyDescendingOrder(actualSortedArray, "userName");
		}
	}

	public void passportNumberAscending() {
		passportNumberSorting("ascending");
	}

	public void passportNumberDescending() {
		passportNumberSorting("descending");
	}

	public void passportNumberSorting(String order) {
		List<String> actualSortedArray = new ArrayList<>();

		clickByJavascript(By.xpath("//table/thead/tr/th/span[@id='PassportNumber']"), "Passport Number", 20);

		List<WebElement> titleLocators = findMultipleElement(
				By.xpath("//table[@id='tblProjectList']//tbody//tr//td[3]/span"), 30);
		for (WebElement titleName : titleLocators) {
			actualSortedArray.add(titleName.getText().trim());
		}

		if (order.equalsIgnoreCase("ascending")) {
			verifyAscendingOrder(actualSortedArray, "passportNumber");
		} else if (order.equalsIgnoreCase("descending")) {
			verifyDescendingOrder(actualSortedArray, "passportNumber");
		}
	}

	public void placeOfIssueAscending() {
		placeOfIssueSorting("ascending");
	}

	public void placeOfIssueDescending() {
		placeOfIssueSorting("descending");
	}

	public void placeOfIssueSorting(String order) {
		List<String> actualSortedArray = new ArrayList<>();

		clickByJavascript(By.xpath("//table/thead/tr/th/span[@id='PlaceOfIssue']"), "Place Of Issue", 20);

		List<WebElement> titleLocators = findMultipleElement(
				By.xpath("//table[@id='tblProjectList']//tbody//tr//td[4]/span"), 30);
		for (WebElement titleName : titleLocators) {
			actualSortedArray.add(titleName.getText().trim());
		}

		if (order.equalsIgnoreCase("ascending")) {
			verifyAscendingOrder(actualSortedArray, "PlaceOfIssue");
		} else if (order.equalsIgnoreCase("descending")) {
			verifyDescendingOrder(actualSortedArray, "PlaceOfIssue");
		}
	}

	public void expiryDateAscending() {
		expiryDateSorting("ascending");
	}

	public void expiryDateDescending() {
		expiryDateSorting("descending");
	}

	public void expiryDateSorting(String order) {
		List<String> actualSortedArray = new ArrayList<>();

		clickByJavascript(By.xpath("//table/thead/tr/th/span[contains(@id,'ExpiryDate')]"), "Expiry Date", 20);

		List<WebElement> titleLocators = findMultipleElement(
				By.xpath("//table[@id='tblProjectList']//tbody//tr//td[5]/span"), 30);
		for (WebElement titleName : titleLocators) {
			actualSortedArray.add(titleName.getText().trim());
		}

		if (order.equalsIgnoreCase("ascending")) {
			verifyAscendingOrder(actualSortedArray, "Expiry Date");
		} else if (order.equalsIgnoreCase("descending")) {
			verifyDescendingOrder(actualSortedArray, "Expiry Date");
		}
	}

	public void statusAscending() {
		statusSorting("ascending");
	}

	public void statusDescending() {
		statusSorting("descending");
	}

	public void statusSorting(String order) {
		List<String> actualSortedArray = new ArrayList<>();

		clickByJavascript(By.xpath("//table/thead/tr/th/span[contains(@id,'Status')]"), "Status", 20);

		List<WebElement> titleLocators = findMultipleElement(
				By.xpath("//table[@id='tblProjectList']//tbody//tr//td[6]/span"), 30);
		for (WebElement titleName : titleLocators) {
			actualSortedArray.add(titleName.getText().trim());
		}

		if (order.equalsIgnoreCase("ascending")) {
			verifyAscendingOrder(actualSortedArray, "Status");
		} else if (order.equalsIgnoreCase("descending")) {
			verifyDescendingOrder(actualSortedArray, "Status");
		}
	}

	public void attachmentAscending() {
		attachmentSorting("ascending");
	}

	public void attachmnetDescending() {
		attachmentSorting("descending");
	}

	public void attachmentSorting(String order) {
		List<String> actualSortedArray = new ArrayList<>();

		clickByJavascript(By.xpath("//table/thead/tr/th[contains(@id,'th-ATTACHMENT')]/span"), "ATTACHMENT", 20);

		List<WebElement> titleLocators = findMultipleElement(
				By.xpath("//table[@id='tblProjectList']//tbody//tr//td[7]/a"), 30);
		for (WebElement titleName : titleLocators) {
			actualSortedArray.add(titleName.getText().trim());
		}

		if (order.equalsIgnoreCase("ascending")) {
			verifyAscendingOrder(actualSortedArray, "Attachment");
		} else if (order.equalsIgnoreCase("descending")) {
			verifyDescendingOrder(actualSortedArray, "Attachment");
		}
	}

	public void verifyAscendingOrder(List<String> actualSortedArray, String fieldName) {
		List<String> result = new ArrayList<>();
		List<String> expectedSortedList = new ArrayList<>(actualSortedArray);
		expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER);
		for (int i = 0; i < expectedSortedList.size(); i++) {
			if (expectedSortedList.get(i).equalsIgnoreCase(actualSortedArray.get(i))) {
				result.add("true");
			} else {
				result.add("false");
			}
		}
		if (!result.contains("false")) {
			getTest().log(LogStatus.PASS,
					fieldName + "s are sorted in ascending Order when click the " + fieldName + " header for one time");
			logger.info(
					fieldName + "s are sorted in ascending Order when click the " + fieldName + " header for one time");
		} else {
			getTest().log(LogStatus.FAIL, fieldName + "s are not sorted in ascending Order when click the " + fieldName
					+ " header for one time");
			logger.info(fieldName + "s are not sorted in ascending Order when click the " + fieldName
					+ " header for one time");
			takeScreenshot(fieldName + "Ascending");
		}
	}

	public void verifyDescendingOrder(List<String> actualSortedArray, String fieldName) {
		List<String> result = new ArrayList<>();
		List<String> expectedSortedList = new ArrayList<>(actualSortedArray);
		expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER);
		Collections.reverse(expectedSortedList);
		for (int i = 0; i < expectedSortedList.size(); i++) {
			if (expectedSortedList.get(i).equalsIgnoreCase(actualSortedArray.get(i))) {
				result.add("true");
			} else {
				result.add("false");
			}
		}
		if (!result.contains("false")) {
			getTest().log(LogStatus.PASS, fieldName + "s are sorted in descending Order when click the " + fieldName
					+ " header for two times");
			logger.info(fieldName + "s are sorted in descending Order when click the " + fieldName
					+ " header for two times");
		} else {
			getTest().log(LogStatus.FAIL, fieldName + "s are not sorted in descending Order when click the " + fieldName
					+ " header for two times");
			logger.info(fieldName + "s are not sorted in descending Order when click the " + fieldName
					+ " header for two times");
			takeScreenshot(fieldName + "Descending");
		}
	}

}
