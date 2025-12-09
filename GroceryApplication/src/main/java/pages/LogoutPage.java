
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']") WebElement Admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']") WebElement Logout;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement signinButton;
	
	public WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnAdmin()
	{
		Admin.click();
	}
	public void clickOnLogout()
	{
		Logout.click();
	}
	public boolean isLoginPageDisplayed()
	{
		return signinButton.isDisplayed();
	}
}
