package mern.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import mern.base.BaseTest;
import mern.pageComponents.resetPasswordPage;

public class RestetPasswordTest extends BaseTest{
	
	@Test
	public void testResetPasswordFuntionality() {
		resetPasswordPage resetPasswordUtility = new resetPasswordPage(getDriver());
		String message = resetPasswordUtility.resetPassword("john@email.com");
		Assert.assertEquals(message, "Password reset email sent, please check your email.");
	}

}
