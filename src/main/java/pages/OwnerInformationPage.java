package pages;

import org.openqa.selenium.By;

//import java.security.PublicKey;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class OwnerInformationPage extends PageBase {

	// *********Constructor*********
	public OwnerInformationPage(WebDriver driver) {
		super(driver);
	}

	// *********Web Elements*********
	public By ownerNameThatIsSerachFor = By.xpath("//table/tbody/tr/td/b");

	// ********* Web Elements of Owner Information Table*********
	private By nameRow = By.xpath("//table[1]/tbody/tr[1]/td[1]");
	private By adressRoW = By.xpath("//table/tbody/tr[2]/td[1]");
	private By cityRow = By.xpath("//table/tbody/tr[3]/td[1]");
	private By telephoneRow = By.xpath("//table/tbody/tr[4]/td[1]");

	// *********Web Elements of Edit Owner and Add new Pet BtN*********
	private By editOwnerButton = By.xpath("//a[@class='btn btn-default'][1]");
	private By addNewPetBtN = By.xpath("//a[@class='btn btn-default'][2]");
	private By editPetBtN = By.xpath("//table[2][@class='table table-striped']/tbody/tr/td[2]/table/tbody/tr/td[1]/a");
	private By addVisitBtN = By.xpath("//table[2][@class='table table-striped']/tbody/tr/td[2]/table/tbody/tr/td[2]/a");

	// *********Web Elemnts of Pets Table *********
	private By AddedPetName = By.xpath("//table[2][@class='table table-striped']/tbody/tr/td[1]/dl/dd[1]");
	private By addedBirthDate = By.xpath("//table[2][@class='table table-striped']/tbody/tr/td[1]/dl/dd[2]");
	private By addedType = By.xpath("//table[2][@class='table table-striped']/tbody/tr/td[1]/dl/dd[3]");

	// *********Web Elements of Visit Table*********
	private By addedVisitDate = By.xpath("//table[@class='table-condensed']/tbody/tr[1]/td[1]");
	private By addedDesciption = By.xpath("//table[@class='table-condensed']/tbody/tr[1]/td[2]");

	// *********Page Methods*********

	// *********Check data of added owner successfully*********
	public OwnerInformationPage checkOwnerInformation(String firstName, String lastName, String addedAdress,
			String addedCity, String addedTelephone) {
		SoftAssert soft = new SoftAssert();
		String nameText = driver.findElement(nameRow).getText();
		soft.assertEquals(nameText, firstName + " " + lastName);
		String adressText = driver.findElement(adressRoW).getText();
		soft.assertEquals(adressText, addedAdress);
		String cityText = driver.findElement(cityRow).getText();
		soft.assertEquals(cityText, addedCity);
		String telephoneText = driver.findElement(telephoneRow).getText();
		Assert.assertEquals(telephoneText, addedTelephone);
		return this;
	}

//	public void hardAssertForSearchingForAlreadyAddedOwner(String addedOwnerSearchFor)
//
//	{
//		String searchedOwnerText = driver.findElement(ownerNameThatIsSerachFor).getText();
//		Assert.assertTrue(searchedOwnerText.contains(addedOwnerSearchFor));
//	}

	// *********click edit Owner Btn*********
	public EditOwnerPage openEditOwnerPage() {
		clickButton(editOwnerButton);
		return new EditOwnerPage(driver);
	}

	// *********click add new pet Btn*********
	public AddNewPetPage clickaddNewPetBtN() {
		clickButton(addNewPetBtN);
		return new AddNewPetPage(driver);
	}

	// *********Check data of added pet successfully*********
	public OwnerInformationPage checkAddedPetData(String expectedName, String expectedBirthDate, String expectedType) {
		String atcualName = driver.findElement(AddedPetName).getText();
		Assert.assertEquals(atcualName, expectedName);
		String actualBirthDate = driver.findElement(addedBirthDate).getText();
		Assert.assertEquals(actualBirthDate, expectedBirthDate);
		String actualType = driver.findElement(addedType).getText();
		Assert.assertEquals(actualType, expectedType);
		return this;
	}

	// *********click edit Pet Btn*********
	public EditPetPage clickEditPetBtN() {
		clickButton(editPetBtN);
		return new EditPetPage(driver);
	}

	// *********click add visit Btn*********
	public NewVisitPage clickAddVisitBtN() {
		clickButton(addVisitBtN);
		return new NewVisitPage(driver);
	}

	// *********check not presence of pet data which has been edited*********
	public OwnerInformationPage checkNotPresenceEditetPet(String expectedName, String expectedBirthDate,
			String expectedType) {
		String atcualName = driver.findElement(AddedPetName).getText();
		Assert.assertNotEquals(atcualName, expectedName);
		String actualBirthDate = driver.findElement(addedBirthDate).getText();
		Assert.assertNotEquals(actualBirthDate, expectedBirthDate);
		String actualType = driver.findElement(addedType).getText();
		Assert.assertNotEquals(actualType, expectedType);
		return this;
	}

	// *********check data of added visit*********
	public OwnerInformationPage checkAddedVisitData(String expectedDate, String expectedDescription) {
		String atcualDate = driver.findElement(addedVisitDate).getText();
		Assert.assertEquals(atcualDate, expectedDate);
		String actualDescription = driver.findElement(addedDesciption).getText();
		Assert.assertEquals(actualDescription, expectedDescription);
		return this;
	}

//	public FindOwnersPage openFindOwnerPage() {
//		clickButton(findOwnersTab);
//		return new FindOwnersPage(driver);
//	}
}
