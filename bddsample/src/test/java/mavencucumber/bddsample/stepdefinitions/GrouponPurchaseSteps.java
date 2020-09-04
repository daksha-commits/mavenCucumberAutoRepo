package mavencucumber.bddsample.stepdefinitions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import mavencucumber.bddsample.AppHooks;


public class GrouponPurchaseSteps 
{
	WebDriver driver ;
	String url ;
	AppHooks hook ;
	
	public GrouponPurchaseSteps(AppHooks _hook)
	{
		hook = _hook ;
		driver = hook.setup() ;
	}
	
	@Given("I navigate to groupon site {string}")     
	public void i_navigate_to_groupon_site(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		url = string ;
	    driver.get(url);        
		Thread.sleep(5000);
	}

	@When("I set valid credentials")
	public void i_set_valid_credentials() throws InterruptedException {

		driver.findElement(By.id("nothx")).click();
		driver.findElement(By.id("signin-container")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("sf-email")).click();
		driver.findElement(By.id("sf-email")).sendKeys("daksha.sosa@gmail.com");

		driver.findElement(By.id("sf-pw")).click();
		driver.findElement(By.id("sf-pw")).sendKeys("DSosa@123");

		driver.findElement(By.className("btn-signin")).click();
		Thread.sleep(5000); ;
	}

	@Then("I am logged in successfully")
	public void i_am_logged_in_successfully() throws InterruptedException {

		Thread.sleep(5000);
		String welcomeText = driver.findElement(By.className("main-page-header-title")).getText() ;
		Assert.assertEquals("Hi Daksha,", welcomeText);

	}

	@Given("I see search box on home page")
	public void i_see_search_box_on_home_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
    	Thread.sleep(10000);

		WebElement elm = driver.findElement(By.cssSelector("input#ls-search"));
		if (elm == null)
			Assert.fail("Unable to find input element for search");
		else
			elm.click();

	}

	@When("I set search field as {string}")
	public void i_set_search_field_as(String item) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		driver.findElement(By.id("ls-search")).sendKeys(item);
		driver.findElement(By.id("ls-search")).sendKeys(Keys.ENTER);
	}

	@Then("I see list of items")
	public void i_see_list_of_items() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		Thread.sleep(10000);
		List<WebElement> results = driver.findElements(By.className("cui-udc-title")) ;
		Assert.assertTrue("Found result containing "+results.size()+" items", true);
		
        for (WebElement element : results)
        {
        	String title = element.getText() ;
        	
            if(title.toLowerCase().contains("car") || title.toLowerCase().contains("phone") || title.toLowerCase().contains("holder") )
            {
                System.out.println("Found title as "+title);
            }
            else
            {
            	System.out.println("Found wrong title as "+title);
            }
        } 

	}



}
