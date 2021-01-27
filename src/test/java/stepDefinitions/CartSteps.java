package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.HomePage;
import utilities.utilities;


public class CartSteps {
	
	public WebDriver driver;
	public HomePage hp;
	
	@Given("The website is launched URL {string}")
	public void the_website_is_launched_url(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		hp=new HomePage(driver);
		//open the URL
		driver.get(url);
		//maximize window
		driver.manage().window().maximize();
	}

	@When("Page Title is {string}")
	public void page_title_is(String title) {
		//check if displayed page title is as expected
		if(driver.getTitle()==title) 
		{
			Assert.assertTrue(false);
		}
		else 
		{
			Assert.assertEquals(title, driver.getTitle());
		}
	}
	
	@Then("Add Dress to Cart {string}")
	public void add_dress_to_cart(String dressName) {
		hp.focusAddCart(dressName);
		utilities.pause(2000); //pausing to observe screen action
		hp.clickContinueShopping();
		
	}

	@And("Open Sign In Page")
	public void open_sign_in_page() {
		utilities.pause(2000); //pausing to observe screen action
		hp.clickLogin();
		
	}

	@Then("Close browser")
	public void close_browser() {
		//close the browser and exit
		utilities.pause(2000); //pausing to observe screen action
		driver.quit();
		
	}

}
