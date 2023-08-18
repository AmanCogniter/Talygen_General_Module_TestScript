package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class CustomFieldsPage extends WebBasePage{
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);

	static String fieldName;
	static String Activestatus;
	static String InActivestatus;
	
	
	
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public CustomFieldsPage(WebDriver driver) {
		super(driver, "Custom Fields Page");
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

	public void clickOnCustomFieldsPage() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[@data-original-title='Custom Fields']"), "Custom Fields", 30);
		try {
			WebElement customField = driver.findElement(By.xpath("//div/span[contains(text(),'Custom Field')]"));
			if (customField.isDisplayed()) {
				logger.info("Custom Field page displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Custom Field page not displayed successfully");
			e.printStackTrace();
		}
	}
	public void clickOnAddCustomFields() {
		staticWait(2000);
		click(By.xpath("//div/span/a[@data-original-title='Add Custom Fields']"), "Add Custom Fields", 30);
		try {
			WebElement addcustomField = driver.findElement(By.xpath("//div/span[contains(text(),'Manage Custom Fields')]"));
			if (addcustomField.isDisplayed()) {
				logger.info("Manage Custom Fields page displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Manage Custom Fields page not displayed successfully");
			e.printStackTrace();
		}
	}
	public void clickOnSaveButton() {
		staticWait(2000);
		click(By.xpath("//div/a[@data-original-title='Save']"), "Save Button", 30);
		
	}
	public void clickOnCancelButton() {
		staticWait(2000);
		click(By.xpath("//div/a[@data-original-title='Cancel']"), "Cancel Button", 30);
		
	}
	public void VerifyMandatoryFieldValidation() {

		int i = 0;

		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='form-group']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "Module Name", "Sub Module Name","Field Name","Length"};
		for (Object expected : expectedValue) {
			WebElement asterikField = findElementVisibility(By.xpath("//*[text()='"+ expected +"']/ancestor::div[@class='form-group']/descendant::span[@class='mandatory']"), 45);

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
	public void SelectModuleName() {
		staticWait(2000);
		selectValueWithText(By.xpath("//tg-select/select[@name='ModuleId']"), "CRM", "Module Name", 25);

	}
	public void SelectSubModuleName() {
		staticWait(2000);
		selectValueWithText(By.xpath("//tg-select/select[@id='ddlSubModule']"), "Campaign", "Sub Module Name", 25);

	}
	public void enterFieldName() {
		staticWait(2000);
		fieldName = prop.getProperty("fielName")+" "+ datevalue;
		enter(By.xpath("//div/tg-input/input[@id='txtName']"), fieldName  , "Field Name", 20);
	}
	public void enterLength() {
		staticWait(2000);
		String length = prop.getProperty("length");
		enter(By.xpath("//div/tg-input/input[@id='txtLength']"), length  , "Length", 20);
	}
	public void SelectLanguage() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div/table[@id='ulContacts']/tbody/tr/td/select"), "English", "Language", 25);

	}
	public void enterLanguageLabel() {
		staticWait(3000);
		String label = prop.getProperty("label")+" "+ datevalue;
		enter(By.xpath("//div/table[@id='ulContacts']/tbody/tr/td[2]/input"), label  , "Language label", 20);
	}
	public void enterDescription() {
		staticWait(2000);
		String description = prop.getProperty("Description");
		enter(By.xpath("//div/textarea[@id='txtdesc']"), description  , "Description", 20);
	}
	public void validateNotifyMessage() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'Custom Field successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Custom Field not added");
			e.printStackTrace();
		}
		
	}
	public void clickOnModuleNameOfSearchField() {
		staticWait(2000);
		click(By.xpath("//div/h5/a/span[text()='Module Name']"), "Module Name", 30);
		
	}
	public void enterModuleNameInSearchField() {
		staticWait(2000);
		
		enter(By.xpath("//div/input[@placeholder='Search']"), "CRM"  , "Module Name", 20);
		staticWait(1000);
		click(By.xpath("//div/label[text()='CRM']"), "Module Name", 30);
	}
	public void clickOnSubModuleNameOfSearchField() {
		staticWait(2000);
		click(By.xpath("//div/h5/a/span[text()='Sub Module Name']"), "Sub Module Name", 30);
		
	}
	public void enterSubModuleNameInSearchField() {
		staticWait(2000);
		
		enter(By.xpath("(//div/input[@placeholder='Search'])[last()]"), "Campaign"  , "Sub Module Name", 20);
		staticWait(1000);
		click(By.xpath("//div/label[text()='Campaign']"), "Sub Module Name", 30);
	}
	public void clickOnSearchButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//span/a[@data-original-title='Click here to search']"), "Search Button", 30);
		WebElement customFieldPage = driver
				.findElement(By.xpath("//table/tbody/tr/td/a[contains(text(),'"+fieldName+"')]"));
		if (customFieldPage.isDisplayed()) {
			logger.info("Field Name is displayed in Custom Field page");
		} else {
			logger.info("Field Name isn't displayed in Custom Field page");

		}
	}
	public void clickOnCheckBox() {
		staticWait(2000);
		click(By.xpath("//table/tbody/tr/td/div[@class='custom-control custom-checkbox']"), "Check Box", 30);
		
	}
	public void clickOnRemove() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/span/a[@id='DeleteMultiple']"), "Remove Button", 30);
		
	}
	public void clickOnConfirmation() {
		staticWait(2000);
		click(By.xpath("//div/button[@title='OK']"), "OK Button", 30);
		
	}
	public void validateNotifyMessageforDeletedFieldname() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'Custom Field has been successfully deleted')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Custom Field hasn't been successfully deleted");
			e.printStackTrace();
		}
		
	}
	public void clickOnInteger() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/span[contains(text(),'Integer')]"), "Integer", 30);
		
	}
	public void enterLengthforInteger() {
		staticWait(2000);
		String length = prop.getProperty("lengthforinteger");
		enter(By.xpath("//div/tg-input/input[@id='txtLength']"), length  , "Length", 20);
	}
	public void clickOnIsRequired() {
		staticWait(2000);
		click(By.xpath("//div/label/span[@class='slider round']/span[2]"), "Is Required Toggle button", 30);
		
	}
	public void clickOnAddMore() {
		staticWait(2000);
		clickByJavascript(By.xpath("//table/tbody/tr/td/a[@data-original-title='Add More']"), "Add More", 30);
		
	}
	public void clickOnClearAll() {
		staticWait(2000);
		clickByJavascript(By.xpath("//table/tbody/tr/td/a[@data-original-title='Clear all ']/i"), "Clear All", 30);
		
	}
	public void clickOnLongInteger() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/span[contains(text(),'Long Integer')]"), "Long Integer", 30);
		
	}
	public void enterLengthforLongInteger() {
		staticWait(2000);
		String length = prop.getProperty("lengthforlonginteger");
		enter(By.xpath("//div/tg-input/input[@id='txtLength']"), length  , "Length", 20);
	}
	public void clickOnDecimal() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/span[contains(text(),'Decimal')]"), "Decimal", 30);
		
	}
	public void clickOnDecimalPlaces() {
		staticWait(2000);
		enter(By.xpath("//div/tg-input/input[@id='txtDp']"), "2"  , "Decimal Places", 20);
		
	}
	public void clickOnDate() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/span[contains(text(),'Date')]"), "Date", 30);
		
	}
	public void clickOnSelectList() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/span[contains(text(),'Select List')]"), "Select List", 30);
		
	}
	public void clickOnPickListOption() {
		staticWait(2000);
		String picklist = prop.getProperty("picklistoption");
		enter(By.xpath("//div/textarea[@id='txtPickList']"), "picklist"  , "Pick List Option", 20);
		
	}
	public void clickOnurl() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/span[contains(text(),'Url')]"), "Url Data Type", 30);
		
	}
	public void enterLengthforUrl() {
		staticWait(2000);
		String length = prop.getProperty("lengthforUrl");
		enter(By.xpath("//div/tg-input/input[@id='txtLength']"), length  , "Length", 20);
	}
}
