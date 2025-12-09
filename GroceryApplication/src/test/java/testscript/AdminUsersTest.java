
package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;

import utilities.ExcelUtilities;

public class AdminUsersTest extends Base {
	@Test
	public void verifyUserIsAbleToEnterAdminUserInformations() throws IOException
	{
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		String adminUsername=ExcelUtilities.getStringData(1, 0, "adminuser");
		String adminPassword=ExcelUtilities.getStringData(1, 1, "adminuser");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSignin();

		AdminUsersPage adminuserstest = new AdminUsersPage(driver);
		adminuserstest.clickMoreInfo();
		adminuserstest.clickNew();
		adminuserstest.enterTheUserName(adminUsername);
		adminuserstest.enterThePassword(adminPassword);
		adminuserstest.userType();
		adminuserstest.clickSave();
		boolean alert = adminuserstest.isAlertDisplayed();
		Assert.assertTrue(alert);
		
	}
		
}
