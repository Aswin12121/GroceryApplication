package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']") WebElement ManageNews ;
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement Newbutton;
	@FindBy(xpath="//textarea[@placeholder='Enter the news']") WebElement Enternews;
	@FindBy(xpath="//button[text()='Save']") WebElement SaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	public void clickMoreInfo()
	{
		ManageNews.click();
	}
	public void newButton()
	{
		Newbutton.click();
	}
	public void enterTheNews(String enternews2)
	{
		Enternews.sendKeys(enternews2);
	}
	public void save()
	{
		SaveButton.click();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
}
