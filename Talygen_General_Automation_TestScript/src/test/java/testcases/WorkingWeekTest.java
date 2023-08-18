package testcases;

import static reporting.ComplexReportFactory.getTest;

import java.awt.AWTException;

import org.testng.annotations.Test;

import action.LoginAction;
import action.WorkingWeekAction;
import utils.WebTestBase;

public class WorkingWeekTest extends WebTestBase{
	static String Screenname = "<b> Working Week </b>";

	/* Validation check on SetUp For Working Week , User guide and Save Button */
	@Test(priority = 1)
	public void validateFunctionalityForSetUpForTheWorkingWeekAndSaveButton() throws AWTException {

		test = getTest(Screenname + ": Validate Functionality For SetUp For The Working Week , User Guide and Save Button");
		WorkingWeekAction workingWeekAction = new WorkingWeekAction(driver);
		new LoginAction(driver).logoutLogin();
		workingWeekAction.GoToWorkingWeekTab();
		workingWeekAction.checkFunctionalityofSetUpWoorkingWeek();

	}

	/* Validation functionality of Reset Button */
	@Test(priority = 2)
	public void validateFunctionalityOfResetButton() {

		test = getTest(Screenname + ": Validate Functionality Reset Button");
		WorkingWeekAction workingWeekAction = new WorkingWeekAction(driver);
		new LoginAction(driver).logoutLogin();
		workingWeekAction.GoToWorkingWeekTab();
		workingWeekAction.checkFunctionalityofResetButton();

	}
}
