package action;

import org.openqa.selenium.WebDriver;

import pageobjects.PassportInformationPage;

public class PassportInformationAction {
	WebDriver driver;

	PassportInformationPage passportInformationPage;

	public PassportInformationAction(WebDriver driver) {
		this.driver = driver;
		passportInformationPage = new PassportInformationPage(driver);
	}

	public void GoToAddPassportTab() {
		passportInformationPage.clickFullMenuDropDown();
		passportInformationPage.clickOnGeneralLink();
		passportInformationPage.clickOnPassportInformationPage();

	}

	public void ValidationCheck() {
		passportInformationPage.clickOnAddPassportPage();
		passportInformationPage.clickOnSaveButton();
		passportInformationPage.VerifyMandatoryFieldValidation();
		passportInformationPage.clickOnCancelButton();

	}

	public void AddPassportInformation() {
		passportInformationPage.clickOnAddPassportPage();

		passportInformationPage.selectUserName();
		passportInformationPage.enterPassportNumber();
		passportInformationPage.selectNationality();
		passportInformationPage.enterPlaceOfIssue();
		passportInformationPage.clickOnIssueDate();
		passportInformationPage.clickOnExpiryDate();
		passportInformationPage.enterdateOfBirth();
		passportInformationPage.uploadDocument();
		passportInformationPage.clickOnPlusicon();
		passportInformationPage.clickOnRemove();
		passportInformationPage.clickOnSaveButton();
		// passportInformationPage.validateNotifyMessage();

	}

	public void validateSearchFunctionalityWithUserName() {

		passportInformationPage.clickOnUserNameSearchFilter();
		passportInformationPage.enterUserNameInSerachByUserNameTextField();
		passportInformationPage.clickOnSearchButton();
	}

	public void validateSearchFunctionalityWithStatus() {

		passportInformationPage.clickOnUserNameSearchFilter();
		passportInformationPage.enterUserNameInSerachByUserNameTextField();
		passportInformationPage.clickOnStatusSearchFilter();
		passportInformationPage.enterStatusInSerachByStatusTextField();
		passportInformationPage.clickOnSearchButton();
	}

	public void verifyEditFunctionality() {

		validateSearchFunctionalityWithUserName();
		passportInformationPage.clickOnActionButton();
		passportInformationPage.clickOnEditButton();
		passportInformationPage.clickOnUpdateButton();
		// passportInformationPage.validateNotifyMessageForUpdate();

	}

	public void verifyViewPassportButtonFunctionality() {

		validateSearchFunctionalityWithUserName();
		passportInformationPage.clickOnActionButton();
		passportInformationPage.clickOnViewPassportButton();

	}

	public void ValidationCheckForVisaDetailsPage() {
		validateSearchFunctionalityWithUserName();
		passportInformationPage.clickOnActionButton();
		passportInformationPage.clickOnViewVisaButton();
		passportInformationPage.clickOnAddVisaDetails();
		passportInformationPage.clickOnSaveButton();
		passportInformationPage.VerifyMandatoryFieldValidationOfVisaDetailsPage();
		passportInformationPage.clickOnCancelButton();

	}

	public void AddVisaDetails() {
		validateSearchFunctionalityWithUserName();
		passportInformationPage.clickOnActionButton();
		passportInformationPage.clickOnViewVisaButton();
		passportInformationPage.clickOnAddVisaDetails();
		passportInformationPage.clickOnUserGuide();
		passportInformationPage.enterVisaNumber();
		passportInformationPage.selectCountry();
		passportInformationPage.clickOnFromDate();
		// passportInformationPage.clickOnToDate();
		passportInformationPage.enterControlNumber();
		passportInformationPage.enterViasDescription();
		passportInformationPage.addAttachment();
		passportInformationPage.clickOnClear();
		passportInformationPage.addAttachment();
		passportInformationPage.clickOnPlusicon();
		passportInformationPage.clickOnRemove();
		passportInformationPage.clickOnSaveButton();
		// passportInformationPage.validateNotifyMessageForVisa();

	}

	public void validateSearchFunctionalityWithVisaNumber() {

		validateSearchFunctionalityWithUserName();
		passportInformationPage.clickOnActionButton();
		passportInformationPage.clickOnViewVisaButton();
		passportInformationPage.clickOnVisaNameSearchFilter();
		passportInformationPage.enterVisaNumberInSerachByVisaNumberTextField();
		passportInformationPage.clickOnSearchButtonOfVisaDetails();
	}

	public void validateSearchFunctionalityWithStatusOfVisa() {

		validateSearchFunctionalityWithUserName();
		passportInformationPage.clickOnActionButton();
		passportInformationPage.clickOnViewVisaButton();
		passportInformationPage.clickOnVisaNameSearchFilter();
		passportInformationPage.enterVisaNumberInSerachByVisaNumberTextField();
		passportInformationPage.clickOnStatusSearchFilterOfVisa();
		passportInformationPage.enterStatusInSerachByStatusTextFieldOfVisa();
		passportInformationPage.clickOnSearchButtonOfVisaDetails();
	}

	public void verifyEditFunctionalityOfVisa() {

		validateSearchFunctionalityWithUserName();
		passportInformationPage.clickOnActionButton();
		passportInformationPage.clickOnViewVisaButton();
		passportInformationPage.clickOnVisaNameSearchFilter();
		passportInformationPage.enterVisaNumberInSerachByVisaNumberTextField();
		passportInformationPage.clickOnSearchButtonOfVisaDetails();
		passportInformationPage.clickOnEDitVisa();
		passportInformationPage.clickOnUpdateButton();
		// passportInformationPage.validateNotifyMessageForUpdate();

	}

	public void verifyDEleteFunctionalityOfVisa() {

		validateSearchFunctionalityWithUserName();
		passportInformationPage.clickOnActionButton();
		passportInformationPage.clickOnViewVisaButton();
		passportInformationPage.clickOnVisaNameSearchFilter();
		passportInformationPage.enterVisaNumberInSerachByVisaNumberTextField();
		passportInformationPage.clickOnSearchButtonOfVisaDetails();
		passportInformationPage.clickOnCheckBox();
		passportInformationPage.clickOnDelete();
		passportInformationPage.clickOnConfirmation();
		passportInformationPage.clickOnBackToPassportList();

	}

	public void userNameSorting() {
		passportInformationPage.userNmaeAscending();
		passportInformationPage.UserNameDescending();
	}

	public void passportNumberSorting() {
		passportInformationPage.passportNumberAscending();
		passportInformationPage.passportNumberDescending();
	}

	public void placeOfIssueSorting() {
		passportInformationPage.placeOfIssueAscending();
		passportInformationPage.placeOfIssueDescending();
	}

	public void expiryDateSorting() {
		passportInformationPage.expiryDateAscending();
		passportInformationPage.expiryDateDescending();
	}

	public void statusSorting() {
		passportInformationPage.statusAscending();
		passportInformationPage.statusDescending();
	}

	public void attachmentSorting() {
		passportInformationPage.attachmentAscending();
		passportInformationPage.attachmnetDescending();
	}

	public void verifyDEleteFunctionalityOfPassport() {

		validateSearchFunctionalityWithUserName();

		passportInformationPage.clickOnCheckBox();
		passportInformationPage.clickOnDelete();
		passportInformationPage.clickOnConfirmation();

	}
}
