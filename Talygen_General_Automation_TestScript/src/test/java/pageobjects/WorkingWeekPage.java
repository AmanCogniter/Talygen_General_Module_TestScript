package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class WorkingWeekPage extends WebBasePage {
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

	public WorkingWeekPage(WebDriver driver) {
		super(driver, "Working Week Page");
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

	public void clickOnWorkingWeekPage() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[@data-original-title='Working Week']"), "Working Week", 30);
		try {
			WebElement workingWeek = driver
					.findElement(By.xpath("//div/span[contains(text(),'Setup for the working week')]"));
			if (workingWeek.isDisplayed()) {
				logger.info("Working Week page displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Working Week page not displayed successfully");
			e.printStackTrace();
		}
	}

	public void clickOnUserGuide() {
		staticWait(2000);
		click(By.xpath("//span/a[text()='User Guide']"), "User Guide Open", 30);
		staticWait(1000);
		click(By.xpath("//span/a[text()='User Guide']"), "User Guide Close", 30);

	}

	public void clickOnSelectChooseShift() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div/select[@name='Shift']"), prop.getProperty("shift"), "Shift", 30);
		try {
			staticWait(3000);
			WebElement workingDay = driver.findElement(By.xpath("//div/span[contains(text(),'Working Day')]"));
			if (workingDay.isDisplayed()) {
				logger.info("All Working and NonWorking day displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("All Working and NonWorking day not displayed successfully");
			e.printStackTrace();
		}
	}

	public void clickOnSelectWorkingOrNonWorkingDay() throws AWTException {
		staticWait(2000);
		Robot robot = new Robot();
		try {
			List<WebElement> days = driver.findElements(By.xpath("//table/tbody/tr/th"));
			for (WebElement e : days) {

				String workingDays = e.getText();
				if(workingDays.contains("Monday")){
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[2]"), "Monday Working Off radio button", 30);
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[1]"), "Monday Working  radio button", 30);
					click(By.xpath("//div[contains(@id,'divShowfromtimepicker')]"), "Monday Work Start time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					staticWait(1000);
					robot.keyPress(KeyEvent.VK_8);
					robot.keyRelease(KeyEvent.VK_8);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					//enter(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[1]"), prop.getProperty("Timefrom") ,"Monday Work Start time", 30);
					//driver.findElement(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[1]")).sendKeys("8:00 AM");
					logger.info("Monday Work Start time enter into text field");
					click(By.xpath("(//div[contains(@id,'divShowtotimepicker')])[1]"), "Monday Work Stop time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					//enter(By.xpath("//div[contains(@id,'divShowtotimepicker')]"), prop.getProperty("TimeTo") ,"Monday Work Stop time", 30);
					robot.keyPress(KeyEvent.VK_5);
					robot.keyRelease(KeyEvent.VK_5);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_P);
					robot.keyRelease(KeyEvent.VK_P);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					logger.info("Monday Work Stop time enter into text field");
				}else if (workingDays.contains("Tuesday")) {
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[4]"), "Tuesday Working Off radio button", 30);
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[3]"), "Tuesday Working  radio button", 30);
					click(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[2]"), "Tuesday Work Start time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					/*
					 * enter(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[2]"),
					 * prop.getProperty("Timefrom") , "Tuesday Work Start time", 30);
					 */
					staticWait(1000);
					robot.keyPress(KeyEvent.VK_8);
					robot.keyRelease(KeyEvent.VK_8);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					logger.info("Tuesday Work Start time enter into text field");
					click(By.xpath("(//div[contains(@id,'divShowtotimepicker')])[2]"), "Tuesday Work Stop time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					/*
					 * enter(By.xpath("(//div[contains(@id,'divShowtotimepicker')])[2]"),
					 * prop.getProperty("TimeTo") , "Tuesday Work Stop time", 30);
					 */
					robot.keyPress(KeyEvent.VK_5);
					robot.keyRelease(KeyEvent.VK_5);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_P);
					robot.keyRelease(KeyEvent.VK_P);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					logger.info("Tuesday Work Stop time enter into text field");
				}else if (workingDays.contains("Wednesday")) {
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[6]"), "Wednesday Working Off radio button", 30);
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[5]"), "Wednesday Working  radio button", 30);
					click(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[3]"), "Wednesday Work Start time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					/*
					 * enter(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[3]"),
					 * prop.getProperty("Timefrom") , "Wednesday Work Start time", 30);
					 */
					staticWait(1000);
					robot.keyPress(KeyEvent.VK_8);
					robot.keyRelease(KeyEvent.VK_8);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					logger.info("Wednesday Work Start time enter into text field");
					click(By.xpath("(//div[contains(@id,'divShowtotimepicker')])[3]"), "Wednesday Work Stop time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					/*
					 * enter(By.xpath("(//div[contains(@id,'divShowtotimepicker')])[3]"),
					 * prop.getProperty("TimeTo") , "Wednesday Work Stop time", 30);
					 */
					robot.keyPress(KeyEvent.VK_5);
					robot.keyRelease(KeyEvent.VK_5);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_P);
					robot.keyRelease(KeyEvent.VK_P);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					logger.info("Wednesday Work Stop time enter into text field");
				}else if (workingDays.contains("Thursday")) {
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[8]"), "Thursday Working Off radio button", 30);
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[7]"), "Thursday Working  radio button", 30);
					click(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[4]"), "Thursday Work Start time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					/*
					 * enter(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[4]"),
					 * prop.getProperty("Timefrom") , "Thursday Work Start time", 30);
					 */
					staticWait(1000);
					robot.keyPress(KeyEvent.VK_8);
					robot.keyRelease(KeyEvent.VK_8);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					logger.info("Thursday Work Start time enter into text field");
					click(By.xpath("(//div[contains(@id,'divShowtotimepicker')])[4]"), "Thursday Work Stop time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					/*
					 * enter(By.xpath("(//div[contains(@id,'divShowtotimepicker')])[4]"),
					 * prop.getProperty("TimeTo") , "Thursday Work Stop time", 30);
					 */
					robot.keyPress(KeyEvent.VK_5);
					robot.keyRelease(KeyEvent.VK_5);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_P);
					robot.keyRelease(KeyEvent.VK_P);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					logger.info("Thursday Work Stop time enter into text field");
				}else if (workingDays.contains("Friday")) {
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[10]"), "Friday Working Off radio button", 30);
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[9]"), "Friday Working  radio button", 30);
					click(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[5]"), "Friday Work Start time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					/*
					 * enter(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[5]"),
					 * prop.getProperty("Timefrom") , "Friday Work Start time", 30);
					 */
					staticWait(1000);
					robot.keyPress(KeyEvent.VK_8);
					robot.keyRelease(KeyEvent.VK_8);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					logger.info("Friday Work Start time enter into text field");
					click(By.xpath("(//div[contains(@id,'divShowtotimepicker')])[5]"), "Friday Work Stop time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					/*
					 * enter(By.xpath("(//div[contains(@id,'divShowtotimepicker')])[5]"),
					 * prop.getProperty("TimeTo") , "Friday Work Stop time", 30);
					 */
					robot.keyPress(KeyEvent.VK_5);
					robot.keyRelease(KeyEvent.VK_5);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_P);
					robot.keyRelease(KeyEvent.VK_P);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					logger.info("Friday Work Stop time enter into text field");
				}else if (workingDays.contains("Saturday")) {
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[11]"), "Saturday Working  radio button", 30);
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[12]"), "Saturday Working Off radio button", 30);
					click(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[6]"), "Saturday Work Start time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					/*
					 * enter(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[6]"),
					 * prop.getProperty("Timefrom") , "Saturday Work Start time", 30);
					 */
					staticWait(1000);
					robot.keyPress(KeyEvent.VK_8);
					robot.keyRelease(KeyEvent.VK_8);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					logger.info("Saturday Work Start time enter into text field");
					click(By.xpath("(//div[contains(@id,'divShowtotimepicker')])[6]"), "Saturday Work Stop time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					/*
					 * enter(By.xpath("(//div[contains(@id,'divShowtotimepicker')])[6]"),
					 * prop.getProperty("TimeTo") , "Saturday Work Stop time", 30);
					 */
					robot.keyPress(KeyEvent.VK_5);
					robot.keyRelease(KeyEvent.VK_5);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_P);
					robot.keyRelease(KeyEvent.VK_P);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					logger.info("Saturday Work Stop time enter into text field");
				}else if (workingDays.contains("Sunday")) {
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[13]"), "Sunday Working  radio button", 30);
					click(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[14]"), "Sunday Working Off radio button", 30);
					click(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[7]"), "Sunday Work Start time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					/*
					 * enter(By.xpath("(//div[contains(@id,'divShowfromtimepicker')])[7]"),
					 * prop.getProperty("Timefrom") , "Sunday Work Start time", 30);
					 */
					staticWait(1000);
					robot.keyPress(KeyEvent.VK_8);
					robot.keyRelease(KeyEvent.VK_8);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					logger.info("Sunday Work Start time enter into text field");
					click(By.xpath("(//div[contains(@id,'divShowtotimepicker')])[7]"), "Sunday Work Stop time text field", 30);
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyPress(KeyEvent.VK_BACK_SPACE);
					robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					/*
					 * enter(By.xpath("(//div[contains(@id,'divShowtotimepicker')])[7]"),
					 * prop.getProperty("TimeTo") , "Sunday Work Stop time", 30);
					 */
					robot.keyPress(KeyEvent.VK_5);
					robot.keyRelease(KeyEvent.VK_5);
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
					robot.keyPress(KeyEvent.VK_SHIFT);
					robot.keyPress(KeyEvent.VK_P);
					robot.keyRelease(KeyEvent.VK_P);
					robot.keyPress(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_M);
					robot.keyRelease(KeyEvent.VK_SHIFT);
					logger.info("Sunday Work Stop time enter into text field");
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("All Working and NonWorking day not displayed successfully");
			e.printStackTrace();
		}
	}
	public void clickOnSaveButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Save']"), "Save Button", 30);

	}
	public void clickOnOKButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//button[@title='OK']"), "OK Button", 30);

	}
	public void validateNotifyMessage() {
		staticWait(2000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Working Week has been successfully saved')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Working Week hasn't been successfully saved");
			e.printStackTrace();
		}

	}
	public void clickOnResetButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Reset']"), "Reset Button", 30);
		try {
		 WebElement workingDay = driver.findElement(By.xpath("//div/span[contains(text(),'Working Day')]"));
		 if (workingDay.isDisplayed()) {
			 logger.info("Reset Button not clicked");
		}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Reset Button working properly");
		}
	}

}
