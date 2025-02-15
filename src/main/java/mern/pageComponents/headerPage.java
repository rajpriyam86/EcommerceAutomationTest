package mern.pageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mern.globalComponents.globalMethods;

public class headerPage extends globalMethods{

	WebDriver driver;
	public headerPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText ="MERN Shop")
	WebElement mernLogo;
	
	@FindBy(xpath = "//input[@placeholder='Search Products...']")
	WebElement searchProduct;
	
	@FindBy(xpath = "//button[@class = 'btn btn-warning'][1]")
	WebElement productSearchIcon;
	
	@FindBy(partialLinkText = "Cart")
	WebElement cartButton;
	
	@FindBy(xpath = "//a[contains(@class, 'nav-link') and (contains(text(), 'Sign In') or @id='username')]")
	WebElement loginOrProfileLink;
	
	public void clickTheLogo() {
		mernLogo.click();
	}
	
	public void searchProduct(String product) {
		searchProduct.sendKeys(product);
		productSearchIcon.click();
	}
	
	public void goToCart() {
		cartButton.click();
	}
	
	public void clickUserNavigation() {
		loginOrProfileLink.click();
	}
	
	
	

}
