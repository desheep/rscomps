package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page{

		@FindBy(id = "searchTerm") WebElement StoreHomePageSearchField;
		@FindBy(linkText = "Log In") WebElement StoreHomePageButtonLinkLogin;
		
		public HomePage(WebDriver driver){
			super(driver);
		}
		
		public void searchForItem(String searchTerm){
			StoreHomePageSearchField.sendKeys(searchTerm);
			StoreHomePageSearchField.sendKeys(Keys.RETURN);	
		}
		
		public void goToLogInPage() {
			StoreHomePageButtonLinkLogin.click();
		}
}


