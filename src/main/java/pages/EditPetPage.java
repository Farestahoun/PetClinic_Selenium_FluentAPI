package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditPetPage extends PageBase {

	// *********Constructor*********
	public EditPetPage(WebDriver driver) {
		super(driver);
	}

	// *********Web Elements*********
	private By nameTxtBox = By.id("name");
	private By birthDateTxtBox = By.id("birthDate");
	private By dropDownList = By.id("type");
	private By updatePetBtN = By.xpath("//button[@type='submit' and @class='btn btn-default' ]");

	// *********Page Methods*********

	// *********set data*********
	public EditPetPage setEditPetData(String name, String birthDate, String type) {
		clearText(nameTxtBox);
		setTextElementText(nameTxtBox, name);
		clearText(birthDateTxtBox);
		setTextElementText(birthDateTxtBox, birthDate);
		selectDropDownList(dropDownList, type);
		return this;
	}

	// *********valid edit pet*********
	public OwnerInformationPage validEditPet() {
		// *********click Updat pet Btn*********
		clickButton(updatePetBtN);
		// *********take instance from OwnerInformationPage *********
		return new OwnerInformationPage(driver);
	}

	// *********invalid edit pet*********
	public EditPetPage invalidEditPet() {
		// *********click Updat pet Btn*********
		clickButton(updatePetBtN);
		// *********take instance from current class EditPetPage *********
		return this;
	}

}
