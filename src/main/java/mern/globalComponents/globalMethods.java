package mern.globalComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class globalMethods {
	WebDriver driver;

	public globalMethods(WebDriver driver) {

		this.driver = driver;

	}

	public void goTo(String url) {
		driver.get(url);

	}

	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForAttributeToLoad(WebElement element, String attributeName, String expectedAttributeValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeToBe(element, attributeName, expectedAttributeValue));
	}

	public void moveAndClickTOElement(WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();

	}

}
