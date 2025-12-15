package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constants;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	@Test(description="Used to verify the user eith valid credentials")/*(groups = {"Regression"},retryAnalyzer= retry.Retry.class)*/
	public void verifyUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
		
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSignin();
		boolean homepage = loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepage,Constants.LOGINCORRECTUSERNAMEANDPASSWORD);
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
		Assert.assertTrue(alert,Constants.LOGININCORRECTUSERNAMEANDCORRECTPASSWORD);
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
		Assert.assertTrue(alert,Constants.LOGINCORRECTUSERNAMEANDINCORRECTPASSWORD);
		
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
		Assert.assertTrue(alert,Constants.LOGININCORRECTUSERNAMEANDPASSOWRD);
		
	}
	@DataProvider(name="LoginProvider")
	public Object[][] getDataFromTestData() throws IOException{
		return new Object[][] {{ExcelUtilities.getStringData(4, 0,"loginpage"),ExcelUtilities.getStringData(4,1,"loginpage")}};
	

	}
}

