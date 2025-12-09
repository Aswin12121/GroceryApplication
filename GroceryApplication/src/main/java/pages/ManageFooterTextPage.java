package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']") WebElement ManageFooterTextMoreInfo;
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']") WebElement ActionIcon;
	@FindBy(xpath = "//textarea[@name='address']")WebElement Address;
	@FindBy(xpath = "//input[@name='email']")WebElement email ;
	@FindBy(xpath = "//input[@name='phone']")WebElement Phone;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")WebElement UpdateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alert ;
	
	public WebDriver driver;
	
	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	public void clickOnmoreInfo()
	{
		ManageFooterTextMoreInfo.click();
	}
	public void clickOnAction()
	{
		ActionIcon.click();
	}
	public void enterAddress(String address2)
	{
		Address.clear();
		Address.sendKeys(address2);
	}
	public void enterEmail(String email2)
	{
		email.clear();
		email.sendKeys(email2);
	}
	public void enterPhone(String phone2)
	{
		Phone.clear();
		Phone.sendKeys(phone2);
	}
	public void clickOnUpdateButton()
	{
		UpdateButton.click();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}