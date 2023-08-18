package action;

import org.openqa.selenium.WebDriver;

import pageobjects.RuleEnginePage;

public class RuleEngineAction {
	WebDriver driver;

	RuleEnginePage ruleEnginePage;

	public RuleEngineAction(WebDriver driver) {
		this.driver = driver;
		ruleEnginePage = new RuleEnginePage(driver);
	}

	public void GoToRuleEngineTab() {
		ruleEnginePage.clickFullMenuDropDown();
		ruleEnginePage.clickOnGeneralLink();
		ruleEnginePage.clickOnRuleEnginePage();

	}

	public void ValidationCheck() {
		ruleEnginePage.clickOnAddNewRuelPage();
		ruleEnginePage.clickOnUserGuide();
		ruleEnginePage.clickOnSaveButton();
		ruleEnginePage.clickOnCloseNotifyMessage();
		ruleEnginePage.VerifyMandatoryFieldValidation();
		ruleEnginePage.clickOnCancelButton();

	}

	public void AddNewRule() {
		ruleEnginePage.clickOnAddNewRuelPage();
		ruleEnginePage.enterRuleName();

		ruleEnginePage.clickOnSelectModule();
		ruleEnginePage.clickOnSelectAction();
		ruleEnginePage.enterDescription();

		ruleEnginePage.clickOnRadioButton();
		ruleEnginePage.clickOnTarget();
		ruleEnginePage.clickOnSelectRuleTargetFieldID();
		ruleEnginePage.clickOnSelectRuleTargetOperatorID();
		ruleEnginePage.enterRuleFieldValue();
		ruleEnginePage.clickOnPlusIcon();
		ruleEnginePage.clickOnSaveButtonOfTarget();
		ruleEnginePage.clickOnAddResult();
		ruleEnginePage.clickOnUserGuideOfResult();
		ruleEnginePage.clickOnSelectResultType();
		ruleEnginePage.enterWarningMessage();
		ruleEnginePage.clickOnSaveButtonOfResult();

		ruleEnginePage.clickOnSaveButton();
		// ruleEnginePage.validateNotifyMessage();
	}

	public void checkSearchFunctionalityWithRuleName() {
		ruleEnginePage.clickOnRuleNameExpand();
		ruleEnginePage.enterRuleNameInSearchField();

		ruleEnginePage.clickOnSearchButton();

	}

	public void checkSearchFunctionalityWithModuleName() {
		ruleEnginePage.clickOnRuleNameExpand();
		ruleEnginePage.enterRuleNameInSearchField();
		ruleEnginePage.clickOnModuleNameExpand();
		ruleEnginePage.enterModuleNameInSearchField();
		ruleEnginePage.clickOnSearchButton();

	}

	public void checkResetButtonFunctionality() {
		ruleEnginePage.clickOnRuleNameExpand();
		ruleEnginePage.enterRuleNameInSearchField();
		ruleEnginePage.clickOnSearchButton();
		ruleEnginePage.clickOnRefreshButton();
		ruleEnginePage.clickOnRuleNameExpand();
		ruleEnginePage.checkRefreshButtonFunctionality();

	}

	public void checktheFubctionalityOfStatusButton() {
		ruleEnginePage.clickOnRuleNameExpand();
		ruleEnginePage.enterRuleNameInSearchField();
		ruleEnginePage.clickOnSearchButton();
		ruleEnginePage.clickOnSelectStatusAsInActive();
		ruleEnginePage.clickOnConfirmationButtonOfStatus();
		ruleEnginePage.clickOnSelectStatusAsActive();
		ruleEnginePage.clickOnConfirmationButtonOfStatus();

	}

	public void ruleNameSorting() {
		ruleEnginePage.ruleNameAscending();
		ruleEnginePage.ruleNameDescending();
	}

	public void moduleNameSorting() {
		ruleEnginePage.moduleNameAscending();
		ruleEnginePage.moduleNameDescending();
	}

	public void lastUpdatedDateSorting() {
		ruleEnginePage.lastUpDatedDateAscending();
		ruleEnginePage.lastUpdatedDateDescending();
	}

	public void lastUpdatedBySorting() {
		ruleEnginePage.lastUpDatedByAscending();
		ruleEnginePage.lastUpdatedByDescending();
	}

	public void checkDeleteButtonFunctionality() {
		ruleEnginePage.clickOnRuleNameExpand();
		ruleEnginePage.enterRuleNameInSearchField();
		ruleEnginePage.clickOnSearchButton();
		ruleEnginePage.clickOnCheckBox();
		ruleEnginePage.clickOnRemove();
		ruleEnginePage.clickOnConfirmation();
		// ruleEnginePage.validateNotifyMessageForDeleteRuleName();

	}

}
