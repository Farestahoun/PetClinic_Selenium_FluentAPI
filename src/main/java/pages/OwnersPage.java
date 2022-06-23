package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OwnersPage extends PageBase {

	// *********Constructor*********
	public OwnersPage(WebDriver driver) {
		super(driver);
	}

	// *********Web Elements of Searching for two added nonunique owners*********
	private By firstrowName = By.xpath("//*[@id=\"owners\"]/tbody/tr[1]/td[1]/a");
	private By secondRowName = By.xpath("//*[@id=\"owners\"]/tbody/tr[2]/td[1]/a");

	// *********Page Methods*********

	// *********Check precence of two added owners*********
	public OwnersPage checkAddedOwners(String expectedName) {
		String firstRowText = driver.findElement(firstrowName).getText();
		Assert.assertTrue(firstRowText.equals(expectedName));

		String secondRowText = driver.findElement(secondRowName).getText();
		Assert.assertTrue(secondRowText.equals(expectedName));
		return this;
	}

	// *********open first row*********
	public OwnerInformationPage clickFirstRow() {
		clickButton(firstrowName);
		return new OwnerInformationPage(driver);
	}

}
