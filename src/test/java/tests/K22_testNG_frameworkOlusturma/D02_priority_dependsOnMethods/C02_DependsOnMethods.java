package tests.K22_testNG_frameworkOlusturma.D02_priority_dependsOnMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static com.google.common.base.Ascii.equalsIgnoreCase;

public class C02_DependsOnMethods {

    // 3 farkli test methodu olusturup, asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidip url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmadan "phone" bulundugunu test edin

    WebDriver driver;

    @BeforeClass
    public void setup(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown(){
    driver.quit();
    }




    @Test
    public void anasayfaTesti(){
        // 1- testotomasyonu anasayfaya gidip
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        driver.close();
    }

    @Test(dependsOnMethods = "anasayfaTesti")
    public void phoneAramaTesti(){
        // 2- phone icin arama yapip
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        Assert.assertTrue(actualBulunanUrunSayisi>0);

        driver.close();
    }

    // 3- ilk urunu tiklayip, urun isminde case sensitive olmadan "phone" bulundugunu test edin
    @Test
    public void ilkUrunTesti(){
        driver.findElement(By.xpath("//div[@class='product-box my-2  py-1'][1]")).click();
        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = driver.findElement(By.xpath("//div[@class='mx-2 mb-3 mt-4'][1]"))
                .getText()
                .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));
        driver.close();
    }






}
