package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class AdminUserPage {
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement AdminUsersMoreInfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement NewButton;
	@FindBy(xpath="//input[@id='username']") WebElement Username;
	@FindBy(xpath = "//input[@id='password']")WebElement Password;
	@FindBy(xpath = "//select[@id='user_type']")WebElement UserType;
	@FindBy(xpath = "//button[@name='Create']") WebElement Save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement Alert;
	
	public WebDriver driver;
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickMoreInfo() {
		AdminUsersMoreInfo.click();
	}
	public void clickNew()
	{
		NewButton.click();
	}
	public void enterTheUserName(String adminUsername)
	{
		Username.sendKeys(adminUsername);
	}
	public void enterThePassword(String adminPassword)
	{
		Password.sendKeys(adminPassword);
	}
	public void userType()
	{
		PageUtilities pageutilities= new PageUtilities();
		pageutilities.selectByVisibleText(UserType,"Admin");
	}
	public void clickSave() {
		Save.click();
	}
	public boolean isAlertDisplayed() {
		return Alert.isDisplayed();
		
	}

}
