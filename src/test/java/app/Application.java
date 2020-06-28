package app;

import Pages.CartPage;
import Pages.MainPage;
import Pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.TestBase;

public class Application extends TestBase {

    private WebDriver driver;

    private MainPage mainPage;
    private ProductPage productPage;
    private CartPage cartPage;

    public Application(WebDriver driver) {

        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

    }

    public void open() {
        mainPage.open();
    }

    public void addProductToCart() {
        mainPage.chooseProduct();
        productPage.addToCart();
    }

    public void addProductsToCart(int number) {
        for (int i = 1; i <= number; i++) {
            addProductToCart();

            if (i != number) {
                open();
            }
        }
    }

    public void goToCart() {
        productPage.goToCart();
    }

    public int getAddedProductsQuantity() {
        return cartPage.getProductsQuantityFromTable();
    }

    private void removeProduct() {
        cartPage.removeProduct();
    }

    public void removeAddedProducts(int number) {
        for (int i = 1; i <= number; i++) {
            removeProduct();

            if (i != number) {
                cartPage.waitTableIsUpdated();
            }
        }
    }
}
