package pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class StoragePage extends WebBasePage{
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);

	
	
	
	
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public StoragePage(WebDriver driver) {
		super(driver, "Storage Page");
		this.driver = driver;
	}

	public void clickFullMenuDropDown() {
		staticWait(3000);
		click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 30);
		
	}

	public void clickOnGeneralLink() {
		staticWait(2000);
		click(By.xpath("//li[@data-name='General']/span"), "General Link", 30);
		
	}

	public void clickOnStoragePage() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[@data-original-title='Storage']"), "Storage", 30);
		try {
			WebElement storage = driver.findElement(By.xpath("//div/span[contains(text(),'Manage Storage')]"));
			if (storage.isDisplayed()) {
				logger.info("Storage page displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Storage page not displayed successfully");
			e.printStackTrace();
		}
	}
	public void setScreenshotAllocationSpace() {
		staticWait(3000);
		 WebElement slider = driver.findElement(By.xpath("//table/tbody/tr/td/div[@class='jslider-pointer']"));

		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'left: 30%;')",slider);
		    logger.info("ScreenShot Space Allocated succesfully");
	}
	public void setFileAllocationSpace() {
		staticWait(5000);
		 WebElement slider = driver.findElement(By.xpath("(//table/tbody/tr/td/div[@class='jslider-pointer'])[2]"));

		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'left: 44%;')",slider);
		    logger.info("File Space Allocated succesfully");
	}
	public void setDocStorageAllocationSpace() {
		staticWait(2000);
		 WebElement slider = driver.findElement(By.xpath("(//table/tbody/tr/td/div[@class='jslider-pointer'])[3]"));

		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'left: 22%;')",slider);
		    logger.info("Doc Storage Space Allocated succesfully");
	}
	public void setTransactionSizeAllocationSpace() {
		staticWait(2000);
		 WebElement slider = driver.findElement(By.xpath("(//table/tbody/tr/td/div[@class='jslider-pointer'])[4]"));

		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'left: 15%;')",slider);
		    logger.info("Transaction Size Space Allocated succesfully");
	}
	public void clickOnSaveButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[text()='Save']"), "Save Button", 30);
		
	}
	public void validateNotifyMessage() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver.findElement(By.xpath("//div/span[contains(text(),'Storage has been saved successfully')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Storage hasn't been saved successfully");
			e.printStackTrace();
		}
		
	}
}
