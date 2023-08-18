package action;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;

import pageobjects.CompanySetupUserPage;
import utils.WebBasePage;

public class CompanySetupUserAction extends WebBasePage {

	WebDriver driver;
	CompanySetupUserPage companySetupUserPage;

	public CompanySetupUserAction(WebDriver driver) {
		super(driver, "Add Expense Limit");
		this.companySetupUserPage = new CompanySetupUserPage(driver);
		this.driver = driver;
	}

	public void navigateToCompanySetup() {
		//companySetupUserPage.TourguidePopup();
		companySetupUserPage.clickOnFullMenu();
		companySetupUserPage.clickOnCompanySetup();
		companySetupUserPage.clickOnUser();
//		companySetupUserPage.clickUser();
	}
	public void validationMessageCheck()
	{
		companySetupUserPage.clickAddUser();
		companySetupUserPage.clickSave();
		companySetupUserPage.VerifyMandatoryFieldValidation();
		
	}

	public void clickPerformanceReviewTab() {
		companySetupUserPage.clickPerformanceReviewTab();
	}

	public void createUser() {
		companySetupUserPage.createUser();
	}
	public void createUserForWorkingDay() {
		companySetupUserPage.createUserForWorkingDay();
	}
	/*
	 * public void selectcheckbox() { companySetupUserPage.SelectcheckBox(); }
	 */

	public void settingsForCreatedUser() {
		companySetupUserPage.clickCreatedUser();
	}

	
	public void deleteUser() {
		companySetupUserPage.deleteCreatedUser();
		companySetupUserPage.ClickOnOk();
	}
	

	public void addReview() throws ParseException {
		companySetupUserPage.clickAddReview();
		companySetupUserPage.enterTitle();
		companySetupUserPage.enterStartDate();
		companySetupUserPage.enterEndDate();
		companySetupUserPage.enterDueDate();
		companySetupUserPage.selectReviewTemplate();
		companySetupUserPage.enterDescription();
		companySetupUserPage.addFirstReviewer();
		companySetupUserPage.addButton();
		companySetupUserPage.enterReviewerDueDate();
		companySetupUserPage.saveButton();
//		companySetupUserPage.getPopUpText();
	}
	public void addFeedbackSetting() {
		companySetupUserPage.clickfeedback();
		companySetupUserPage.clickonaddfeedback();
		companySetupUserPage.feedBackQuestion();
		companySetupUserPage.clickontoggleButton();
		companySetupUserPage.enterUserName();
		companySetupUserPage.selectCheckBox();
		companySetupUserPage.savefeedback();
	}

	public void addGoalSettings() {
		companySetupUserPage.clickGoal();
		companySetupUserPage.addGoal();
		companySetupUserPage.enterGoalTitle();
		companySetupUserPage.clickStartDate();
		companySetupUserPage.clickEndDate();
		companySetupUserPage.enterGoalDescription();
		companySetupUserPage.saveGoal();
	}

	public void addNoteSettings() {
		companySetupUserPage.clickNoteTab();
		companySetupUserPage.clickAddNote();
		companySetupUserPage.enterNoteTitle();
		companySetupUserPage.enterNoteDescription();
		companySetupUserPage.saveNote();
	}

	public void addSkillSettings() {
		//companySetupUserPage.clickOnFullMenu();
		//companySetupUserPage.clickOnCompanySetup();
		//companySetupUserPage.innerCompanySetup();
		companySetupUserPage.clickOnCreateNewSkill();
		//companySetupUserPage.addSkill();
		//companySetupUserPage.enterSkillTitle();
		companySetupUserPage.enterSkillComment();
		companySetupUserPage.clickOnPostNewComment();
		companySetupUserPage.clickSaveSkill();
	}

	public void addSkillforCreatedUser() {
		companySetupUserPage.clickSkillFromCreatedUser();
		companySetupUserPage.addSkillForCreatedUser();
		companySetupUserPage.selectSkillCheckbox();
		companySetupUserPage.clickSaveSkillForUser();
	}
}
