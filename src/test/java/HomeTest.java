import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtil;

import java.util.List;

public class HomeTest extends BasicTest {
    @BeforeTest
    public void setup() throws InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.setExcel("C:\\Users\\Frosty\\Desktop\\phptravels\\src\\main\\resources\\data.xlsx");
        excelUtil.setWorkSheet(0);
        String email = excelUtil.getData(1, 0);
        String password = excelUtil.getData( 1, 1);
        excelUtil.closeExcel();
        super.setup();
        webDriver.get(this.baseURL+"/admin");
        Thread.sleep(2000);

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(email,password);
        Thread.sleep(2000);
    }
    @Test
    public void sideMenu() throws InterruptedException {
        HomePage homePage = new HomePage(webDriver);
        List<WebElement> webElementList = homePage.getSideBarList();

        webElementList.get(0).click();
        Assert.assertEquals(webDriver.getTitle(), "Dashboard");

        webElementList = homePage.getSideBarList();
        webElementList.get(1).click();
        Assert.assertEquals(webDriver.getTitle(), "Updates");
        webDriver.navigate().back();

        webElementList = homePage.getSideBarList();
        webElementList.get(2).click();
        Assert.assertEquals(webDriver.getTitle(), "Modules");
        webDriver.navigate().back();

        webElementList = homePage.getSideBarList();
        webElementList.get(26).click();
        List<WebElement> tourList = webDriver.findElements(By.cssSelector("#Tours a"));
        Thread.sleep(2000);
        tourList.get(1).click();
        Assert.assertEquals(webDriver.getTitle(), "Add Tour");
        webDriver.navigate().back();

        webElementList = homePage.getSideBarList();
        webElementList.get(48).click();
        Assert.assertTrue(webDriver.getTitle().contains("Coupon"));
        webDriver.navigate().back();

        webElementList = homePage.getSideBarList();
        webElementList.get(49).click();
        Assert.assertTrue(webDriver.getTitle().contains("Newsletter"));
        webDriver.navigate().back();

        webElementList = homePage.getSideBarList();
        webElementList.get(50).click();
        Assert.assertTrue(webDriver.getTitle().contains("Booking"));
    }
}
