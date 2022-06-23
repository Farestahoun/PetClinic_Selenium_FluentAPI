package tests;

import org.testng.annotations.Test;

import pages.HomePage;

public class AddOwnersTest extends TestBase {

	// **Validate that user can add onwer with valid data**
	@Test
	public void validAddOwnerTest() {
		long executionTime = System.currentTimeMillis();
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
				.setOwnerData("Hamza", "Klein" + executionTime, "Nahria", "Tanta", "01272564239").addValidOwner()
				.checkOwnerInformation("Hamza", "Klein" + executionTime, "Nahria", "Tanta", "01272564239");
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Klein" + executionTime).validSearch()
				.checkOwnerInformation("Hamza", "Klein" + executionTime, "Nahria", "Tanta", "01272564239");
	}

	// **Validate that user cannot add onwer when phone contain strings**
	@Test
	public void invalidAddOwnerTest_phoneContainsStrings() {
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
				.setOwnerData("Kaln", "Maln", "swrwrwrg", "ffwfeffwe", "dfwfefwewfwef").addInvalidOwner()
				.checkErrorMessages(null, null, null, null,
						"numeric value out of bounds (<10 digits>.<0 digits> expected)");
	}

	// **Validate that user cannot add onwer when phone more than 10 Int**
	@Test
	public void invalidAddOwnerTest_phoneMoreThan10Int() {
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
				.setOwnerData("Kaln", "Maln", "swrwrwrg", "ffwfeffwe", "01265786543289765").addInvalidOwner()
				.checkErrorMessages(null, null, null, null,
						"numeric value out of bounds (<10 digits>.<0 digits> expected)");
	}

	// **Validate that user cannot add onwer when required fields blank**
	@Test
	public void invalidAddOwnerTest_requiredFieldsBlank() {
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage().setOwnerData("", "", "", "", "")
				.addInvalidOwner().checkErrorMessages("must not be empty", "must not be empty", "must not be empty",
						"must not be empty", "numeric value out of bounds (<10 digits>.<0 digits> expected)");
	}

	// **Validate that ErrorMsg displays in empty fName not in other filled fields**

	@Test
	public void invalidAddOwnerTest_fNameBlank() throws Exception {
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
				.setOwnerData("", "rffr47", "gewrggere", "gwgrgre", "987654").addInvalidOwner()
				.checkErrorMessages("must not be empty", null, null, null, null);
	}

}
