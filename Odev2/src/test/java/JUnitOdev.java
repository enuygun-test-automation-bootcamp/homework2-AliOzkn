import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class JUnitOdev {

    // ---------- Junit Test Class olusturuldu.
    @Test
    public void test(){

        // ---------- ChromeDriver Eklendi.
        Path resourceDirectory = Paths.get("src", "main", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath + "/binary/chromedriver.exe");


        WebDriver driver = new ChromeDriver();                             // ---- Nesne Olusturuldu.
        driver.manage().window().maximize();                               // ---- Sayfa tam ekran yapildi.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));  // ---- Sayfanin tamamen yuklenmesi icin 2 saniye bekleme konuldu.
        driver.get("https://demoqa.com/webtables");                        // ---- Belirtilen url'ye gidildi.
        WebElement typeToSearch = driver.findElement(By.id("searchBox"));  // ---- Type To Search butonunun Locator bulundu.
        Assert.assertTrue(typeToSearch.isDisplayed());                     // ---- Butonun gorunur olup olmadigi test edildi.
    }
}
