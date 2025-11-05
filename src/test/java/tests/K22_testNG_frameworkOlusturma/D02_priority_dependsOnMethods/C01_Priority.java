package tests.K22_testNG_frameworkOlusturma.D02_priority_dependsOnMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Priority {
    // uc farkli test method'u olusturun
    // testotomasyonu, wisequarter ve bestbuy sitelerine gidip
    // url'in testotomasyonu, wisequarter ve bestbuy kelimeleri icerdigini test edin
    // ve windowlari kapatin


    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }


    @Test  (priority = 20)
    public  void  testotomasyonuTest() throws InterruptedException {
        driver.get("https://www.testotomasyonu.com");
       String actualTestotomasyonUrl=driver.getCurrentUrl();
       String expectedWordInTestotomasyonuURL="testotomasyonu";
       Assert.assertTrue(actualTestotomasyonUrl.contains(expectedWordInTestotomasyonuURL));
        Thread.sleep(1000);

    }

    @Test
    public  void  wisequarterTest(){
        driver.get("https://www.wisequarter.com");
        String actualWisequarterUrl=driver.getCurrentUrl();
        String expectedWordinWisequarterURL="wisequarter";
        Assert.assertTrue(actualWisequarterUrl.contains(expectedWordinWisequarterURL));

    }

    @Test
    public void bestbuy(){
        driver.get("https://www.bestbuy.com/");
        String actualBestbuyURL=driver.getCurrentUrl();
        String expectedWordInBestbuyURL="bestbuy";
        Assert.assertTrue(actualBestbuyURL.contains(expectedWordInBestbuyURL));
    }





/*

    @Test (priority = 20)
    public void testotomasyonuTest() throws InterruptedException {

        driver.get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Thread.sleep(1000);

    }

    @Test
    public void wisequarterTest() throws InterruptedException {
        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Thread.sleep(1000);
    }

    @Test
    public void bestbuyTest() throws InterruptedException {
        driver.get("https://www.bestbuy.com");

        String expectedUrlIcerik = "bestbuy";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        Thread.sleep(1000);*/
    }
