package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.OwnerInformationPage;

public class EditOwnerTest extends TestBase {

	// **Validate that user can edit onwer with valid data**
	@Test
	public void validEditownerTest() {
		long executionTime = System.currentTimeMillis();

		// **Given: New owner added and added data checked**
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
				.setOwnerData("Gaber", "Hager" + executionTime, "Nahriaaa", "Tantaaa", "01234239").addValidOwner()
				.checkOwnerInformation("Gaber", "Hager" + executionTime, "Nahriaaa", "Tantaaa", "01234239");
		// **And: New added owner displayed in owner infomationpage when i search for**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Hager" + executionTime).validSearch()
				.checkOwnerInformation("Gaber", "Hager" + executionTime, "Nahriaaa", "Tantaaa", "01234239");
		// **When: i edit added owner** Then: It should be edited**
		(new OwnerInformationPage(driver)).openEditOwnerPage()
				.editOwner("Margerin", "Hegrin" + executionTime, "kölnstrasse", "köln", "457432").validEdit()
				.checkOwnerInformation("Margerin", "Hegrin" + executionTime, "kölnstrasse", "köln", "457432");
		// **And: new edited owner should exist when i search for**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Hegrin" + executionTime).validSearch()
				.checkOwnerInformation("Margerin", "Hegrin" + executionTime, "kölnstrasse", "köln", "457432");
		// **And: old edited owner shouldnot exist when i search for**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Hager" + executionTime).invalidSearch()
				.checkSearchErrorMsg("has not been found");
	}

}
