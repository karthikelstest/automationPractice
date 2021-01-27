package pageObjects;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import utilities.utilities;



public class HomePage { 
	Logger logger=LogManager.getLogger(HomePage.class);
	
	public WebDriver testdriver;
	
	public HomePage(WebDriver tdriver)
	{
		testdriver=tdriver;
		PageFactory.initElements(tdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"index\"]")
	@CacheLookup
	WebElement cartBanner;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")
	@CacheLookup
	WebElement continueShopping;

	@FindBy(className="login")
	@CacheLookup
	WebElement loginLink;
	
	public void clickLogin()
	{ 
		
		Actions actions = new Actions(testdriver);
		actions.moveToElement(loginLink);
		actions.perform();
		loginLink.click();
	}
	
	public void clickContinueShopping()
	{
		Actions action = new Actions(testdriver);
		action.moveToElement(cartBanner).moveToElement(continueShopping).click().build().perform();
	}
	
	public void focusAddCart(String dressName)
	{
		List<WebElement> featuredDressList = testdriver.findElements(By.xpath("*//img[@class='replace-2x img-responsive']"));
		int dressCounter=0;
		for (WebElement dressLinks : featuredDressList )
		{
			String dressNameText = dressLinks.getAttribute("alt");
			dressCounter++;
			logger.error("Found Dress# : "+dressNameText + " : Expected# : "+dressName+ " : DressCounter : "+dressCounter);
			if(Objects.equals(dressName, dressNameText))
			{
				logger.error("Match Found : Actual# "+dressNameText + " : Expected# "+dressName);
				//move to the identified dress image
				utilities.pause(2000); //pausing to observe screen action
				Actions action1 = new Actions(testdriver);
				action1.moveToElement(dressLinks);

				//bring 'add to cart' into view and click on it
				utilities.pause(2000); //pausing to observe screen action
				WebElement cartLink=testdriver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li["+String.valueOf(dressCounter)+"]/div/div[2]/div[2]/a[1]"));
				Actions action2 = new Actions(testdriver);
				//clicks on add-to-cart
				action2.moveToElement(dressLinks).moveToElement(cartLink).click().build().perform();
				utilities.pause(3000); //pausing to observe screen action
				break;
			}
		}	
	}

}
