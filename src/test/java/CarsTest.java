import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CarsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtil;

import java.util.List;

public class CarsTest extends BasicTest {
    @BeforeTest
    public void setup() throws InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.setExcel("C:\\Users\\Frosty\\Desktop\\phptravels\\src\\main\\resources\\data.xlsx");
        excelUtil.setWorkSheet(0);
        String email = excelUtil.getData(1, 0);
        String password = excelUtil.getData(1, 1);
        excelUtil.closeExcel();
        super.setup();
        webDriver.get(this.baseURL + "/admin");
        Thread.sleep(2000);

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(email, password);
        Thread.sleep(2000);
    }

    @BeforeMethod
    public void goToCarsPage() throws InterruptedException {
        HomePage homePage = new HomePage(webDriver);
        List<WebElement> webElementList = homePage.getSideBarList();

        webElementList.get(32).click();
        List<WebElement> carsList = homePage.getSideBarCars();
        Thread.sleep(2000);
        carsList.get(0).click();
        //close Chat iframe
        homePage.killAbraham();
    }

    @Test
    public void numberOfCars() throws InterruptedException {
        CarsPage carsPage = new CarsPage(webDriver);
        carsPage.clickButtonAll();
        Thread.sleep(2000);
        List<WebElement> cars = carsPage.getCarsRows();
        Thread.sleep(2000);
        Assert.assertEquals(cars.size(), 10);
    }

    @Test
    public void numberOfOrders() {
        CarsPage carsPage = new CarsPage(webDriver);
        List<WebElement> orderList = carsPage.getOrderColumn();
        int count = 0;
        for (WebElement element : orderList) {
            count += Integer.parseInt(element.getAttribute("Value"));
//            Assert.assertTrue(Integer.parseInt(element.getAttribute("Value")) > 50);
        }
        Assert.assertTrue(count > 50);
    }

    @Test
    public void uploadImage() throws InterruptedException {
        CarsPage carsPage = new CarsPage(webDriver);
        carsPage.clickUpload();
        carsPage.uploadImage();
        Thread.sleep(3000);
        List<WebElement> images = carsPage.getImageList();
        Assert.assertTrue(images.get(0).getAttribute("href").contains("1.jpg"));
    }
}
