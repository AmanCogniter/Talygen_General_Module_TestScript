package testcases;

import static reporting.ComplexReportFactory.getTest;

import java.awt.AWTException;

import org.testng.annotations.Test;

import action.LoginAction;
import action.ManageLayoutAction;
import utils.WebTestBase;
/**
 * 
 * @author aanand
 *
 */
/* Manually working fine but through automation not working . In Manage Layout page, After selecting the module name when click on serach button.Submodules are not showing in listing page*/
public class ManageLayoutTest extends WebTestBase{
	static String Screenname = "<b>Manage Layout </b>";

	/* Validate Search and Reset Button Functionality*/
	@Test(priority = 1)
	public void  ValidateSearchAndResetButtonFunctionality() throws AWTException {

		test = getTest(Screenname + ":  Validate Search and Reset Button Functionality");
		ManageLayoutAction manageLayoutAction = new ManageLayoutAction(driver);
		new LoginAction(driver).logoutLogin();
		manageLayoutAction.GoToManageLayoutTab();
		manageLayoutAction.checkFunctionalityOfSearchAndResetButton();

	}
}
