package tests.K22_testNG_frameworkOlusturma.D01_TestNG_tanitim;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_AramaTesti {

@Test
    public void aramaTesti() throws InterruptedException{
    //1- Bir test class’i olusturun ilgili ayarlari yapin
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));


    //2- https://www.testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");
    //3- urun arama kutusunu locate edin
    WebElement aramakutusu=driver.findElement(By.id("global-search"));
    //4- arama kutusuna “shoe” yazdirin
    aramakutusu.sendKeys("shoe");
    //5- arama islemini yapabilmek icin ENTER tusuna basin
    aramakutusu.submit();

    driver.quit();
}












}
