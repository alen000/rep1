package shop.automation.homepage;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import shop.automation.homepage.constants.HomePageConstants;
import shop.automation.homepage.constants.LoginConstants;
import shop.automation.homepage.base.BaseHomeTest;
import shop.automation.homepage.common.CommonMethods;
import shop.automation.homepage.common.LoginMethods;

public class LoginHomePage extends BaseHomeTest{

	@Test(priority = 1, enabled = true)
	public void goToLoginPage() {
		assertTrue(LoginMethods.loginPage());
	}

	@Test(priority = 2, enabled = true)
	public void enterCredentials() {
		LoginMethods.setUsername(LoginConstants.USERNAME);
		LoginMethods.setPassword(LoginConstants.PASSWORD);	
	}
	
	/* Make click on login button */
	@Test(priority = 3, enabled = true)
	public void clickLoginButton() {
		CommonMethods.clickById(LoginConstants.LOGIN_BUTTON_ID);
	}
	
	/* Check that add button id is visible and make click */
	@Test(priority = 4, enabled = true)
	public void checkMarketPage() {
		assertTrue(LoginMethods.marketPage());
		CommonMethods.clickById(HomePageConstants.ADD_CART_BUTTON1);
	}
	
	/* Check cart value , it should be 1 */
	@Test(priority = 5, enabled = true)
	public void checkCart() {
		CommonMethods.elementTextSearchByXpath(HomePageConstants.CART_BUTTON,"1");
	}
	
	/* Check that add button id is visible and make click */
	@Test(priority = 6, enabled = true)
	public void checkMarketPage1() {
		assertTrue(LoginMethods.marketPage());
		CommonMethods.clickById(HomePageConstants.ADD_CART_BUTTON2);
	}
	
	/* Check cart value , it should be 2 */
	@Test(priority = 7, enabled = true)
	public void checkCart1() {
		CommonMethods.elementTextSearchByXpath(HomePageConstants.CART_BUTTON,"2");
	}
	
	/* Check that add button id is visible and make click */
	@Test(priority = 8, enabled = true)
	public void checkMarketPage2() {
		assertTrue(LoginMethods.marketPage());
		CommonMethods.clickById(HomePageConstants.REMOVE_CART_BUTTON2);
	}
	
	/* Check cart value , it should be 1 */
	@Test(priority = 9, enabled = true)
	public void checkCart2() {
		CommonMethods.elementTextSearchByXpath(HomePageConstants.CART_BUTTON,"1");
	}
	
	
	/* Go to cart content */
	@Test(priority = 10, enabled = true)
	public void goToCart() {
		CommonMethods.clickByXpath(HomePageConstants.CART_BUTTON);
		assertTrue(LoginMethods.marketPage());

	}
	
	/* Check value price */
	@Test(priority = 11, enabled = true)
	public void goToCart1() {
		String price2 = "29.99";
		String price = CommonMethods.elementByXpath(shop.automation.homepage.constants.HomePageConstants.VALUE1).getText().substring(1);

		String text1 = (price.equals(price2)) ? "Value is OK" : "Value is not OK";
		System.out.println(text1);
	}
	
	
	/* Check that add button id is visible and make click */
	@Test(priority = 12, enabled = true)
	public void goToCheckout() {
		CommonMethods.clickById(HomePageConstants.CHECKOUT_BUTTON);
		assertTrue(LoginMethods.marketPage());

	}
	
	/* Check that add button id is visible and make click */
	@Test(priority = 13, enabled = true)
	public void filedForm() {
		LoginMethods.setFirstname(HomePageConstants.FIRST_NAME1);
		LoginMethods.setLastname(HomePageConstants.LAST_NAME1);
		LoginMethods.setPostalcode(HomePageConstants.POSTAL_CODE1);
		CommonMethods.clickById(HomePageConstants.CONTINUE_BUTTON);		
		
	}
	
	/* Check value price */
	@Test(priority = 14, enabled = true)
	public void goToCart2() {
		String price3 = "32.39";
		String price4 = CommonMethods.elementByXpath(shop.automation.homepage.constants.HomePageConstants.VALUE2).getText().substring(8);

		String text1 = (price4.equals(price3)) ? "Total Value is OK" : "Total Value is not OK";
		System.out.println(text1);
	}
	
	
	/* Check that add button id is visible and make click */
	@Test(priority = 15, enabled = true)
	public void goToLast() {
		CommonMethods.clickById(HomePageConstants.FINISH_BUTTON);
		assertTrue(LoginMethods.marketPage());
	}
	
	/* Check that add button id is visible and make click */
	@Test(priority = 16, enabled = true)
	public void goToFirst() {
		CommonMethods.clickById(HomePageConstants.BACK_BUTTON);
		assertTrue(LoginMethods.marketPage());
	}
		
}



