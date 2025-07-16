package ecommerceproject.tests;
import java.io.IOException;
import java.net.Authenticator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import ecommerceproject.pageobjects.CartPage;
import ecommerceproject.pageobjects.ProductCatalogue;
import ecommerceproject.tests.TestComponents.BaseTest;
import ecommerceproject.tests.TestComponents.Retry;

public class ErrorValidations extends BaseTest {
	
	@Test
	public void productErrorValidation() throws IOException, InterruptedException
	{
		
		String productName = "IPHONE 13 PRO";
		ProductCatalogue productCatalogue = landingpage.loginApplication("yogesh@org.com", "Yogeshyogesh@1234");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		//Assert.assertFalse(match);
		Assert.assertTrue(match);
	}
	
	@Test (groups = {"ErrorHandling"}, retryAnalyzer=ecommerceproject.tests.TestComponents.Retry.class)
	public void LoginErrorValidation()
	{
		landingpage.loginApplication("yogesh@testing.com", "Yogesh@12345");
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	}
	
}
