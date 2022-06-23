package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	// *********Variable from WebDriverWait*********
	public WebDriverWait wait;
	// *********Variable from WebDriver*********
	public static WebDriver driver;

	// *********ExplicitWait_locating of all Elements*********
	public void waitVisibility(By elementBy) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	}
}
