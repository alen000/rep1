package shop.automation.homepage.common;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shop.automation.homepage.constants.CoreConstants;
import shop.automation.homepage.constants.HomePageConstants;
import shop.automation.homepage.constants.LoginConstants;

public class CommonMethods {

	private CommonMethods() {

	}

	private static WebDriver driver;
	private static WebDriverWait wait;
	public static final int WAIT_PARAMETER = 10;
	public static final Logger logger = Logger.getLogger(CommonMethods.class);

	// get driver
	public static WebDriver getDriver() {
		return driver;
	}

	// get wait
	public static WebDriverWait getWait() {
		return wait;
	}

	// Creates and returns Firefox driver
	public static WebDriver createFirefoxDriver() {

		System.setProperty("webdriver.gecko.driver", CoreConstants.GECKO_DRIVER_PATH);

		FirefoxOptions firefoxOptions = new FirefoxOptions();

		driver = new FirefoxDriver(firefoxOptions);

		return driver;

	}

	// Creates and returns Chrome driver
	public static WebDriver createChromeDriver() {

		System.setProperty("webdriver.chrome.driver", CoreConstants.CHROME_DRIVER_PATH);

		ChromeOptions options = new ChromeOptions();

		options.addArguments("disable-infobars");

		driver = new ChromeDriver(options);

		return driver;

	}

	// waits for a page to load
	public static void waitForPageToLoad(long timeOut, final TimeUnit unit) {

		if (!unit.equals(TimeUnit.SECONDS)) {

			unit.convert(timeOut, TimeUnit.SECONDS);

		}

		wait = new WebDriverWait(driver, TimeUnit.SECONDS.convert(timeOut, unit));

		wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
				.equals("complete"));

	}

	public static void waitForPageToLoad() {

		waitForPageToLoad(CommonMethods.WAIT_PARAMETER, TimeUnit.SECONDS);
	}

	// open a browser, maximize window and go to the specified URL
	public static boolean openBrowser(String browser) {

		try {

			if (browser.equals(CoreConstants.CHROME)) {

				driver = createChromeDriver();

			} else {

				driver = createFirefoxDriver();

			}

			driver.manage().window().maximize();

			waitForPageToLoad();

			driver.get(CoreConstants.HOMEPAGE_URL);

			if (getDriver().getTitle().equals(CoreConstants.SAUCE_PAGE_TITLE)) {

				return true;

			}

		} catch (Exception e) {

			logger.error("openBrowser", e);

		}

		return false;

	}

	// close browser
	public static void closeBrowser() {
		driver.quit();

	}

	// refresh browser page
	public static void reloadBrowserPage() {
		driver.navigate().refresh();

	}

	// browser page back
	public static void browserPageBack() {
		driver.navigate().back();

	}

	// type by xpath
	public static void typeByXpath(String xpath, String value) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		driver.findElement(By.xpath(xpath)).sendKeys(value);

	}

	// type by Id
	public static void typeById(String id, String value) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

		driver.findElement(By.id(id)).sendKeys(value);

	}

	// click by Id
	public static void clickById(String id) {

		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));

		driver.findElement(By.id(id)).click();

	}

	// click by xpath
	public static void clickByXpath(String xpath) {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		driver.findElement(By.xpath(xpath)).click();

	}

	// clear by Id
	public static void clearById(String id) {

		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));

		driver.findElement(By.id(id)).clear();

	}

	// get element by xpath
	public static WebElement elementByXpath(String xpath) {

		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

			return driver.findElement(By.xpath(xpath));

		} catch (Exception e) {

			logger.error("elementByXpath", e);

			return (WebElement) e;

		}

	}

	// get element by ID
	public static WebElement elementById(String id) {

		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

			return driver.findElement(By.id(id));

		} catch (Exception e) {

			logger.error("elementById", e);

			return (WebElement) e;

		}

	}

	// get element text by xpath
	public static boolean elementTextSearchByXpath(String xpath, String text) {

		try {

			if (elementByXpath(xpath).getText().equals(text)) {

				return true;

			}

		} catch (Exception e) {

			logger.error("elementTextSearchByXpath", e);

		}

		return false;

	}

	// get element text by ID
	public static boolean elementTextSearchById(String id, String text) {

		try {

			if (elementById(id).getText().equals(text)) {

				return true;

			}

		} catch (Exception e) {

			logger.error("elementTextSearchById", e);

		}

		return false;

	}

	// check if element is visible by id
	public static boolean isElementVisibleById(String id) {

		try {

			if (driver.findElement(By.id(id)).isDisplayed()) {

				return true;

			}

		} catch (Exception e) {

			logger.error("isElementVisiblebyId", e);

		}

		return false;

	}

	// check if element is visible by xpath
	public static boolean isElementVisibleByXpath(String xpath) {

		try {

			if (driver.findElement(By.xpath(xpath)).isDisplayed()) {

				return true;

			}

		} catch (Exception e) {

			logger.error("isElementVisibleByXpath", e);

		}

		return false;

	}

}
