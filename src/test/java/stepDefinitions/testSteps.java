package stepDefinitions;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Batteries;
import pages.Checkout;
import pages.Home;
import pages.NewProduct;

public class testSteps {
	public static WebDriver driver;
	
		
	String productSelected, originalMatch, finalMatch;
	Home home;
	Batteries batteries;
	Checkout checkout;  
	NewProduct newProd ;
		
	@Given("^user is on the RS Components \"([^\"]*)\"$")
		public void user_is_on_the_RS_Component_home_page(String arg1)  {
		    
			System.setProperty("webdriver.chrome.driver","src\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			
			home = new Home(driver);
			batteries = new Batteries(driver);
			checkout = new Checkout(driver);
			newProd = new NewProduct(driver);
			home.goToUrl();
			
		}

		@When("^user click on All Products drop down$")
		public void user_click_on_All_Products_drop_down() throws Throwable {
		   home.clickAllProducts();
		}
		
		@When("^click on Batteries$")
		public void click_on_Batteries1() throws Throwable {
		    home.clickBatteries();
		}

		@When("^click on Rechargeable Batteries$")
		public void click_on_Rechargeable_Batteries() throws Throwable {
		   batteries.clickRechargeableBatteries();
		}

		@When("^click on Add button in front of the same product$")
		public void click_on_Add_button_in_front_of_the_same_product() throws Throwable {
		   productSelected =  batteries.add6170773Batteries();	
		}
		
		@When("^click on Add button in front of the new product$")
		public void click_on_Add_button_in_front_of_the_new_product() throws Throwable {
		    newProd.clickNewProd();	
		}

		@When("^click on check out icon$")
		public void click_on_check_out_icon() throws Throwable {
		    batteries.checkOut();
		}

		@Then("^checkout page should be displayed$")
		public void checkout_page_should_be_displayed() throws Throwable {
			Thread.sleep(2000);
			String[] prod = productSelected.split("\\r?\\n");
			System.out.println(" prod 0 " + prod[0]);
			String checkedOutDetail = checkout.checkOutTitle();
			assertTrue(checkedOutDetail.contains("Checkout securely"));
			assertTrue(checkedOutDetail.contains(prod[1]));
					    
		}
		


		@When("^user click on New Products$")
		public void user_click_on_New_Products() throws Throwable {
		    home.clickNewProducts();
		}

		@When("^click on BatteriesNew$")
		public void click_on_BatteriesNew() throws Throwable {
			Thread.sleep(2000);
			
			newProd.clickNewProd();
			
		}
		
		@When("^add Power Bank$")
		public void add_Power_Bank() throws Throwable{
			productSelected = newProd.addPowerBank();
			
		}
		
		@When("^click on basket icon$")
		public void click_on_basket_icon() throws Throwable{
			newProd.basket();
		}
		
		
		
		@When("^user search for Power Banks$")
		public void user_search_for_Power_Banks() throws Throwable {
		    home.enterSearch();
		   
		}

		@When("^click on search button$")
		public void click_on_search_button() throws Throwable{
			home.startSearch();
		}
		
		@When("^search filter changed to Capacity$")
		public void search_filter_changed_to_Capacity() throws Throwable {
			
			originalMatch = batteries.getMatchFilter();
			
			batteries.selectFilter("Capacity");
			batteries.clickCapacity();
			finalMatch = batteries.getMatchFilter();
		}
		
		@When("^search filter changed to Input Voltage$")
		public void search_filter_changed_to_Input_Voltage() throws Throwable {
			
			originalMatch = batteries.getMatchFilter();
			
			batteries.selectFilter("Input Voltage");
			batteries.clickInputVoltage();
			finalMatch = batteries.getMatchFilter();
		}
		
		@Then("^filter is applied$")
		public void filter_is_applied() throws Throwable {
			assertFalse("Match filter matches", originalMatch.equals(finalMatch));		
		}
		
		@Then("^filter is removed$")
		public void filter_is_removed() throws Throwable {
			Thread.sleep(2000);
			batteries.clickRemoveFilter();
			Thread.sleep(2000);
			finalMatch = batteries.getMatchFilter();
			System.out.println("Original match " + originalMatch);
			System.out.println("final match " + finalMatch);
			assertTrue("Match filter matches", originalMatch.equals(finalMatch));		
		}
		
		@When("^click apply filter$")
		public void click_apply_filter() throws Throwable {
			batteries.clickApplyFilter();		
		}
		



		@After()
		public void closeBrowser() throws InterruptedException{
			Thread.sleep(5000);
			driver.quit();
		}
		

	}


