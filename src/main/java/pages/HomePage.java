package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends  BasicPage{
    private By sideBarList = By.cssSelector("#social-sidebar-menu a");
    private  By sideBarCars = By.cssSelector("#Cars a");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getSideBarList(){
        return getWebDriver().findElements(sideBarList);
    }

    public List<WebElement> getSideBarCars() {
        return getWebDriver().findElements(this.sideBarCars);
    }

}
