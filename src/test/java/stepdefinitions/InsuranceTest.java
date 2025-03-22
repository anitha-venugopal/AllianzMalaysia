package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.FlightsSearchPage;
import pages.HomePage;

public class InsuranceTest {
      @Given("User is on the Home Page")
      public void user_is_on_the_home_page() {
    	  HomePage homepage = new HomePage(BaseTest.getDriver());
          String expectedUrl = "https://www.airasia.com/en/gb";
          System.out.println("Current page url is: " + homepage.getcurrenturl());

          Assert.assertEquals(homepage.getcurrenturl(), expectedUrl, "Expected URL is not displayed");
      }


	@Given("User sets From destination {string}")
	public void user_sets_from_destination(String FromDestination) {
  	  	HomePage homepage = new HomePage(BaseTest.getDriver());
		homepage.setLocation("From" , FromDestination);
	}

	@Given("User sets To destination {string}")
	public void user_sets_to_destination(String ToDestination) {
  	  	HomePage homepage = new HomePage(BaseTest.getDriver());
		homepage.setLocation("To" , ToDestination);
	}

	@Then("User selects Depart date {string}")
	public void user_selects_depart_date(String departDate) throws InterruptedException {
  	  	HomePage homepage = new HomePage(BaseTest.getDriver());
		 homepage.setdate("Depart", departDate);
	}

	@Then("User selects Return date {string}")
	public void user_selects_return_date(String returnDate) throws InterruptedException {
  	  	HomePage homepage = new HomePage(BaseTest.getDriver());
		homepage.setdate("Return", returnDate);
	}

	@Then("User clicks on the Home Page Search button")
	public void user_clicks_on_the_home_page_search_button() {
  	  	HomePage homepage = new HomePage(BaseTest.getDriver());
		homepage.clickhomepagesearchbtn();
	}

	@Then("User navigates to the Flights Search Page")
	public void user_navigates_to_the_flights_search_page() {
  	  	HomePage homepage = new HomePage(BaseTest.getDriver());
	    String Expectedurlpart = "/flights/search";

	    WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(2));
	    wait.until(ExpectedConditions.urlContains(Expectedurlpart));

	    String currenturl = homepage.getcurrenturl();
	    System.out.println("Current page url is: " + currenturl);
	    Assert.assertTrue(currenturl.contains(Expectedurlpart), "Expected search results page was not loaded.");
	}

	@Then("User selects departing flight {string}")
	public void user_selects_departing_flight(String departingFlight) throws InterruptedException {
	    Thread.sleep(2000);
		FlightsSearchPage flightsearchPage = new FlightsSearchPage(BaseTest.getDriver());
		flightsearchPage.clickSelectBtn();
	}

	@Then("User selects returning flight {string}")
	public void user_selects_returning_flight(String returningFlight) throws InterruptedException {
	    Thread.sleep(2000);
		FlightsSearchPage flightsearchPage = new FlightsSearchPage(BaseTest.getDriver());
		flightsearchPage.clickSelectBtn();
	}

	@Then("User clicks on Continue as Guest button")
	public void user_clicks_on_continue_as_guest_button() {
		FlightsSearchPage flightsearchPage = new FlightsSearchPage(BaseTest.getDriver());
		flightsearchPage.clickContinueasguestbtn();
	}

	@Then("User navigates to the Checkout Page")
	public void user_navigates_to_the_checkout_page() {
		String Expectedurlpart = "/flights/checkout/";
		WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(2));
	    wait.until(ExpectedConditions.urlContains(Expectedurlpart));

  	  	HomePage homepage = new HomePage(BaseTest.getDriver());
	    String currenturl = homepage.getcurrenturl();
	    System.out.println("Current page url is: " + currenturl);
	    Assert.assertTrue(currenturl.contains(Expectedurlpart), "Expected search results page was not loaded.");
	}

	@When("User selects Insurance Plus from the list of options available")
	public void user_selects_insurance_plus_from_the_list_of_options_available() {
  	  	CheckOutPage checkOutPage = new CheckOutPage(BaseTest.getDriver());
	    checkOutPage.SelectInsuranceAddons("Plus");
	}

	@Then("The Insurance Plus Add-on price should be reflected in the Fare")
	public void the_insurance_plus_add_on_price_should_be_reflected_in_the_fare() {
  	  	CheckOutPage checkOutPage = new CheckOutPage(BaseTest.getDriver());
		Assert.assertEquals(checkOutPage.GetInsuranceAddonPrice("Plus"), checkOutPage.GetAddOnPriceOnFareSummary());
		// Assert the same price is displaying in fare details
		checkOutPage.ToggleFare();
		Assert.assertEquals(checkOutPage.GetInsuranceAddonPrice("Plus"), checkOutPage.GetAddOnPriceOnFareDetails());
	}

	@When("User selects Insurance Lite from the list of options available")
	public void user_selects_insurance_lite_from_the_list_of_options_available() {
  	  	CheckOutPage checkOutPage = new CheckOutPage(BaseTest.getDriver());
	    checkOutPage.SelectInsuranceAddons("Lite");
	}

	@Then("The Insurance Lite Add-on price should be reflected in the Fare")
	public void the_insurance_lite_add_on_price_should_be_reflected_in_the_fare() {
  	  	CheckOutPage checkOutPage = new CheckOutPage(BaseTest.getDriver());
		Assert.assertEquals(checkOutPage.GetInsuranceAddonPrice("Lite"), checkOutPage.GetAddOnPriceOnFareSummary());
		// Assert the same price is displaying in fare details
		checkOutPage.ToggleFare();
		Assert.assertEquals(checkOutPage.GetInsuranceAddonPrice("Lite"), checkOutPage.GetAddOnPriceOnFareDetails());
	}
}
