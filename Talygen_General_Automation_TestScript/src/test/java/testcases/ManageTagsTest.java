package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.LoginAction;
import action.ManageTagsAction;
import utils.WebTestBase;

public class ManageTagsTest extends WebTestBase {
	static String Screenname = "<b> Manage Tags </b>";

	/* Validation check and Userguide Check and cancel button */
	@Test(priority = 1)
	public void ManageTagsValidationCheck() {

		test = getTest(Screenname + ":  Validation check and Userguide Check and cancel button on Manage Tags Screen");
		ManageTagsAction manageTagsAction = new ManageTagsAction(driver);
		new LoginAction(driver).logoutLogin();
		manageTagsAction.GoToManageTagsTab();
		manageTagsAction.ValidationCheck();

	}

	/* Add New Tag with Inactive Status */
	@Test(priority = 2)
	public void addNewTagwithInactiveStatus() {

		test = getTest(Screenname + ": Add New Tag with Inactive Status");
		ManageTagsAction manageTagsAction = new ManageTagsAction(driver);
		new LoginAction(driver).logoutLogin();
		manageTagsAction.GoToManageTagsTab();
		manageTagsAction.AddNewTagwithInactiveStatus();

	}

	/* Validate Clear all Search And Delete Functionality */
	@Test(priority = 3)
	public void validateClearAllSearchAndDeleteFunctionality() {

		test = getTest(Screenname + ": Validate Clear all,Search And Delete Functionality");
		ManageTagsAction manageTagsAction = new ManageTagsAction(driver);
		new LoginAction(driver).logoutLogin();
		manageTagsAction.GoToManageTagsTab();
		manageTagsAction.ValidateDeleteFunctionality();

	}

	/* Add New Tag with Active Status */
	@Test(priority = 4)
	public void addNewTagwithActiveStatus() {

		test = getTest(Screenname + ": Add New Tag with Active Status");
		ManageTagsAction manageTagsAction = new ManageTagsAction(driver);
		new LoginAction(driver).logoutLogin();
		manageTagsAction.GoToManageTagsTab();
		manageTagsAction.AddNewTagwithActiveStatus();

	}
	/* Validate InActive Button Functionality*/
	@Test(priority = 5)
	public void validateInActiveButtonFunctionality() {

		test = getTest(Screenname + ":Validate InActive Button Functionality");
		ManageTagsAction manageTagsAction = new ManageTagsAction(driver);
		new LoginAction(driver).logoutLogin();
		manageTagsAction.GoToManageTagsTab();
		manageTagsAction.ValidateInActiveButtonFunctionality();

	}
	/* Validate Active Button Functionality*/
	@Test(priority = 6)
	public void validateActiveButtonFunctionality() {

		test = getTest(Screenname + ":Validate Active Button Functionality");
		ManageTagsAction manageTagsAction = new ManageTagsAction(driver);
		new LoginAction(driver).logoutLogin();
		manageTagsAction.GoToManageTagsTab();
		manageTagsAction.ValidateActiveButtonFunctionality();

	}
	/* Validate DropDown InActive Functionality*/
	@Test(priority = 7)
	public void validateDrpoDownInActiveFunctionality() {

		test = getTest(Screenname + ":Validate DropDown InActive Functionality");
		ManageTagsAction manageTagsAction = new ManageTagsAction(driver);
		new LoginAction(driver).logoutLogin();
		manageTagsAction.GoToManageTagsTab();
		manageTagsAction.ValidateDropDownInActiveFunctionality();

	}
	/* Validate DropDown Active Functionality*/
	@Test(priority = 8)
	public void validateDrpoDownActiveFunctionality() {

		test = getTest(Screenname + ":Validate DropDown Active Functionality");
		ManageTagsAction manageTagsAction = new ManageTagsAction(driver);
		new LoginAction(driver).logoutLogin();
		manageTagsAction.GoToManageTagsTab();
		manageTagsAction.ValidateDropDownActiveFunctionality();

	}
	/* Validate Edit Functionality*/
	@Test(priority = 9)
	public void validateUpdateFunctionality() {

		test = getTest(Screenname + ":Validate Update Functionality");
		ManageTagsAction manageTagsAction = new ManageTagsAction(driver);
		new LoginAction(driver).logoutLogin();
		manageTagsAction.GoToManageTagsTab();
		manageTagsAction.ValidateEditButtonFunctionality();

	}
	/* Validate sorting functionality*/
	@Test(priority=10)
    public void verifySortingFunctionality() {
		test = getTest(Screenname + ":Validate Sorting Functionality");
		ManageTagsAction manageTagsAction = new ManageTagsAction(driver);
        LoginAction login = new LoginAction(driver);

        login.logoutLogin();
        manageTagsAction.GoToManageTagsTab();
        manageTagsAction.tagNameSorting();
        manageTagsAction.descriptionSorting();
       
       
    }
	/* Validate Search And Delete Functionality For Active Status*/
	@Test(priority = 11)
	public void validateSearchAndDeleteFunctionalityForActiveStatus() {

		test = getTest(Screenname + ": Validate Search And Delete Functionality For Active Status");
		ManageTagsAction manageTagsAction = new ManageTagsAction(driver);
		new LoginAction(driver).logoutLogin();
		manageTagsAction.GoToManageTagsTab();
		manageTagsAction.ValidateDeleteFunctionality();

	}
}
