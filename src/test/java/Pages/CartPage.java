package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends Page {

    public CartPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".dataTable")
    WebElement productTable;

    @FindBy(css = ".dataTable tr")
    List<WebElement> productList;

    @FindBy(css = "[name=remove_cart_item]")
    WebElement removeButton;

    public int getProductsQuantityFromTable() {
        return productList.size() - 5;
    }

    public void removeProduct() {
        WebElement table = driver.findElement(By.cssSelector(".dataTable"));
        removeButton.click();
        wait.until(ExpectedConditions.stalenessOf(table));
    }

    public void waitTableIsUpdated() {
        wait.until(ExpectedConditions.visibilityOf(productTable));
    }
}
