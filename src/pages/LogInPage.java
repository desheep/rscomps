package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends Page{

		@FindBy(name = "username") WebElement LogInPageUserNameField;
		@FindBy(name = "j_password") WebElement LogInPagePasswordField;
		@FindBy(name = "loginBtn") WebElement LogInPageLogInButton;
		
		public LogInPage(WebDriver driver){
			super(driver);
		}
		
		public void loginAsValidUser(String loginName, String password){
			LogInPageUserNameField.sendKeys(loginName);
			LogInPagePasswordField.sendKeys(password);
			LogInPageLogInButton.click();
		}
}


