package utilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class PageUtilities {
	//dropdown 
	public void selectByVisibleText(WebElement element, String visibleText)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	public void selectByIndex(WebElement element, int index)
	{
		Select select= new Select(element);
		select.selectByIndex(index);
	}
	public void selectByValue(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public void acceptAlert(WebDriver driver) 
	{
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
	public void dismissAlert(WebDriver driver)
	{
		Alert alert= driver.switchTo().alert();
		alert.dismiss();
	}
	public void sendAlertText(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("Aswin");
	}
	
	//action calss
	public void dragAndDrop(WebDriver driver, WebElement element1, WebElement element2)
	{
		Actions actions= new Actions(driver);
		actions.dragAndDrop(element1, element2).perform();;
	}
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions actions= new Actions(driver);
		actions.moveToElement(element).perform();;
	}
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions actions= new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void click(WebDriver driver, WebElement element)
	{
		Actions actions= new Actions(driver);
		actions.click(element).perform();
	}
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions actions= new Actions(driver);
		actions.contextClick(element).perform();
	}

	//javascript executor
	public void sendKeysJs(WebDriver driver, WebElement element, String text)
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='value';", element);
	}
	public void scrollBYpixel(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("windows.scrollBy(arguments[0],arguments[1];",x,y);	
	}
	public void scrollToBottom(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
	}
	public void clickbyJS(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
}
