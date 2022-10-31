package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.EmployeeListPageUI;

public class EmployeeListPO extends BasePage{
	WebDriver driver;

	public EmployeeListPO(WebDriver driver) {
		this.driver = driver;
	}


    public boolean isEmployeeListDisplayed() {
		waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_LIST);
		return isElementDisplayed(driver, EmployeeListPageUI.EMPLOYEE_LIST);
    }

	public void clickToPimButton() {
		waitForElementClickable(driver, EmployeeListPageUI.PIM_BUTTON);
		clickToElement(driver, EmployeeListPageUI.PIM_BUTTON);
	}

	public void clickToAddButton() {
		waitForElementClickable(driver, EmployeeListPageUI.ADD_BUTTON);
		clickToElement(driver, EmployeeListPageUI.ADD_BUTTON);
	}
}
