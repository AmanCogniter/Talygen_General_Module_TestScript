package action;

import org.openqa.selenium.WebDriver;

import pageobjects.WorkingDayPage;

public class WorkingDayAction {
	WebDriver driver;

	WorkingDayPage workingDayPage;

	public WorkingDayAction(WebDriver driver) {
		this.driver = driver;
		workingDayPage = new WorkingDayPage(driver);
	}

	public void GoToWorkingDayTab() {
		workingDayPage.clickFullMenuDropDown();
		workingDayPage.clickOnGeneralLink();
		workingDayPage.clickOnWorkingDayPage();

	}

	public void ValidationCheck() {
		workingDayPage.clickOnAddWorkingDay();
		workingDayPage.clickOnUserGuide();
		workingDayPage.clickOnSaveButton();
		workingDayPage.VerifyMandatoryFieldValidation();
		workingDayPage.clickOnCancelButton();

	}

	public void AddWorkingDay() {
		workingDayPage.clickOnAddWorkingDay();

		workingDayPage.clickOnDatePicker();
		workingDayPage.clickOnSelectLocation();
		workingDayPage.clickOnSelectCompanyHolidayRadioButton();
		workingDayPage.clickOnEnterUsername();
		workingDayPage.clickOnEnterComment();
		workingDayPage.clickOnSaveButton();
		workingDayPage.validateNotifyMessage();

	}

	public void editWorkingDay() {

		workingDayPage.clickOnEditButton();
		workingDayPage.clickOnSaveButton();
		workingDayPage.validateNotifyMessageForEdit();
		

	}
	public void deleteWorkingDay() {

		workingDayPage.clickOnDelete();
		workingDayPage.clickOnConfirmation();
		workingDayPage.validateNotifyMessageForDelete();
		

	}
}
