package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NewVisitPage extends PageBase {

	// *********Construtor*********
	public NewVisitPage(WebDriver driver) {
		super(driver);
	}

	// *********Web Elements*********
	private By dateTxtBox = By.id("date");
	private By descriptionTxtBox = By.id("description");
	private By addVisitBtN = By.xpath("//button[@type='submit' ]");

	// *********Web Elements of Error Msgs*********
	private By dateErrorMsg = By
			.xpath("//div[@class='container-fluid']/div/form/div/div[1]/div/span[@class = 'help-inline']");
	private By dCErrorMsg = By
			.xpath("//div[@class='container-fluid']/div/form/div/div[2]/div/span[@class = 'help-inline']");

	// *********Page Methods********

	// *********set add visit data*********
	public NewVisitPage setaddVisitData(String expectedDescription) {
		clearText(dateTxtBox);
		// *********get current dynamic and increment one year*********
		setTextElementText(dateTxtBox, addMoreYear(1));
		clearText(descriptionTxtBox);
		setTextElementText(descriptionTxtBox, expectedDescription);
		return this;
	}

	// **Set value of add visit in case that Date Format doesnot match**
	public NewVisitPage setAddVisitData_DFNotMatch(String expectedDate, String expectedDescription) {
		clearText(dateTxtBox);
		setTextElementText(dateTxtBox, expectedDate);
		setTextElementText(descriptionTxtBox, expectedDescription);
		return this;
	}

	// *********add valid visit*********
	public OwnerInformationPage addValidVisit() {
		clickButton(addVisitBtN);
		return new OwnerInformationPage(driver);
	}

	// *********add invalid visit*********
	public NewVisitPage addInValidVisit() {
		clickButton(addVisitBtN);
		return this;
	}

	// *********check error Msgs*********
	public NewVisitPage checkErrorMSgs(String expectedDateError, String expectedCsErrorMsg) {
		if (expectedDateError != null) {
			String actualErrorMsg = driver.findElement(dateErrorMsg).getText();
			Assert.assertTrue(actualErrorMsg.contains(expectedDateError));
		} else {
			List<WebElement> foundElements = driver.findElements(dateErrorMsg);
			Assert.assertEquals(foundElements.size(), 0);
		}
		if (expectedCsErrorMsg != null) {
			String actualErrorMsg = driver.findElement(dCErrorMsg).getText();
			Assert.assertTrue(actualErrorMsg.contains(expectedCsErrorMsg));
		} else {
			List<WebElement> foundElements = driver.findElements(dCErrorMsg);
			Assert.assertEquals(foundElements.size(), 0);
		}
		if (jSErrorMsg(dateTxtBox)) {
			System.out.println("The entered data are valid");
		} else {
			System.out.println("The entered data are invalid");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			System.out.println((String) js.executeScript("return arguments[0].validationMessage;",
					(driver.findElement(dateTxtBox))));
		}
		return this;
	}

}
