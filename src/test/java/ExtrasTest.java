import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ExtrasPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtil;

import java.util.List;

public class ExtrasTest extends BasicTest {

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
        Thread.sleep(7000);
    }

    @BeforeMethod
    public void goToCarsPage() throws InterruptedException {
        HomePage homePage = new HomePage(webDriver);
        List<WebElement> webElementList = homePage.getSideBarList();
        Thread.sleep(2000);

        webElementList.get(32).click();
        List<WebElement> carsList = homePage.getSideBarCars();
        Thread.sleep(2000);
        carsList.get(1).click();
        //close Chat iframe
//        homePage.killAbraham();
    }

    @Test
    public void addExtrasToCar() throws InterruptedException {
        ExtrasPage extrasPage = new ExtrasPage(webDriver);

        extrasPage.clickAdd();
        Thread.sleep(8000);

        extrasPage.clickName();
        webDriver.findElement(extrasPage.getName()).sendKeys("Nikola");

//        extrasPage.clickStatus();
        extrasPage.clickPrice();
        webDriver.findElement(extrasPage.getPrice()).sendKeys("1000");
//        extrasPage.clickThumb();

        Select select = new Select(webDriver.findElement(extrasPage.getStatus()));
        select.selectByIndex(1);

        extrasPage.uploadImage();
        Thread.sleep(3000);

        //        extrasPage.clickSave();
//        ("[title='Edit']");
    }
}
