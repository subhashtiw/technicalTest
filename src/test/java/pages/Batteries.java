package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Batteries {
WebDriver driver;
	
	public Batteries(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ".//*[@id='campaignBody']/div/div[6]/div/div[2]/div/a/div[2]/h4")
	private WebElement rechargeableBatteries;

	public void clickRechargeableBatteries() {
		rechargeableBatteries.click();		
	}
	
	@FindBy(xpath= ".//*[@id='results-table']/tbody/tr[1]/td[2]")
	private WebElement prodDetails;
	
	@FindBy(xpath = ".//*[@id='atbBtn-1']")
	private WebElement add6170773;

	public String add6170773Batteries() {
		add6170773.click();	
		return prodDetails.getText();
	}
	
	@FindBy(xpath = ".//*[@id='miniBasketId']/i")
	private WebElement checkOut;

	public void checkOut() {
		checkOut.click();		
	}
	
	
	
	@FindBy(xpath=".//*[@id='bread-box']/div[1]")
	private WebElement matchFilter;

	public void selectFilter(String filterName) throws InterruptedException {
			
		List<WebElement> filterColumn = driver.findElements(By.className("filter"));
		for ( int i = 0; i <filterColumn.size(); i++ ) {
		    if (filterColumn.get(i).getText().equals(filterName) ) {
		           filterColumn.get(i).click();
		           Thread.sleep(1000);
		      }
		}
	}
	
	@FindBy(xpath = ".//*[@id='4294332975']/input")
	private WebElement searchFilterCapacity;
	
	public void clickCapacity() throws InterruptedException {	
		searchFilterCapacity.click();	
		Thread.sleep(5000);
		System.out.println("filters after applying" + matchFilter.getText());
	}
	
	@FindBy(xpath=".//*[@id='4294876531']/input")
	private WebElement filterInputVoltage1;
	
	@FindBy(xpath=".//*[@id='4294327431']/input")
	private WebElement filterInputVoltage2;
	
	@FindBy(xpath = ".//*[@id='filters']/div/div/rs-facets/a[5]")
	private WebElement searchFilterInputVoltage;
	
	public void clickInputVoltage() throws InterruptedException {
		
		filterInputVoltage1.click();	
		filterInputVoltage2.click();
		Thread.sleep(5000);
		
	}
	
	public String getMatchFilter() {
		return matchFilter.getText();
	}
	
	@FindBy(xpath=".//*[@id='bread-box']/div[1]/div[2]/span/rs-apply-button/button")
	private WebElement applyFilter;
	
	public void clickApplyFilter() {
		applyFilter.click();
	}
	
	@FindBy(xpath=".//*[@id='bread-box']/div[2]/rs-bread-box/div[1]/div/a")
	private WebElement removeFilter;
	
	public void clickRemoveFilter() {
		removeFilter.click();
	}
	
}


