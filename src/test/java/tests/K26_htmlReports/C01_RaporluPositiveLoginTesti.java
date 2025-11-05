package tests.K26_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class C01_RaporluPositiveLoginTesti extends TestBaseRapor {


    @Test
    public void positiveLoginTesti(){

        extentTest = extentReports.createTest("pozitif Login testi",
                "Kullanici gecerli bilgilerle sisteme giris yapabilmeli");

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki
                .click();
        extentTest.info("account linkine basar");

        // 3- Kullanici email'i olarak wise@gmail.com girin
        testotomasyonuPage.loginSayfasiEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliMail"));
        extentTest.info("Email kutusuna gecerli email'i yazar");

        // 4- Kullanici sifresi olarak 12345 girin
        testotomasyonuPage.loginSayfasiPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Password kutusuna gecerli password'u yazar");

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiSubmitButonu
                .click();
        extentTest.info("Login butonuna basarak login olur");

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilabildigini test eder");

        // 7- logout olun
        testotomasyonuPage.logoutButonu.click();
        extentTest.info("Logout butonuna basarak sistemden cikis yapar");

        // 8- sayfayi kapatin
        extentTest.info("sayfayi kapatir");

    }


}