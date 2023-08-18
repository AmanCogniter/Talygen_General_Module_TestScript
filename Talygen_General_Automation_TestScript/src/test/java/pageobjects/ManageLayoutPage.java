package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.PropertiesLoader;
import utils.WebBasePage;

public class ManageLayoutPage extends WebBasePage{
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
	
	public ManageLayoutPage(WebDriver driver) {
		super(driver, "Manage Layout Page");
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

	public void clickOnManageLayoutPage() {
		staticWait(2000);
		click(By.xpath("//a[contains(text(),'Manage Layout')]"), "Manage Layout", 30);

		try {
			WebElement manageLayoutPage = driver.findElement(By.xpath("//div/span[contains(text(),'Manage Layout')]"));
			if (manageLayoutPage.isDisplayed()) {
				logger.info("Manage Layout Page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Manage Layout Page not opened successfully");
		}

	}
	public void SelectModule() throws AWTException {
				staticWait(5000);
		//selectValueWithText(By.xpath("//div/span[contains(text(),'Manage Layout')]/ancestor::section[@id='divMainLeadData']/descendant::select[@class='form-control']"), "Event", "Event", 25);
		driver.findElement(By.xpath("//div/span[contains(text(),'Manage Layout')]/ancestor::section[@id='divMainLeadData']/descendant::select[@class='form-control']")).sendKeys(Keys.ENTER);
		logger.info("Select DropDown Clicked");
		staticWait(5000);
		
		driver.findElement(By.xpath("//div/select/option[text()='CRM']")).click();
		logger.info("Module is Selected");

	}
public void SelectCRMModule() {
		
		
		staticWait(5000);
		selectValueWithText(By.xpath("//div/span[contains(text(),'Manage Layout')]/ancestor::section[@id='divMainLeadData']/descendant::select[@class='form-control']"), "CRM", "CRM", 25);
		

	}
public void refreshPage() {
		
		
		driver.navigate().refresh();

	}
	public void clickOnSearch() {
		staticWait(3000);
		WebElement serchButton = driver.findElement(By.xpath("//div/a[@data-original-title='Click here to search']"));
		Actions action = new Actions(driver);
		action.moveToElement(serchButton).click().perform();
		logger.info("Search Button clicked");
		//clickByJavascript(By.xpath("//div/a[@id='Search']"), "Search Button", 30);
		staticWait(5000);
	}
	public void clickOnReset() {
		staticWait(2000);
		//clickByJavascript(By.xpath("//div/a[@id='ResetFilters']"), "Reset Button", 30);
		WebElement resetButton = driver.findElement(By.xpath("//div/a[@data-original-title='Click here to reset']"));
		Actions action = new Actions(driver);
		action.moveToElement(resetButton).click().perform();
		logger.info("Reset Button clicked");
		staticWait(5000);

	}
	public void SelectEntries() {
		staticWait(2000);
		selectValueWithText(By.xpath("//span/select[@id='pageSize']"), "100", "Entries", 25);

	}
	public void CaptureAllSubModules() {
		staticWait(2000);
		List<WebElement> subModules = driver.findElements(By.xpath("//table[@id='tablelistingdata']"));
		 System.out.println(subModules.size());

	        for (WebElement webElement : subModules) {
	            String name = webElement.getText();
	            logger.info(name);

	}
	}
}
