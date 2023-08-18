package testcases;

import static reporting.ComplexReportFactory.getTest;

import java.text.ParseException;

import org.testng.annotations.Test;

import action.CompanySetupUserAction;
import action.CustomFieldsAction;
import action.LoginAction;
import action.WorkingDayAction;
import utils.WebTestBase;

public class WorkingDayTest extends WebTestBase {
	static String Screenname = "<b> Working Day </b>";

	/* Validation check on Add Working Day Screen */
	@Test(priority = 1)
	public void addWorkingDayValidationCheck() {

		test = getTest(Screenname + ":  Validation check  on Working Day Screen");
		WorkingDayAction workingDayAction = new WorkingDayAction(driver);
		new LoginAction(driver).logoutLogin();
		workingDayAction.GoToWorkingDayTab();
		workingDayAction.ValidationCheck();

	}
	/* Add Working Day For Company Holiday */
	@Test(priority = 2)
	public void addWorkingDayForCompanyHolidays() throws ParseException {

		test = getTest(Screenname + ": Add Working Day for Company Holiday");
		
		CompanySetupUserAction companySetupUserAction = new CompanySetupUserAction(driver);
		new LoginAction(driver).logoutLogin();
		companySetupUserAction.navigateToCompanySetup();

		// companySetupUserAction.selectcheckbox();
		// companySetupUserAction.deleteUser();
		companySetupUserAction.createUserForWorkingDay();

		/*
		 * companySetupUserAction.settingsForCreatedUser();
		 * companySetupUserAction.addFeedbackSetting();
		 * companySetupUserAction.addGoalSettings();
		 * companySetupUserAction.addNoteSettings();
		 */
		// companySetupUserAction.clickPerformanceReviewTab();
		// companySetupUserAction.addReview();
		/* companySetupUserAction.addSkillforCreatedUser(); */
		// companySetupUserAction.addSkillSettings();
		/*
		 * companySetupUserAction.clickPerformanceReviewTab();
		 * companySetupUserAction.addReview();
		 */

		// new LoginAction(driver).logoutLoginNewUser();
//		companySetupUserAction.clickPerformanceReviewTab();
//		companySetupUserAction.addReview();
		  new LoginAction(driver).logoutLogin();
		  WorkingDayAction workingDayAction = new WorkingDayAction(driver);
		  workingDayAction.GoToWorkingDayTab();
			workingDayAction.AddWorkingDay();

	}
	/* Validate Edit Functionality Of Working Day*/
	@Test(priority = 3)
	public void ValidateEditFunctionality() {

		test = getTest(Screenname + ": Validate Edit Functionality Of Working Day");
		WorkingDayAction workingDayAction = new WorkingDayAction(driver);
		new LoginAction(driver).logoutLogin();
		workingDayAction.GoToWorkingDayTab();
		workingDayAction.editWorkingDay();

	}
	/* Validate Delete Functionality Of Working Day*/
	@Test(priority = 4)
	public void ValidateDeleteFunctionality() {

		test = getTest(Screenname + ": Validate Delete Functionality Of Working Day");
		WorkingDayAction workingDayAction = new WorkingDayAction(driver);
		new LoginAction(driver).logoutLogin();
		workingDayAction.GoToWorkingDayTab();
		workingDayAction.deleteWorkingDay();

	}
}
