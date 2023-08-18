package action;

import org.openqa.selenium.WebDriver;

import pageobjects.StoragePage;

public class StorageAction {
	WebDriver driver;

	StoragePage storagePage;

	public StorageAction(WebDriver driver) {
		this.driver = driver;
		storagePage = new StoragePage(driver);
	}

	public void GoToStorageTab() {
		storagePage.clickFullMenuDropDown();
		storagePage.clickOnGeneralLink();
		storagePage.clickOnStoragePage();

	}
	public void allocateSpace() {
		storagePage.setScreenshotAllocationSpace();

		storagePage.setFileAllocationSpace();
		storagePage.setDocStorageAllocationSpace();
		storagePage.setTransactionSizeAllocationSpace();
		storagePage.clickOnSaveButton();
		storagePage.validateNotifyMessage();
	}
}
