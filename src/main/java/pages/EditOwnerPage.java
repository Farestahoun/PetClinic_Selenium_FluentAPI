package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditOwnerPage extends PageBase {

	// ********** Constructor**********
	public EditOwnerPage(WebDriver driver) {
		super(driver);

	}

	// ********** Web Elements**********
	By firstNameTxtBoX = By.id("firstName");
	By lastNameTxtBoX = By.id("lastName");
	By adressTxtBoX = By.xpath("//input[@id='address']");
	By cityTxtBoX = By.xpath("//input[@id='city']");
	By telephoneTxtBoX = By.xpath("//input[@id='telephone']");
	By updateOwnerButton = By.xpath("//button[@type='submit']");

	// ********** Page Methods**********

	// ********** Set edit owner data**********
	public EditOwnerPage editOwner(String firstName, String lastName, String adress, String city, String telephone) {
		clearText(firstNameTxtBoX);
		setTextElementText(firstNameTxtBoX, firstName);
		clearText(lastNameTxtBoX);
		setTextElementText(lastNameTxtBoX, lastName);
		clearText(adressTxtBoX);
		setTextElementText(adressTxtBoX, adress);
		clearText(cityTxtBoX);
		setTextElementText(cityTxtBoX, city);
		clearText(telephoneTxtBoX);
		setTextElementText(telephoneTxtBoX, telephone);
		return this;
	}

	// ********** Valid Edit Owner**********
	public OwnerInformationPage validEdit() {
		clickButton(updateOwnerButton);
		return new OwnerInformationPage(driver);
	}
}