package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	@Test
	public void verifyUserIsAbleToAccessManageContactPage() throws IOException
	{
		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		String phone = ExcelUtilities.getIntegerData(0, 0, "contact");
		String email = ExcelUtilities.getStringData(1, 0, "contact");
		String address = ExcelUtilities.getStringData(2, 0, "contact");
		String delivery_time = ExcelUtilities.getIntegerData(3,0 , "contact");
		String delivery_charge_limit = ExcelUtilities.getIntegerData(4, 0, "contact");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterThePassword(password);
		loginpage.clickSignin();
		
		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage.clickOnMoreInfo();
		managecontactpage.clickOnActionIcon();
		managecontactpage.updatePhone(phone);
		managecontactpage.updateEmail(email);
		managecontactpage.updateaddress(address);
		managecontactpage.updateDeliveryTime(delivery_time);
		managecontactpage.updateDeliveryChargeLimit(delivery_charge_limit);
		managecontactpage.clickOnUpdateButton();
		boolean alert = managecontactpage.alertDisplayed();
		Assert.assertTrue(alert);
		
	}

}