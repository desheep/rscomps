package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutAddressPage extends Page {

		@FindBy(id = "checkoutSecurelyBtn") WebElement CheckoutAddressPageContinueButton;
		
		public CheckoutAddressPage(WebDriver driver){
			super(driver);
		}
		
		public boolean didThePageLoad(){
			return CheckoutAddressPageContinueButton.isDisplayed();
		}
}