package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtilities;

public class LogoutTest extends Base {
	@Test
	public void verifyUserIsAbleToLogout() throws IOException
	{
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSignin();
		
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickOnAdmin();
		logoutpage.clickOnLogout();
		boolean LoginDisplayed = logoutpage.isLoginPageDisplayed();
		Assert.assertTrue(LoginDisplayed);
	}


}