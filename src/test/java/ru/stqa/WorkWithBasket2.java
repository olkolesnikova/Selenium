package ru.stqa;

import Pages.MainPage;
import org.testng.annotations.Test;

public class WorkWithBasket2 extends TestBase {

    @Test

    public void testWorkWithBasket() {

        app.open();
        app.addProductsToCart(3);
        app.goToCart();
        app.removeAddedProducts(app.getAddedProductsQuantity());


    }


}
