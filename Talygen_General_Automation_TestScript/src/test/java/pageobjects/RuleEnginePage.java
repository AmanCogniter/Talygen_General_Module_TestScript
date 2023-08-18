package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class RuleEnginePage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);

	static String ruleName;
	static String resultType;

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public RuleEnginePage(WebDriver driver) {
		super(driver, "Rule Engine Page");
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

	public void clickOnRuleEnginePage() {
		staticWait(2000);
		click(By.xpath("//a[contains(text(),'Rule Engine')]"), "Rule Engine", 30);
		try {
			WebElement ruleEngine = driver.findElement(By.xpath("//div/span[text()='Rule Engine']"));
			if (ruleEngine.isDisplayed()) {
				logger.info("Rule Engine page Opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Rule Engine page not Opened successfully");
		}

	}

	public void clickOnAddNewRuelPage() {
		staticWait(2000);
		click(By.xpath("//span/a[@data-original-title='Add Rule']"), "Add New Auto Responder", 30);
		try {
			WebElement addNewRuele = driver.findElement(By.xpath("//div/span[text()='Add Rule']"));
			if (addNewRuele.isDisplayed()) {
				logger.info("Add Ruel page Opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Add Rule page not Opened successfully");
		}

	}

	public void clickOnUserGuide() {
		staticWait(3000);
		click(By.xpath("//div/span/a[text()='User Guide']"), "User Guide open", 30);
		staticWait(2000);
		click(By.xpath("//div/span/a[text()='User Guide']"), "User Guide Closed", 30);

	}

	public void clickOnUserGuideOfResult() {
		staticWait(3000);
		click(By.xpath("(//div/span/a[text()='User Guide'])[2]"), "User Guide open", 30);
		staticWait(2000);
		click(By.xpath("(//div/span/a[text()='User Guide'])[2]"), "User Guide Closed", 30);

	}

	public void clickOnSaveButton() {
		staticWait(3000);
		click(By.xpath("//div/a[@data-original-title='Save']"), "Save Button", 30);

	}

	public void clickOnSaveButtonOfResult() {
		staticWait(3000);
		click(By.xpath("(//div/a[@data-original-title='Save'])[last()]"), "Save Button", 30);

	}

	public void clickOnSaveButtonOfTarget() {
		staticWait(3000);
		click(By.xpath("(//div/a[@data-original-title='Save'])[last()]"), "Save Button", 30);

	}

	public void clickOnCloseTargetNotifyPopup() {
		staticWait(3000);
		clickOnSaveButtonOfTarget();
		try {
			WebElement targetRequired = driver.findElement(By.xpath("//div/span[text()='Target is required']"));
			if (targetRequired.isDisplayed()) {
				click(By.xpath("//button[@id='closenotifymessage']"), "Close notify message", 30);
				staticWait(1000);
				clickOnSaveButtonOfTarget();
			}
		} catch (Exception e) {
			// TODO: handle exception
			clickOnAddResult();
		}
	}

	public void clickOnCancelButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Cancel']"), "Cancel Button", 30);

	}

	public void clickOnCloseNotifyMessage() {
		staticWait(2000);
		click(By.xpath("//button[@id='closenotifymessage']"), "Close Notify Message", 30);

	}

	public void VerifyMandatoryFieldValidation() {

		int i = 0;

		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='form-group']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "Rule Name", "Select Module", "Select Action", "Description" };
		for (Object expected : expectedValue) {
			WebElement asterikField = findElementVisibility(By.xpath("//label[text()='" + expected
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

	public void enterRuleName() {
		staticWait(3000);
		ruleName = prop.getProperty("ruleName") + " " + datevalue;
		enter(By.xpath("//tg-input/input[@id='RuleName']"), ruleName, "Rule Name", 20);
	}

	public void clickOnSelectModule() {
		staticWait(2000);
		selectValueWithText(By.xpath("//select[@id='ddlRuleModule']"), "Product Management", "Module", 30);

	}

	public void clickOnSelectAction() {
		staticWait(2000);
		selectValueWithText(By.xpath("//select[@id='ddlRuleModuleActionId']"), "Product Type", "Action", 30);

	}

	public void enterDescription() {
		staticWait(2000);
		String DescriptionText = prop.getProperty("Description");
		enter(By.xpath("//tg-textarea/textarea[@name='Description']"), DescriptionText, "Description", 20);
	}

	public void validateNotifyMessage() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Rule Submitted Successfully')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Rule not added");
			e.printStackTrace();
		}

	}

	public void clickOnRadioButton() {
		staticWait(2000);
		click(By.xpath("//div/input[@name='radioevent']"), "Event Radio Button", 30);

	}

	public void clickOnTarget() {
		staticWait(2000);
		click(By.xpath("//ul/li/p/a[text()='Add Target']"), "Add target", 30);

	}

	public void clickOnSelectRuleTargetFieldID() {
		staticWait(3000);
		selectValueWithText(By.xpath("//div/ul/li/select"), "asset type", "Rule target field id", 30);

	}

	public void clickOnSelectRuleTargetOperatorID() {
		staticWait(3000);
		String selectcondition = prop.getProperty("selectcondition");
		selectValueWithText(By.xpath("(//div/ul/li/select)[2]"), selectcondition, "Rule target operator id", 30);

	}

	public void enterRuleFieldValue() {
		staticWait(3000);
		String rulefieldvalue = prop.getProperty("rulefieldvalue");
		enter(By.xpath("//div/input[@id='txtFirstValue']"), rulefieldvalue, "Rule Field Value", 20);
	}

	public void clickOnAddResult() {
		staticWait(3000);
		click(By.xpath("//ul/li/p/a[text()='Add Result']"), "Add Result", 30);

	}

	public void clickOnSelectResultType() {
		staticWait(2000);
		resultType = prop.getProperty("resultType");
		selectValueWithText(By.xpath("//select[@id='ddlwarningMessageTypeId']"), resultType, "Result Type", 30);

	}

	public void enterWarningMessage() {
		staticWait(3000);

		selectValueWithText(By.xpath("//div/select[@class='form-control ddlresultCriteria']"), prop.getProperty("warningmessage"), "Warning Message", 20);
	}

	public void clickOnPlusIcon() {
		staticWait(2000);
		click(By.xpath("//div/a[@id='ancAddMoreData']"), "Plus Icon", 30);
		staticWait(1000);
		clickByJavascript(By.xpath("//div/a[text()='⤬']"), "Close", 30);

	}

	public void clickOnRuleNameExpand() {
		staticWait(3000);
		click(By.xpath("//div/h5/a/span[text()='Name']"), "Rule Name Expand", 30);

	}

	public void clickOnModuleNameExpand() {
		staticWait(3000);
		click(By.xpath("//div/h5/a/span[text()='Module']"), "Module Name Expand", 30);

	}

	public void enterRuleNameInSearchField() {
		staticWait(2000);

		enter(By.xpath("//div/input[@placeholder='Search by Rule Name']"), ruleName, "Rule Name ", 20);
	}

	public void clickOnSearchButton() {
		staticWait(3000);
		click(By.xpath("//span[@data-original-title='Search']"), "Search Button", 30);

		try {
			WebElement searchRuleName = driver
					.findElement(By.xpath("//table/tbody/tr/td/a[contains(text(),'" + ruleName + "')]"));
			if (searchRuleName.isDisplayed()) {
				logger.info("Rule name displayed in listing page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Rule name not displayed in listing page");
			e.printStackTrace();
		}
	}

	public void enterModuleNameInSearchField() {
		staticWait(2000);

		enter(By.xpath("//div/input[@placeholder='Search']"), "Product Management", "Module Name ", 20);
		staticWait(2000);
		click(By.xpath("//div/label[contains(text(),'Product Management')]"), "Module Name", 30);
	}

	public void clickOnCheckBox() {
		staticWait(3000);
		click(By.xpath("//table/tbody/tr/td/div[@class='custom-control custom-checkbox']"), "CheckBox", 30);
	}

	public void clickOnRemove() {
		staticWait(3000);
		clickByJavascript(By.xpath("//div/span/a[@id='DeleteMultiple']"), "Remove Button", 30);
	}

	public void clickOnConfirmation() {
		staticWait(3000);
		click(By.xpath("//div/button[@title='OK']"), "Confirmation Button", 30);
	}

	public void clickOnConfirmationButtonOfStatus() {
		staticWait(3000);
		click(By.xpath("//div/button[@data-original-title='OK']"), "Confirmation Button", 30);
	}

	public void validateNotifyMessageForDeleteRuleName() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Rule has been successfully deleted')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Rule hasn't been successfully deleted");
			e.printStackTrace();
		}

	}

	public void clickOnRefreshButton() {
		staticWait(3000);
		click(By.xpath("//span/a[@data-original-title='Reset']"), "Reset Button", 30);
	}

	public void checkRefreshButtonFunctionality() {
		staticWait(3000);
		try {
			WebElement rulename = driver.findElement(By.xpath("//div/input[@id='search']"));
			String value = rulename.getAttribute(ruleName);
			if (value == null) {
				logger.info("Reset all the data successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Reset Button not working");
			e.printStackTrace();
		}
	}

	public void clickOnSelectStatusAsInActive() {
		staticWait(2000);

		selectValueWithText(By.xpath("//table/tbody/tr/td/div[@class='cstm-drop-btn']/select"), "Inactive",
				"InActive Status", 30);

	}

	public void clickOnSelectStatusAsActive() {
		staticWait(2000);

		selectValueWithText(By.xpath("//table/tbody/tr/td/div[@class='cstm-drop-btn']/select"), "Active",
				"Active Status", 30);

	}

	public void ruleNameAscending() {
		ruleNameSorting("ascending");
	}

	public void ruleNameDescending() {
		ruleNameSorting("descending");
	}

	public void ruleNameSorting(String order) {
		List<String> actualSortedArray = new ArrayList<>();

		click(By.xpath("//table/thead/tr/th/span[@id='RULE_NAME']"), "Rule Name", 20);

		List<WebElement> ruleNameLocators = findMultipleElement(
				By.xpath("//table[@id='tblRuleEngine']//tbody//tr//td[2]/a"), 30);
		for (WebElement ruleName : ruleNameLocators) {
			actualSortedArray.add(ruleName.getText().trim());
		}

		if (order.equalsIgnoreCase("ascending")) {
			verifyAscendingOrder(actualSortedArray, "Rule Name");
		} else if (order.equalsIgnoreCase("descending")) {
			verifyDescendingOrder(actualSortedArray, "Rule Name");
		}
	}

	public void moduleNameAscending() {
		moduleNameSorting("ascending");
	}

	public void moduleNameDescending() {
		moduleNameSorting("descending");
	}

	public void moduleNameSorting(String order) {
		List<String> actualSortedArray = new ArrayList<>();

		click(By.xpath("//table/thead/tr/th/span[@id='MODULE_NAME']"), "Module Name", 20);

		List<WebElement> moduleNameLocators = findMultipleElement(
				By.xpath("//table[@id='tblRuleEngine']//tbody//tr//td[3]/span"), 30);
		for (WebElement moduleName : moduleNameLocators) {
			actualSortedArray.add(moduleName.getText().trim());
		}

		if (order.equalsIgnoreCase("ascending")) {
			verifyAscendingOrder(actualSortedArray, "Module Name");
		} else if (order.equalsIgnoreCase("descending")) {
			verifyDescendingOrder(actualSortedArray, "Module Name");
		}
	}

	public void lastUpDatedDateAscending() {
		lastUpdatedDateSorting("ascending");
	}

	public void lastUpdatedDateDescending() {
		lastUpdatedDateSorting("descending");
	}

	public void lastUpdatedDateSorting(String order) {
		List<String> actualSortedArray = new ArrayList<>();

		click(By.xpath("//table/thead/tr/th/span[@id='LASTUPDATEDDATE']"), "Last Updated Date", 20);

		List<WebElement> lastUpdatedDateLocators = findMultipleElement(
				By.xpath("//table[@id='tblRuleEngine']//tbody//tr//td[4]/span"), 30);
		for (WebElement lastUpdatedDate : lastUpdatedDateLocators) {
			actualSortedArray.add(lastUpdatedDate.getText().trim());
		}

		if (order.equalsIgnoreCase("ascending")) {
			verifyAscendingOrder(actualSortedArray, "Last Updated Date");
		} else if (order.equalsIgnoreCase("descending")) {
			verifyDescendingOrder(actualSortedArray, "Last Updated Date");
		}
	}

	public void lastUpDatedByAscending() {
		lastUpdatedBySorting("ascending");
	}

	public void lastUpdatedByDescending() {
		lastUpdatedBySorting("descending");
	}

	public void lastUpdatedBySorting(String order) {
		List<String> actualSortedArray = new ArrayList<>();

		click(By.xpath("//table/thead/tr/th/span[@id='LASTUPDATEDBY']"), "Last Updated By", 20);

		List<WebElement> lastUpdatedDateLocators = findMultipleElement(
				By.xpath("//table[@id='tblRuleEngine']//tbody//tr//td[5]/span"), 30);
		for (WebElement lastUpdatedDate : lastUpdatedDateLocators) {
			actualSortedArray.add(lastUpdatedDate.getText().trim());
		}

		if (order.equalsIgnoreCase("ascending")) {
			verifyAscendingOrder(actualSortedArray, "Last Updated By");
		} else if (order.equalsIgnoreCase("descending")) {
			verifyDescendingOrder(actualSortedArray, "Last Updated By");
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
