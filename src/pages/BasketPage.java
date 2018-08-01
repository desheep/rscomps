package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends Page{

		@FindBy(id = "checkoutSecurelyAndPuchBtn") WebElement BasketPageCheckoutButton;
		@FindBy(id = "clearBasketButton") WebElement ClearAllProductsButton;
		@FindBy(id = "confirmDeleteContinue") WebElement ConfirmClearAllProductsButton;
				
		public BasketPage(WebDriver driver){
			super(driver);
		}
		
		public void checkout(){
			BasketPageCheckoutButton.click();
		}
		
		public boolean isTheCheckoutButtonEnabled(){
			return BasketPageCheckoutButton.isEnabled();
		}

}