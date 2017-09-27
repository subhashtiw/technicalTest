package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProduct {
WebDriver driver;
	
	public NewProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Batteries")
	private WebElement newProd;

	public void clickNewProd() {
		System.out.println("link text " + newProd.getText());
		newProd.click();
	}
	
	
	@FindBy(xpath=".//*[@id='SRTNResultViewWidgetActionPAGE_REFRESH_EVENT']/table/tbody/tr[2]/td[3]/div/ul")
	private WebElement newProductDetail;
	
	@FindBy(xpath="html/body/div[6]/div[3]/div[3]/span[2]/div[1]/table/tbody/tr[2]/td[1]/div/div[2]/ul/li[3]/form/div[1]/div[2]/span/input")
	private WebElement powerBank;

	public String addPowerBank() {
		powerBank.click();
		
		return newProductDetail.getText();
		
	}
	
	@FindBy(xpath="html/body/div[3]/div[2]/form/span/div/div/a/div[2]")
	private WebElement basketIcon;
	
	public void basket(){
		basketIcon.click();
	}
	

}
