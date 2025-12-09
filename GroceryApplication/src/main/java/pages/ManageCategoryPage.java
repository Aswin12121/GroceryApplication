package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;
import utilities.FileUploadUtilities;
import utilities.PageUtilities;

public class ManageCategoryPage {
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']") WebElement ManageCategoryMoreInfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement NewButton;
	@FindBy(xpath = "//input[@name='category']") WebElement Category;
	@FindBy(xpath = "//input[@name='main_img']") WebElement ChooseFileButton;
	@FindBy(xpath = "//span[text()='discount']") WebElement Discount;
	@FindBy(xpath = "//button[text()='Save']") WebElement SaveButton;
	@FindBy(xpath = "//button[@aria-hidden='true']")WebElement addCategoryAlert;
	
	public WebDriver driver;
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMoreInfo()
	{
		ManageCategoryMoreInfo.click();
	}
	
	public void clickOnNewButton()
	{
		NewButton.click();
	}
	public void enterCategory()
	{
		Category.sendKeys("Category");
	}
	public void chooseFileButtonClick()
	{
		FileUploadUtilities fileuploadutilities = new FileUploadUtilities();
		fileuploadutilities.usingSendKeys(ChooseFileButton, Constants.TESTDATAFILE);
		
		//ChooseFileButton.sendKeys("C:\Users\HP\Downloads\download.png");
		//ChooseFileButton.click();
	}
	public void clickOnDiscount()
	{
		Discount.click();
	}
	public void clickOnSaveButton()
	{
		//SaveButton.click();
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.click(driver, SaveButton);
	}
	public boolean isAlertDisplayed() {
		
		return addCategoryAlert.isDisplayed();
	}
}