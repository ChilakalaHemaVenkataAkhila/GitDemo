package stepDefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreenKartStepDefenitions {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	

	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page()
	{
	//System.setProperty("web", null)
	driver=new ChromeDriver();
	driver.get("https://rahulshetty.com/seleniumPractise/#/");
	   }
	@When("User searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		
		landingPageProductName=driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(landingPageProductName +" is extracted from Home page");
	   }
	@Then("User Searched for same shortname in offers page to check if product exist")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
	driver.findElement(By.linkText("Top Deals")).click();
	Set<String> s1=driver.getWindowHandles();
	Iterator<String> i1=s1.iterator();
	String parentWindow=i1.next();
	String childWindow=i1.next();
	System.out.println("*******");
	System.out.println("commits ");
	System.out.println("commits1 ");
	System.out.println("commits2 ");
	System.out.println("commits3 ");
	
	driver.switchTo().window(childWindow);
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	Thread.sleep(2000);
	offerPageProductName=driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();	
	
	}
	@Then("Validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_Offers_page() {
		Assert.assertEquals(offerPageProductName, landingPageProductName);
		
	}
	}
