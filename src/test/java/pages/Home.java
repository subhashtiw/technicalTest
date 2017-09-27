package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	
	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToUrl () {
		driver.get("https://uk.rs-online.com");
	}
	
@FindBy(linkText = "All Products")
private WebElement allProduct;

public void clickAllProducts() {
	allProduct.click();

	
}



@FindBy(linkText = "Batteries")
private WebElement batteries;

public void clickBatteries() {
	batteries.click();

	
}

@FindBy(linkText = "New Products")
private WebElement newProduct;

public void clickNewProducts() {
	
	newProduct.click();

	
}


@FindBy(id="searchTerm")
private WebElement mainSearch;

public void enterSearch() {
	mainSearch.click();
	mainSearch.sendKeys("Power Banks");
	
}


@FindBy(id="btnSearch")
private WebElement mainSearchButton;

public void startSearch() {
	
	mainSearchButton.click();
	
}



}
