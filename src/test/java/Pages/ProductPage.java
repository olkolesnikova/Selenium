package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends Page {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name=add_cart_product]")
    WebElement addProductButton;

    @FindBy(css = "#cart .quantity")
    WebElement quantity;

    @FindBy(css = "#cart .link")
    WebElement checkOutLink;

    public void selectSize() {
        if (driver.findElements(By.cssSelector("option")).size() > 0){
            Select size = new Select(driver.findElement(By.cssSelector("[name='options[Size]']")));
            size.selectByValue("Small");
        }
    }

    public void addProduct() {
        addProductButton.click();
    }

    public void addToCart() {
        selectSize();
        String countBeforeAdd = getProductsQuantity();
        addProduct();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(quantity, countBeforeAdd)));
    }

    private String getProductsQuantity() {
        return quantity.getAttribute("textContent");
    }

    public void goToCart() {
        checkOutLink.click();
    }
}
