package ecommerceproject.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerceproject.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
				
	}
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;
	
//	@FindBy(css=".totalRow button")
//	private List<WebElement> cartProducts;
//	
		
	public Boolean VerifyProductDisplay(String productName)
	{
		Boolean match = cartProducts.stream().anyMatch(product->product.getText().equals(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout() throws InterruptedException
	{
		checkoutEle.click();
		Thread.sleep(2000);
		return new CheckoutPage(driver);
		
		
	
	}
	
	
	
	

}
