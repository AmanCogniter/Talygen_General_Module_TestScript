package testcases;

import static reporting.ComplexReportFactory.getTest;

import java.awt.AWTException;

import org.testng.annotations.Test;

import action.ExternalLinkAction;
import action.LoginAction;
import utils.WebTestBase;

public class ExternalLinkTest extends WebTestBase {
	static String Screenname = "<b>Edit External Link </b>";

	/* Validate Edit functionality of External Link*/
	@Test(priority = 1)
	public void validateEditfunctionalityOfExternalLink() {

		test = getTest(Screenname + ":  Validate Edit functionality of External Link");
		ExternalLinkAction externalLinkAction = new ExternalLinkAction(driver);
		new LoginAction(driver).logoutLogin();
		externalLinkAction.GoToExternalLinkTab();
		externalLinkAction.editExternalLink();

	}
	/* Validate View functionality of External Link*/
	@Test(priority = 2)
	public void validateViewfunctionalityOfExternalLink() {

		test = getTest(Screenname + ":  Validate View functionality of External Link");
		ExternalLinkAction externalLinkAction = new ExternalLinkAction(driver);
		new LoginAction(driver).logoutLogin();
		externalLinkAction.GoToExternalLinkTab();
		externalLinkAction.ViewExternalLink();

	}
	/* Validate Copy External Link functionality of External Link*/
	@Test(priority = 3)
	public void validateCopyExternalLinkfunctionalityOfExternalLink() throws AWTException {

		test = getTest(Screenname + ":  Validate Copy External Link functionality of External Link");
		ExternalLinkAction externalLinkAction = new ExternalLinkAction(driver);
		new LoginAction(driver).logoutLogin();
		externalLinkAction.GoToExternalLinkTab();
		externalLinkAction.ViewCopyExternalLinkk();

	}
}
