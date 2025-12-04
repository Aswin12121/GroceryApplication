package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class AdminUsersTest extends Base {
	@Test
	public void verifyTheUserIsAbleToEnterAdminUserInformation() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		String adminUsername=ExcelUtilities.getStringData(1, 0, "AdminUser");
		String adminPassword=ExcelUtilities.getStringData(1, 1, "AdminUser");
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSignin();
		
		AdminUserPage adminuserspage= new AdminUserPage(driver);
		adminuserspage.clickMoreInfo();
		adminuserspage.clickNew();
		adminuserspage.enterTheUserName(adminUsername);
		adminuserspage.enterThePassword(adminPassword);
		adminuserspage.userType();
		adminuserspage.clickSave();
		boolean alert= adminuserspage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}

}
