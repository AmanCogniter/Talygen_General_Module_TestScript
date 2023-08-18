package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class ExternalLinkPage extends WebBasePage {
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

	public ExternalLinkPage(WebDriver driver) {
		super(driver, "External Link Page");
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

	public void clickOnExternalLinkPage() {
		staticWait(2000);
		click(By.xpath("(//a[contains(text(),'External Link')])[last()]"), "External Link", 30);

		try {
			WebElement externalLinkPage = driver.findElement(By.xpath("//span[contains(text(),'External Link')]"));
			if (externalLinkPage.isDisplayed()) {
				logger.info("External Link Page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("External Link Page not opened successfully");
		}

	}

	public void clickOnActionButton() {
		staticWait(2000);
		click(By.xpath("//div/a[@class='cht-collapse']/i"), "Close Communication PopUp", 30);
		staticWait(1000);
		click(By.xpath("//span[@class='actions mobileaction']/i"), "Action Button", 30);

	}

	public void clickOnEditExterLink() {
		staticWait(2000);
		click(By.xpath("//a[@data-original-title='Edit']"), "Edit", 30);

		try {
			WebElement manageExternalLink = driver
					.findElement(By.xpath("//div/span[contains(text(),'Manage External Link')]"));
			if (manageExternalLink.isDisplayed()) {
				logger.info("Manage External Link Page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Manage External Link Page not opened successfully");
		}
	}

	public void clickOnPreview() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@id='btnPreview']"), "Preview Button", 30);

		try {
			WebElement previewPage = driver.findElement(By.xpath("//div/h5[text()='Preview']"));
			if (previewPage.isDisplayed()) {
				logger.info("Preview Page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Preview Page not opened successfully");
		}
	}

	public void SelectService() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div/select[@id='ddlServices']"), "Service 1", "Service", 25);

	}

	public void clickOnDay() {
		staticWait(2000);
		click(By.xpath("//span/span[text()='day']"), "Day", 30);

	}

	public void clickOnWeek() {
		staticWait(2000);
		click(By.xpath("//span/span[text()='week']"), "Week", 30);

	}

	public void clickOnPrevious() {
		staticWait(2000);
		click(By.xpath("//span/span[@class='ui-icon ui-icon-circle-triangle-w']"), "Previous", 30);

	}

	public void clickOnNext() {
		staticWait(2000);
		click(By.xpath("//span/span[@class='ui-icon ui-icon-circle-triangle-e']"), "Next", 30);

	}

	public void clickOnClose() {
		staticWait(2000);
		click(By.xpath("//button[@data-original-title='Close']"), "Close Button", 30);

	}

	public void clickOnReset() {
		staticWait(2000);
		click(By.xpath("//div/a[@data-original-title='Reset']"), "Reset", 30);
		staticWait(1000);
		clickOnsave();
		try {
			WebElement reset = driver.findElement(By.xpath("//span/span[contains(text(),'Header Text is required')]"));
			if (reset.isDisplayed()) {
				logger.info("All data Reset successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("All data not Reset successfully");
		}
		driver.navigate().refresh();
	}

	/*
	 * public void enterExternalLink() { staticWait(2000);
	 * 
	 * enter(By.xpath("//tg-input/input[@id='ExternalLink']"), "app" ,
	 * "External Link", 20); } public void enterHeader() { staticWait(2000);
	 * 
	 * enter(By.xpath("//tg-input/input[@id='ExternalLink']"), "app" , "Header",
	 * 20);
	 * 
	 * }
	 */
	public void clickOnsave() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Save']"), "Save Button", 30);

	}

	public void validateNotifyMessage() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(
					By.xpath("//div/span[contains(text(),'External Link has been successfully updated')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("External Link hasn't been successfully updated");
			e.printStackTrace();
		}

	}

	public void clickOnView() {
		staticWait(2000);
		click(By.xpath("//span/a[@data-original-title='View']"), "view", 30);
		String mainId = driver.getWindowHandle();
		Set<String> allID = driver.getWindowHandles();
		for (String id : allID) {
			if (!mainId.equals(id)) {
				driver.switchTo().window(id);
			}
		}
		try {
			staticWait(1000);
			click(By.xpath("//div/button[contains(text(),'Advanced')]"), "Advanced", 30);
			staticWait(1000);
			click(By.xpath("//div/p/a[@id='proceed-link']"), "proceed-link", 30);
			waitForVisibilityOfElement(By.xpath("//div/a/img[@title='Talygen Time Tracking Tool']"), 50);
			WebElement newpage = driver.findElement(By.xpath("//div/a/img[@title='Talygen Time Tracking Tool']"));
			if (newpage.isDisplayed()) {
				logger.info("External Link Page Url Page opened succesfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			waitForVisibilityOfElement(By.xpath("//div/a/img[@title='Talygen Time Tracking Tool']"), 50);
			WebElement newpage = driver.findElement(By.xpath("//div/a/img[@title='Talygen Time Tracking Tool']"));
			if (newpage.isDisplayed()) {
				logger.info("External Link Page Url Page opened succesfully");
			} else {
				logger.info("External Link Page Url Page not opened succesfully");
				e.printStackTrace();
			}
		}

		driver.switchTo().window(mainId);
	}

	public void clickOnCopyExternalLink() throws AWTException {
		staticWait(2000);
		click(By.xpath("//span/a[@data-original-title='Copy External Link']"), "Copy External Link", 30);
		staticWait(1000);
		driver.switchTo().alert().accept();

		logger.info(driver.getCurrentUrl());

	}
}
