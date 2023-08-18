package action;

import org.openqa.selenium.WebDriver;

import pageobjects.AddReportPage;
import pageobjects.CustomFieldsPage;

public class CustomFieldsAction {
	WebDriver driver;

	CustomFieldsPage customFieldsPage;

	public CustomFieldsAction(WebDriver driver) {
		this.driver = driver;
		customFieldsPage = new CustomFieldsPage(driver);
	}

	public void GoToCustomFieldsTab() {
		customFieldsPage.clickFullMenuDropDown();
		customFieldsPage.clickOnGeneralLink();
		customFieldsPage.clickOnCustomFieldsPage();

	}

	public void ValidationCheck() {
		customFieldsPage.clickOnAddCustomFields();
		customFieldsPage.clickOnSaveButton();
		customFieldsPage.VerifyMandatoryFieldValidation();
		customFieldsPage.clickOnCancelButton();

	}

	public void AddCustomFields() {
		customFieldsPage.clickOnAddCustomFields();

		customFieldsPage.SelectModuleName();
		customFieldsPage.SelectSubModuleName();
		customFieldsPage.enterFieldName();
		customFieldsPage.enterLength();
		customFieldsPage.SelectLanguage();
		customFieldsPage.enterLanguageLabel();
		customFieldsPage.enterDescription();
		customFieldsPage.clickOnSaveButton();
		customFieldsPage.validateNotifyMessage();
	}

	public void validateSearchFunctionality() {

		customFieldsPage.clickOnModuleNameOfSearchField();
		customFieldsPage.enterModuleNameInSearchField();
		customFieldsPage.clickOnSubModuleNameOfSearchField();
		customFieldsPage.enterSubModuleNameInSearchField();
		customFieldsPage.clickOnSearchButton();

	}

	public void verifyDEleteFunctionalityOfCustomField() {
		customFieldsPage.clickOnModuleNameOfSearchField();
		customFieldsPage.enterModuleNameInSearchField();
		customFieldsPage.clickOnSubModuleNameOfSearchField();
		customFieldsPage.enterSubModuleNameInSearchField();
		customFieldsPage.clickOnSearchButton();
		customFieldsPage.clickOnCheckBox();
		customFieldsPage.clickOnRemove();
		customFieldsPage.clickOnConfirmation();
		customFieldsPage.validateNotifyMessageforDeletedFieldname();

	}

	public void AddCustomFieldsWithInteger() {
		customFieldsPage.clickOnAddCustomFields();
		customFieldsPage.clickOnInteger();
		customFieldsPage.SelectModuleName();
		customFieldsPage.SelectSubModuleName();
		customFieldsPage.enterFieldName();
		customFieldsPage.enterLengthforInteger();
		customFieldsPage.clickOnIsRequired();
		customFieldsPage.SelectLanguage();
		customFieldsPage.enterLanguageLabel();
		customFieldsPage.clickOnAddMore();
		customFieldsPage.clickOnClearAll();
		customFieldsPage.clickOnConfirmation();
		customFieldsPage.enterDescription();
		customFieldsPage.clickOnSaveButton();
		customFieldsPage.validateNotifyMessage();
	}
	public void AddCustomFieldsWithLonghInteger() {
		customFieldsPage.clickOnAddCustomFields();
		customFieldsPage.clickOnLongInteger();
		customFieldsPage.SelectModuleName();
		customFieldsPage.SelectSubModuleName();
		customFieldsPage.enterFieldName();
		customFieldsPage.enterLengthforLongInteger();
		customFieldsPage.clickOnIsRequired();
		customFieldsPage.SelectLanguage();
		customFieldsPage.enterLanguageLabel();
		customFieldsPage.clickOnAddMore();
		customFieldsPage.clickOnClearAll();
		customFieldsPage.clickOnConfirmation();
		customFieldsPage.enterDescription();
		customFieldsPage.clickOnSaveButton();
		customFieldsPage.validateNotifyMessage();
	}
	public void AddCustomFieldsWithDecimal() {
		customFieldsPage.clickOnAddCustomFields();
		customFieldsPage.clickOnDecimal();
		customFieldsPage.SelectModuleName();
		customFieldsPage.SelectSubModuleName();
		customFieldsPage.enterFieldName();
		customFieldsPage.enterLengthforLongInteger();
		customFieldsPage.clickOnDecimalPlaces();
		customFieldsPage.SelectLanguage();
		customFieldsPage.enterLanguageLabel();
		customFieldsPage.clickOnAddMore();
		customFieldsPage.clickOnClearAll();
		customFieldsPage.clickOnConfirmation();
		customFieldsPage.enterDescription();
		customFieldsPage.clickOnSaveButton();
		customFieldsPage.validateNotifyMessage();
	}
	public void AddCustomFieldsWithDate() {
		customFieldsPage.clickOnAddCustomFields();
		customFieldsPage.clickOnDate();
		customFieldsPage.SelectModuleName();
		customFieldsPage.SelectSubModuleName();
		customFieldsPage.enterFieldName();
		customFieldsPage.clickOnIsRequired();
		customFieldsPage.SelectLanguage();
		customFieldsPage.enterLanguageLabel();
		customFieldsPage.clickOnAddMore();
		customFieldsPage.clickOnClearAll();
		customFieldsPage.clickOnConfirmation();
		customFieldsPage.enterDescription();
		customFieldsPage.clickOnSaveButton();
		customFieldsPage.validateNotifyMessage();
	}
	public void AddCustomFieldsWithSElectList() {
		customFieldsPage.clickOnAddCustomFields();
		customFieldsPage.clickOnSelectList();
		customFieldsPage.SelectModuleName();
		customFieldsPage.SelectSubModuleName();
		customFieldsPage.enterFieldName();
		customFieldsPage.clickOnPickListOption();
		customFieldsPage.clickOnIsRequired();
		customFieldsPage.SelectLanguage();
		customFieldsPage.enterLanguageLabel();
		customFieldsPage.clickOnAddMore();
		customFieldsPage.clickOnClearAll();
		customFieldsPage.clickOnConfirmation();
		customFieldsPage.enterDescription();
		customFieldsPage.clickOnSaveButton();
		customFieldsPage.validateNotifyMessage();
	}
	public void AddCustomFieldsWithUrl() {
		customFieldsPage.clickOnAddCustomFields();
		customFieldsPage.clickOnurl();
		customFieldsPage.SelectModuleName();
		customFieldsPage.SelectSubModuleName();
		customFieldsPage.enterFieldName();
		customFieldsPage.enterLengthforUrl();
		customFieldsPage.clickOnIsRequired();
		customFieldsPage.SelectLanguage();
		customFieldsPage.enterLanguageLabel();
		customFieldsPage.clickOnAddMore();
		customFieldsPage.clickOnClearAll();
		customFieldsPage.clickOnConfirmation();
		customFieldsPage.enterDescription();
		customFieldsPage.clickOnSaveButton();
		customFieldsPage.validateNotifyMessage();
	}
}
