package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StartPage {
	private final WebDriver driver;

	@FindBy(xpath = "//*[@id=\"home-page-tabs\"]/li[2]/a")
	private WebElement bestSellersLink;

	@FindBy(className = "shop-phone")
	private WebElement phoneNum;

	@FindBy(id = "homeslider")
	private WebElement homeslider;

	@FindBy(className = "shopping_cart")
	private WebElement shoppingCart;

	@FindBy(linkText = "Printed Chiffon Dress")
	private WebElement productName;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	private WebElement dressesLink;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")
	private WebElement casualDressesLink;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a")
	private WebElement eveningDressesLink;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")
	private WebElement summerDressesLink;

	@FindBy(className = "login")
	private WebElement loginButton;

	public StartPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPhoneNum() {
		return phoneNum;
	}

	public WebElement getHomeSlider() {
		return homeslider;
	}

	public WebElement getShoppingCart() {
		return shoppingCart;
	}

	public WebElement getDressesLink() {
		return dressesLink;
	}

	public WebElement getCasualDressesLink() {
		return casualDressesLink;
	}

	public WebElement getEveningDressesLink() {
		return eveningDressesLink;
	}

	public WebElement getSummerDressesLink() {
		return summerDressesLink;
	}

	public void hoverDressesLink() {
		Actions action = new Actions(driver);
		action.clickAndHold(dressesLink).build().perform();
	}

	public WebElement getBestSellers() {
		return bestSellersLink;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getProductName() {
		return productName;
	}

	public void clickBestSellers() {
		getBestSellers().click();
	}

	public void clickLoginButton() {
		getLoginButton().click();
	}

	public List<WebElement> getProducts() {
		return driver.findElement(By.cssSelector("#blockbestsellers")).findElements(By.tagName("li"));
	}

	public void open() {
		driver.get("http://automationpractice.com");
		PageFactory.initElements(driver, this);
	}
}