package mern.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import mern.base.BaseTest;
import mern.pageComponents.loginPage;

public class LoginTest extends BaseTest {

	@Test
	public void testLogin() {

		loginPage login = new loginPage(getDriver());
		login.goTo("http://localhost:3000/");
		String loginConfirmationMsg = login.login("john@email.com", "john123");
		Assert.assertEquals(loginConfirmationMsg, "Login successful");
	}

}
