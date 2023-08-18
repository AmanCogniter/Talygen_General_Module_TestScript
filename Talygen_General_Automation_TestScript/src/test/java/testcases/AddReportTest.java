package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddReportAction;
import action.LoginAction;
import utils.WebTestBase;

public class AddReportTest extends WebTestBase {
	static String Screenname = "<b> Add Report </b>";
	/* Validation check and Userguide Check and cancel button*/
	@Test(priority = 1)
	public void addReportValidationCheck()
	{
		
		
		test = getTest( Screenname + ":  Validation check and Userguide Check and cancel button on Add Report Screen");
		AddReportAction addReportAction = new AddReportAction(driver);
		new LoginAction(driver).logoutLogin();
		addReportAction.GoToAddReportTab();
		addReportAction.ValidationCheck();	
		
	}
	/* Add Report */
	@Test(priority = 2)
	public void  addReport()
	{
		
		test = getTest( Screenname + ": Add Report Screen");
		AddReportAction addReportAction = new AddReportAction(driver);
		new LoginAction(driver).logoutLogin();
		addReportAction.GoToAddReportTab();
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
	/* validate functionality of delete button */
	@Test(priority = 5)
	public void  validatefunctionalityOfDeleteButton()
	{
		
		test = getTest( Screenname + ": validate functionality Of Delete Button");
		AddReportAction addReportAction = new AddReportAction(driver);
		new LoginAction(driver).logoutLogin();
		addReportAction.GoToCustomReportTab();
		addReportAction.deleteReport();
		
	}
}
