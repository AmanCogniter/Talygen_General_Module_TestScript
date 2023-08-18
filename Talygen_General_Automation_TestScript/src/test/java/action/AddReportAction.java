package action;

import org.openqa.selenium.WebDriver;

import pageobjects.AddReportPage;



public class AddReportAction {
	WebDriver driver;

	AddReportPage addReportPage;

	public AddReportAction(WebDriver driver) {
		this.driver = driver;
		addReportPage = new AddReportPage(driver);
	}

	public void GoToAddReportTab() {
		addReportPage.clickFullMenuDropDown();
		addReportPage.clickOnGeneralLink();
		addReportPage.clickOnAddReportPage();

		
	}

	public void ValidationCheck() {
		addReportPage.clickOnUserGuide();
		addReportPage.clickOnSaveButton();
		addReportPage.VerifyMandatoryFieldValidation();
		addReportPage.clickOnCancelButton();

	}
	public void AddReport() {
		addReportPage.enterReportName();
		
		addReportPage.SelectCategoryType();
		addReportPage.enterDescription();
		addReportPage.clickOnColumn();
		addReportPage.entertextIntoSearchField();
		addReportPage.clickOnSearchButton();
		addReportPage.clickOnCheckBox();
		addReportPage.clickOnMoveToRightArrow();
		//addReportPage.entertextIntoRightSideSearchField();
		addReportPage.clickOnRightSideSearchButton();
		addReportPage.clickOnRightSideCheckBox();
		addReportPage.clickOnFilterButton();
		addReportPage.clickOnPreview();
		addReportPage.clickOnClosePreviewPage();
		addReportPage.clickOnAddCalculatedColumn();
		addReportPage.enterFieldNameIntoSearchField();
		addReportPage.clickOnAvailableColumns();
		addReportPage.clickOnMoveAllToRightButton();
		addReportPage.clickOnVerifyButton();
		addReportPage.clickOncolumnsaveButton();
		addReportPage.clickOnGrouptab();
		addReportPage.entertextIntoGroupingSearchField();
		addReportPage.clickOnGroupSearchButton();
		addReportPage.clickOnGroupPageCheckBox();
		addReportPage.clickOnMoveAllGroupArrow();
		addReportPage.clickOnSharingTab();
		addReportPage.entertextIntoSharingSearchField();
		addReportPage.clickOnSharingPageSearchButton();
		addReportPage.clickOnSharingPageCheckBox();
		addReportPage.clickOnSaveButton();
		addReportPage.validateNotifyMessage();
		
		

	}
	public void GoToCustomReportTab() {
		addReportPage.clickFullMenuDropDown();
		addReportPage.clickOnGeneralLink();
		addReportPage.clickOnCustomReportPage();

		
	}
	public void ValidationCheckofReportName() {
		addReportPage.entertextIntoCustomReportSearchField();
		addReportPage.clickOnSearchButtonOfCustomReport();
		addReportPage.validateReportNameInCustomReport();
		

	}
	public void editReport() {
		addReportPage.entertextIntoCustomReportSearchField();
		addReportPage.clickOnSearchButtonOfCustomReport();
		addReportPage.validateReportNameInCustomReport();
		addReportPage.clickOnReport();
		addReportPage.clickOnColumn();
		addReportPage.clickOnSaveButton();
		addReportPage.validateNotifyMessageOfCustomReport();
		

	}
	public void deleteReport() {
		addReportPage.entertextIntoCustomReportSearchField();
		addReportPage.clickOnSearchButtonOfCustomReport();
		addReportPage.validateReportNameInCustomReport();
		addReportPage.clickOnCustomReportCheckBox();
		addReportPage.clickOnDelete();
		addReportPage.clickOnConfurmationButton();
		addReportPage.validateDeleteNotifyMessageOfCustomReport();
		

	}
}
