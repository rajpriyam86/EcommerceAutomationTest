package mern.pageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mern.globalComponents.globalMethods;

public class resetPasswordPage extends globalMethods{

	WebDriver driver;
	public resetPasswordPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(xpath="//button[@type='submit' and text() = 'Submit']")
	WebElement resetPasswordSubmitButton;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement resetEmailConfirmtion;
	
	@FindBy(partialLinkText = "Forgot password")
	WebElement forgotPasswordButton;
	
	public String resetPassword(String Email) {
		goTo("https://mern-shop-abxs.onrender.com/login");
		forgotPasswordButton.click();
		email.sendKeys(Email);
		waitForElement(resetPasswordSubmitButton);
		resetPasswordSubmitButton.click();
		return resetEmailConfirmtion.getText();
	}
	
	

}
