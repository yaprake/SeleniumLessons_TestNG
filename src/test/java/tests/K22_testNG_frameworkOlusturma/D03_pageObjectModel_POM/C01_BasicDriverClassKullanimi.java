package tests.K22_testNG_frameworkOlusturma.D03_pageObjectModel_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_BasicDriverClassKullanimi {



    @Test
    public void driverClassIlkTest(){
        // testotomasyonu anasayfaya gidin

        Driver.getDriver().get("https://www.wisequarter.com");

        Driver.getDriver().get("https://www.youtube.com");

        Driver.getDriver().get("https://www.testotomasyonu.com");

        // Arama kutusunu locate edip
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));

        // phone icin arama yapin
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // sayfayi kapatin
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }

}