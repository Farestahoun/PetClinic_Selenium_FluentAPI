package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.PageBase;

public class NewVisitTest extends TestBase {

	// **Validate that user can add new visit**
	@Test
	public void validAddVisitTest() {

		long executionTime = System.currentTimeMillis();

		// **Given: New owner added and added data checked**
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
				.setOwnerData("Mahran", "Sahran" + executionTime, "berlinerstr", "bochum", "2345678").addValidOwner()
				.checkOwnerInformation("Mahran", "Sahran" + executionTime, "berlinerstr", "bochum", "2345678");
		// **And: New added owner display in ownerinformation page when i search for**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Sahran" + executionTime).validSearch()
				.checkOwnerInformation("Mahran", "Sahran" + executionTime, "berlinerstr", "bochum", "2345678")
				// **And: i add new pet**Then: OwnerInformation page should display**
				.clickaddNewPetBtN().setPetData("khawaga", "1950-11-11", "cat").addValidPet()
				.checkAddedPetData("khawaga", "1950-11-11", "cat");
		// **And:pet display in ownerinformationpage when i search for its owner**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Sahran" + executionTime).validSearch()
				.checkAddedPetData("khawaga", "1950-11-11", "cat")
				// **When: i add new visit**
				.clickAddVisitBtN().setaddVisitData("Halsschmerz").addValidVisit()
				// **Then: date and des. of added visit should display in Onerinformationpage**
				.checkAddedVisitData(new PageBase(driver).addMoreYear(1), "Halsschmerz");
		// **And: added visit display under its owner when i search for this owner**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Sahran" + executionTime).validSearch()
				.checkAddedVisitData(new PageBase(driver).addMoreYear(1), "Halsschmerz");
	}

	// **Validate that user cannot add visit when description field is blank**
	@Test
	public void invalidAddVisitTest_DescriptionFBlank() {

		long executionTime = System.currentTimeMillis();

		// **Given: New owner added and added data checked**
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
				.setOwnerData("Shawal", "Ramdan" + executionTime, "berlinStr", "Wattenscheid", "5464654")
				.addValidOwner()
				.checkOwnerInformation("Shawal", "Ramdan" + executionTime, "berlinStr", "Wattenscheid", "5464654");
		// **And: New added owner display in ownerinformation page when i search for**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Ramdan" + executionTime).validSearch()
				.checkOwnerInformation("Shawal", "Ramdan" + executionTime, "berlinStr", "Wattenscheid", "5464654")
				// **And: i add new pet**Then: OwnerInformation page should display**
				.clickaddNewPetBtN().setPetData("Fawzy", "1940-11-10", "cat").addValidPet()
				.checkAddedPetData("Fawzy", "1940-11-10", "cat");
		// **And:pet display in ownerinformationpage when i search for its owner**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Ramdan" + executionTime).validSearch()
				.checkAddedPetData("Fawzy", "1940-11-10", "cat")
				// **When: i leave required description field blank during adding visit**Then:
				// Error Msg should display
				.clickAddVisitBtN().setaddVisitData("").addInValidVisit().checkErrorMSgs(null, "must not be empty");
	}

	// **Validate that user cannot add visit when date format doesnot match**
	@Test
	public void invalidAddVisitTest_DateFNotMatch() {
		long executionTime = System.currentTimeMillis();

		// **Given: New owner added and added data checked**
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
				.setOwnerData("Tamer", "Kady" + executionTime, "kölnerstr", "bambenberg", "7555443").addValidOwner()
				.checkOwnerInformation("Tamer", "Kady" + executionTime, "kölnerstr", "bambenberg", "7555443");
		// **And: New added owner display in ownerinformation page when i search for**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Kady" + executionTime).validSearch()
				.checkOwnerInformation("Tamer", "Kady" + executionTime, "kölnerstr", "bambenberg", "7555443")
				// **And: i add new pet**Then: OwnerInformation page should display**
				.clickaddNewPetBtN().setPetData("Fawaz", "1970-11-15", "cat").addValidPet()
				.checkAddedPetData("Fawaz", "1970-11-15", "cat");
		// **And:pet display in ownerinformationpage when i search for its owner**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Kady" + executionTime).validSearch()
				.checkAddedPetData("Fawaz", "1970-11-15", "cat")
				// **When: Dateformat doesnot match when add visit**Then:ErrorMsg should display
				.clickAddVisitBtN().setAddVisitData_DFNotMatch("09/30/2021", "kalt").addInValidVisit()
				.checkErrorMSgs(null, null);
	}
}
