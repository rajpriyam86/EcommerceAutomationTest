package mern.pageComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mern.globalComponents.globalMethods;

public class homePage extends globalMethods {

	WebDriver driver;

	public homePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// carousel is image slider
	@FindBy(xpath = "//div[contains(@class,'carousel-item') and contains (@class , 'active')]")
	WebElement activeCarousel;

	@FindBy(xpath = "//div[contains(@class,'carousel-item')]")
	List<WebElement> carouselList; // for future use

	@FindBy(xpath = "//span[@class= 'carousel-control-next-icon']")
	WebElement nextcarousel;

	@FindBy(xpath = "//span[@class= 'carousel-control-prev-icon']")
	WebElement previouscarousel;

	@FindBy(xpath = "//button[contains(@aria-label, 'Slide')]")
	List<WebElement> carouselDots;

	public String activeSlideItem() {
		return activeCarousel.getText();
	}

	public void goToNextSlide() {
		nextcarousel.click();
	}

	public void goToPrevSlide() {
		previouscarousel.click();
	}

	public void selectSpecificSlideDot(int i) {
		carouselDots.get(i).click();
	}

	public String getActiveSlideAttribute(String attribute) {
		waitForElement(activeCarousel);
		return activeCarousel.getAttribute(attribute);
	}

}
