package action;

import org.openqa.selenium.WebDriver;

import pageobjects.ManageTagsPage;

public class ManageTagsAction {
	WebDriver driver;

	ManageTagsPage manageTagsPage;

	public ManageTagsAction(WebDriver driver) {
		this.driver = driver;
		manageTagsPage = new ManageTagsPage(driver);
	}

	public void GoToManageTagsTab() {
		manageTagsPage.clickFullMenuDropDown();
		manageTagsPage.clickOnGeneralLink();
		manageTagsPage.clickOnManageTagsPage();

	}

	public void ValidationCheck() {
		manageTagsPage.clickOnAddNewTagPage();
		manageTagsPage.clickOnUserGuide();
		manageTagsPage.clickOnSaveButton();
		manageTagsPage.VerifyMandatoryFieldValidation();
		manageTagsPage.clickOnCancelButton();

	}

	public void AddNewTagwithInactiveStatus() {
		manageTagsPage.clickOnAddNewTagPage();
		manageTagsPage.enterTagName();
		manageTagsPage.clickOnSelectStatus();

		manageTagsPage.enterDescription();
		manageTagsPage.clickOnSaveButton();
		manageTagsPage.validateNotifyMessage();

	}

	public void ValidateDeleteFunctionality() {
		manageTagsPage.enterTagNameIntoSearchTextField();
		manageTagsPage.clickOnSearchButton();
		manageTagsPage.clickOnRefreshButton();
		manageTagsPage.enterTagNameIntoSearchTextField();
		manageTagsPage.clickOnSearchButton();
		manageTagsPage.clickOnCheckBox();
		manageTagsPage.clickOnDeleteButton();
		manageTagsPage.clickOnConfirmationButton();
		manageTagsPage.validateNotifyMessageForDelete();

	}

	public void AddNewTagwithActiveStatus() {
		manageTagsPage.clickOnAddNewTagPage();
		manageTagsPage.enterTagName();

		manageTagsPage.enterDescription();
		manageTagsPage.clickOnSaveButton();
		manageTagsPage.validateNotifyMessage();

	}

	public void ValidateInActiveButtonFunctionality() {
		manageTagsPage.enterTagNameIntoSearchTextField();
		manageTagsPage.clickOnSearchButton();
		manageTagsPage.clickOnCheckBox();
		manageTagsPage.clickOnInactiveButton();
		manageTagsPage.clickOnConfirmationButton();
		manageTagsPage.validateNotifyMessageForUpdate();

	}

	public void ValidateActiveButtonFunctionality() {
		manageTagsPage.enterTagNameIntoSearchTextField();
		manageTagsPage.clickOnSearchButton();
		manageTagsPage.clickOnCheckBox();
		manageTagsPage.clickOnActiveButton();
		manageTagsPage.clickOnConfirmationButton();
		manageTagsPage.validateNotifyMessageForUpdate();

	}
	public void ValidateDropDownInActiveFunctionality() {
		manageTagsPage.enterTagNameIntoSearchTextField();
		manageTagsPage.clickOnSearchButton();
		manageTagsPage.clickOnCheckBox();
		manageTagsPage.clickOnSelectInActiveStatusFromDropDown();
		manageTagsPage.clickOnConfirmationButton();
		manageTagsPage.validateNotifyMessageForUpdate();

	}
	public void ValidateDropDownActiveFunctionality() {
		manageTagsPage.enterTagNameIntoSearchTextField();
		manageTagsPage.clickOnSearchButton();
		manageTagsPage.clickOnCheckBox();
		manageTagsPage.clickOnSelectActiveStatusFromDropDown();
		manageTagsPage.clickOnConfirmationButton();
		manageTagsPage.validateNotifyMessageForUpdate();

	}
	public void ValidateEditButtonFunctionality() {
		manageTagsPage.enterTagNameIntoSearchTextField();
		manageTagsPage.clickOnSearchButton();
		manageTagsPage.clickOnEditButton();
		manageTagsPage.clickOnSaveButton();
		manageTagsPage.validateNotifyMessageForUpdate();
		

	}
	 public void tagNameSorting() {
		 manageTagsPage.tagNAmeAscending();
		 manageTagsPage.tagNameDescending();
	    }
	 public void descriptionSorting() {
		 manageTagsPage.descriptionAscending();
		 manageTagsPage.descriptionDescending();
	    }
}
