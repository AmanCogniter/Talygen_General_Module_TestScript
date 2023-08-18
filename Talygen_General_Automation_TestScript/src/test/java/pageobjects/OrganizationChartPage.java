package pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class OrganizationChartPage extends WebBasePage {
	WebDriver driver;
	

	static String autorespondertitle;
	
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public OrganizationChartPage(WebDriver driver) {
		super(driver, "Organization Chart Page");
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

	public void clickOnOrganizationChartPage() {
		staticWait(2000);
		click(By.xpath("//a[contains(text(),'Organization Chart')]"), "Organization Chart", 30);
		try {
			WebElement organizationChart = driver.findElement(By.xpath("//div/span[text()='Organization Chart']"));
			if (organizationChart.isDisplayed()) {
				logger.info("Organization Chart page Opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Organization Chart page not Opened successfully");
		}

	}
	public void clickOnUserGuide() {
		staticWait(2000);
		click(By.xpath("//div/span/a[text()='User Guide']"), "User Guide open", 30);
		try {
			staticWait(2000);
			WebElement userGuide = driver.findElement(By.xpath("//div/h5[contains(text(),'Organization Chart')]"));
			if (userGuide.isDisplayed()) {
				logger.info("User Guide Opened successfully");
				staticWait(2000);
				click(By.xpath("//div/h5[contains(text(),'Organization Chart')]/ancestor::div[@class='modal-content']/descendant::button[@data-original-title='Close']"), "User Guide Closed", 30);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("User Guide not Opened successfully");
		}
		
		
	}
	public void clickOnChangeRoot() {
		staticWait(2000);
		clickByJavascript(By.xpath("//span/a[@data-original-title='Change Root Member']"), "Change Root Memeber", 30);
		try {
			WebElement changeRootMemeber = driver.findElement(By.xpath("//div/h5[contains(text(),'Replace Root Member With')]"));
			if (changeRootMemeber.isDisplayed()) {
				logger.info("Replace Root Member page Opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Replace Root Member page not Opened successfully");
		}
	}
	public void clickOnSelectUser() {
		staticWait(2000);
		click(By.xpath("//select[@id='NewManagerId']"), "Select User", 30);
		staticWait(1000);
		click(By.xpath("//select[@id='NewManagerId']/option[2]"), "User", 30);

	}
	public void clickOnSaveButton() {
		staticWait(2000);
		click(By.xpath("//div/a[text()='Save']"), "Save Button", 30);
		

	}
	public void validateNotifyMessageForWithouSelectUser() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[text()='Please select user']"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
				click(By.xpath("//button[@id='closenotifymessage']"), "Close Button", 30);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("User is Selected");
			e.printStackTrace();
		}
		
	}
	public void validateNotifyMessage() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'Primary Manager has been changed successfully')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Primary Manager hasn't been changed successfully");
			e.printStackTrace();
		}
		
	}
}
