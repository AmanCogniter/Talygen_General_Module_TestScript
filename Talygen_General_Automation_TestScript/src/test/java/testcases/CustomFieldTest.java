package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddReportAction;
import action.CustomFieldsAction;
import action.LoginAction;
import utils.WebTestBase;

public class CustomFieldTest extends WebTestBase {
	static String Screenname = "<b> Custom Fields </b>";

	/* Validation check on Add Custom Fields Screen */
	@Test(priority = 1)
	public void addCustomFieldsValidationCheck() {

		test = getTest(Screenname + ":  Validation check  on Add Custom Fields Screen");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.ValidationCheck();

	}

	/* Add Custom Field */
	@Test(priority = 2)
	public void addCustomFields() {

		test = getTest(Screenname + ": Add Custom Fields Screen");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.AddCustomFields();

	}

	/* validate Field Name */
	@Test(priority = 3)
	public void validateFieldrName() {

		test = getTest(Screenname + ": validate Passport User Name");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.validateSearchFunctionality();

	}

	/* validate Delete Functionality Of Custom Field */
	@Test(priority = 4)
	public void validateDeleteFunctionalityOfCustomField() {

		test = getTest(Screenname + ":validate Delete Functionality Of Custom Field");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.verifyDEleteFunctionalityOfCustomField();

	}
	/* Add Custom Field With Integer Data Type*/
	@Test(priority = 5)
	public void addCustomFieldsWithIntegerDataType() {

		test = getTest(Screenname + ":  Add Custom Field With Integer Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.AddCustomFieldsWithInteger();

	}
	/* validate Field Name Integer Data Type */
	@Test(priority = 6)
	public void validateFieldrNameWithIntegerDataType() {

		test = getTest(Screenname + ": validate Passport User Name with Integer Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.validateSearchFunctionality();

	}

	/* validate Delete Functionality Of Custom Field with Integer Data Type */
	@Test(priority = 7)
	public void validateDeleteFunctionalityOfCustomFieldWithIntegerDataType() {

		test = getTest(Screenname + ":validate Delete Functionality Of Custom Field With Integer Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.verifyDEleteFunctionalityOfCustomField();

	}
	/* Add Custom Field With Long Integer Data Type*/
	@Test(priority = 8)
	public void addCustomFieldsWithLongIntegerDataType() {

		test = getTest(Screenname + ":  Add Custom Field With Long Integer Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.AddCustomFieldsWithLonghInteger();

	}
	/* validate Field Name Long Integer Data Type */
	@Test(priority = 9)
	public void validateFieldrNameWithLongIntegerDataType() {

		test = getTest(Screenname + ": validate Passport User Name with Long Integer Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.validateSearchFunctionality();

	}

	/* validate Delete Functionality Of Custom Field with Integer Data Type */
	@Test(priority = 10)
	public void validateDeleteFunctionalityOfCustomFieldWithLongIntegerDataType() {

		test = getTest(Screenname + ":validate Delete Functionality Of Custom Field With Integer Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.verifyDEleteFunctionalityOfCustomField();

	}
	/* Add Custom Field With Decimal Data Type*/
	@Test(priority = 11)
	public void addCustomFieldsWithDecimalDataType() {

		test = getTest(Screenname + ":  Add Custom Field With Decimal Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.AddCustomFieldsWithDecimal();

	}
	/* validate Field Name With Decimal Data Type */
	@Test(priority = 12)
	public void validateFieldrNameWithDecimalDataType() {

		test = getTest(Screenname + ": validate Passport User Name with Decimal Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.validateSearchFunctionality();

	}

	/* validate Delete Functionality Of Custom Field with Decimal Data Type */
	@Test(priority = 13)
	public void validateDeleteFunctionalityOfCustomFieldWithDecimalDataType() {

		test = getTest(Screenname + ":validate Delete Functionality Of Custom Field With Decimal Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.verifyDEleteFunctionalityOfCustomField();

	}
	/* Add Custom Field With Date Data Type*/
	@Test(priority = 14)
	public void addCustomFieldsWithDateDataType() {

		test = getTest(Screenname + ":  Add Custom Field With date Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.AddCustomFieldsWithDate();

	}
	/* validate Field Name With date Data Type */
	@Test(priority = 15)
	public void validateFieldrNameWithDateDataType() {

		test = getTest(Screenname + ": validate Passport User Name with Date Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.validateSearchFunctionality();

	}

	/* validate Delete Functionality Of Custom Field with Date Data Type */
	@Test(priority = 16)
	public void validateDeleteFunctionalityOfCustomFieldWithDateDataType() {

		test = getTest(Screenname + ":validate Delete Functionality Of Custom Field With Date Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.verifyDEleteFunctionalityOfCustomField();

	}
	/* Add Custom Field With Select List Data Type*/
	@Test(priority = 17)
	public void addCustomFieldsWithSelectListDataType() {

		test = getTest(Screenname + ":  Add Custom Field With Select List Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.AddCustomFieldsWithSElectList();

	}
	/* validate Field Name With Select List Data Type */
	@Test(priority = 18)
	public void validateFieldrNameWithSelectListDataType() {

		test = getTest(Screenname + ": validate Passport User Name with Select List Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.validateSearchFunctionality();

	}

	/* validate Delete Functionality Of Custom Field with Select List Data Type */
	@Test(priority = 19)
	public void validateDeleteFunctionalityOfCustomFieldWithSelectListDataType() {

		test = getTest(Screenname + ":validate Delete Functionality Of Custom Field With Select List Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.verifyDEleteFunctionalityOfCustomField();

	}
	/* Add Custom Field With Url Data Type*/
	@Test(priority = 20)
	public void addCustomFieldsWithUrlDataType() {

		test = getTest(Screenname + ":  Add Custom Field With Url Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.AddCustomFieldsWithUrl();

	}
	/* validate Field Name With Url Data Type */
	@Test(priority = 21)
	public void validateFieldrNameWithUrlDataType() {

		test = getTest(Screenname + ": validate Passport User Name with Url Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.validateSearchFunctionality();

	}

	/* validate Delete Functionality Of Custom Field with Url Data Type */
	@Test(priority = 22)
	public void validateDeleteFunctionalityOfCustomFieldWithUrlDataType() {

		test = getTest(Screenname + ":validate Delete Functionality Of Custom Field With Url Data Type");
		CustomFieldsAction customFieldsAction = new CustomFieldsAction(driver);
		new LoginAction(driver).logoutLogin();
		customFieldsAction.GoToCustomFieldsTab();
		customFieldsAction.verifyDEleteFunctionalityOfCustomField();

	}
}
