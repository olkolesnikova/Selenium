package ru.stqa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckColor extends TestBase {

    @Test

    public void testCheckColor() {

        driver.get("http://localhost/litecart/en/");

        //для хрома
       /* String regularPriceColor = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        System.out.println(regularPriceColor);

        String stroka = regularPriceColor.substring(5, 18);
        String stroka2 = stroka.replaceAll(" ", "");
        System.out.println(stroka2);

        String[] str = stroka2.split(",",3);
        System.out.println(str[0]);

        Assert.assertEquals(str[0], str[1]);
        Assert.assertEquals(str[1], str[2]);

        String campaignPriceColor = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        String red = campaignPriceColor.substring(5, 14);
        System.out.println(red);
        String red2 = red.replaceAll(" ", "");
        System.out.println(red2);
        String[] response_red = red2.split(",",3);
        System.out.println(response_red[1]);
        Assert.assertEquals(response_red[1], "0");
        Assert.assertEquals(response_red[2], "0"); */

        //для Firefox

        String regularPriceColor = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        System.out.println(regularPriceColor);
        String grey = regularPriceColor.substring(4, 17);
        System.out.println(grey);
        String grey2 = grey.replaceAll(" ", "");
        System.out.println(grey2);
        String[] response = grey2.split(",",3);
        Assert.assertEquals(response[0], response[1]);
        Assert.assertEquals(response[1], response[2]);

        //driver.get("http://localhost/litecart/en/rubber-ducks-c-1/subcategory-c-2/yellow-duck-p-1");

        String campaignPrice1Color = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        System.out.println(campaignPrice1Color);
        String red = campaignPrice1Color.substring(4, 13);
        System.out.println(red);
        String red2 = red.replaceAll(" ", "");
        System.out.println(red2);
        String[] response_red = red2.split(",",3);
        Assert.assertEquals(response_red[1], "0");
        Assert.assertEquals(response_red[2], "0");

    }
}
