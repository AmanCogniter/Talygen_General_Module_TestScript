package action;

import org.openqa.selenium.WebDriver;

import pageobjects.OrganizationChartPage;

public class OrganizationChartAction {
	WebDriver driver;

	OrganizationChartPage organizationChartPage;

	public OrganizationChartAction(WebDriver driver) {
		this.driver = driver;
		organizationChartPage = new OrganizationChartPage(driver);
	}

	public void GoToOrganizationChartTab() {
		organizationChartPage.clickFullMenuDropDown();
		organizationChartPage.clickOnGeneralLink();
		organizationChartPage.clickOnOrganizationChartPage();

	}
	public void ValidateChangeRootMemeber() {
		organizationChartPage.clickOnUserGuide();
		organizationChartPage.clickOnChangeRoot();

		organizationChartPage.clickOnSaveButton();
		organizationChartPage.validateNotifyMessageForWithouSelectUser();
	}
	public void changeRootMemeber() {
		organizationChartPage.clickOnUserGuide();
		organizationChartPage.clickOnChangeRoot();

		organizationChartPage.clickOnSelectUser();
		organizationChartPage.clickOnSaveButton();
		organizationChartPage.validateNotifyMessage();
	}
}
