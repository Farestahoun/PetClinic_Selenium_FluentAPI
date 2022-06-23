package pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FindOwnersPage extends PageBase {

	// ********** Constructor**********
	public FindOwnersPage(WebDriver driver) {
		super(driver);
	}

	// ********** Web Elements**********
	By addOwnerbutton = By.xpath("//a[contains(text(),'Add Owner')]");
	By searchBox = By.xpath("//input[@name='lastName']");
	By findOwnerButton = By.xpath("//button[@type='submit']");

	// ********** Web Elements_Error Msg**********
	private By searchErrorMessage = By.xpath("//span/div/p");

	// **********Open add owner page**********
	public AddOwnersPage openAddOwnerPage() {
		clickButton(addOwnerbutton);
		return new AddOwnersPage(driver);
	}

	public FindOwnersPage setsearchData(String ownerName) {
		setTextElementText(searchBox, ownerName);
		return this;

	}

	public OwnerInformationPage validSearch() {
		clickButton(findOwnerButton);
		return new OwnerInformationPage(driver);
	}

	public FindOwnersPage invalidSearch() {
		clickButton(findOwnerButton);
		return this;
	}

	public void checkSearchErrorMsg(String ErrorMsg) {
		String actualErrorMsg = driver.findElement(searchErrorMessage).getText();
		Assert.assertTrue(actualErrorMsg.contains(ErrorMsg));
	}
}
