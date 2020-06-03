package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckStickers extends TestBase {

    int products, stickers, productStickerQuantity;
    int i;
    List<WebElement> productSticker;
    @Test

    public void testCheckStickers() {

        driver.get("http://localhost/litecart");
        List<WebElement> productList = driver.findElements(By.cssSelector("li.product"));
        WebElement product;
        products = productList.size();
        //System.out.println(products);

        List<WebElement> stickerList = driver.findElements(By.cssSelector("div[class*=sticker]"));
        WebElement sticker;
        stickers = stickerList.size();
        //System.out.println(stickers);

        for (i = 0; i < products; i++) {

            productList = driver.findElements(By.cssSelector("li.product"));
            productSticker = (List<WebElement>) productList.get(i).findElements(By.cssSelector("div[class*=sticker]"));
            productStickerQuantity = productSticker.size();
            Assert.assertEquals(productStickerQuantity, 1);
        }
        //System.out.println(productStickerQuantity);
    }
}
