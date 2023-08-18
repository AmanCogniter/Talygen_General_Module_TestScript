package action;

import org.openqa.selenium.WebDriver;

import pageobjects.AddReportPage;
import pageobjects.AutoResponderPage;

public class AutoResponderAction {
	WebDriver driver;

	AutoResponderPage autoResponderPage;

	public AutoResponderAction(WebDriver driver) {
		this.driver = driver;
		autoResponderPage = new AutoResponderPage(driver);
	}

	public void GoToAutoResponderTab() {
		autoResponderPage.clickFullMenuDropDown();
		autoResponderPage.clickOnGeneralLink();
		autoResponderPage.clickOnAutoResponderPage();

	}

	public void ValidationCheck() {
		autoResponderPage.clickOnAddNewAutoResponderPage();
		autoResponderPage.clickOnUserGuide();
		autoResponderPage.clickOnSaveButton();
		autoResponderPage.VerifyMandatoryFieldValidation();
		autoResponderPage.clickOnCancelButton();

	}

	public void AddNewAutoResponder() {
		autoResponderPage.clickOnAddNewAutoResponderPage();
		autoResponderPage.enterAutoResponderTitle();

		autoResponderPage.enterMessage();
		autoResponderPage.clickOnSaveButton();
		autoResponderPage.validateNotifyMessage();
	}

	public void checkSearchFunctionalityWithTitleName() {
		autoResponderPage.searchByTitle();
		autoResponderPage.clickOnSearchButton();

		autoResponderPage.validateAutoResponderTitleInListingPage();

	}

	public void checkSearchFunctionalityWithStatus() {
		autoResponderPage.searchByTitle();
		autoResponderPage.searchByStatus();
		autoResponderPage.clickOnSearchButton();

		autoResponderPage.validateAutoResponderTitleInListingPage();

	}
	public void editAutoResponder() {
		autoResponderPage.searchByTitle();
		autoResponderPage.clickOnSearchButton();
		autoResponderPage.clickOnTitle();
		autoResponderPage.clickOnSaveButton();
		autoResponderPage.validateNotifyMessageForUpdate();
		
		

	}
	 public void titleSorting() {
		 autoResponderPage.titleAscending();
		 autoResponderPage.titleDescending();
	    }
	 public void messageSorting() {
		 autoResponderPage.messageAscending();
		 autoResponderPage.messageDescending();
	    }
	 public void statusSorting() {
		 autoResponderPage.statusAscending();
		 autoResponderPage.statusDescending();
	    }
	public void deleteAutoResponder() {
		autoResponderPage.searchByTitle();
		autoResponderPage.clickOnSearchButton();
		autoResponderPage.clickOnCheckBox();
		autoResponderPage.clickOnDelete();
		autoResponderPage.clickOnConfirmationButton();
		autoResponderPage.validateNotifyMessageForDelete();
		
		

	}
}
