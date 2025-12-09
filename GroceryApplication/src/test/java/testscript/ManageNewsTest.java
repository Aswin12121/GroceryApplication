package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	
	@Test
	public void verifyTheUserIsAbleToEnterTheManageNews() throws IOException
	{
		String username= ExcelUtilities.getStringData(1, 0, "loginpage");
		String password= ExcelUtilities.getStringData(1, 1, "loginpage");
		String enternews= ExcelUtilities.getStringData(0, 0, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSignin();
		ManageNewsPage managenewspage= new ManageNewsPage(driver);
		managenewspage.clickMoreInfo();
		managenewspage.newButton();
		managenewspage.enterTheNews(enternews);
		managenewspage.save();
		boolean alert= managenewspage.isAlertDisplayed();
		Assert.assertTrue(alert);
		
	}

}
