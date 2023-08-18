package pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class CustomReportsPage extends WebBasePage{
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

	public CustomReportsPage(WebDriver driver) {
		super(driver, "Custom Reports Page");
		this.driver = driver;
	}
	public void clickOnAddReport() {
		staticWait(2000);
		click(By.xpath("//span/a[@data-original-title='Add Report']"), "Add Report", 30);
		
	}
	public void SelectStatusAsInActive() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div[@class='cstm-drop-btn']/select"), "Inactive", "InActive Status", 25);

	}
	public void clickOnConfurmationButton() {
		staticWait(2000);
		click(By.xpath("//div/button[@title='OK']"), "Ok Button", 30);
		
	}
	public void SelectStatusAsActive() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div[@class='cstm-drop-btn']/select"), "Active", "Active Status", 25);

	}
	public void clickOnViewReport() {
		staticWait(2000);
		click(By.xpath("//td/a[@data-original-title='View Report']"), "View Report", 30);
		try {
			WebElement ruleName = driver.findElement(By.xpath("//div/span[contains(text(),'Report Name')]"));
			if (ruleName.isDisplayed()) {
				logger.info("Report Name list page opened");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Report Name list page opened");
			e.printStackTrace();
		}
	}
	public void clickOnCRMTypeRadioButton() {
		staticWait(5000);
		//click(By.xpath("//div/input[@id='rdo_1']"), "Radio Button", 30);
		WebElement radioButton = driver.findElement(By.xpath("//div/input[@id='rdo_1']"));
		Actions action = new Actions(driver);
		action.moveToElement(radioButton).click().perform();
	}
	public void clickOnSearchButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Search']"), "Search Button", 30);
		
	}
	public void verifyReport() {
		staticWait(5000);
		try {
			switchToFrame();
			WebElement report = driver.findElement(By.xpath("//div[text()='Lead Owner']"));
			if (report.isDisplayed()) {
				logger.info("Report Displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Report didn't Displayed ");
			e.printStackTrace();
		}
		driver.navigate().refresh();
		
	}
	public void clickOnClearButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Clear all ']"), "Clear Button", 30);
		
	}

}
