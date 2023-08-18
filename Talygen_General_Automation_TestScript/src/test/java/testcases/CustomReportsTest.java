package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddReportAction;
import action.CustomReportsAction;
import action.LoginAction;
import utils.WebTestBase;

public class CustomReportsTest  extends WebTestBase{
	static String Screenname = "<b> Add Report </b>";
	/* Validation check and Userguide Check and cancel button*/
	@Test(priority = 1)
	public void addReportValidationCheck()
	{
		
		
		test = getTest( Screenname + ":  Validation check and Userguide Check and cancel button on Add Report Screen");
		AddReportAction addReportAction = new AddReportAction(driver);
		CustomReportsAction customReportsAction = new CustomReportsAction(driver);
		new LoginAction(driver).logoutLogin();
		addReportAction.GoToCustomReportTab();
		customReportsAction.GoToAddReportPage();
		addReportAction.ValidationCheck();	
		
	}
	/* Add Report */
	@Test(priority = 2)
	public void  addReport()
	{
		
		test = getTest( Screenname + ": Add Report Screen");
		AddReportAction addReportAction = new AddReportAction(driver);
		CustomReportsAction customReportsAction = new CustomReportsAction(driver);
		new LoginAction(driver).logoutLogin();
		addReportAction.GoToCustomReportTab();
		customReportsAction.GoToAddReportPage();
		addReportAction.AddReport();
		
	}
	/* Validate Report */
	@Test(priority = 3)
	public void  validateReport()
	{
		
		test = getTest( Screenname + ": Validate Report Screen");
		AddReportAction addReportAction = new AddReportAction(driver);
		new LoginAction(driver).logoutLogin();
		addReportAction.GoToCustomReportTab();
		addReportAction.ValidationCheckofReportName();
		
	}
	/* Update Report in custom report page */
	@Test(priority = 4)
	public void  validationCheckOfUpdateReport()
	{
		
		test = getTest( Screenname + ": Validate check of edit Report Screen");
		AddReportAction addReportAction = new AddReportAction(driver);
		new LoginAction(driver).logoutLogin();
		addReportAction.GoToCustomReportTab();
		addReportAction.editReport();
		
	}
	/*Check Functionality Of Active and InActive Status */
	@Test(priority = 5)
	public void  validateFunctionalityOfActiveAndInActiveStatus()
	{
		
		test = getTest( Screenname + ": validate Functionality Of Active And InActiveStatus");
		CustomReportsAction customReportsAction = new CustomReportsAction(driver);
		AddReportAction addReportAction = new AddReportAction(driver);
		new LoginAction(driver).logoutLogin();
		addReportAction.GoToCustomReportTab();
		customReportsAction.validationCheckOfActiveAndInActiveAStatus();
		
	}
	/*Check Functionality Of View Report*/
	@Test(priority = 6)
	public void  validateFunctionalityOfViewReportButton()
	{
		
		test = getTest( Screenname + ": validate Functionality Of View Report Button");
		CustomReportsAction customReportsAction = new CustomReportsAction(driver);
		AddReportAction addReportAction = new AddReportAction(driver);
		new LoginAction(driver).logoutLogin();
		addReportAction.GoToCustomReportTab();
		customReportsAction.validationCheckOfViewReport();
		
	}
	/* validate functionality of delete button */
	@Test(priority = 7)
	public void  validatefunctionalityOfDeleteButton()
	{
		
		test = getTest( Screenname + ": validate functionality Of Delete Button");
		AddReportAction addReportAction = new AddReportAction(driver);
		new LoginAction(driver).logoutLogin();
		addReportAction.GoToCustomReportTab();
		addReportAction.deleteReport();
		
	}
}
