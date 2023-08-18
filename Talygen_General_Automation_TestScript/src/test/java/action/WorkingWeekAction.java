package action;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import pageobjects.WorkingDayPage;
import pageobjects.WorkingWeekPage;

public class WorkingWeekAction {
	WebDriver driver;

	WorkingWeekPage workingWeekPage;

	public WorkingWeekAction(WebDriver driver) {
		this.driver = driver;
		workingWeekPage = new WorkingWeekPage(driver);
	}

	public void GoToWorkingWeekTab() {
		workingWeekPage.clickFullMenuDropDown();
		workingWeekPage.clickOnGeneralLink();
		workingWeekPage.clickOnWorkingWeekPage();

	}

	public void checkFunctionalityofSetUpWoorkingWeek() throws AWTException {
		workingWeekPage.clickOnUserGuide();
		workingWeekPage.clickOnSelectChooseShift();
		workingWeekPage.clickOnSelectWorkingOrNonWorkingDay();
		workingWeekPage.clickOnSaveButton();
		workingWeekPage.clickOnOKButton();
		workingWeekPage.validateNotifyMessage();

	}

	public void checkFunctionalityofResetButton() {
		workingWeekPage.clickOnUserGuide();
		workingWeekPage.clickOnSelectChooseShift();

		workingWeekPage.clickOnResetButton();

	}
}
