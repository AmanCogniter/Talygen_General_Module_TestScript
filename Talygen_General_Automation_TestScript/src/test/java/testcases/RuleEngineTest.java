package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.LoginAction;
import action.RuleEngineAction;
import utils.WebTestBase;

public class RuleEngineTest extends WebTestBase {
	static String Screenname = "<b> Rule Engine </b>";

	/* Validation check and Userguide Check and cancel button */
	@Test(priority = 1)
	public void ruleEngineValidationCheck() {

		test = getTest(
				Screenname + ":  Validation check and Userguide Check and cancel button on Rule Engine Screen");
		RuleEngineAction ruleEngineAction = new RuleEngineAction(driver);
		new LoginAction(driver).logoutLogin();
		ruleEngineAction.GoToRuleEngineTab();
		ruleEngineAction.ValidationCheck();

	}
	/* Add New Rule */
	@Test(priority = 2)
	public void  addNewRule()
	{
		
		test = getTest( Screenname + ": Add New Rule Screen");
		RuleEngineAction ruleEngineAction = new RuleEngineAction(driver);
		new LoginAction(driver).logoutLogin();
		ruleEngineAction.GoToRuleEngineTab();
		ruleEngineAction.AddNewRule();
		 
	}
	/* Validate Sear ch functionality with Rule name*/
	@Test(priority = 3)
	public void  ValidateSerachFunctionalityWithRuleName()
	{
		
		test = getTest( Screenname + ": Validate Serach Functionality With Rule Name");
		RuleEngineAction ruleEngineAction = new RuleEngineAction(driver);
		new LoginAction(driver).logoutLogin();
		ruleEngineAction.GoToRuleEngineTab();
		ruleEngineAction.checkSearchFunctionalityWithRuleName();
		
	}
	/* Validate Search functionality with Module name*/
	@Test(priority = 4)
	public void  ValidateSerachFunctionalityWithModuleName()
	{
		
		test = getTest( Screenname + ": Validate Serach Functionality With Module Name");
		RuleEngineAction ruleEngineAction = new RuleEngineAction(driver);
		new LoginAction(driver).logoutLogin();
		ruleEngineAction.GoToRuleEngineTab();
		ruleEngineAction.checkSearchFunctionalityWithModuleName();
		
	}
	/* Validate the functionality of Reset Button*/
	@Test(priority = 5)
	public void  ValidatetheFunctionalityOfRestButton()
	{
		
		test = getTest( Screenname + ": Validate the Functionality Of Reset Button");
		RuleEngineAction ruleEngineAction = new RuleEngineAction(driver);
		new LoginAction(driver).logoutLogin();
		ruleEngineAction.GoToRuleEngineTab();
		ruleEngineAction.checkResetButtonFunctionality();
		
	}
	/* Validate the functionality of Status Button*/
	@Test(priority = 6)
	public void  ValidatetheFunctionalityOfStatusButton()
	{
		
		test = getTest( Screenname + ": Validate the Functionality Of Status Button");
		RuleEngineAction ruleEngineAction = new RuleEngineAction(driver);
		new LoginAction(driver).logoutLogin();
		ruleEngineAction.GoToRuleEngineTab();
		ruleEngineAction.checktheFubctionalityOfStatusButton();
		
	}
	/* Validate the functionality of Sorting*/
	@Test(priority = 7)
	public void  ValidatetheFunctionalityOfSorting()
	{
		
		test = getTest( Screenname + ": Validate the Functionality Of Sorting");
		RuleEngineAction ruleEngineAction = new RuleEngineAction(driver);
		new LoginAction(driver).logoutLogin();
		ruleEngineAction.GoToRuleEngineTab();
		ruleEngineAction.ruleNameSorting();
		ruleEngineAction.moduleNameSorting();
		ruleEngineAction.lastUpdatedDateSorting();
		ruleEngineAction.lastUpdatedBySorting();
		
	}
	/* Validate Delete button functionality*/
	@Test(priority = 8)
	public void  ValidateDeleteButtonFunctionality()
	{
		
		test = getTest( Screenname + ": Validate Delete Button Functionality");
		RuleEngineAction ruleEngineAction = new RuleEngineAction(driver);
		new LoginAction(driver).logoutLogin();
		ruleEngineAction.GoToRuleEngineTab();
		ruleEngineAction.checkDeleteButtonFunctionality();
		
	}
}
