package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private final WebDriver driver;

	@FindBy(id = "create_account_error")
	private WebElement accountError;

	@FindBy(id = "SubmitCreate")
	private WebElement createButton;

	@FindBy(id = "email")
	private WebElement loginInput;

	@FindBy(css = "#passwd")
	private WebElement passwordInput;

	@FindBy(id = "SubmitLogin")
	private WebElement loginButton;

	@FindBy(id = "email_create")
	private WebElement emailCreate;

	@FindBy(className = "logout")
	private WebElement logout;

	@FindBy(className = "alert-danger")
	private WebElement alertDanger;

	public WebElement getLogout() {
		return logout;
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean errorMessageExists() {
		return accountError.isDisplayed();
	}

	public void open() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailCreate() {
		return emailCreate;
	}

	public WebElement getAlertDanger() {
		return alertDanger;
	}

	public void setEmailCreate(String email) {
		emailCreate.sendKeys(email);
		createButton.click();
	}

	public void setEmailAndPasswd(String email, String passwd) {

		loginInput.sendKeys(email);
		passwordInput.sendKeys(passwd);
		loginButton.click();
	}

	public void login() {
		loginButton.click();
	}

	public void logout() {
		logout.click();
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getLoginInput() {
		return loginInput;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public boolean isLoginSuccessful() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")) == null;
	}
}