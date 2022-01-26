package shop.automation.homepage.common;

import shop.automation.homepage.common.CommonMethods;
import shop.automation.homepage.constants.LoginConstants;
import shop.automation.homepage.constants.HomePageConstants;

public class LoginMethods {

	private LoginMethods() {

	}

	// go to login page
	public static boolean loginPage() {

		try {

			if (CommonMethods.isElementVisibleById(LoginConstants.LOGIN_BUTTON_ID)) {
		
					return true;

			}

		} catch (Exception e) {

			CommonMethods.logger.error("loginPage", e);

		}

		return false;

	}
	
	
	public static boolean marketPage() {

		try {

			if ((CommonMethods.isElementVisibleById(HomePageConstants.ADD_CART_BUTTON1 ))
			|| (CommonMethods.isElementVisibleById(HomePageConstants.ADD_CART_BUTTON2 ))
			|| (CommonMethods.isElementVisibleById(HomePageConstants.REMOVE_CART_BUTTON2))
			|| (CommonMethods.isElementVisibleById(HomePageConstants.CHECKOUT_BUTTON))
			|| (CommonMethods.isElementVisibleById(HomePageConstants.CONTINUE_BUTTON))
			|| (CommonMethods.isElementVisibleById(HomePageConstants.BACK_BUTTON))
			)
			 {
				

					return true;
			}
		} catch (Exception e) {

			CommonMethods.logger.error("loginPage", e);
		}
		return false;
	}
	
	

	
	// set username
	public static void setUsername(String value) {

		try {

			if (CommonMethods.isElementVisibleById(LoginConstants.USERNAME_ID)) {

				CommonMethods.typeById(LoginConstants.USERNAME_ID, value);

			}

		} catch (Exception e) {

			CommonMethods.logger.error("setUsername", e);

		}

	}

	// set password
	public static void setPassword(String value) {

		try {

			if (CommonMethods.isElementVisibleById(LoginConstants.PASSWORD_ID)) {

				CommonMethods.typeById(LoginConstants.PASSWORD_ID, value);

			}

		} catch (Exception e) {

			CommonMethods.logger.error("setPassword", e);

		}

	}
	
	// set firstname
		public static void setFirstname(String value) {
			try {
				if (CommonMethods.isElementVisibleById(HomePageConstants.FIRST_NAME)) {

					CommonMethods.typeById(HomePageConstants.FIRST_NAME, value);
				}
			} catch (Exception e) {
				CommonMethods.logger.error("setFirstName", e);
			}
		}
		
		// set lastname
		public static void setLastname(String value) {
			try {
				if (CommonMethods.isElementVisibleById(HomePageConstants.LAST_NAME)) {

					CommonMethods.typeById(HomePageConstants.LAST_NAME, value);
				}
			} catch (Exception e) {
				CommonMethods.logger.error("setLastName", e);
			}
		}
		
		// set postalcode
		public static void setPostalcode(String value) {
			try {
				if (CommonMethods.isElementVisibleById(HomePageConstants.POSTAL_CODE)) {

					CommonMethods.typeById(HomePageConstants.POSTAL_CODE, value);
				}
			} catch (Exception e) {
				CommonMethods.logger.error("setPostalCode", e);
			}
		}

}
