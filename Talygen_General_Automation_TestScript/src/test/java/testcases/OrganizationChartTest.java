package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.LoginAction;
import action.OrganizationChartAction;
import utils.WebTestBase;

public class OrganizationChartTest extends WebTestBase{
	static String Screenname = "<b> Organization Chart </b>";
	/*Validation Check for Change Root Member*/
	
	@Test(priority = 1)
	public void validationCheckForChangeRootMember()
	{
		
		
		test = getTest( Screenname + ": Validation Check for Change Root Memeber");
		OrganizationChartAction organizationChartAction = new OrganizationChartAction(driver);
		new LoginAction(driver).logoutLogin();
		organizationChartAction.GoToOrganizationChartTab();
		organizationChartAction.ValidateChangeRootMemeber();	
		
	}
	/*Validate Functionality of User guide and Change Root Member*/
	@Test(priority = 2)
	public void validateFunctionalityOfUserGuideAndChangeRootMember()
	{
		
		
		test = getTest( Screenname + ": Validate Functionality of User guide and Change Root Member Of Organization Chart");
		OrganizationChartAction organizationChartAction = new OrganizationChartAction(driver);
		new LoginAction(driver).logoutLogin();
		organizationChartAction.GoToOrganizationChartTab();
		organizationChartAction.changeRootMemeber();	
		
	}
}
