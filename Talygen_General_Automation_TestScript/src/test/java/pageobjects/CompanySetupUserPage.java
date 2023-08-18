package pageobjects;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import utils.DateTime;
import utils.PropertiesLoader;
import utils.WebBasePage;
import static reporting.ComplexReportFactory.getTest;
public class CompanySetupUserPage extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String pattern = "yyMMddHHmmss";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	static String datevalue = dateformat.format(date);
	public static int characterLength;
	static String otherDateValue = dateformat.format(date);
	DateTime dateTime;

	public String enterlastname;

	static String randomTitleName = nameGenerator();
	static String userNAame;

	public CompanySetupUserPage(WebDriver driver) {
		super(driver, "Company Setup User Page");
		this.dateTime = new DateTime(driver);
		this.driver = driver;
	}
	/*
	 * public void TourguidePopup() {
	 * click(By.xpath("//*[name()='svg' and @class='guided-tour-icon']"),
	 * "Full Menu", 30); staticWait(2000); }
	 */

	// click on full menu
	public void clickOnFullMenu() {
		/*
		 * findElementInVisibility(By.cssSelector("#navbarDropdownPortfolio"), 20);
		 * click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
		 */
		/*
		 * click(By.xpath("//span[text()='Full Menu']"), "Full Menu", 30);
		 * staticWait(2000);
		 */
			staticWait(3000);
		try {
			WebElement tourGuide = driver.findElement(By.xpath("(//*[name()='svg' and @class='guided-tour-icon'])[1]"));
			
			if(tourGuide.isDisplayed()) {

				Actions action = new Actions(driver);
				action.moveToElement(tourGuide).
				click().build().perform();
				
			click(By.xpath("//span[text()='Full Menu']"), "Full Menu", 20);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			click(By.xpath("//span[text()='Full Menu']"), "Full Menu", 20);
		}
			
			
				 
		}

		
	

	// click on aCompany Setup
	public void clickOnCompanySetup() {
		staticWait(2000);
		//clickByJavascript(By.xpath("//a[@data-original-title='User']"), "Company Setup", 20);
		 click(By.xpath("//li[@data-name='COMPANY SETUP']"),"Company Setup Link", 30);
		
	}

	// click on User
	public void clickOnUser() {
		/*
		 * click(By.xpath(
		 * "//li[@data-name='COMPANY']//a//i//following::text()[1]//following::span[1]")
		 * , "Company Side menu", 20);
		 */
		staticWait(3000);
		click(By.xpath("//a[@data-original-title='User']/i"), "Company Side menu", 20);
		staticWait(2000);
		 
	}

	// click on Performance Review Tab
	public void clickPerformanceReviewTab() {
		staticWait(6000);
		findElementVisibility(By.xpath("//a[@id='PrReview']"), 25);
		click(By.xpath("//a[@id='PrReview']"), "PerformanceReviewTab", 20);
	}

	// click on Add Review
	public void clickAddReview() {
		staticWait(3000);
		click(By.cssSelector("#addnewreview"), "Add Review", 20);
	}

	// enter Title
	public void enterTitle() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h5[text()='Manage Review']")));
		enter(By.cssSelector("#Title"), prop.getProperty("enterReviewTitle"), "enter title", 20);
	}

	// enter Start Date
	public void enterStartDate() {
		staticWait(5000);
		
		//driver.findElement(By.xpath("//label[@for='StartDate']//following::input[@id='txtReviewStartDate']")).clear();
		enter(By.xpath("//label[@for='StartDate']//following::input[@id='txtReviewStartDate']"), DateTime.datevalue,
				"enter Start Date", 20);
	}

	// enter End Date
	public void enterEndDate() {
		dateTime.getTenDaysDate();
		enter(By.xpath("//label[@for='EndDate']//following::input[@id='txtReviewEndDate']"), DateTime.tenDaysEndDate,
				"enter End Date", 20);
	}

	// enter Due Date
	public void enterDueDate() {
		enter(By.xpath("//label[@for='CandidateTillDate']//following::input[@id='txtCandidateTillDate']"),
				DateTime.datevalue, "enter Due Date", 20);
	}

	// Default Review Template
	public void selectReviewTemplate() {
		selectValueWithText(By.cssSelector("#ReviewTemplateId"), "Default Review Template", "Default Review Template",
				20);
	}

	// enter Description
	public void enterDescription() {
		enter(By.cssSelector("#Description"), prop.getProperty("enterReviewDescription"), "enter Review Description",
				20);
	}

	// Add first Reviewer
	public void addFirstReviewer() {
		click(By.xpath("//select[@id='ddlManager']//option[1]"), "Add first Reviewer", 20);
	}

	// Add Reviewer button
	public void addButton() {
		click(By.cssSelector("#addApprover"), "Add Approver button", 20);
	}

	// enter Reviewer Due Date
	public void enterReviewerDueDate() {
		enter(By.xpath("//input[@id='ReviewerModelList_1__TillDate']"), DateTime.datevalue, "enter Reviewer Due date",
				20);
	}

	// Add save buttona
	public void saveButton() {
		click(By.xpath("//a[@class='btn btn-success formbtn']"), "Save button", 20);
	}

	// Add save buttona
	public void getPopUpText() throws ParseException {
		String popText = gettextByJSexecuter(By.xpath(
				"//div[@class='alert alert-dismissible fade show msg mw-90 alert-danger' and @role='alert']//span[text()]"),
				"Pop up text", 20);
		logger.info("Pop up text message is :: " + popText);
		String replacedPopUpText = popText.replaceAll(
				"Review dates are overlapping with another review. Please select the date range apart from ", "")
				.replaceAll("to", "");

		logger.info("Pop up text :: " + replacedPopUpText);

		String[] splittedString = replacedPopUpText.split(" ", 2);

//		logger.info("string text :: " + splittedString);
		for (String a : splittedString)
			System.out.println(a.replaceAll("\"", "").replaceAll("\\.", ""));

		String startPopUpDate = splittedString[0];
		String endPopUpDate = splittedString[1];
		Date date;
		System.out.println("" + startPopUpDate.replaceAll("\"", "").replaceAll("\\.", ""));
		System.out.println("" + endPopUpDate.replaceAll("\"", "").replaceAll("\\.", ""));

		String parseDate = endPopUpDate.replaceAll("\"", "").replaceAll("\\.", "").replaceAll("\\s{2,}", "");
		System.out.println("Parse date ::: " + parseDate.trim());

//		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
//		Date date1 = formatter1.parse(parseDate);

//		int output = (int) Double.parseDouble(parseDate);
//		int stringToDouble = Double.parseDouble(parseDate);

//		Date date1 = formatter1.parse(String.valueO.f(parseDate));

//		 Date date2 = dateformat.parse(parseDate);
//		System.out.println(date2);
		dateTime.getOneDaysDate(1, parseDate.trim());
		enter(By.xpath("//label[@for='StartDate']//following::input[@id='txtReviewStartDate']"), DateTime.todayAsString,
				"enter Start Date", 20);
	}
	
	
	 public void VerifyMandatoryFieldValidation()
	 {
		 int i=0;
		 String actualText;
		 String expectedText;
		 
	        List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//div[@class='form-group']/descendant::span[contains(@class,'invalid-feedback')]"), 20);
	        String[] expectedValue = {"User Type","First Name","Last Name","Email","Password","Confirm Password"};
	        for(Object expected : expectedValue)
	        {
	        	//WebElement AsteriskField = findElementVisibility(By.xpath("//label[text()='" + expected +":']"), 45);
	        	
	        	//WebElement AsteriskField = findElementVisibility(By.xpath("//label[@class='lblctrlname']/span/parent::label[text()='" + expected +":']"), 45);
	        	WebElement AsteriskField = findElementVisibility(By.xpath("//span[@class='mandatory']/../label[text()='"+expected+"']"), 20);
	        	//WebElement PasswordAsteriskField = findElementVisibility(By.xpath("//span[@class='text-danger']/ancestor::div[@class='form-group']/descendant::label[text()='"+expected+":']"), 20);
	        	WebElement PasswordAsteriskField = findElementVisibility(By.xpath("//span[@class='text-danger']/ancestor::div[@class='form-group']/descendant::label[text()='"+expected+":']"), 20);
	        	if (AsteriskField!= null || PasswordAsteriskField!= null)
	        	{
	        		  getTest().log(LogStatus.PASS, "The Asterisk symbol is displayed for " + expected + " field");
	                  logger.info("The Asterisk symbol is displayed for " + expected + " field");
					} /*
						 * else if (PasswordAsteriskField!= null) { getTest().log(LogStatus.PASS,
						 * "The Asterisk symbol is displayed for " + expected + " field");
						 * logger.info("The Asterisk symbol is displayed for " + expected + " field");
						 * 
						 * }
						 */
	            	  else {
	                  getTest().log(LogStatus.FAIL, "The Asterisk symbol is not displayed for " + expected + " field");
	                  logger.info("The Asterisk symbol is not displayed for " + expected + " field");
	                  takeScreenshot(expected.toString());
	        	}
	        
	        List<WebElement> expectedElements = errorMessageLocator;
            for (WebElement element : expectedElements) {
                i++;
                actualText = element.getText();
                expectedText = expected.toString();
               
                if (actualText.indexOf(expectedText) != -1) {
                    getTest().log(LogStatus.PASS, "Error message for \"" + expected + "\" field is displayed as expected");
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
	
		
		
	 
 

	// Add save button
	public void clickUser() {
		click(By.xpath("//table[@id='tableResponsive']//tbody//tr[1]//td[2]//a"), "Save button", 20);
	}

	// click on user
	public void clickAddUser() {
		findElementVisibility(By.xpath("//a[@id='ancCreateDepartment']"), 20);
		clickByJavascript(By.xpath("//a[@id='ancCreateDepartment']"), "Add User", 20);
	}

	// select title
	public void selectTitle() {
		selectValueWithText(By.cssSelector("#user_title_id"), "Mr.", "Select Title", 0);
	}

	// Select User Type
	public void selectUserType() {
		//selectValueWithText(By.cssSelector("#Clientdetail_user_type_id"), "Normal User", "Select User Type", 0);
		selectValueWithText(By.xpath("//select[@id='Clientdetail_user_type_id']"), "Normal User", "Select User Type", 0);
	}

	// enter First Name
	public void enterFirstName() {
		enter(By.cssSelector("#txtFirstName"), prop.getProperty("userFirstName"), "First name", 40);
	}

	// enter Last Name
	public void enterLastName() {
		String enterlastname = prop.getProperty("enterLastName")+randomTitleName;
				enter(By.cssSelector("#Clientdetail_last_name"),enterlastname , "Last name", 40);
				userNAame=enterlastname;
		
	}
	// enter Last Name
		public void enterLastNameForWorkingDay() {
			String enterlastname = prop.getProperty("enterLastNameofWorkingDay")+randomTitleName;
					enter(By.cssSelector("#Clientdetail_last_name"),enterlastname , "Last name", 40);
					userNAame=enterlastname;
			
		}

	// enter Email
	public void enterEmail() {
		enter(By.cssSelector("#txtEmail"),prop.getProperty("enterEmail")+datevalue+"@yopmail.com", "Email", 20);
	}
	// enter Email
		public void enterEmailForWorkingDay() {
			enter(By.cssSelector("#txtEmail"),prop.getProperty("enterWorkingDAyEmail")+datevalue+"@yopmail.com", "Email", 20);
		}

	// Select Gender
	public void selectGender() {
		selectValueWithText(By.cssSelector("#Clientdetail_gender"), "Male", "Select Gender", 20);
	}

	// Select Enable Login
	public void clickEnableLoginSwitch() {
		//click(By.xpath("//div[@id='divAttForm']/div[7]/div/div/label/span"), "Enable Login switch", 30);
		click(By.xpath("//label[@class='switch']/input[@id='is_enable_LoginN']/ancestor::asp-checkbox-toggle/descendant::span[@class='slider round']"), "Enable Login switch", 30);

		// input[@id='chkHourFormatN']//following::span[@class='slider
		// round'][1]//span[@class='slider-no']
	}

	// enter Password
	public void enterPassword() {
		enter(By.cssSelector("#txtPassword"), prop.getProperty("enterPassword"), "Password", 20);
	}

	// enter Confirm Password
	public void enterConfirmPassword() {
		enter(By.cssSelector("#txtConfirmPassword"), prop.getProperty("enterConfirmPassword"), "ConfirmPassword", 20);
	}

	// Select Timezone
	public void selectTimezone() {
		selectValueWithText(By.xpath("//select[@id='ddlTimeZone']"),
				"(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi Standard Time", "Time zone", 20);
	}
	//Select Date Formate
	public void selectDateFormate() {
		//click(By.xpath("//select[@id='ddlDateFormat']"), "Date picker", 30);
		selectValueWithText(By.xpath("//select[@id='ddlDateFormat']"), "M/D/YYYY", "Select Date Formate", 20);
		
		
	}
	// Select DOB
	public void selectDOB() {

		click(By.xpath("//div[@data-target='#Clientdetail_date_of_birth']"), "Date picker", 30);
		click(By.cssSelector("td.day.active.today"), "Todays Date", 30);
	}

	/*
	 * // Select DOD public void selectDOD() {
	 * 
	 * click(By.xpath("//div[@data-target='#Clientdetail_date_of_death']"),
	 * "Date picker", 30); click(By.cssSelector("td.day.active"), "Date of death",
	 * 30); }
	 */

	// Select DOH
	public void selectDOH() {

		click(By.xpath("//div[@data-target='#Clientdetail_date_of_join']"), "Date picker", 20);
		click(By.cssSelector("td.day.active"), "Date of joining", 30);

	}

	// Select DOT
	public void selectDOT() {

		click(By.xpath("//div[@data-target='#Clientdetail_date_of_leave']"), "Date picker", 20);
		click(By.cssSelector("td.day.active.today"), "Date of leave", 30);

	}

	// Select Department
	public void selectDepartment() {
		selectValueWithText(By.cssSelector("#Clientdetail_department_id"), "Select", "Select", 20);
		selectValueWithText(By.cssSelector("#Clientdetail_department_id"), "Human Resource", "Human Resource", 20);
	}

	// Select Designation
	public void selectDesignation() {
		selectValueWithText(By.cssSelector("#Clientdetail_designation_id"), "Select", "Select", 20);
		selectValueWithText(By.cssSelector("#Clientdetail_designation_id"), "CEO", "CEO", 20);
	}

	// Select Shift
	public void selectShift() {
		selectValueWithText(By.cssSelector("#Clientdetail_shift_id"), "Select", "Select", 20);
		selectValueWithText(By.cssSelector("#Clientdetail_shift_id"), "Day(Texas)", "Day(Texas)", 20);
	}

	// enter Employee Id:
	public void enterEmployeeId() {
//			prop.getProperty("employeeId") 
		enter(By.cssSelector("#Clientdetail_user_emp_id"), datevalue + prop.getProperty("employeeId"), "Employee Id:",
				20);
	}

	// enter Alias Name
	public void enterAliasName() {
		enter(By.cssSelector("#Clientdetail_AliasName"), prop.getProperty("aliasName") + datevalue, "Alias Name", 20);
	}

	// Select Virtual User
	public void clickVirtualUserSwitch() {
		//click(By.xpath("//*[@id='divAttForm']/div[15]/div/div/label/span"), "Virtual User switch", 20);
		click(By.xpath("//label[@class='switch']/input[@id='is_virtualN']/ancestor::asp-checkbox-toggle/descendant::span[@class='slider round']"), "Virtual User switch", 20);
		// input[@id='chkHourFormatN']//following::span[@class='slider
		// round'][1]//span[@class='slider-no']
	}
	public void SelectcheckBox() {
		click(By.xpath("//div[@class='custom-control custom-checkbox']/input[@class='chkItems custom-control-input']/parent::div"), "select CheckBox", 30);
	}

	public void clickSave() {

		click(By.cssSelector("#btnSave"), "Save button", 20);
		staticWait(6000);
	}

	public void clickDeleteButton() {

		click(By.cssSelector("#DeleteMultiple"), "Delete button", 20);
	}
	public void ClickOnOk() {
		click(By.xpath("//button[@title='OK']"), "Save button", 20);
		staticWait(6000);
		
	}

	// click Save Settings
	public void clickSaveSettings() {
		click(By.cssSelector("#hlkSave"), "Save Settings", 20);
	}

	public void clickActionButton() {
		staticWait(8000);
		click(By.xpath("//table[@id='tableResponsive']/tbody/tr[1]//td//span/i[@class='fa fa-ellipsis-h action_icon']"),
				"Action button", 20);
	}

	public void clickAssociateLicenses() {
		click(By.xpath(
				"//table[@id='tableResponsive']/tbody/tr[1]//td//span/i[@class='fa fa-ellipsis-h action_icon']//following::a[@class='aAssociateLicenses actions-onclick'][1]"),
				"Associate Licenses button", 20);
	}

	// add General License
	public void clickGeneralLicense() {
		/*
		 * findElementPresence(By.xpath(
		 * "//li[@class='list-group-item single-action']//strong[text()='Performance Review (50)']//following::a[@moduleid='14']"
		 * ), 20);
		 */
		findElementPresence(By.xpath(
				  "//li/strong[contains(text(),'General')]"
				  ), 20);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("arguments[0].scrollIntoView();", element);
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		/*
		 * clickByJavascript(By.xpath(
		 * "//li[@class='list-group-item single-action']//strong[text()='Performance Review (50)']//following::a[@moduleid='14']"
		 * ), "Performance Review License", 20);
		 */
		clickByJavascript(By.xpath(
				  "//li/strong[contains(text(),'General')]/following-sibling::a[@class='aAddLicense float-right']"
				  ), "General License", 20);
	}

	// Performance Review License
	public void addPerformanceReviewLicense() {
//			verifySuccessMessage(By.cssSelector("#notifymessage div"), "Performance Review License", 40);
		findElementVisibility(By.cssSelector("#notifymessage div"), 30);

	}

	// close license popup
	public void closeLicensePopup() {
		staticWait(3000);
		click(By.xpath("//a[@class='closeassoLicense btn btn-danger']"), "close License Popup", 20);
	}

	// click configuration
	public void clickConfiguration() {
		click(By.xpath(
				"//table[@id='tableResponsive']/tbody/tr[1]//td//span/i[@class='fa fa-ellipsis-h action_icon']//following::a[@class='aConfig actions-onclick'][1]"),
				"configuration Popup", 20);

	}

	// click enable Ticket Resolve
	public void enableTicketResolve() {
		click(By.xpath("//*[@id='ulKeysContainer']/div[1]/div[2]/div/div/div/label[1]/div/label"),
				"Enable Ticket Resolver", 20);
	}

	// click close Configuration
	public void clickCloseConfiguration() {
		staticWait(6000);
		clickByJavascript(By.xpath("//h5[@id='ui-id-14']//following::button[@data-original-title='Close'][1]"),
				"click close configuration", 20);
	}

	public void createUser() {

		clickAddUser();
		selectUserType();
		selectTitle();
		enterFirstName();
		enterLastName();
		enterEmail();
		selectGender();
		clickEnableLoginSwitch();
		enterPassword();
		enterConfirmPassword();
		selectTimezone();
		selectDateFormate();
		selectDOB();
		selectDOH();
		selectDOT();
		selectDepartment();
		selectDesignation();
		selectShift();
		enterEmployeeId();
		enterAliasName();
		clickVirtualUserSwitch();
		clickSave();
		clickActionButton(); 
		clickAssociateLicenses(); 
		clickGeneralLicense();
		 
		//addLicenseSuccessMessage();
		/*
		 * closeLicensePopup(); clickActionButton(); clickConfiguration();
		 * enableTicketResolve(); clickSaveSettings();
		 * verifySuccessMessage(By.cssSelector("#notifymessage div"),
		 * "Record(s) has been successfully saved.", 20); clickCloseConfiguration();
		 */
	}
	public void createUserForWorkingDay() {

		clickAddUser();
		selectUserType();
		selectTitle();
		enterFirstName();
		enterLastNameForWorkingDay();
		enterEmailForWorkingDay();
		selectGender();
		clickEnableLoginSwitch();
		enterPassword();
		enterConfirmPassword();
		selectTimezone();
		selectDateFormate();
		selectDOB();
		selectDOH();
		selectDOT();
		selectDepartment();
		selectDesignation();
		selectShift();
		//enterEmployeeId();
		//enterAliasName();
		clickVirtualUserSwitch();
		clickSave();
		clickActionButton(); 
		clickAssociateLicenses(); 
		clickGeneralLicense();
		 
		//addLicenseSuccessMessage();
		/*
		 * closeLicensePopup(); clickActionButton(); clickConfiguration();
		 * enableTicketResolve(); clickSaveSettings();
		 * verifySuccessMessage(By.cssSelector("#notifymessage div"),
		 * "Record(s) has been successfully saved.", 20); clickCloseConfiguration();
		 */
	}

	// click CompanySetup
	public void innerCompanySetup() {
		clickByJavascript(By.xpath("//ul[@class='submenu clschild_0 d-flex']//a[@data-original-title='Company Setup']"),
				"inner Company Setup", 20);
	}

	// ----------add skill ----- //
	// click Skill tab
	public void clickSkill() {
		findElementPresence(By.xpath("//*[@id='upper']/li[30]/a"), 20);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)"); // Scroll vertically down by 1000 pixels

		// Find element by link text and store in variable "Element"
		WebElement Element = driver.findElement(By.xpath("//*[@id='upper']/li[30]/a"));
		// Find element by link text and store in variable "Element"

		js.executeScript("arguments[0].scrollIntoView();", Element);
		js.executeScript("arguments[0].scrollIntoView();", Element);

		clickByJavascript(By.xpath("//*[@id='upper']/li[30]/a"), " Skill tab", 20);
	}
	public void clickOnCreateNewSkill() {
		clickByJavascript(By.xpath("//a[@data-original-title='Create new Skill']"),
				"Create New skill", 20);
	}

	// ----------add skill ----- //
	// click Skill tab
	public void clickSkillFromCreatedUser() {
		staticWait(3000);
		findElementPresence(By.xpath("//*[@id='Skill']"), 20);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)"); // Scroll vertically down by 1000 pixels

		// Find element by link text and store in variable "Element"
		WebElement Element = driver.findElement(By.xpath("//*[@id='Skill']"));
		// Find element by link text and store in variable "Element"

		js.executeScript("arguments[0].scrollIntoView();", Element);
		js.executeScript("arguments[0].scrollIntoView();", Element);

		clickByJavascript(By.xpath("//*[@id='Skill']"), " Skill tab", 20);
	}

	// Add Skill
	public void addSkill() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1000)"); // Scroll vertically down by 1000 pixels
		((JavascriptExecutor) driver).executeScript("scroll(0, -350);");

		// Find element by link text and store in variable "Element"
//		WebElement Element = driver.findElement(By.xpath("//a[@id='addSkills']"));
		// Find element by link text and store in variable "Element"

//		js.executeScript("arguments[0].scrollIntoView();", Element);
		staticWait(6000);
		clickByJavascript(By.xpath("//a[@id='ancCreateSkill']"), "Add Skill", 20);
	}

	// Add Skill
	public void addSkillForCreatedUser() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollBy(0,1000)"); // Scroll vertically down by 1000 pixels

		// Find element by link text and store in variable "Element"
		WebElement Element = driver.findElement(By.xpath("//a[@id='addSkills']"));
		// Find element by link text and store in variable "Element"

		js.executeScript("arguments[0].scrollIntoView();", Element);
		clickByJavascript(By.xpath("//a[@id='addSkills']"), "Add Skill", 20);//span[text()=' Title']/ancestor::table[@id='manageUserSkill']/descendant::div[@class='custom-control custom-checkbox']
	}

	// select Skill checkbox
	public void selectSkillCheckbox() {
		staticWait(3000);
		/*clickByJavascript(
				
				  By.xpath(
				  "//table[@id='manageUserSkill']//td[1]//div//input[1]//following::label[@for='chk_11']"
				  ), "select Skill", 20);
			*/	
		WebElement selectcCheckBox = driver.findElement(
		By.xpath("//span[text()=' Title']/ancestor::table[@id='manageUserSkill']/descendant::div[@class='custom-control custom-checkbox']"));
		String value = selectcCheckBox.getAttribute("Checked");
		 
   	 if(value == null)
   	 {
   		 
 
   	 	click(By.xpath("//span[text()=' Title']/ancestor::table[@id='manageUserSkill']/descendant::div[@class='custom-control custom-checkbox']"),"Select Check Box",10);
   	 }
		
   }
	

	// enter skill title
	public void enterSkillTitle() {
		//enter(By.cssSelector("#SkillTitle"), randomTitleName, "skill  Name", 20);
		enter(By.xpath("//span[@class='mandatory']/ancestor::tg-input/input[@id='SkillName']"), randomTitleName, "skill  Name", 20);
	}

	// enter skill description
	public void enterSkillComment() {
		//enter(By.cssSelector("#Description"), prop.getProperty("enterSkillDescription"), "skill Description", 20);
		enter(By.xpath("//span[@class='mandatory']/ancestor::tg-textarea/textarea[@id='Comment']"), prop.getProperty("enterSkillDescription"), "skill Description", 20);
	}
	//Click On Post New Comment
	public void clickOnPostNewComment() {
		clickByJavascript(By.xpath("//span[text()='Post New Comment']"), "Post New Comment", 20);
	}
	

	// click save
	public void clickSaveSkillForUser() {
		staticWait(3000);
		//clickByJavascript(By.xpath("//a[@class='btn btn-success formbtn']"), "Save Skill for created user.", 20);
		clickByJavascript(By.cssSelector("#btnPopupSave"), "Save Skill for created user.", 20);
	}

	// click save
	public void clickSaveSkill() {
		//clickByJavascript(By.xpath("//a[@id='btnSave']"), "Save Skill", 20);
		clickByJavascript(By.xpath("//div[@class='modal-footer']/descendant::button[@data-original-title='Save']"), "Save Skill", 20);
	}

	// Question Tab
	public void questionsTab() {
		clickByJavascript(By.xpath("//a[@data-tabr='#question']"), "Question Tab", 20);
	}

	// enter Alias Name
	public void enterQuestionsTitle() {
		enter(By.cssSelector("#QuestionTitle#QuestionTitle"), prop.getProperty("aliasName"), "Alias Name", 20);
	}

	public void deleteCreatedUser() {
		try {
//			pageNavigate(prop.getProperty("companyUsersListingPage"), "Company Users Listing PageU rl");
			List<WebElement> createdUsers = driver
					.findElements(By.xpath("//table[@id='tableResponsive']/tbody/tr//Td[2]//a"));
			List<WebElement> checkBoxes = driver
					.findElements(By.xpath("//table[@id='tableResponsive']/tbody/tr/td[1]"));

			for (int i = 0; i <= 1; i++) {
				if (createdUsers.get(i).getText().contains("Automation User")) {
					checkBoxes.get(i).click();
					staticWait(2000);
					clickDeleteButton();
					staticWait(4000);
					driver.switchTo().alert().accept();
					System.out.println("user deleted");
					break;
				} else if (createdUsers.get(i).getText().startsWith("Automation")) {
					checkBoxes.get(i).click();
					staticWait(2000);
					clickDeleteButton();
					staticWait(4000);
					
					driver.switchTo().alert().accept();
					System.out.println("user deleted");
					break;
				} else {
					System.out.println("Users with Name james not found.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	// click user
	public void clickCreatedUser() {
		clickByJavascript(By.xpath("//table[@id='tableResponsive']/tbody/tr[1]//Td[2]//a[1]"), "user", 20);
	}
	//Click on feedback
	public void clickfeedback() {
		staticWait(3000);
		clickByJavascript(By.xpath("//a[@id='Feedback']"), "feedback", 20);
	}
	//Click on addfeedback
		public void clickonaddfeedback() {
			staticWait(3000);
			clickByJavascript(By.xpath("//a[@id='addnewFeedback']"), "feedback", 20);
		}
		//Enter feedback question
		public void feedBackQuestion() {
			staticWait(3000);
		enter(By.xpath("//textarea[@id='FeedbackQuestion']"), prop.getProperty("enterFeedbackQuestion"), "feedback Question", 20);
		}
		//Click on togglebutton
				public void clickontoggleButton() {
					staticWait(3000);
					clickByJavascript(By.xpath("//asp-checkbox-toggle/label[@class='switch']/input[@id='IsAnonymousN']"), "toggle button", 20);
				}
		//Enter User Name
		public void enterUserName() {
			staticWait(3000);
	
		enter(By.xpath("//th[@id='th-USERNAME']/input[@type='text']"),userNAame, "user Name ", 20);
		}
		//Click on checkBox
		public void selectCheckBox() {
			staticWait(3000);
			click(By.xpath("//th[@id='th-USERNAME']/input[@type='text']/ancestor::tr[@class='search']/descendant::th[@class='nr_customchkbox']/descendant::div[@class='custom-control custom-checkbox']"), "Select CheckBox", 20);
		}
		//Click on Save Feedback
				public void savefeedback() {
					click(By.xpath("//div/input[@id='btnSaveFeedback']"), "Save Feedback", 20);
				}
	// click goal
	public void clickGoal() {
		clickByJavascript(By.cssSelector("#Goal"), "Goal", 20);
	}

	// add goal
	public void addGoal() {
		clickByJavascript(By.xpath("//a[@data-original-title='Add a Goal']"), "Add Goal", 20);
	}

	// goal title
	public void enterGoalTitle() {
		enter(By.cssSelector("#Title"), randomTitleName, "title description", 20);
	}

	// start date
	public void clickStartDate() {
		clickByJavascript(By.xpath("//label[@for='StartDate']//following::span[@class='input-group-text'][1]"),
				"start date", 20);
	}

	// End date
	public void clickEndDate() {
		clickByJavascript(By.xpath("//label[@for='EndDate']//following::span[@class='input-group-text'][1]"),
				"End date", 20);
	}

	// goal description
	public void enterGoalDescription() {
		enter(By.cssSelector("#Description"), prop.getProperty("goalDescription"), "goal description", 20);
	}

	// click save
	public void saveGoal() {
		clickByJavascript(By.cssSelector("#btnSave"), "Save Goal", 20);
	}

	// click note tab
	public void clickNoteTab() {
		clickByJavascript(By.cssSelector("#Note"), "note tab", 20);
	}

	// click Add note
	public void clickAddNote() {
		clickByJavascript(By.cssSelector("#addnewNote"), "Add new note", 20);
	}

	// title description
	public void enterNoteTitle() {
		enter(By.cssSelector("#Title"), randomTitleName, "title description", 20);
	}

	// note description
	public void enterNoteDescription() {
		enter(By.cssSelector("#Description"), prop.getProperty("enterNoteDescription"), "enter Note Description", 20);
	}

	// save Note
	public void saveNote() {
		clickByJavascript(By.cssSelector("#btnPopupSave"), "save button", 20);
	}

	// save Note
	public void selectSkill() {
		clickByJavascript(By.cssSelector("#btnPopupSave"), "save button", 20);
	}

	
	//a[@data-addaction='AddFeedback']
	// table[@id="manageUserSkill"]//tr//td[2]//span
	// table[@id="manageUserSkill"]//tr//td[1]//div

}
