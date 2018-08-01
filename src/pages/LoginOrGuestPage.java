package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOrGuestPage extends Page {

	@FindBy(id = "guestCheckoutForm:GuestWidgetAction_emailAddress_decorate:GuestWidgetAction_emailAddress") WebElement LoginOrGuestPageEmailInput;
	@FindBy(id = "guestCheckoutForm:guestCheckout") WebElement LoginOrGuestPageGuestCheckoutButton;
	@FindBy(id = "alreadyRegisteredForm:continue") WebElement LoginOrGuestPageContinueButton;
	
	public LoginOrGuestPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkoutAsGuest(String email) {
		LoginOrGuestPageEmailInput.sendKeys(email);
		LoginOrGuestPageGuestCheckoutButton.click();
		WebDriverWait waitForContinueButton = new WebDriverWait(driver, 10);
		WebElement visibleElement = waitForContinueButton.until(ExpectedConditions.visibilityOf(LoginOrGuestPageContinueButton));
		visibleElement.click();
	}
}