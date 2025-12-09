package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class ManageContactPage {
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class=' nav-link']") WebElement ManageContactmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1' and @class='btn btn-sm btn btn-primary btncss']") WebElement ActionIcon;
	@FindBy(xpath = "//input[@id='phone']") WebElement Phone;
	@FindBy(xpath = "//input[@id='email']")WebElement Email;
	@FindBy(xpath = "//textarea[@name='address']")WebElement Address;
	@FindBy(xpath = "//textarea[@name='del_time']")WebElement DeliveryTime;
	@FindBy(xpath = "//input[@name='del_limit']")WebElement DeliveryChargeLimit;
	@FindBy(xpath = "//button[@name='Update']")WebElement UpdateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alertDisplayed;

	public WebDriver driver;
	
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnMoreInfo()
	{
		ManageContactmoreinfo.click();
	}
	public void clickOnActionIcon()
	{
		ActionIcon.click();
	}
	public void updatePhone(String phone2)
	{
		Phone.clear();
		Phone.sendKeys(phone2);
	}
	public void updateEmail(String email2)
	{
		Email.clear();
		Email.sendKeys(email2);
	}
	public void updateaddress(String address2)
	{
		Address.clear();
		Address.sendKeys(address2);
	}
	public void updateDeliveryTime(String delivery_time)
	{
		DeliveryTime.clear();
		DeliveryTime.sendKeys(delivery_time);
	}
	public void updateDeliveryChargeLimit(String delivery_charge_limit)
	{
		DeliveryChargeLimit.clear();
		DeliveryChargeLimit.sendKeys(delivery_charge_limit);
	}
	public void clickOnUpdateButton()
	{
		//UpdateButton.click();
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.click(driver, UpdateButton);
	}
	public boolean alertDisplayed()
	{
		return alertDisplayed.isDisplayed();
	}

}