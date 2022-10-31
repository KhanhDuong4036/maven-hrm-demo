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

public class Login extends BaseTest {
    String adminUser, adminPassword, inValidAdminUser, inValidAdminPassword;
    WebDriver driver;
    LoginPO loginPage;
    EmployeeListPO employeeListPage;
    AddEmployeePO addEmployeeListPage;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        log.info("Pre-Condition - Step 01: Open Browser '" + browserName + "' and navigate to '" + appUrl + "'");
        driver = getBrowserDriver(browserName, appUrl);
        loginPage = PageGenerator.getLoginPage(driver);
        adminUser = "Admin";
        adminPassword = "admin123";
        inValidAdminUser = "Admin123";
        inValidAdminPassword= "admin123123";

    }

    @Test
    public void Login_With_Invalid_Account() {
        log.info("Input invalid username");
        loginPage.LoginToSystem(inValidAdminUser, inValidAdminPassword);
        log.info("Verify error message");
        verifyTrue(loginPage.isErrorMessageDisplayed(driver,"CSRF token validation failed"));
    }

    @Test
    public void Login_With_Valid_Account(){
        log.info("Input valid Username and Password");
        loginPage.LoginToSystem(adminUser, adminPassword);
        log.info("verify Dashboard");
        employeeListPage =PageGenerator.getEmployeeListPage(driver);
        employeeListPage.sleepInSecond(5);
        verifyTrue(employeeListPage.isEmployeeListDisplayed());
        }

/*    @Test
    public void Add_New_Employee(){
        employeeListPage = PageGenerator.getEmployeeListPage(driver);
        log.info("Click to Add button");
        employeeListPage.clickToAddButton();
        log.info("Verify Add Employee Page is displayed");
        addEmployeeListPage = PageGenerator.getAddEmployeePage(driver);
        verifyTrue(addEmployeeListPage.isAddEmployeeTitleDisplayed());

    }*/

    @AfterClass
    public void cleanBrowser() {
        log.info("Post-Condition: Close browser");
        driver.quit();
    }

}
