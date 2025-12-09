package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtilities;

public class ManageCategoryTest extends Base {
	@Test
	public void verifyUserIsAbleToAccessCategoryInformations() throws IOException
	{
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSignin();
		
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.clickOnMoreInfo();
		managecategorypage.clickOnNewButton();
		managecategorypage.enterCategory();
		managecategorypage.chooseFileButtonClick();
		managecategorypage.clickOnDiscount();
		managecategorypage.clickOnSaveButton();
		boolean alert = managecategorypage.isAlertDisplayed();
		Assert.assertTrue(alert);
		
	}

}