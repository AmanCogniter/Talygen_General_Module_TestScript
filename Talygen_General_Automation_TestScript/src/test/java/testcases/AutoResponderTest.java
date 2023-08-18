package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AutoResponderAction;
import action.LoginAction;
import utils.WebTestBase;

public class AutoResponderTest extends WebTestBase {
	static String Screenname = "<b> Auto Responder </b>";
	/* Validation check and Userguide Check and cancel button*/
	@Test(priority = 1)
	public void autoResponderValidationCheck()
	{
		
		
		test = getTest( Screenname + ":  Validation check and Userguide Check and cancel button on Auto Responder Screen");
		AutoResponderAction autoResponderAction = new AutoResponderAction(driver);
		new LoginAction(driver).logoutLogin();
		autoResponderAction.GoToAutoResponderTab();
		autoResponderAction.ValidationCheck();	
		
	}
	/* Add New Auto Responder */
	@Test(priority = 2)
	public void  addAutoResponder()
	{
		
		test = getTest( Screenname + ": Add New Auto Responder Screen");
		AutoResponderAction autoResponderAction = new AutoResponderAction(driver);
		new LoginAction(driver).logoutLogin();
		autoResponderAction.GoToAutoResponderTab();
		autoResponderAction.AddNewAutoResponder();
		 
	}
	/* Validate Serach functionality with Title name*/
	@Test(priority = 3)
	public void  ValidateSerachFunctionalityWithTitleName()
	{
		
		test = getTest( Screenname + ": Validate Serach Functionality With Title Name");
		AutoResponderAction autoResponderAction = new AutoResponderAction(driver);
		new LoginAction(driver).logoutLogin();
		autoResponderAction.GoToAutoResponderTab();
		autoResponderAction.checkSearchFunctionalityWithTitleName();
		
	}
	/* Validate Serach functionality with Status*/
	@Test(priority = 4)
	public void  ValidateSerachFunctionalityWithStatus()
	{
		
		test = getTest( Screenname + ": Validate Serach Functionality With Status");
		AutoResponderAction autoResponderAction = new AutoResponderAction(driver);
		new LoginAction(driver).logoutLogin();
		autoResponderAction.GoToAutoResponderTab();
		autoResponderAction.checkSearchFunctionalityWithStatus();
		
	}
	/* Validate Update functionality*/
	@Test(priority = 5)
	public void  ValidateUpdateFunctionality()
	{
		
		test = getTest( Screenname + ": Validate Update Functionality");
		AutoResponderAction autoResponderAction = new AutoResponderAction(driver);
		new LoginAction(driver).logoutLogin();
		autoResponderAction.GoToAutoResponderTab();
		autoResponderAction.editAutoResponder();
		
	}
	/* Validate sorting functionality*/
	@Test(priority=6)
    public void verifySortingFunctionality() {
        test = getTest("TC_User_Storage_003");
        AutoResponderAction autoResponderAction = new AutoResponderAction(driver);
        LoginAction login = new LoginAction(driver);

        login.logoutLogin();
        autoResponderAction.GoToAutoResponderTab();
        autoResponderAction.titleSorting();
        autoResponderAction.messageSorting();
        autoResponderAction.statusSorting();
       
    }
	/* Validate Delete functionality*/
	@Test(priority = 7)
	public void  ValidateDeleteFunctionality()
	{
		
		test = getTest( Screenname + ": Validate Delete Functionality");
		AutoResponderAction autoResponderAction = new AutoResponderAction(driver);
		new LoginAction(driver).logoutLogin();
		autoResponderAction.GoToAutoResponderTab();
		autoResponderAction.deleteAutoResponder();
		
	}
}
