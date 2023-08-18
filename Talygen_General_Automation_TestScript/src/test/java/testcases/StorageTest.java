package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.LoginAction;
import action.StorageAction;
import utils.WebTestBase;

public class StorageTest extends WebTestBase{
	static String Screenname = "<b> Storage</b>";

	/* Validation check and Allocate Space on Storage Screen */
	@Test(priority = 1)
	public void allocateSpaceOnManageStoragePage() {

		test = getTest(Screenname + ":  Allocate Space On Manage Storage Page");
		StorageAction storageAction = new StorageAction(driver);
		new LoginAction(driver).logoutLogin();
		storageAction.GoToStorageTab();
		storageAction.allocateSpace();

	}
}
