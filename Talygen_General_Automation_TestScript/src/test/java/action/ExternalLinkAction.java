package action;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import pageobjects.AddReportPage;
import pageobjects.ExternalLinkPage;

public class ExternalLinkAction {
	WebDriver driver;

	ExternalLinkPage externalLinkPage;

	public ExternalLinkAction(WebDriver driver) {
		this.driver = driver;
		externalLinkPage = new ExternalLinkPage(driver);
	}

	public void GoToExternalLinkTab() {
		externalLinkPage.clickFullMenuDropDown();
		externalLinkPage.clickOnGeneralLink();
		externalLinkPage.clickOnExternalLinkPage();

		
	}
	public void editExternalLink() {
		externalLinkPage.clickOnActionButton();
		externalLinkPage.clickOnEditExterLink();
		externalLinkPage.clickOnPreview();
		//externalLinkPage.SelectService();
		//externalLinkPage.clickOnDay();
		//externalLinkPage.clickOnWeek();
		//externalLinkPage.clickOnPrevious();
		//externalLinkPage.clickOnNext();
		externalLinkPage.clickOnClose();
		externalLinkPage.clickOnReset();
		externalLinkPage.clickOnsave();
		externalLinkPage.validateNotifyMessage();
		

	}
	public void ViewExternalLink() {
		externalLinkPage.clickOnActionButton();
		externalLinkPage.clickOnView();
		
	}
	public void ViewCopyExternalLinkk() throws AWTException {
		externalLinkPage.clickOnActionButton();
		externalLinkPage.clickOnCopyExternalLink();
		
	}
}
