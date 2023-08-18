package action;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import pageobjects.ManageLayoutPage;

public class ManageLayoutAction {
	WebDriver driver;

	ManageLayoutPage manageLayoutPage;

	public ManageLayoutAction(WebDriver driver) {
		this.driver = driver;
		manageLayoutPage = new ManageLayoutPage(driver);
	}

	public void GoToManageLayoutTab() {
		manageLayoutPage.clickFullMenuDropDown();
		manageLayoutPage.clickOnGeneralLink();
		manageLayoutPage.clickOnManageLayoutPage();

	}
	public void checkFunctionalityOfSearchAndResetButton() throws AWTException {
		manageLayoutPage.SelectModule();
		//manageLayoutPage.clickOnSearch();
		manageLayoutPage.clickOnReset();
		
		
		manageLayoutPage.SelectModule();
		manageLayoutPage.clickOnSearch();
		//manageLayoutPage.SelectEntries();
		manageLayoutPage.CaptureAllSubModules();
		

	}
}
