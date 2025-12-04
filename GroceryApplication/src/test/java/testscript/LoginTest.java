package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	@Test
	public void verifyUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
		
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSignin();
		boolean homepage = loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepage);
	}
	@Test(description = "Used to verify the user with incorrect username and correct password")
	public void verifyUserIsAbleToLoginUsingIncorrectUsernameAndcorrectPassword() throws IOException
	{
		String username = ExcelUtilities.getStringData(2, 0, "loginpage");
		String password = ExcelUtilities.getStringData(2, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSignin();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
	@Test(description = "Used to verify the user with correct username and incorrect password")
	public void verifyUserIsAbleToLoginUsingCorrectUsernameAndIncorrectPassword() throws IOException
	{
		String username = ExcelUtilities.getStringData(3, 0, "loginpage");
		String password = ExcelUtilities.getStringData(3, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSignin();
		loginpage.isAlertDisplayed();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
		
	}
	@Test(description = "Used to verify the user with invalid credentials")
	public void verifyUserIsAbleToLoginUsingIncorrectUsernameAndIncorrectPassword() throws IOException
	{
		String username = ExcelUtilities.getStringData(4, 0, "loginpage");
		String password = ExcelUtilities.getStringData(4, 1, "loginpage") ;
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSignin();
		loginpage.isAlertDisplayed();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
		
	}
	

}

