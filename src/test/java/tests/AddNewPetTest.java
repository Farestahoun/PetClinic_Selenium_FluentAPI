package tests;

import org.testng.annotations.Test;

import pages.HomePage;

public class AddNewPetTest extends TestBase {

	// **Validate that user can add pet with valid data**
	@Test
	public void validAddUniquePetTest() {
		long executionTime = System.currentTimeMillis();

		// **Given: New owner added and added data checked**
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
				.setOwnerData("Maher", "Mohamed" + executionTime, "Baustr", "dortmund", "65839396").addValidOwner()
				.checkOwnerInformation("Maher", "Mohamed" + executionTime, "Baustr", "dortmund", "65839396");
		// **And: New added owner display in ownerinformation page when i search for**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Mohamed" + executionTime).validSearch()
				.checkOwnerInformation("Maher", "Mohamed" + executionTime, "Baustr", "dortmund", "65839396")
				// **When: i add new pet**Then: OwnerInformation page should display**
				.clickaddNewPetBtN().setPetData("Marwan", "1980-11-10", "cat").addValidPet()
				.checkAddedPetData("Marwan", "1980-11-10", "cat");
		// **And:pet must display in ownerinformationpage when i search for its owner**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Mohamed" + executionTime).validSearch()
				.checkAddedPetData("Marwan", "1980-11-10", "cat");
	}

	// ** Validate that user cannot add new Pet in case that all fields are blank**
	@Test
	public void invalidAddUniquePetTest_NameBirthDateBlank() {
		long executionTime = System.currentTimeMillis();
		// **Given: New owner added and added data checked**
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
				.setOwnerData("Hamda", "Ibrahim" + executionTime, "Tahounstr", "omarnia", "5637347").addValidOwner()
				.checkOwnerInformation("Hamda", "Ibrahim" + executionTime, "Tahounstr", "omarnia", "5637347");
		// **And: New added owner display in ownerinformation page when i search for**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Ibrahim" + executionTime).validSearch()
				.checkOwnerInformation("Hamda", "Ibrahim" + executionTime, "Tahounstr", "omarnia", "5637347")
				// *When: i leave name and bdate blank during add pet**Then: errorMsg display*
				.clickaddNewPetBtN().setPetData("", "", "bird").addInvalidPet()
				.checkErrorMsgs("is required", "is required");
	}

	// ** Validate that user cannot add pet in case that dateformat doesnot match**
	@Test
	public void invalidAddUniquePetTest_ValidNameInvalidDateFormat() {
		long executionTime = System.currentTimeMillis();

		// **Given: New owner added and added data checked**
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
				.setOwnerData("Huda", "Shich" + executionTime, "ShichStr", "Bamberg", "64577875").addValidOwner()
				.checkOwnerInformation("Huda", "Shich" + executionTime, "ShichStr", "Bamberg", "64577875");
		// **And: New added owner display in ownerinformation page when i search for**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Shich" + executionTime).validSearch()
				.checkOwnerInformation("Huda", "Shich" + executionTime, "ShichStr", "Bamberg", "64577875")
				// *When: i enter valid name but not valid dateformat**Then: errorMsg display*
				.clickaddNewPetBtN().setPetData("saber", "gedgregreger", "bird").addInvalidPet()
				.checkErrorMsgs(null, null);
	}

}
