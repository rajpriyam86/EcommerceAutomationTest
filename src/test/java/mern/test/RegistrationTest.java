package mern.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import mern.base.BaseTest;
import mern.pageComponents.registrationPage;

public class RegistrationTest extends BaseTest {

	@Test (enabled = false)
	public void testSuccessfullRegistration() {
		registrationPage registrationPage = new registrationPage(getDriver());
		registrationPage.goToRegistrationPage();
		registrationPage.enterName("Priyam");
		registrationPage.enterEmail("usertest@gmail.com");
		registrationPage.enterPassword("UserTest123");
		registrationPage.enterConfirmPassword("UserTest123");
		registrationPage.clickSubmit();
		String confirmationMsg = registrationPage.getRegistrationConfimationMsg();
		Assert.assertEquals(confirmationMsg, "Registration successful. Welcome!");
	}

	@Test
	public void testShowPasswordFunctionlity() {

		registrationPage registrationPage = new registrationPage(getDriver());
		registrationPage.goToRegistrationPage();
		// Password Section
		registrationPage.enterPassword("Abc123");
		Assert.assertEquals(registrationPage.getPasswordFieldType(), "password");
		registrationPage.clickShowPassword();
		Assert.assertEquals(registrationPage.getPasswordFieldType(), "text");

		// ConfirmPassword section
		registrationPage.enterConfirmPassword("Abc123");
		Assert.assertEquals(registrationPage.getConfirmPasswordFieldType(), "password");
		registrationPage.clickShowConfirmPassword();
		Assert.assertEquals(registrationPage.getConfirmPasswordFieldType(), "text");

	}
	
	
	
	@Test
	public void testAlreadyHaveAccount() {
		registrationPage registrationPage = new registrationPage(getDriver());
		registrationPage.goToRegistrationPage();
		registrationPage.clickSignInButton();
		Assert.assertEquals(getDriver().getTitle(), "Sign In");
	}
	
}
