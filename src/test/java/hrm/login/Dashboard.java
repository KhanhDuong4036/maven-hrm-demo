package hrm.login;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.AddEmployeePO;
import pageObjects.EmployeeListPO;
import pageObjects.LoginPO;
import pageObjects.PageGenerator;


public class Dashboard extends BaseTest {
    String adminUser, adminPassword;
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        log.info("Pre-Condition - Step 01: Open Browser '" + browserName + "' and navigate to '" + appUrl + "'");
        driver = getBrowserDriver(browserName, appUrl);
        loginPage = PageGenerator.getLoginPage(driver);
        adminUser = "Admin";
        adminPassword = "admin123";
        loginPage.LoginToSystem(adminUser,adminPassword);
        employeeListPage = PageGenerator.getEmployeeListPage(driver);
    }
    @Test
    public void Add_New_Employee(){
        log.info("Click to Add button");
        employeeListPage.clickToAddButton();
        log.info("Verify Add Employee Page is displayed");
        addEmployeeListPage = PageGenerator.getAddEmployeePage(driver);
        verifyTrue(addEmployeeListPage.isAddEmployeeTitleDisplayed());

    }


    @AfterClass
    public void cleanBrowser() {
        log.info("Post-Condition: Close browser");
        driver.quit();
    }
    WebDriver driver;
    LoginPO loginPage;
    EmployeeListPO employeeListPage;
    AddEmployeePO addEmployeeListPage;
}
