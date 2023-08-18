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

public class ProvisionalRightPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);

	static String provisionalRightsName;
	static String Activestatus;
	static String InActivestatus;

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public ProvisionalRightPage(WebDriver driver) {
		super(driver, "Provisional Right Page");
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

	public void clickOnProvisionalRightsPage() {
		staticWait(2000);
		click(By.xpath("//a[contains(text(),'Provisional Rights')]"), "Provisional Rights", 30);
		try {
			WebElement provisionalRightsListingPage = driver
					.findElement(By.xpath("//div/span[text()='Provisional Rights']"));
			if (provisionalRightsListingPage.isDisplayed()) {
				logger.info("Provisional Rights listing page Opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Provisional Rights listing page not Opened successfully");
		}

	}

	public void clickOnAddNewProvisionalRightsPage() {
		staticWait(2000);
		click(By.xpath("//span/a/span[text()=' Add Provisional Rights']"), " Add Provisional Rights", 30);
		try {
			WebElement addNewProvisionalRights = driver
					.findElement(By.xpath("//div/span[text()='Add Provisional Rights']"));
			if (addNewProvisionalRights.isDisplayed()) {
				logger.info("Add Provisional Rights page Opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Add Provisional Rights page not Opened successfully");
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

	public void clickOnEffectiveFrom() {
		staticWait(2000);
		click(By.xpath("(//div[@data-original-title='Select Date']/span)[3]"), "Effective From ", 30);
		staticWait(1000);
		clickByJavascript(By.xpath("//table/tbody/tr/td/a[@title='Clear selection']"), "Clear All", 30);

	}

	public void clickOnEffectiveTo() {
		staticWait(2000);
		click(By.xpath("(//div[@data-original-title='Select Date']/span)[last()]"), "Effective From ", 30);
		staticWait(1000);
		clickByJavascript(By.xpath("//table/tbody/tr/td/a[@title='Clear selection']"), "Clear All", 30);

	}

	public void VerifyMandatoryFieldValidation() {

		int i = 0;

		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='form-group']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "Provisional Rights Name ", "Assigned From", "Assigned To", "Effective From ",
				"Effective To " };
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

	public void enterProvisionalRightsName() {
		staticWait(3000);
		provisionalRightsName = prop.getProperty("provisionalRightsName") + "" + datevalue;
		enter(By.xpath("//div/input[@id='ProvisionalRightName']"), provisionalRightsName, "Provisional Right Name", 20);
	}

	public void selectAssignedFromUser() {
		staticWait(3000);

		selectValueWithText(By.xpath("//div/select[@id='FromUserId']"), prop.getProperty("assignedfromUser"),
				"Assigned From User", 20);
	}

	public void selectAssignedToUser() {
		staticWait(3000);

		selectValueWithText(By.xpath("//div/select[@id='ToUserId']"), prop.getProperty("assignedToUser"),
				"Assigned To User", 20);
	}

	public void selectStatus() {
		staticWait(3000);

		selectValueWithText(By.xpath("//div/select[@id='StatusId']"), "Inactive", "Status", 20);
	}

	public void validateNotifyMessage() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Provisional Rights successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Provisional Rights not added");
			e.printStackTrace();
		}

	}

	public void clickOnStatus() {
		staticWait(3000);

		click(By.xpath("//div/h5/a[@data-toggle='collapse']/span[contains(text(),'Status')]"), "Status", 20);
		staticWait(1000);
		enter(By.xpath("//div/input[@placeholder='Search']"), "Inactive", "Status", 20);
		staticWait(1000);
		click(By.xpath("//label[text()='Inactive']"), "InActive Status", 20);
	}
	public void clickOnSearch() {
		staticWait(2000);

		click(By.xpath("//span[@id='Go']"), "Search", 20);
		
		try {
			WebElement provisionalRight = driver.findElement(By.xpath("//table/tbody/tr/td/a/span[contains(text(),'"+provisionalRightsName+"')]"));
			if (provisionalRight.isDisplayed()) {
				logger.info("Provisional Rights Name is Displayed on Listing page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Provisional Rights Name isn't Displayed on Listing page");
		}
	}
	public void clickOnCheckBox() {
		staticWait(2000);

		click(By.xpath("//table/tbody/tr/td/div/div[@class='custom-control custom-checkbox']"), "CheckBox", 20);
}
	public void clickOnDelete() {
		staticWait(2000);

		clickByJavascript(By.xpath("//a[@id='DeleteMultiple']"), "Delete Button", 20);
}
	public void clickOnConfirmation(){
		staticWait(2000);

		click(By.xpath("//div/button[@title='OK']"), "Confirmation", 20);
}
	public void clickOnAssignedFromSearchFilter(){
		staticWait(2000);

		click(By.xpath("//div/h5/a/span[contains(text(),' Assigned From ')]"), "Assigned from Search Filter", 20);
		staticWait(1000);
		enter(By.xpath("//div/input[@id='assignedFrom']"), "ginny", "Assigned From", 20);
}
	public void clickOnAssignedToSearchFilter(){
		staticWait(2000);

		click(By.xpath("//div/h5/a/span[contains(text(),' Assigned To ')]"), "Assigned To Search Filter", 20);
		staticWait(1000);
		enter(By.xpath("//div/input[@id='assignedTo']"), "David Bush", "Assigned To", 20);
}
	public void clickOnActiveStatus() {
		staticWait(2000);

		clickByJavascript(By.xpath("//div/span/a[@data-original-title='Active']"), "Active Button", 20);
}
	public void clickOnInActiveStatus() {
		staticWait(2000);

		clickByJavascript(By.xpath("//div/span/a[@data-original-title='Inactive']"), "InActive Button", 20);
}
	public void validateNotifyMessageForUpdate() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Provisional Rights has been successfully updated')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Provisional Rights hasn't been successfully updated");
			e.printStackTrace();
		}

	}
	 public void provisionalRightNameAscending() {
		 provisionalRightNameSorting("ascending");
	    }

	    public void provisionalRightNameDescending() {
	    	provisionalRightNameSorting("descending");
	    }
	 public void provisionalRightNameSorting(String order) {
	        List<String> actualSortedArray = new ArrayList<>();

	        click(By.xpath("//table/thead/tr/th/span[@id='PROVISIONAL_RIGHT_NAME']"), "Provisional Right Name", 20);

	        List<WebElement> provisionalRightsNameLocators = findMultipleElement(By.xpath("//table[@id='AutoResponderData']//tbody//tr//td[2]/a/span[contains(@class,'dynamic-container')]"), 30);
	        for (WebElement provisionalRightsName : provisionalRightsNameLocators) {
	            actualSortedArray.add(provisionalRightsName.getText().trim());
	        }

	        if (order.equalsIgnoreCase("ascending")) {
	            verifyAscendingOrder(actualSortedArray, "Provisional Right Name");
	        } else if (order.equalsIgnoreCase("descending")) {
	            verifyDescendingOrder(actualSortedArray, "Provisional Right Name");
	        }
	    }
	 public void assignedFromAscending() {
		 assignedFromSorting("ascending");
	    }

	    public void assignedFromDescending() {
	    	assignedFromSorting("descending");
	    }
	 public void assignedFromSorting(String order) {
	        List<String> actualSortedArray = new ArrayList<>();

	        click(By.xpath("//table/thead/tr/th/span[@id='FROM_USER_NAME']"), "Assigned From", 20);

	        List<WebElement> assignedForLocators = findMultipleElement(By.xpath("//table[@id='AutoResponderData']//tbody//tr//td[3]/span[contains(@class,'dynamic-container')]"), 30);
	        for (WebElement assignedFrom : assignedForLocators) {
	            actualSortedArray.add(assignedFrom.getText().trim());
	        }

	        if (order.equalsIgnoreCase("ascending")) {
	            verifyAscendingOrder(actualSortedArray, "Assigned From ");
	        } else if (order.equalsIgnoreCase("descending")) {
	            verifyDescendingOrder(actualSortedArray, "Assigned From ");
	        }
	    }
	 public void assignedToAscending() {
		 assignedToSorting("ascending");
	    }

	    public void assignedToDescending() {
	    	assignedToSorting("descending");
	    }
	 public void assignedToSorting(String order) {
	        List<String> actualSortedArray = new ArrayList<>();

	        click(By.xpath("//table/thead/tr/th/span[@id='TO_USER_NAME']"), "Assigned To", 20);

	        List<WebElement> assignedToLocators = findMultipleElement(By.xpath("//table[@id='AutoResponderData']//tbody//tr//td[4]/span[contains(@class,'dynamic-container')]"), 30);
	        for (WebElement assignedTo : assignedToLocators) {
	            actualSortedArray.add(assignedTo.getText().trim());
	        }

	        if (order.equalsIgnoreCase("ascending")) {
	            verifyAscendingOrder(actualSortedArray, "Assigned To");
	        } else if (order.equalsIgnoreCase("descending")) {
	            verifyDescendingOrder(actualSortedArray, "Assigned To");
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

	        List<WebElement> descriptionLocators = findMultipleElement(By.xpath("//table[@id='AutoResponderData']//tbody//tr//td[5]/span[contains(@class,'dynamic-container')]"), 30);
	        for (WebElement description : descriptionLocators) {
	            actualSortedArray.add(description.getText().trim());
	        }

	        if (order.equalsIgnoreCase("ascending")) {
	            verifyAscendingOrder(actualSortedArray, "Description");
	        } else if (order.equalsIgnoreCase("descending")) {
	            verifyDescendingOrder(actualSortedArray, "Description");
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

	        click(By.xpath("//table/thead/tr/th/span[@id='Status']"), "Status", 20);

	        List<WebElement> statusLocators = findMultipleElement(By.xpath("//table[@id='AutoResponderData']//tbody//tr//td[8]"), 30);
	        for (WebElement status : statusLocators) {
	            actualSortedArray.add(status.getText().trim());
	        }

	        if (order.equalsIgnoreCase("ascending")) {
	            verifyAscendingOrder(actualSortedArray, " Status ");
	        } else if (order.equalsIgnoreCase("descending")) {
	            verifyDescendingOrder(actualSortedArray, " Status ");
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
