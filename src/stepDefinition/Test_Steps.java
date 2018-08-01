package stepDefinition;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import pages.BasketPage;
import pages.CheckoutAddressPage;
import pages.HomePage;
import pages.LogInPage;
import pages.LoginOrGuestPage;
import pages.ProductPage;


public class Test_Steps {	
	
	WebDriver driver;
	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	
	BasketPage objBasketPage;
	CheckoutAddressPage objCheckoutAddressPage;
	HomePage objHomePage;
	LogInPage objLogInPage;
	LoginOrGuestPage objLoginOrGuestPage;
	ProductPage objProductPage;
	
	private static final String KEYWORD_SEARCH = "NPN to PNP/PNP to NPN signal converter";
	private static final String MANUFACTURER_NUMBER_SEARCH = "FP-01-000";
	
	private String searchContext;
	
	@Before
	public void beforeScenario() {
		System.setProperty("webdriver.gecko.driver",
				"G:\\Selenium\\Drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void afterScenario() {
		driver.close();
	}
	
	@Given("^I am on the store homepage$")
	public void i_am_on_the_store_homepage() throws Throwable {
		
		driver.get("https://uk.rs-online.com/web/");
	}

	@When("^I login as my test user$")
	public void i_login_as_my_test_user() throws Throwable {
		objHomePage = new HomePage(driver);
		objHomePage.goToLogInPage();
		objLogInPage = new LogInPage(driver);
		objLogInPage.loginAsValidUser("desheep", "testforrs");		
	}

	@When("^I add a product to my basket$")
	public void i_add_a_product_to_my_basket() throws Throwable {
		objHomePage = new HomePage(driver);
		objHomePage.searchForItem("110-006");
		objProductPage = new ProductPage(driver);
		objProductPage.addProductToBasket(1);
	}

	@Then("^I should see the checkout address page$")
	public void i_should_see_the_checkout_address_page() throws Throwable {
		objCheckoutAddressPage = new CheckoutAddressPage(driver);
		assertTrue(
				"Assert Failed: Expected page elements where not found",
				objCheckoutAddressPage.didThePageLoad());		
	}

	@When("^I try to checkout$")
	public void i_try_to_checkout() throws Throwable {
		objProductPage = new ProductPage(driver);
		objProductPage.viewBasket();
		objBasketPage = new BasketPage(driver);
		assertTrue("Assert Failed: Checkout button wasn't enabled",
				objBasketPage.isTheCheckoutButtonEnabled());
		objBasketPage.checkout();
	}

	@Then("^I should be able to create a guest account$")
	public void i_should_be_able_to_create_a_guest_account() throws Throwable {
		objLoginOrGuestPage = new LoginOrGuestPage(driver);
		objLoginOrGuestPage.checkoutAsGuest("test@test.com");
	}

	@When("^I search by keyword$")
	public void i_search_by_keyword() throws Throwable {
		objHomePage = new HomePage(driver);
		objHomePage.searchForItem(KEYWORD_SEARCH);
		searchContext = KEYWORD_SEARCH;
	}

	@Then("^I should be taken to the exact store page for the keyword$")
	public void i_should_be_taken_to_the_exact_store_page_for_the_keyword() throws Throwable {
		objProductPage = new ProductPage(driver);
	    assertTrue("Assert Failed: Expected search results not found", 
	    		objProductPage.isThisThePageForMyKeyword(searchContext));
	}

	@When("^I search by manufacturer part number$")
	public void i_search_by_manufacturer_part_number() throws Throwable {
		objHomePage = new HomePage(driver);
		objHomePage.searchForItem(MANUFACTURER_NUMBER_SEARCH);
		searchContext = MANUFACTURER_NUMBER_SEARCH;
	}

	@When("^I search by RS Part Number \"([^\"]*)\"$")
	public void i_search_by_RS_Part_Number(String rsPartnumber) throws Throwable {
		objHomePage = new HomePage(driver);
		objHomePage.searchForItem(rsPartnumber);
		searchContext = rsPartnumber;
	}

	@Then("^I should be taken to the exact store page for rs number \"([^\"]*)\"$")
	public void i_should_be_taken_to_the_exact_store_page_for_rs_number(String rsPartnumber) throws Throwable {
		objProductPage = new ProductPage(driver);
	    assertTrue("Assert Failed: Expected search results not found", 
	    		objProductPage.isThisThePageForMyRsPartNumber(searchContext));
	}
	
	@Then("^I should be taken to the exact store page for the manufacturer part number$")
	public void i_should_be_taken_to_the_exact_store_page_for_the_manufacturer_part_number() throws Throwable {
		objProductPage = new ProductPage(driver);
	    assertTrue("Assert Failed: Expected search results not found", 
	    		objProductPage.isThisThePageForMyManufacturerPartNumber(searchContext));
	}
}
