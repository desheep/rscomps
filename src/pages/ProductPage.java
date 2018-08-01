package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends Page {
		
		@FindBy(className = "form-control") WebElement ProductPageUnitsSpinner;
		@FindBy(css = "button[class='btn btn-primary-red btn-large btn-add-to-basket']") WebElement ProductPageAddToBasketButton;
		@FindBy(id = "js-basketAmt") WebElement ProductPageViewBasketButton;
		@FindBy(css = "h1[class='col-xs-12 main-page-header']") WebElement ProductPageHeader;
		@FindBy(className = "keyDetailsLL") WebElement ProductPageDetailsList;
		
		public ProductPage(WebDriver driver){
			super(driver);
		}
		
		public void addProductToBasket(Integer numberOfUnits){
			ProductPageUnitsSpinner.clear();
			ProductPageUnitsSpinner.sendKeys(numberOfUnits.toString());
			ProductPageAddToBasketButton.click();
		}
		
		public void viewBasket() {
			ProductPageViewBasketButton.click();
		}

		public boolean isThisThePageForMyKeyword(String searchContext) {
			WebDriverWait waitForHeader = new WebDriverWait(driver, 10);
			WebElement visibleElement = waitForHeader.until(ExpectedConditions.visibilityOf(ProductPageHeader));
			return visibleElement.getText().equals(searchContext);
		}

		public boolean isThisThePageForMyRsPartNumber(String searchContext) {
			WebDriverWait waitForHeader = new WebDriverWait(driver, 10);
			WebElement visibleElement = waitForHeader.until(ExpectedConditions.visibilityOf(ProductPageDetailsList));
			List<WebElement> details = visibleElement.findElements(By.tagName("li"));
			return details.get(0).getText().contains(searchContext);
		}

		public boolean isThisThePageForMyManufacturerPartNumber(String searchContext) {
			WebDriverWait waitForHeader = new WebDriverWait(driver, 10);
			WebElement visibleElement = waitForHeader.until(ExpectedConditions.visibilityOf(ProductPageDetailsList));
			List<WebElement> details = visibleElement.findElements(By.tagName("li"));
			return details.get(1).getText().contains(searchContext);
		}
}


