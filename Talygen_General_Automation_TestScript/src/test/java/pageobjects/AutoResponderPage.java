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

public class AutoResponderPage extends WebBasePage{
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);

	static String autorespondertitle;
	static String Activestatus;
	static String InActivestatus;
	
	
	
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public AutoResponderPage(WebDriver driver) {
		super(driver, "Auto Responder Page");
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

	public void clickOnAutoResponderPage() {
		staticWait(2000);
		click(By.xpath("//a[contains(text(),'Auto Responder')]"), "Auto Responder", 30);
		try {
			WebElement autoResponder = driver.findElement(By.xpath("//div/span[text()='Auto Responder']"));
			if (autoResponder.isDisplayed()) {
				logger.info("Auto Responder page Opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Auto Responder page not Opened successfully");
		}
		
	}
	public void clickOnAddNewAutoResponderPage() {
		staticWait(2000);
		click(By.xpath("//span/a[@id='ancCreateProject']"), "Add New Auto Responder", 30);
		try {
			WebElement addNewAutoResponder = driver.findElement(By.xpath("//div/span[text()='Manage Auto Responder']"));
			if (addNewAutoResponder.isDisplayed()) {
				logger.info("Manage Auto Responder page Opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Manage Auto Responder page not Opened successfully");
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
		String[] expectedValue = { "Title", "Message" };
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
	public void enterAutoResponderTitle() {
		staticWait(3000);
		autorespondertitle = prop.getProperty("autorespondertitle")+ " "+datevalue;
		enter(By.xpath("//tg-input/input[@id='Title']"), autorespondertitle  , "Auto Responder Title", 20);
	}
	public void enterMessage() {
		staticWait(2000);
		String DescriptionText = prop.getProperty("Description");
		enter(By.xpath("//tg-textarea/textarea[@name='Message']"), DescriptionText, "Auto Responder Message", 20);
	}
	public void validateNotifyMessage() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'Auto Responder successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Auto Responder not added");
			e.printStackTrace();
		}
		
	}
	public void searchByTitle() {
		staticWait(2000);
		click(By.xpath("//div/h5/a/span[text()=' Title ']"), "Title", 30);
		staticWait(1000);
		enter(By.xpath("//div/input[@placeholder='Search By Title']"), autorespondertitle, "Title", 20);
	}
	public void clickOnSearchButton() {
		staticWait(2000);
		click(By.xpath("//span[@id='SearchFilter']"), "Search Button", 30);
		
	}
	public void validateAutoResponderTitleInListingPage() {
		staticWait(2000);
		try {
			WebElement titleName = driver.findElement(By.xpath("//tbody/tr/td/a/span[contains(text(),'"+autorespondertitle+"')]"));
			if (titleName.isDisplayed()) {
				logger.info("Auto Responder Title name is displayed in listing page");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Auto Responder Title name is not displayed in listing page");
			e.printStackTrace();
		}
	}
	public void searchByStatus() {
		staticWait(2000);
		click(By.xpath("//div/h5/a/span[contains(text(),' Status')]"), "Status", 30);
		staticWait(1000);
		enter(By.xpath("//div/input[@placeholder='Search']"), "Active", "Title", 20);
		staticWait(1000);
		click(By.xpath("//label[text()='Active']"), "Active", 30);
	
	}
	
	public void clickOnTitle() {
		staticWait(2000);
		click(By.xpath("//tbody/tr/td/a/span[contains(text(),'"+autorespondertitle+"')]"), " Title", 30);
		try {
			WebElement addNewAutoResponder = driver.findElement(By.xpath("//div/span[text()='Manage Auto Responder']"));
			if (addNewAutoResponder.isDisplayed()) {
				logger.info("Manage Auto Responder page Opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Manage Auto Responder page not Opened successfully");
		}
	}
	public void validateNotifyMessageForUpdate() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'Auto Responder has been successfully updated')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Auto Responder hasn't been successfully updated");
			e.printStackTrace();
		}
		
	}
	public void clickOnCheckBox() {
		staticWait(2000);
		click(By.xpath("//div[@class='custom-control custom-checkbox']"), "Check Box", 30);
		
	}
	public void clickOnDelete() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/span/a[@id='DeleteMultiple']"), "Delete Button", 30);
		
	}
	public void clickOnConfirmationButton() {
		staticWait(2000);
		click(By.xpath("//div/button[@title='OK']"), "Ok Button", 30);
		
	}
	public void validateNotifyMessageForDelete() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'Auto Responder has been successfully deleted')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("//div/span[contains(text(),'Auto Responder hasn't been successfully deleted')]");
			e.printStackTrace();
		}
		
	}
	 public void titleAscending() {
	        titleSorting("ascending");
	    }

	    public void titleDescending() {
	        titleSorting("descending");
	    }
	 public void titleSorting(String order) {
	        List<String> actualSortedArray = new ArrayList<>();

	        click(By.xpath("//table/thead/tr/th/span[@id='NAME']"), "Title", 20);

	        List<WebElement> titleLocators = findMultipleElement(By.xpath("//table[@id='AutoResponderData']//tbody//tr//td[2]/a/span[contains(@class,'dynamic-container')]"), 30);
	        for (WebElement titleName : titleLocators) {
	            actualSortedArray.add(titleName.getText().trim());
	        }

	        if (order.equalsIgnoreCase("ascending")) {
	            verifyAscendingOrder(actualSortedArray, "titleName");
	        } else if (order.equalsIgnoreCase("descending")) {
	            verifyDescendingOrder(actualSortedArray, "titleName");
	        }
	    }
	 public void messageAscending() {
	        designationSorting("ascending");
	    }

	    public void messageDescending() {
	        designationSorting("descending");
	    }

	    public void designationSorting(String order) {
	        List<String> actualSortedArray = new ArrayList<>();

	        click(By.xpath("//table/thead/tr/th/span[@id='DESCRIPTION']"), "Message", 20);

	        List<WebElement> messageLocators = findMultipleElement(By.xpath("//table[@id='AutoResponderData']//tbody//tr//td[3]/span[contains(@class,'dynamic-container')]"), 30);
	        for (WebElement message : messageLocators) {
	            actualSortedArray.add(message.getText().trim());
	        }
	        if (order.equalsIgnoreCase("ascending")) {
	            verifyAscendingOrder(actualSortedArray, "Designation");
	        } else if (order.equalsIgnoreCase("descending")) {
	            verifyDescendingOrder(actualSortedArray, "Designation");
	        }
	    }
	    public void statusAscending() {
	        designationSorting("ascending");
	    }

	    public void statusDescending() {
	        designationSorting("descending");
	    }

	    public void statusSorting(String order) {
	        List<String> actualSortedArray = new ArrayList<>();

	        click(By.xpath("//table/thead/tr/th/span[@id='STATUS']"), "Status", 20);

	        List<WebElement> statusLocators = findMultipleElement(By.xpath("//table[@id='AutoResponderData']//tbody//tr//td/div/select[contains(@class,'ddlupdatestatus')]"), 30);
	        for (WebElement status : statusLocators) {
	            actualSortedArray.add(status.getText().trim());
	        }
	        if (order.equalsIgnoreCase("ascending")) {
	            verifyAscendingOrder(actualSortedArray, "Designation");
	        } else if (order.equalsIgnoreCase("descending")) {
	            verifyDescendingOrder(actualSortedArray, "Designation");
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
