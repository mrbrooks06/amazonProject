package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utulities.WebDriverFactory;

import java.util.List;

public class vacuum_cleaner {

    WebDriver driver;
    @BeforeMethod
     public void setup(){
        driver= WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();

        
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void vacuum() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("vacuum cleaner");
       WebElement searchclick = driver.findElement(By.id("nav-search-submit-button"));
        searchclick.click();
        Thread.sleep(4000);
        WebElement sort = driver.findElement ( By.xpath ( "//span[@class='a-button-text a-declarative']" ) );
        sort.click();
        Thread.sleep(4000);
        WebElement newest = driver.findElement(By.id("s-result-sort-select_4"));
        newest.click();
        Thread.sleep(5000);
        WebElement firstitem = driver.findElement(By.xpath("//div/h2/a/span[@class='a-size-medium a-color-base a-text-normal']"));
        firstitem.click();
        Thread.sleep(5000);
        WebElement quantity = driver.findElement(By.id("quantity"));
        quantity.click ();
        WebElement qua2 = driver.findElement(By.cssSelector("select>option[value='2']"));





    }


    
    



}
