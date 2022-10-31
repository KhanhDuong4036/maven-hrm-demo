package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPO extends BasePage{
	WebDriver driver;

	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}
	public void LoginToSystem(String username, String password){
		waitForElementVisible(this.driver, LoginPageUI.USER_TEXTBOX);
		sendkeyToElement(this.driver,LoginPageUI.USER_TEXTBOX,username);
		sendkeyToElement(this.driver,LoginPageUI.PASSWORD_TEXTBOX,password);
		clickToElement(this.driver,LoginPageUI.LOGIN_BTN);
	}

	public boolean isErrorMessageDisplayed(WebDriver driver, String message) {
		waitForElementVisible(driver,LoginPageUI.ERROR_MESSAGE, message);
		return isElementDisplayed(driver, LoginPageUI.ERROR_MESSAGE, message);

	}

}
