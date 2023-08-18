package action;

import org.openqa.selenium.WebDriver;

import pageobjects.AddReportPage;
import pageobjects.CustomReportsPage;

public class CustomReportsAction {
	WebDriver driver;

	CustomReportsPage customReportsPage;
	AddReportPage addReportPage;

	public CustomReportsAction(WebDriver driver) {
		this.driver = driver;
		customReportsPage = new CustomReportsPage(driver);
		addReportPage = new AddReportPage(driver);
	}

	public void GoToAddReportPage() {
		customReportsPage.clickOnAddReport();

}
	public void validationCheckOfActiveAndInActiveAStatus() {
		addReportPage.entertextIntoCustomReportSearchField();
		addReportPage.clickOnSearchButtonOfCustomReport();
		addReportPage.validateReportNameInCustomReport();
		customReportsPage.SelectStatusAsInActive();
		customReportsPage.clickOnConfurmationButton();
		customReportsPage.SelectStatusAsActive();
		customReportsPage.clickOnConfurmationButton();
		

}
	public void validationCheckOfViewReport() {
		addReportPage.entertextIntoCustomReportSearchField();
		addReportPage.clickOnSearchButtonOfCustomReport();
		addReportPage.validateReportNameInCustomReport();
		customReportsPage.clickOnViewReport();
		customReportsPage.clickOnCRMTypeRadioButton();
		customReportsPage.clickOnSearchButton();
		customReportsPage.verifyReport();
		customReportsPage.clickOnClearButton();
		

}
}
