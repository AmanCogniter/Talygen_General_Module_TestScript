package action;

import org.openqa.selenium.WebDriver;

import pageobjects.ProvisionalRightPage;

public class ProvisionalRightAction {
	WebDriver driver;

	ProvisionalRightPage provisionalRightPage;

	public ProvisionalRightAction(WebDriver driver) {
		this.driver = driver;
		provisionalRightPage = new ProvisionalRightPage(driver);
	}

	public void GoToProvisionalRightsTab() {
		provisionalRightPage.clickFullMenuDropDown();
		provisionalRightPage.clickOnGeneralLink();
		provisionalRightPage.clickOnProvisionalRightsPage();

	}

	public void ValidationCheck() {
		provisionalRightPage.clickOnAddNewProvisionalRightsPage();
		provisionalRightPage.clickOnEffectiveFrom();
		provisionalRightPage.clickOnEffectiveTo();
		provisionalRightPage.clickOnUserGuide();
		provisionalRightPage.clickOnSaveButton();
		provisionalRightPage.VerifyMandatoryFieldValidation();
		provisionalRightPage.clickOnCancelButton();

	}

	public void AddNewProvisionalRightsWithInActiveStatus() {
		provisionalRightPage.clickOnAddNewProvisionalRightsPage();
		provisionalRightPage.enterProvisionalRightsName();

		provisionalRightPage.selectStatus();
		provisionalRightPage.selectAssignedFromUser();
		provisionalRightPage.selectAssignedToUser();
		provisionalRightPage.clickOnSaveButton();
		provisionalRightPage.validateNotifyMessage();
	}

	public void ValidateAssignedFromSearchFunctionality() {
		provisionalRightPage.clickOnAssignedFromSearchFilter();

		provisionalRightPage.clickOnSearch();

	}

	public void ValidateAssignedToSearchFunctionality() {
		provisionalRightPage.clickOnAssignedToSearchFilter();

		provisionalRightPage.clickOnSearch();

	}
	public void ValidateActiveButtonFunctionality() {
		provisionalRightPage.clickOnAssignedToSearchFilter();
		provisionalRightPage.clickOnAssignedToSearchFilter();
		provisionalRightPage.clickOnSearch();
		provisionalRightPage.clickOnCheckBox();
		provisionalRightPage.clickOnActiveStatus();
		provisionalRightPage.clickOnConfirmation();
		provisionalRightPage.validateNotifyMessageForUpdate();

	}
	public void ValidateInActiveButtonFunctionality() {
		provisionalRightPage.clickOnAssignedToSearchFilter();
		provisionalRightPage.clickOnAssignedToSearchFilter();
		provisionalRightPage.clickOnSearch();
		provisionalRightPage.clickOnCheckBox();
		provisionalRightPage.clickOnInActiveStatus();
		provisionalRightPage.clickOnConfirmation();
		provisionalRightPage.validateNotifyMessageForUpdate();

	}
	public void provisionalRightsNameSorting() {
		provisionalRightPage.provisionalRightNameAscending();
		provisionalRightPage.provisionalRightNameDescending();
	    }
	public void assignedFromSorting() {
		provisionalRightPage.assignedFromAscending();
		provisionalRightPage.assignedFromDescending();
	    }
	public void assignedToSorting() {
		provisionalRightPage.assignedToAscending();
		provisionalRightPage.assignedToDescending();
	    }
	public void descriptionSorting() {
		provisionalRightPage.descriptionAscending();
		provisionalRightPage.descriptionDescending();
	    }
	public void statusSorting() {
		provisionalRightPage.statusAscending();
		provisionalRightPage.statusDescending();
	    }

	public void deleteProvisionalRights() {
		provisionalRightPage.clickOnStatus();
		provisionalRightPage.clickOnSearch();
		provisionalRightPage.clickOnCheckBox();
		provisionalRightPage.clickOnDelete();
		provisionalRightPage.clickOnConfirmation();
		provisionalRightPage.validateNotifyMessageForUpdate();

	}

}
