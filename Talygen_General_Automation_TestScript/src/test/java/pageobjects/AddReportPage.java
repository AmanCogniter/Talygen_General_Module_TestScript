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

public class AddReportPage extends WebBasePage{
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);

	static String reportname;
	static String Activestatus;
	static String InActivestatus;
	
	
	
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public AddReportPage(WebDriver driver) {
		super(driver, "AddReport Page");
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

	public void clickOnAddReportPage() {
		staticWait(2000);
		click(By.xpath("//a[contains(text(),'Add Report')]"), " Add Report", 30);
		
	}
	public void clickOnUserGuide() {
		staticWait(2000);
		click(By.xpath("//div/span/a[text()='User Guide']"), "User Guide open", 30);
		staticWait(2000);
		click(By.xpath("//div/span/a[text()='User Guide']"), "User Guide Closed", 30);
		
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
				By.xpath("//div[@class='form-group']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "Report Name", "Category" };
		for (Object expected : expectedValue) {
			WebElement asterikField = findElementVisibility(By.xpath("//label[text()='"+ expected +"']/ancestor::div[@class='form-group']/descendant::span[@class='mandatory']"), 45);

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
	public void enterReportName() {
		staticWait(2000);
		    reportname = prop.getProperty("reportName")+ datevalue;
		enter(By.xpath("//div/tg-input/input[@id='ReportName']"), reportname  , "Report Name", 20);
	}
	public void SelectCategoryType() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div/tg-select/select[@id='CategoryId']"), "CRM", "Category", 25);

	}
	public void enterDescription() {
		staticWait(2000);
		String DescriptionText = prop.getProperty("Description");
		enter(By.xpath("//tg-textarea/textarea[@id='Description']"), DescriptionText, "CategoryDescription", 20);
	}
	public void clickOnColumn() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[@data-original-title='Column']"), " Column", 30);
		
	}
	public void entertextIntoSearchField() {
		staticWait(2000);
		String textIntoSearchField = prop.getProperty("textIntoSearchField");
		enter(By.xpath("//div/input[@id='txtAvailableColumnsInSetup']"), textIntoSearchField, " Lead Owner", 20);
	}
	public void clickOnSearchButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Search']"), " Search button", 30);
		
	}
	public void clickOnCheckBox() {
		staticWait(2000);
		click(By.xpath("//div/ul/li[@columnname='Lead Owner']/descendant::div[@class='custom-control custom-checkbox']"), " CheckBox", 30);
		
	}
	public void clickOnMoveToRightArrow() {
		staticWait(2000);
		click(By.xpath("//button[@id='aColumnArrow']"), " Move to right arrow", 30);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'column already exits in selected columns list')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
				click(By.xpath("//button[@id='closenotifymessage']"), "Close Button", 30);
				staticWait(1000);
				entertextIntoRightSideSearchField();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			entertextIntoRightSideSearchField();
		}
		
	}
	public void entertextIntoRightSideSearchField() {
		staticWait(2000);
		String textIntoSearchField = prop.getProperty("textIntoSearchField");
		enter(By.xpath("//div/input[@id='txtSelectedColumnsInSetup']"), textIntoSearchField, "Lead Owner", 20);
	}
	public void clickOnRightSideCheckBox() {
		staticWait(2000);
		click(By.xpath("(//div/ul[@id='visiblecolumn']/li[@class='list-group-item ui-sortable-handle']/descendant::div[@class='custom-control custom-checkbox'])[last()-1]"), " CheckBox", 30);
		
	}
	public void clickOnRightSideSearchButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@id='ancSearchSelectedColumnsInSetup']"), " Search button", 30);
		
	}
	public void clickOnFilterButton() {
		staticWait(3000);
		click(By.xpath("//div[3]/div[3]/section/div/section/section/form/section/div/div/div[1]/div/div[2]/div/div[1]/div[3]/div/div[3]/ul[2]/li[4]/span[3]/label/span/span[2]"), "Filter loggle button", 30);
		
	}
	public void clickOnPreview() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Preview']"), "Preview button", 30);
		WebElement previewSelectedColumns = driver.findElement(By.xpath("//div/h5[text()='Preview Selected Columns']"));
		try {
			if (previewSelectedColumns.isDisplayed()) {
				logger.info("Preview page displayed succesfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Preview page not displayed");
			e.printStackTrace();
		}
	}
	public void clickOnClosePreviewPage() {
		staticWait(2000);
		click(By.xpath("//h5[text()='Preview Selected Columns']/ancestor::div[@class='modal-content']/descendant::button[@data-original-title='Close']"), "Close Preview Page", 30);
		
	}
	public void clickOnAddCalculatedColumn() {
		staticWait(2000);
		click(By.xpath("//div/a[@data-original-title='Add Calculated Column']"), "Add Calculated Column", 30);
		
	}
	public void enterFieldNameIntoSearchField() {
		staticWait(2000);
		String fieldName = prop.getProperty("fieldName");
		enter(By.xpath("//div/input[@id='txtFieldName']"), fieldName, "Field Name", 20);
	}
	public void clickOnAvailableColumns() {
		staticWait(2000);
		click(By.xpath("//div/label[text()='LeadOwner']"), "Available column", 30);
		
	}
	public void clickOnMoveAllToRightButton() {
		staticWait(2000);
		click(By.xpath("//div/button[@title='Move All Right']"), "Move all to right button", 30);
		
	}
	public void clickOnVerifyButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Verify']"), "Verify Button", 30);
		
	}
	public void clickOncolumnsaveButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@id='btnSaveCalField']"), "Save Button", 30);
		
	}
	public void clickOnGrouptab() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[@data-original-title='Group']"), "Group", 30);
		try {
			WebElement grouping = driver.findElement(By.xpath("//div/h5/span[text()='Grouping']"));
			if (grouping.isDisplayed()) {
				logger.info("Grouping page opened successfully");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Grouping page not opened");
			e.printStackTrace();
			}
	}
	public void entertextIntoGroupingSearchField() {
		staticWait(2000);
		String textIntoSearchField = prop.getProperty("textIntoSearchField");
		enter(By.xpath("//div/input[@id='txtGroupColumnsInSetup']"), textIntoSearchField, "Group Name", 20);
	}
	public void clickOnGroupSearchButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@id='ancSearchGroupColumnsInSetup']"), " Search button", 30);
		
	}
	public void clickOnGroupPageCheckBox() {
		staticWait(2000);
		click(By.xpath("//div/ul[@id='GroupColumn']/descendant::div[@class='custom-control custom-checkbox']"), " CheckBox", 30);
		
	}
	public void clickOnMoveAllGroupArrow() {
		staticWait(2000);
		click(By.xpath("//div/button[@id='aMoveAllGroupArrow']"), "Move all Group arrow", 30);
		
	}
	public void clickOnSharingTab() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[@data-original-title='Sharing']"), "Sharing Tab", 30);
		try {
			WebElement sharing = driver.findElement(By.xpath("//div/h5/span[text()='User Type']"));
			if (sharing.isDisplayed()) {
				logger.info("Sharing page opened successfully");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Sharing page not opened");
			e.printStackTrace();
			}
		
	}
	public void entertextIntoSharingSearchField() {
		staticWait(2000);
		String userType = prop.getProperty("userType");
		enter(By.xpath("//div/input[@id='txtUsertypeUlInSetup']"), userType, "User Type", 20);
	}
	public void clickOnSharingPageSearchButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@id='ancSearchUsertypeUlInSetup']"), " Search button", 30);
		
	}
	public void clickOnSharingPageCheckBox() {
		staticWait(2000);
		click(By.xpath("//div/ul[@id='UsertypeUl']/li[@class='list-group-item UserTypes']/descendant::div[@class='custom-control custom-checkbox']"), " CheckBox", 30);
		
	}
	public void validateNotifyMessage() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'Report successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Report successfully not added");
			e.printStackTrace();
		}
		
	}
	public void clickOnCustomReportPage() {
		staticWait(2000);
		click(By.xpath("//a[contains(text(),'Custom Reports')]"), "Custom Report", 30);
		
	}
	public void entertextIntoCustomReportSearchField() {
		staticWait(2000);
		
		enter(By.xpath("//div/input[@id='search']"), reportname, "User Type", 20);
	}
	public void clickOnSearchButtonOfCustomReport() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Search']"), " Search Button", 30);
		
	}
	public void validateReportNameInCustomReport() {
		staticWait(2000);
		try {
			WebElement reportName = driver.findElement(By.xpath("//tbody/tr/td/a[contains(text(),'"+reportname+"')]"));
			if (reportName.isDisplayed()) {
				logger.info("Report name is Displayed on custom report page");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Report name is not Displayed on custom report page");
			e.printStackTrace();
		}
	}
		
	public void clickOnReport() {
		staticWait(2000);
		click(By.xpath("//tbody/tr/td/a[contains(text(),'"+reportname+"')]"), " Report", 30);
		
	}
	public void validateNotifyMessageOfCustomReport() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'Report has been successfully updated')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Report hasn't been successfully updated");
			e.printStackTrace();
		}
		
	}
	public void clickOnCustomReportCheckBox() {
		staticWait(2000);
		click(By.xpath("//table/tbody/tr/td/div[@class='custom-control custom-checkbox']"), "Check Box", 30);
		
	}
	public void clickOnDelete() {
		staticWait(2000);
		clickByJavascript(By.xpath("//a[@id='aDeleteMultiple']"), "Delete Button", 30);
		
	}
	public void clickOnConfurmationButton() {
		staticWait(2000);
		click(By.xpath("//div/button[@title='OK']"), "Ok Button", 30);
		
	}
	public void validateDeleteNotifyMessageOfCustomReport() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'Report has been successfully deleted')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Report hasn't been successfully deleted");
			e.printStackTrace();
		}
		
	}
	
	
}
