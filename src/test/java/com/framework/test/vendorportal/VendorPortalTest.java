package com.framework.test.vendorportal;

import com.framework.test.AbstractTest;
import com.framework.test.vendorportal.model.VendorPortalTestData;
import com.framework.util.JsonUtil;
import com.myframework.pages.vendorportal.DashboardPage;
import com.myframework.pages.vendorportal.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class VendorPortalTest extends AbstractTest {

    private VendorPortalTestData testData;

    @BeforeMethod
    @Parameters("testDataPath")
    public void setParameters(String testDataPath) {
        this.testData = JsonUtil.getTestData(testDataPath);
    }

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
        Assert.assertTrue(loginPage.isAt());
        loginPage.login(testData.username(), testData.password());
    }

    @Test(dependsOnMethods = "loginTest")
    public void dashboardTest() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isAt());

        // finance metrics
        Assert.assertEquals(dashboardPage.getMonthlyEarning(), testData.monthlyEarning());
        Assert.assertEquals(dashboardPage.getAnnualEarning(), testData.annualEarning());
        Assert.assertEquals(dashboardPage.getProfitMargin(), testData.profitMargin());
        Assert.assertEquals(dashboardPage.getAvailableInventory(), testData.availableInventory());

        // order history search
        dashboardPage.searchOrderHistoryBy(testData.searchKeyword());
        Assert.assertEquals(dashboardPage.getSearchResultsCount(), testData.searchResultsCount());

        dashboardPage.logout();
    }

//    @Test(dependsOnMethods = "dashboardTest")
//    public void logoutTest(){
//        dashboardPage.logout();
//        Assert.assertTrue(loginPage.isAt());
//    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
