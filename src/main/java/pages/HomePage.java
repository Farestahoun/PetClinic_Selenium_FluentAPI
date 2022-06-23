package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

	// **********Constructor**********
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// **********Web Elements**********
	private By findOwners = By.xpath("//span[contains(text(),'Find owners')]");

	// **********Page Methods- Open find owner page**********
	public FindOwnersPage openFindOwnersPage() {
		clickButton(findOwners);
		return new FindOwnersPage(driver);
	}

}
