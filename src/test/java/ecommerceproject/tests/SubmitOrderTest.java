package ecommerceproject.tests;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ecommerceproject.pageobjects.CartPage;
import ecommerceproject.pageobjects.CheckoutPage;
import ecommerceproject.pageobjects.ConfirmationPage;
import ecommerceproject.pageobjects.OrderPage;
import ecommerceproject.pageobjects.ProductCatalogue;
import ecommerceproject.tests.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String productName = "IPHONE 13 PRO";
	
	@Test(dataProvider="getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException
	{
		
		//LandingPage landingpage = launchApplication();
		ProductCatalogue productCatalogue = landingpage.loginApplication(input.get("email"), input.get("password"));
		//"yogesh@org.com", "Yogeshyogesh@1234"
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.SelectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.SubmitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public OrderPage orderHistoryTest()
	{
		ProductCatalogue productCatalogue = landingpage.loginApplication("yogesh@org.com", "Yogeshyogesh@1234");
		OrderPage orderPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
		return orderPage; 
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email","yogesh@org.com");
//		map.put("password", "Yogeshyogesh@1234");
//		map.put("product", "IPHONE 13 PRO");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email","yogesh@automation.com");
//		map1.put("password", "Yogeshyogesh@1234");
//		map1.put("product", "ZARA COAT 3");
		
		List<HashMap<String,String>> data = getJsonDataMap(System.getProperty("user.dir") + "\\src\\test\\java\\ecommerceprojects\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
		
}
