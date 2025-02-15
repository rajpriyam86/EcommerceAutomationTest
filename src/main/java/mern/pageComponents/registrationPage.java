package mern.pageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mern.globalComponents.globalMethods;

public class registrationPage extends globalMethods {

	WebDriver driver;

	public registrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(partialLinkText = "Register")
	WebElement registerButton;

	@FindBy(id = "name")
	WebElement name;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirmPassword")
	
	WebElement confirmPassword;

	@FindBy(id = "togglePasswordVisibility")
	WebElement isPasswordVisible;

	@FindBy(id = "toggleConfirmPasswordVisibility")
	WebElement isConfirmPasswordVisible;

	@FindBy(partialLinkText = "Sign")
	WebElement signInButton;

	@FindBy(xpath = "//button[@type='submit' and contains(@class,'mb-3 ')]")
	WebElement submitButton;

	@FindBy(xpath = "//div[@class='Toastify__toast-body']/div[2]")
	WebElement registrationConfirmation;

	public void goToRegistrationPage() {
		goTo("http://localhost:3000/login");
		registerButton.click();
	}

	public void enterName(String Name) {
		name.sendKeys(Name);
	}

	public void enterEmail(String Email) {
		email.sendKeys(Email);
	}

	public void enterPassword(String Password) {
		password.sendKeys(Password);
	}

	public void enterConfirmPassword(String ConfirmPassword) {
		confirmPassword.sendKeys(ConfirmPassword);
	}

	public void clickShowPassword() {
		isPasswordVisible.click();
	}

	public void clickShowConfirmPassword() {
		isConfirmPasswordVisible.click();
	}

	public String getPasswordFieldType() {
		
		return password.getAttribute("type");
	}

	public String getConfirmPasswordFieldType() {
		
		return confirmPassword.getAttribute("type");
	}

	public void clickSubmit() {
		submitButton.click();
	}

	public String getRegistrationConfimationMsg() {
		waitForElement(registrationConfirmation);
		return registrationConfirmation.getText(); // Registration successful. Welcome!
	}

	public void clickSignInButton() {
		signInButton.click();
	}

}
