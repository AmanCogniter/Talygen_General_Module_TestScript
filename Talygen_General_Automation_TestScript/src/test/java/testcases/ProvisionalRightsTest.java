package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AutoResponderAction;
import action.LoginAction;
import action.ProvisionalRightAction;
import utils.WebTestBase;

public class ProvisionalRightsTest extends WebTestBase {
	static String Screenname = "<b> Provisional rights </b>";

	/* Validation check and Userguide Check and cancel button */
	@Test(priority = 1)
	public void provisinalRightsValidationCheck() {

		test = getTest(
				Screenname + ":  Validation check and Userguide Check and cancel button on Provisional Right Screen");
		ProvisionalRightAction provisionalRightAction = new ProvisionalRightAction(driver);
		new LoginAction(driver).logoutLogin();
		provisionalRightAction.GoToProvisionalRightsTab();
		provisionalRightAction.ValidationCheck();

	}

	/* Add New Provisional Rights With InActive Status */
	@Test(priority = 2)
	public void addNewProvisinalRightsWithInActiveStatus() {

		test = getTest(Screenname + ": Add New Provisional Right Screen");
		ProvisionalRightAction provisionalRightAction = new ProvisionalRightAction(driver);
		new LoginAction(driver).logoutLogin();
		provisionalRightAction.GoToProvisionalRightsTab();
		provisionalRightAction.AddNewProvisionalRightsWithInActiveStatus();

	}

	/* Validate Assigned From Search functionality */
	@Test(priority = 3)
	public void ValidateAssignedFromSearchFunctionality() {

		test = getTest(Screenname + ": Validate Assigned From Search Functionality");
		ProvisionalRightAction provisionalRightAction = new ProvisionalRightAction(driver);
		new LoginAction(driver).logoutLogin();
		provisionalRightAction.GoToProvisionalRightsTab();
		provisionalRightAction.ValidateAssignedFromSearchFunctionality();

	}

	/* Validate Assigned To Search functionality */
	@Test(priority = 4)
	public void ValidateAssignedToSearchFunctionality() {

		test = getTest(Screenname + ": Validate Assigned To Search Functionality");
		ProvisionalRightAction provisionalRightAction = new ProvisionalRightAction(driver);
		new LoginAction(driver).logoutLogin();
		provisionalRightAction.GoToProvisionalRightsTab();
		provisionalRightAction.ValidateAssignedToSearchFunctionality();

	}

	/* Validate Active Status functionality */
	@Test(priority = 5)
	public void ValidateActiveStatusFunctionality() {

		test = getTest(Screenname + ": Validate Active Status Functionality");
		ProvisionalRightAction provisionalRightAction = new ProvisionalRightAction(driver);
		new LoginAction(driver).logoutLogin();
		provisionalRightAction.GoToProvisionalRightsTab();
		provisionalRightAction.ValidateActiveButtonFunctionality();

	}

	/* Validate InActive Status functionality */
	@Test(priority = 6)
	public void ValidateInActiveStatusFunctionality() {

		test = getTest(Screenname + ": Validate InActive Status Functionality");
		ProvisionalRightAction provisionalRightAction = new ProvisionalRightAction(driver);
		new LoginAction(driver).logoutLogin();
		provisionalRightAction.GoToProvisionalRightsTab();
		provisionalRightAction.ValidateInActiveButtonFunctionality();

	}

	/* Validate sorting functionality */
	@Test(priority = 7)
	public void verifySortingFunctionality() {
		test = getTest(Screenname + ":  Validate sorting functionality");
		ProvisionalRightAction provisionalRightAction = new ProvisionalRightAction(driver);
		LoginAction login = new LoginAction(driver);

		login.logoutLogin();
		provisionalRightAction.GoToProvisionalRightsTab();
		provisionalRightAction.provisionalRightsNameSorting();
		provisionalRightAction.assignedFromSorting();
		provisionalRightAction.assignedToSorting();
		provisionalRightAction.descriptionSorting();
		provisionalRightAction.statusSorting();

	}

	/* Validate Delete functionality */
	@Test(priority = 8)
	public void ValidateDeleteFunctionality() {

		test = getTest(Screenname + ": Validate Delete Functionality");
		ProvisionalRightAction provisionalRightAction = new ProvisionalRightAction(driver);
		new LoginAction(driver).logoutLogin();
		provisionalRightAction.GoToProvisionalRightsTab();
		provisionalRightAction.deleteProvisionalRights();

	}
}
