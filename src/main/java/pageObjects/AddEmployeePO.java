package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddEmployeePageUI;

public class AddEmployeePO extends BasePage {
    WebDriver driver;

    public AddEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAddEmployeeTitleDisplayed() {
        waitForElementVisible(driver, AddEmployeePageUI.ADD_EMPLOYEE_TITLE);
        highlightElement(driver,AddEmployeePageUI.ADD_EMPLOYEE_TITLE);
        return isElementDisplayed(driver, AddEmployeePageUI.ADD_EMPLOYEE_TITLE);
    }
}
