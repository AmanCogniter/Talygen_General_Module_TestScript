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

public class ManageTagsPage extends WebBasePage{
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);

	static String tagName;
	static String Activestatus;
	static String InActivestatus;
	
	
	
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public ManageTagsPage(WebDriver driver) {
		super(driver, "Manage Tags Page");
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

	public void clickOnManageTagsPage() {
		staticWait(2000);
		click(By.xpath("//a[contains(text(),'Manage Tags')]"), "Manage Tags", 30);
		try {
			WebElement manageTags = driver.findElement(By.xpath("//div/span[text()='Tag']"));
			if (manageTags.isDisplayed()) {
				logger.info("Tag page Opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Tag page not Opened successfully");
		}
		
	}
	public void clickOnAddNewTagPage() {
		staticWait(2000);
		click(By.xpath("//span/a[@id='ancCreateTag']"), "Add New Tag", 30);
		try {
			WebElement addNewTag = driver.findElement(By.xpath("//div/span[text()='Add']"));
			if (addNewTag.isDisplayed()) {
				logger.info("Add New Tag page Opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Add New Tag page not Opened successfully");
		}
		
	}
	public void clickOnUserGuide() {
		staticWait(2000);
		click(By.xpath("//div/span/a[text()='User Guide']"), "User Guide open", 30);
		staticWait(2000);
		click(By.xpath("//div/span/a[text()='User Guide']"), "User Guide Closed", 30);
		
	}
	public void clickOnSaveButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/button[@data-original-title='Save']"), "Save Button", 30);
		
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
		String[] expectedValue = { "Tag Name"};
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
	public void enterTagName() {
		staticWait(3000);
		tagName = prop.getProperty("tagName")+ " "+datevalue;
		enter(By.xpath("//input[@id='TagName']"), tagName  , "Tag Name", 20);
	}
	public void clickOnSelectStatus() {
		staticWait(2000);
		selectValueWithText(By.xpath("//select[@id='StatusId']"), "Inactive", "Status", 30);
		
	}
	public void enterDescription() {
		staticWait(3000);
		String description = prop.getProperty("Description");
		enter(By.xpath("//tg-textarea/textarea[@id='TagDescription']"), description  , "Description", 20);
	}
	public void validateNotifyMessage() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'Tag successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Tag successfully not added");
			e.printStackTrace();
		}
		
	}
	public void enterTagNameIntoSearchTextField() {
		staticWait(3000);
		
		enter(By.xpath("//div/input[@id='search']"), tagName  , "Tag Name", 20);
	}
	public void clickOnRefreshButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Clear all ']"), "Refresh Button", 30);
	}
	public void clickOnSearchButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Search']"), "Search Button", 30);
		staticWait(3000);
		try {
			WebElement tagname = driver.findElement(By.xpath("//a/span[contains(text(),'"+tagName+"')]"));
			if (tagname.isDisplayed()) {
				logger.info("Tag is available in tag listing page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Tag is not available in tag listing page");
			e.printStackTrace();
		}
		
	}
	public void clickOnCheckBox() {
		staticWait(2000);
		click(By.xpath("//table/tbody/tr/td/div[@class='custom-control custom-checkbox']"), "Check Box", 30);
		
	}
	public void clickOnDeleteButton() {
		staticWait(2000);
		click(By.xpath("//a/span[text()='Delete']"), "Delete Button", 30);
		
	}
	public void clickOnConfirmationButton() {
		staticWait(2000);
		click(By.xpath("//button[@title='OK']"), "Ok Button", 30);
		
	}
	public void validateNotifyMessageForDelete() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'Tag has been successfully deleted')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Tag hasn't been successfully deleted");
			e.printStackTrace();
		}
		
	}
	public void clickOnInactiveButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//a[@data-original-title='Inactive']"), "InActive Button", 30);
		
	}
	public void clickOnActiveButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//a[@data-original-title='Active']"), "Active Button", 30);
		
	}
	public void validateNotifyMessageForUpdate() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'Tag has been successfully updated')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Tag hasn't been successfully updated");
			e.printStackTrace();
		}
		
	}
	public void clickOnSelectInActiveStatusFromDropDown() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div[@class='cstm-drop-btn']/select"), "Inactive", "Status", 30);
		
	}
	public void clickOnSelectActiveStatusFromDropDown() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div[@class='cstm-drop-btn']/select"), "Active", "Status", 30);
		
	}
	public void clickOnEditButton() {
		staticWait(2000);
		click(By.xpath("//table/tbody/tr/td/a[@data-original-title='Edit']"), "Edit Button", 30);
		try {
			WebElement update = driver.findElement(By.xpath("//div/span[text()='Update']"));
			if (update.isDisplayed()) {
				logger.info("Update page displayed succesfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Update page not displayed succesfully");
		}
	}
	 public void tagNAmeAscending() {
		 tagNameSorting("ascending");
	    }

	    public void tagNameDescending() {
	    	tagNameSorting("descending");
	    }
	 public void tagNameSorting(String order) {
	        List<String> actualSortedArray = new ArrayList<>();

	        click(By.xpath("//table/thead/tr/th/span[@id='NAME']"), "Title", 20);

	        List<WebElement> titleLocators = findMultipleElement(By.xpath("//table[@id='tblTags']//tbody//tr//td[2]/a/span[contains(@class,'dynamic-container')]"), 30);
	        for (WebElement titleName : titleLocators) {
	            actualSortedArray.add(titleName.getText().trim());
	        }

	        if (order.equalsIgnoreCase("ascending")) {
	            verifyAscendingOrder(actualSortedArray, "Tag Name");
	        } else if (order.equalsIgnoreCase("descending")) {
	            verifyDescendingOrder(actualSortedArray, "Tag Name");
	        }
	    }
	 public void descriptionAscending() {
		 descriptionSorting("ascending");
	    }

	    public void descriptionDescending() {
	    	descriptionSorting("descending");
	    }
	 public void descriptionSorting(String order) {
	        List<String> actualSortedArray = new ArrayList<>();

	        click(By.xpath("//table/thead/tr/th/span[@id='DESCRIPTION']"), "Description", 20);

	        List<WebElement> titleLocators = findMultipleElement(By.xpath("//td[3]/span[contains(@class,'dynamic-container')]"), 30);
	        for (WebElement titleName : titleLocators) {
	            actualSortedArray.add(titleName.getText().trim());
	        }

	        if (order.equalsIgnoreCase("ascending")) {
	            verifyAscendingOrder(actualSortedArray, "DESCRIPTION");
	        } else if (order.equalsIgnoreCase("descending")) {
	            verifyDescendingOrder(actualSortedArray, "DESCRIPTION");
	        }
	    }
	 public void verifyAscendingOrder(List<String> actualSortedArray, String fieldName) {
	        List<String> result = new ArrayList<>();
	        List<String> expectedSortedList = new ArrayList<>(actualSortedArray);
	        expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER);
	        for(int i =0; i<expectedSortedList.size();i++)
	        {
	            if (expectedSortedList.get(i).equalsIgnoreCase(actualSortedArray.get(i)))
	            {
	                result.add("true");
	            }
	            else
	            {
	                result.add("false");
	            }
	        }
	        if (!result.contains("false")) {
	            getTest().log(LogStatus.PASS, fieldName + "s are sorted in ascending Order when click the " + fieldName + " header for one time");
	            logger.info(fieldName + "s are sorted in ascending Order when click the " + fieldName + " header for one time");
	        } else {
	            getTest().log(LogStatus.FAIL, fieldName + "s are not sorted in ascending Order when click the " + fieldName + " header for one time");
	            logger.info(fieldName + "s are not sorted in ascending Order when click the " + fieldName + " header for one time");
	            takeScreenshot(fieldName + "Ascending");
	        }
	    }
	 public void verifyDescendingOrder(List<String> actualSortedArray, String fieldName) {
	        List<String> result = new ArrayList<>();
	        List<String> expectedSortedList = new ArrayList<>(actualSortedArray);
	        expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER);
	        Collections.reverse(expectedSortedList);
	        for(int i =0; i<expectedSortedList.size();i++)
	        {
	            if (expectedSortedList.get(i).equalsIgnoreCase(actualSortedArray.get(i)))
	            {
	                result.add("true");
	            }
	            else
	            {
	                result.add("false");
	            }
	        }
	        if (!result.contains("false")) {
	            getTest().log(LogStatus.PASS, fieldName + "s are sorted in descending Order when click the " + fieldName + " header for two times");
	            logger.info(fieldName + "s are sorted in descending Order when click the " + fieldName + " header for two times");
	        } else {
	            getTest().log(LogStatus.FAIL, fieldName + "s are not sorted in descending Order when click the " + fieldName + " header for two times");
	            logger.info(fieldName + "s are not sorted in descending Order when click the " + fieldName + " header for two times");
	            takeScreenshot(fieldName + "Descending");
	        }
	    }
}
