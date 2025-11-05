package tests.K22_testNG_frameworkOlusturma.D04_pageClassKullanimi;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_PositiveLoginTesti {

    @Test (groups = "E2E")
    public void positiveLoginTesti(){


        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki
                .click();

        // 3- Kullanici email'i olarak wise@gmail.com girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys("wise@gmail.com");

        // 4- Kullanici sifresi olarak 12345 girin
        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys("123456");
        ReusableMethods.bekle(2);
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(3);
        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiSubmitButonu
                .click();

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());
        ReusableMethods.bekle(6);
        // 7- logout olun

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(9);
        testotomasyonuPage.logoutButonu.click();

        // 8- sayfayi kapatin
        Driver.quitDriver();

    }

}