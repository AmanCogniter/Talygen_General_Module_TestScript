package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class WorkingDayPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();

	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);
	CompanySetupUserPage companySetupUserPage;
	static String fieldName;
	static String Activestatus;
	static String InActivestatus;

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public WorkingDayPage(WebDriver driver) {
		super(driver, "Working Day Page");
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

	public void clickOnWorkingDayPage() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[@data-original-title='Working Day']"), "Working Day", 30);
		try {
			WebElement workingDay = driver
					.findElement(By.xpath("(//div/span[contains(text(),'Working/Non-Working Day')])[last()]"));
			if (workingDay.isDisplayed()) {
				logger.info("Working Day page displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Working Day page not displayed successfully");
			e.printStackTrace();
		}
	}

	public void clickOnAddWorkingDay() {
		staticWait(3000);
		driver.navigate().refresh();
		staticWait(2000);
		click(By.xpath("//div/span/a[@data-original-title='Add Working Day']"), "Add Working Day", 30);
		try {
			WebElement addWorkingDay = driver
					.findElement(By.xpath("//div/span[contains(text(),'Manage Working/Non-Working Day')]"));
			if (addWorkingDay.isDisplayed()) {
				logger.info("Manage Working day page displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Manage Working Day page not displayed successfully");
			e.printStackTrace();
		}
	}

	public void clickOnSaveButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Save']"), "Save Button", 30);

	}

	public void clickOnCancelButton() {
		staticWait(2000);
		click(By.xpath("//div/a[@data-original-title='Cancel']"), "Cancel Button", 30);

	}

	public void clickOnUserGuide() {
		staticWait(2000);
		click(By.xpath("//span/a[text()='User Guide']"), "User Guide Open", 30);
		staticWait(1000);
		click(By.xpath("//span/a[text()='User Guide']"), "User Guide Close", 30);

	}

	public void VerifyMandatoryFieldValidation() {

		int i = 0;

		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='form-group']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "Date ", "Location", "Users", "Comment" };
		for (Object expected : expectedValue) {
			WebElement asterikField = findElementVisibility(By.xpath("//*[text()='" + expected
					+ "']/ancestor::div[@class='form-group']/descendant::span[@class='mandatory']"), 45);

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

	public void clickOnDatePicker() {
		staticWait(3000);
		click(By.xpath("(//div[@data-original-title='Select Date'])[last()]"), "Open Date picker", 30);
		logger.info("Date selected successfully");
		click(By.xpath("(//div[@data-original-title='Select Date'])[last()]"), "Close Date picker", 30);

	}

	public void clickOnSelectLocation() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div/tg-select/select[@id='LocationId']"), prop.getProperty("location"),
				"Location", 30);

	}

	public void clickOnSelectCompanyHolidayRadioButton() {
		staticWait(2000);
		// click(By.xpath("(//div/input[@name='IsWorking'])[2]"), "Radio Button", 30);
		WebElement radioButton = driver.findElement(By.xpath("(//div/input[@name='IsWorking'])[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(radioButton).click().perform();
		logger.info("Company Holiday radio button clicked");
	}

	public void clickOnEnterUsername() {
		staticWait(2000);
		click(By.xpath("//div/button[@title='Select']"), "Select User Name", 30);
		staticWait(1000);
		String name = companySetupUserPage.userNAame;
		enter(By.xpath("//div/input[@placeholder='Enter Keywords']"), prop.getProperty("userFirstName") + " " + name,
				"User Name", 30);
		staticWait(1000);
		click(By.xpath("//a/label[contains(text(),'" + prop.getProperty("userFirstName") + " " + name + "')]"),
				"User Name", 30);

	}

	public void clickOnEnterComment() {
		staticWait(2000);
		click(By.xpath("//div/input[@id='Comment']"), "Comment text field", 30);
		enter(By.xpath("//div/input[@id='Comment']"), prop.getProperty("Description"), "Comment", 30);

	}

	public void validateNotifyMessage() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Status has been successfully saved')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Day's Status hasn't been successfully saved.");
			e.printStackTrace();
		}

	}

	public void clickOnEditButton() {
		staticWait(2000);
		click(By.xpath("//table/tbody/tr/td/a[@id='EditWorkingDay']"), "Edit Button", 30);
		try {
			WebElement manageWorkingDay = driver
					.findElement(By.xpath("//div/span[contains(text(),'Manage Working/Non-Working Day')]"));
			if (manageWorkingDay.isDisplayed()) {
				logger.info("Manage Working day opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Manage Working day not opened");
			e.printStackTrace();
		}

	}

	public void validateNotifyMessageForEdit() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Status has been successfully updated')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Day's Status hasn't been successfully updated.");
			e.printStackTrace();
		}

	}

	public void clickOnDelete() {
		staticWait(2000);
		click(By.xpath("//table/tbody/tr/td/a[@data-original-title='Delete']"), "Delete button", 30);

	}
	public void clickOnConfirmation() {
		staticWait(2000);
		click(By.xpath("//div/button[@title='OK']"), "OK button", 30);

	}
	public void validateNotifyMessageForDelete() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Record(s) deleted successfully')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Record(s) didn't deleted");
			e.printStackTrace();
		}

	}

}
