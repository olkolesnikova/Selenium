package ru.stqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckProductProperties extends TestBase {

    WebElement productFirst, productSecond;
    String productNameFirst;
    String productNameSecond;
    String regularPrice1Color;
    String regularPrice2Color;
    boolean regularPrice1TypeText;
    boolean regularPrice2TypeText;
    String campaignPrice1Color;
    String campaignPrice2Color;
    String[] regularPrice1, campaignPrice1, regularPrice2, campaignPrice2;
    float size1, size2, size3, size4;
    int i;

    @Test

    public void testCheckProduct() {

        driver.get("http://localhost/litecart/en/");
        productFirst = driver.findElement(By.cssSelector("div#box-campaigns div.name"));
        productNameFirst = productFirst.getText();

        System.out.println(productNameFirst);

        regularPrice1 = new String[3];
        campaignPrice1 = new String[3];

        regularPrice1[0] = driver.findElement(By.cssSelector("s.regular-price")).getText();
        regularPrice1[1] = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("font-weight");
        regularPrice1[2] = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("font-size");

        size1 = Float.parseFloat(regularPrice1[2].replaceAll("px",""));

        //проверка что цвет серый на главной странице. для хрома
        regularPrice1Color = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        String grey = regularPrice1Color.substring(5, 18);
        String grey2 = grey.replaceAll(" ", "");
        System.out.println(grey2);
        String[] response = grey2.split(",",3);
        Assert.assertEquals(response[0], response[1]);
        Assert.assertEquals(response[1], response[2]);

        //проверка что цвет серый на главной странице для ff

     /*   String regularPrice1Color = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        System.out.println(regularPrice1Color);
        String grey = regularPrice1Color.substring(4, 17);
        System.out.println(grey);
        String grey2 = grey.replaceAll(" ", "");
        System.out.println(grey2);
        String[] response = grey2.split(",",3);
        Assert.assertEquals(response[0], response[1]);
        Assert.assertEquals(response[1], response[2]);
    */

        //проверка красного цвета на главной странице. для хрома
        campaignPrice1Color = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        String red = campaignPrice1Color.substring(5, 14);
        String red2 = red.replaceAll(" ", "");
        System.out.println(red2);
        String[] response_red = red2.split(",",3);
        Assert.assertEquals(response_red[1], "0");
        Assert.assertEquals(response_red[2], "0");

        //проверка красного цвета на главной странице для ff
     /*   String campaignPrice1Color = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        System.out.println(campaignPrice1Color);
        String red = campaignPrice1Color.substring(4, 13);
        System.out.println(red);
        String red2 = red.replaceAll(" ", "");
        System.out.println(red2);
        String[] response_red = red2.split(",",3);
        Assert.assertEquals(response_red[1], "0");
        Assert.assertEquals(response_red[2], "0");
    */
        regularPrice1TypeText = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration")
        .contains("line-throught");

        campaignPrice1[0]= driver.findElement(By.cssSelector("strong.campaign-price")).getText();
        campaignPrice1[1] = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight");
        campaignPrice1[2] = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-size");

        size2 = Float.parseFloat(campaignPrice1[2].replaceAll("px",""));

        Assert.assertTrue(size1<size2);

        productFirst.click();
        wait = new WebDriverWait(driver, 10);

        productSecond = driver.findElement(By.cssSelector("h1.title"));
        productNameSecond = productSecond.getText();
        System.out.println(productNameSecond);

        Assert.assertEquals(productNameFirst, productNameSecond);

        regularPrice2 = new String[3];
        campaignPrice2 = new String[3];

        regularPrice2[0] = driver.findElement(By.cssSelector("s.regular-price")).getText();
        regularPrice2[1] = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("font-weight");
        regularPrice2[2] = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("font-size");

        size3 = Float.parseFloat(regularPrice2[2].replaceAll("px",""));

        //проверка что цвет серый на странице товара. для хрома
        regularPrice2Color = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        String grey3 = regularPrice1Color.substring(5, 18);
        String grey4 = grey3.replaceAll(" ", "");
        System.out.println(grey4);
        String[] response_grey = grey4.split(",",3);
        Assert.assertEquals(response_grey[0], response_grey[1]);
        Assert.assertEquals(response_grey[1], response_grey[2]);

        //проверка что цвет серый на странице товара в ff
    /*    String regularPrice2Color = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        System.out.println(regularPrice2Color);
        String grey = regularPrice1Color.substring(4, 17);
        System.out.println(grey);
        String grey2 = grey.replaceAll(" ", "");
        System.out.println(grey2);
        String[] response = grey2.split(",",3);
        Assert.assertEquals(response[0], response[1]);
        Assert.assertEquals(response[1], response[2]);
     */

        //проверка что цвет красный на странице товара. для хрома
        campaignPrice2Color = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        String red3 = campaignPrice2Color.substring(5, 14);
        String red4 = red3.replaceAll(" ", "");
        System.out.println(red4);
        String[] response_red2 = red4.split(",",3);
        Assert.assertEquals(response_red2[1], "0");
        Assert.assertEquals(response_red2[2], "0");

        //проверка что цвет красный на странице товара для ff

    /*    String campaignPrice1Color = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        System.out.println(campaignPrice1Color);
        String red = campaignPrice1Color.substring(4, 13);
        System.out.println(red);
        String red2 = red.replaceAll(" ", "");
        System.out.println(red2);
        String[] response_red = red2.split(",",3);
        Assert.assertEquals(response_red[1], "0");
        Assert.assertEquals(response_red[2], "0");
    */

        regularPrice2TypeText = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("text-decoration")
        .contains("line-throught");

        campaignPrice2[0] = driver.findElement(By.cssSelector("strong.campaign-price")).getText();
        campaignPrice2[1] = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-weight");
        campaignPrice2[2] = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-size");

        size4 = Float.parseFloat(campaignPrice2[2].replaceAll("px",""));

        Assert.assertTrue(size3<size4);

        for (i = 0; i < 2; i++) {
            Assert.assertEquals(regularPrice1[i], regularPrice2[i]);
            Assert.assertEquals(campaignPrice1[i], campaignPrice2[i]); //жирность разная на двух страницах в Firefox, в Chrome совпадает
        }
    }
}
