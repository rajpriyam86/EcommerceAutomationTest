package mern.pageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mern.globalComponents.globalMethods;

public class loginPage extends globalMethods {

	public loginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(id = "email")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "checkbox")
	WebElement checkBox;

	@FindBy(xpath = "//button[contains(@class, 'mb-3')]")
	WebElement signIn;
	
	@FindBy(xpath = "//div[@class='Toastify__toast-body']/div[2]")
	WebElement loginConfirmation;

	@FindBy(partialLinkText = "Forgot password")
	WebElement forgotPasswordButton;

	public String login(String username, String Password) {

		headerPage header = new headerPage(driver);
		header.loginOrProfileLink.click();
		userName.sendKeys(username);
		password.sendKeys(Password);
		checkBox.click();
		signIn.click();
		waitForElement(loginConfirmation);
		return loginConfirmation.getText();

	}

	public void clickForgotPasswordButton() {
		forgotPasswordButton.click();
	}

}
