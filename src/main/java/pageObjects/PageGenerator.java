package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerator {

	public static LoginPO getLoginPage (WebDriver driver) {
		return new LoginPO(driver);
	}


	public static EmployeeListPO getEmployeeListPage(WebDriver driver) {
		return new EmployeeListPO(driver);
	}


	public static AddEmployeePO getAddEmployeePage(WebDriver driver) {
		return new AddEmployeePO(driver);
	}
}