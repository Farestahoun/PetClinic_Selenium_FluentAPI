package tests;

import org.testng.annotations.Test;

import pages.HomePage;

public class EditPetTest extends TestBase {

	// **Validate that user can added pet with valid data**
	@Test
	public void userCanEditPet() {
		long executionTime = System.currentTimeMillis();

		// **Given: New owner added and added data checked**
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
				.setOwnerData("Khaled", "Saiad" + executionTime, "darmStr", "Darmstadt", "25343543").addValidOwner()
				.checkOwnerInformation("Khaled", "Saiad" + executionTime, "darmStr", "Darmstadt", "25343543");
		// **And: New added owner display in ownerinformation page when i search for**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Saiad" + executionTime).validSearch()
				.checkOwnerInformation("Khaled", "Saiad" + executionTime, "darmStr", "Darmstadt", "25343543")
				// **And: i add new pet**Then: OwnerInformation page should display**
				.clickaddNewPetBtN().setPetData("cristina", "1970-12-11", "cat").addValidPet()
				.checkAddedPetData("cristina", "1970-12-11", "cat");
		// **And:pet must display in ownerinformationpage when i search for its owner**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Saiad" + executionTime).validSearch()
				.checkAddedPetData("cristina", "1970-12-11", "cat").
				// **When: i edit Name and Birthdate in Pet page with valid data**
				clickEditPetBtN().setEditPetData("Mahitar", "1960-10-10", "cat").validEditPet()
				// **Then: Ownerinformation should display contains new data**
				.checkAddedPetData("Mahitar", "1960-10-10", "cat");
		// **And: new edited pet should exist under its owner when i search for**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Saiad" + executionTime).validSearch()
				.checkAddedPetData("Mahitar", "1960-10-10", "cat");
		// **And: old edited owner shouldnot exist under its owner when i search for**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Saiad" + executionTime).validSearch()
				.checkNotPresenceEditetPet("cristina", "1970-12-11", "animal");
	}

}
