package shop.automation.homepage.base;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import shop.automation.homepage.common.*;

public abstract class BaseHomeTest {

	@BeforeClass
	@Parameters({ "browser" })
	public void setUpBeforeTestMethod(@Optional("chrome") String browser) {
		assertTrue(CommonMethods.openBrowser(browser));
	}

	@AfterClass
	public void tearDownAfterTestMethod() {
		CommonMethods.closeBrowser();
	}

}
