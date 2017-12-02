package s12791.seleniumTests;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import webPages.LoginPage;
import webPages.StartPage;
import webPages.RegisterPage;

import static org.junit.Assert.*;

public class SomeSiteTest {

	private static WebDriver driver;
	WebElement element;
	private StartPage startPage;
	private LoginPage loginPage;
	private RegisterPage registerPage;

	String EMAIL = "k03@dom.com";
	String FIRSTNAME = "Jan";
	String LASTNAME = "Kowalski";
	String PASSWORD = "12345";
	String ADDRES = "Jabloniowa";
	String CITY = "Warsaw";
	String STATE = "arizona";
	String POSTCODE = "12345";
	String MPBILEPHONE = "123123123";

	@BeforeClass
	public static void driverSetup() {

		// PHANTOMJS - WORKING
		System.setProperty("phantomjs.binary.path", "./src/test/resources/drivers/phantomjs.exe");

		// CHROME - WORKING
		// System.setProperty("webdriver.chrome.driver",
		// "./src/test/resources/drivers/chromedriver.exe");

		driver = new PhantomJSDriver();

		// CHROME - WORKING
		// driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MICROSECONDS);
		driver.manage().window().setSize(new Dimension(1000, 700));
	}

	@Before
	public void before() {
		startPage = new StartPage(driver);
		loginPage = new LoginPage(driver);
		registerPage = new RegisterPage(driver);
	}

	@Test
	public void navigateToLoginPageCheckIfLogginButtonExists() throws IOException {

		loginPage.open();

		assertEquals("Sign in", loginPage.getLoginButton().getText());

		if (driver instanceof TakesScreenshot) {
			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File("build/homePage.png"));
		}
	}

	@Test
	public void bestSellersCount() {
		startPage.open();
		startPage.clickBestSellers();
		assertEquals(7, startPage.getProducts().size());
	}

	@Test
	public void bestSellersDisplayed() {
		startPage.open();
		startPage.clickBestSellers();
		assertTrue(startPage.getBestSellers().isDisplayed());
	}

	@Test
	public void dressesLinkOnHoverDisplay() throws InterruptedException, IOException {
		startPage.open();
		startPage.hoverDressesLink();

		assertTrue(startPage.getCasualDressesLink().isDisplayed());
		assertTrue(startPage.getEveningDressesLink().isDisplayed());
		assertTrue(startPage.getSummerDressesLink().isDisplayed());
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("build/dresses.png"));
	}

	@Test
	public void bestSellersDisplayedPrintedChiffonDress() {
		startPage.open();
		startPage.clickBestSellers();
		assertTrue(startPage.getProductName().getText().contains("Printed Chiffon Dress"));
	}

	@Test
	public void phoneNumCorrectFormat() {
		startPage.open();
		assertTrue((startPage.getPhoneNum().getText()).substring(13).matches("[0-9]{4}[-][0-9]{3}[-][0-9]{3}"));
	}

	@Test
	public void loremDisplaysCorrectly() {
		startPage.open();
		assertTrue((startPage.getHomeSlider().getText()).contains(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tristique in tortor et dignissim. Quisque non tempor leo. Maecenas egestas sem elit"));
	}

	@Test
	public void shoppingCartIsDisplayed() {
		startPage.open();
		assertTrue(startPage.getShoppingCart().isDisplayed());
		loginPage.open();
	}

	@Test
	public void loginIncorrect() {
		loginPage.open();
		loginPage.login();
		assertFalse(loginPage.isLoginSuccessful());
	}

	@Test
	public void navigateToLoginPage() throws IOException {
		startPage.open();
		startPage.clickLoginButton();
		assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account",
				driver.getCurrentUrl());
	}

	@Test
	public void registerWithWrongIput() throws InterruptedException {
		loginPage.open();
		loginPage.setEmailCreate("Wrong_input");
		Thread.sleep(1000);
		System.out.println(loginPage.errorMessageExists());
		assertTrue(loginPage.errorMessageExists());
		System.out.println(loginPage.getEmailCreate().getText());
	}

	@Test
	public void shoppingRegisterGood() throws InterruptedException {

		// Randomly generate an email
		EMAIL = (UUID.randomUUID().toString()) + "@wp.pl";
		System.out.println(EMAIL);
		loginPage.open();
		loginPage.setEmailCreate(EMAIL);
		Thread.sleep(1000);
		assertFalse(loginPage.errorMessageExists());
		Thread.sleep(1000);
		registerPage.createAccount(FIRSTNAME, LASTNAME, PASSWORD, ADDRES, CITY, STATE, POSTCODE, MPBILEPHONE);

		Thread.sleep(1000);

		loginPage.logout();
		assertTrue(loginPage.getLoginButton().isDisplayed());

	}

	@Test
	public void shoppingRegisterBad() throws InterruptedException {

		// Randomly generate an email
		EMAIL = (UUID.randomUUID().toString()) + "@wp.pl";
		System.out.println(EMAIL);

		loginPage.open();
		loginPage.setEmailCreate(EMAIL);
		Thread.sleep(1000);
		System.out.println(loginPage.errorMessageExists());
		assertFalse(loginPage.errorMessageExists());
		Thread.sleep(1000);
		registerPage.createAccount(FIRSTNAME, LASTNAME, PASSWORD, ADDRES, CITY, STATE, "", "");
		Thread.sleep(1000);
		assertTrue(registerPage.getErrorMessagePostalCode().getText()
				.contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000"));
	}

	@Test
	public void shoppingBadLogin() throws InterruptedException {
		loginPage.open();
		loginPage.login();

		loginPage.setEmailAndPasswd("sdfsdfsd", "sdfsdfsd");
		Thread.sleep(1500);
		assertTrue(loginPage.getAlertDanger().isDisplayed());
	}

	@Test
	public void shoppingGoodLogin() throws InterruptedException {
		loginPage.open();
		loginPage.login();

		loginPage.setEmailAndPasswd("k@wp.pl", "admin");
		Thread.sleep(1500);
		// assertTrue(!loginPage.getAlertDanger().isDisplayed());
		assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
		loginPage.logout();
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}