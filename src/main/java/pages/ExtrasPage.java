package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExtrasPage extends BasicPage {

    private By addButton = By.cssSelector("[data-task='create']");
    private By name = By.name("cHRfZXh0cmFzLmV4dHJhc190aXRsZQ--");
    private By status = By.tagName("select");
    private By price = By.cssSelector("[data-pattern='numeric']");
    private By thumb = By.className("xcrud-upload");
    private By save = By.cssSelector("[data-after='list']");

    public ExtrasPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickAdd() {
        getWebDriver().findElement(addButton).click();
    }

    public void clickName() {
        getWebDriver().findElement(name).click();
    }

    public void clickStatus() {
        getWebDriver().findElement(status).click();
    }

    public void clickPrice() {
        getWebDriver().findElement(price).click();
    }

//    public void clickThumb() {
//        getWebDriver().findElement(thumb).click();
//    }

    public void clickSave() {
        getWebDriver().findElement(save).click();
    }

    public void uploadImage() {
        String imgUrl = "C:\\Users\\Frosty\\Desktop\\phptravels\\src\\main\\resources\\1.jpg";
        getWebDriver().findElement(thumb).sendKeys(imgUrl);
    }

    public By getName() {
        return name;
    }

    public By getPrice() {
        return price;
    }

    public By getStatus() {
        return status;
    }
}
