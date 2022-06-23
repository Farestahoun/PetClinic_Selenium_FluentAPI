package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.OwnerInformationPage;
import pages.OwnersPage;

public class SearchForOwnerTest extends TestBase {

	// ** Validate that user can search for unique added owner successfully**
	@Test
	public void validSearch_UniqueOwner() {
		long executionTime = System.currentTimeMillis();
		// **Given: New owner added and added data checked**
		(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
				.setOwnerData("Michaelk12", "Timpek345" + executionTime, "frfr", "Tanta", "01272564239").addValidOwner()
				.checkOwnerInformation("Michaelk12", "Timpek345" + executionTime, "frfr", "Tanta", "01272564239");
		// **When: i search for added owner*Then: added owner data should display
		// in information page
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Timpek345" + executionTime).validSearch()
				.checkOwnerInformation("Michaelk12", "Timpek345" + executionTime, "frfr", "Tanta", "01272564239");
	}

	// **Validate that user can search for Nonunique added owner successfully**
	@Test
	public void validSearch_NonUniqueOwner() throws InterruptedException {
		// **Given: owner added twice**
		for (int i = 0; i < 2; i++) {
			(new HomePage(driver)).openFindOwnersPage().openAddOwnerPage()
					.setOwnerData("hamber", "shamber", "khanger", "banger", "0127284239").addValidOwner();
		}
		// **And: Added ownersdata checked**
		(new OwnerInformationPage(driver)).checkOwnerInformation("hamber", "shamber", "khanger", "banger",
				"0127284239");
		// **When: i search for this owner**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("shamber").validSearch();
		// **Then: owner should displa twice in owners page**And: owner data should
		// display in Ownerinformation page when i click on first row
		(new OwnersPage(driver)).checkAddedOwners("hamber shamber").checkAddedOwners("hamber shamber").clickFirstRow()
				.checkOwnerInformation("hamber", "shamber", "khanger", "banger", "0127284239");
	}

	// **Validate that Error Msg display when user search for not exist owner**
	@Test
	public void invalidSearch_NotExistOwner() {
		// **When: i seazrch for not exist owner **Then: Error Msg should display**
		(new HomePage(driver)).openFindOwnersPage().setsearchData("Am56437458yg5").invalidSearch()
				.checkSearchErrorMsg("has not been found");
	}
}
