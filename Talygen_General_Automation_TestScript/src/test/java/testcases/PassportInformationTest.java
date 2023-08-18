package testcases;

import static reporting.ComplexReportFactory.getTest;

import java.text.ParseException;

import org.testng.annotations.Test;

import action.AddReportAction;
import action.AutoResponderAction;
import action.CompanySetupUserAction;
import action.LoginAction;
import action.PassportInformationAction;
import utils.WebTestBase;

public class PassportInformationTest extends WebTestBase {
	static String Screenname = "<b> Add Passport Information </b>";

	/* Validation check and cancel button */
	@Test(priority = 1)
	public void addPassportInformationValidationCheck() {
		test = getTest(Screenname + ":  Validation check and cancel button on Add Passport Information Screen");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		new LoginAction(driver).logoutLogin();
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.ValidationCheck();

	}

	/* Add Passport Information */
	@Test(priority = 2)
	public void addPassportInformation() throws ParseException {

		test = getTest(Screenname + ": Add RepPassport Information Screen");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		new LoginAction(driver).logoutLogin();

		CompanySetupUserAction companySetupUserAction = new CompanySetupUserAction(driver);
		// companySetupUserAction.addSkillSettings();
		companySetupUserAction.navigateToCompanySetup();

		// companySetupUserAction.selectcheckbox();
		// companySetupUserAction.deleteUser();
		 companySetupUserAction.createUser(); 
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
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.AddPassportInformation();

	}

	/* validate Passport User Name */
	@Test(priority = 3)
	public void validatePassportUserName() {

		test = getTest(Screenname + ": validate Passport User Name");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		new LoginAction(driver).logoutLogin();
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.validateSearchFunctionalityWithUserName();

	}

	/* validate Passport User Name with Status serach filter */
	@Test(priority = 4)
	public void validatePassportUserNameWithStatusSearchFilter() {

		test = getTest(Screenname + ":validate Passport User Name With Status Search Filter");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		new LoginAction(driver).logoutLogin();
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.validateSearchFunctionalityWithStatus();

	}

	/* validate Update functionality */
	@Test(priority = 5)
	public void validateUpdateFunctionality() {

		test = getTest(Screenname + ":validate Update Functionality");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		new LoginAction(driver).logoutLogin();
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.verifyEditFunctionality();

	}

	/* validate View Passport Button functionality */
	@Test(priority = 6)
	public void validateViewPassportButtonFunctionality() {

		test = getTest(Screenname + ":validate View passport Button Functionality");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		new LoginAction(driver).logoutLogin();
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.verifyViewPassportButtonFunctionality();

	}

	/* Add Visa Details Validation Check */
	@Test(priority = 7)
	public void addVisaDetailsValidationCheck() {

		test = getTest(Screenname + ":add Visa Details Validation Check");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		new LoginAction(driver).logoutLogin();
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.ValidationCheckForVisaDetailsPage();

	}

	/* Add Visa Details */
	@Test(priority = 8)
	public void addVisaDetails() {

		test = getTest(Screenname + ":add Visa Details ");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		new LoginAction(driver).logoutLogin();
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.AddVisaDetails();

	}

	/* validate Visa Number */
	@Test(priority = 9)
	public void validateVisaNumber() {

		test = getTest(Screenname + ": validate Visa Number");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		new LoginAction(driver).logoutLogin();
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.validateSearchFunctionalityWithVisaNumber();

	}

	/* validate Visa Number with Status serach filter */
	@Test(priority = 10)
	public void validateVisaNumberWithStatusSearchFilter() {

		test = getTest(Screenname + ":validate Visa Number With Status Search Filter");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		new LoginAction(driver).logoutLogin();
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.validateSearchFunctionalityWithStatusOfVisa();

	}

	/* validate Update Functionality Of Visa */
	@Test(priority = 11)
	public void validateUpdateFunctionalityOfVisa() {

		test = getTest(Screenname + ":validate Update Functionality Of Visa");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		new LoginAction(driver).logoutLogin();
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.verifyEditFunctionalityOfVisa();

	}

	/* validate Delete Functionality Of Visa */
	@Test(priority = 12)
	public void validateDeleteFunctionalityOfVisa() {

		test = getTest(Screenname + ":validate Delete Functionality Of Visa");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		new LoginAction(driver).logoutLogin();
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.verifyDEleteFunctionalityOfVisa();

	}

	/* Validate sorting functionality */
	@Test(priority = 13)
	public void verifySortingFunctionality() {
		test = getTest(Screenname + ":Validate sorting functionality");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		LoginAction login = new LoginAction(driver);

		login.logoutLogin();
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.userNameSorting();
		passportInformationAction.passportNumberSorting();
		passportInformationAction.placeOfIssueSorting();
		passportInformationAction.expiryDateSorting();
		passportInformationAction.statusSorting();
		passportInformationAction.attachmentSorting();

	}

	/* validate Delete Functionality Of Passport */
	@Test(priority = 14)
	public void validateDeleteFunctionalityOfPassport() {

		test = getTest(Screenname + ":validate Delete Functionality Of Passport");
		PassportInformationAction passportInformationAction = new PassportInformationAction(driver);
		new LoginAction(driver).logoutLogin();
		passportInformationAction.GoToAddPassportTab();
		passportInformationAction.verifyDEleteFunctionalityOfPassport();

	}
}
