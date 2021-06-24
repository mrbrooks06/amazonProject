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
        driver.get("https://www.amazon.co.uk");
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("vacuum cleaner");
       WebElement searchclick = driver.findElement(By.id("nav-search-submit-button"));
        searchclick.click();
        Thread.sleep(2000);
        WebElement sort = driver.findElement ( By.xpath ( "//span[@class='a-button-text a-declarative']" ) );
        sort.click();
        Thread.sleep(4000);
        WebElement newest = driver.findElement(By.id("s-result-sort-select_4"));
        newest.click();
        Thread.sleep(2000);
        WebElement firstitem = driver.findElement(By.className("a-price-whole"));
        firstitem.click();
        Thread.sleep(2000);
        WebElement quantity = driver.findElement(By.id("quantity"));
        quantity.click ();
        WebElement qua2 = driver.findElement(By.xpath("//div/span/select/option[@value='2']"));
        qua2.click();
        WebElement addtochart = driver.findElement(By.id("add-to-cart-button"));
        addtochart.click();
        Thread.sleep(2000);
        WebElement nothanks = driver.findElement(By.xpath("(//span/input[@class='a-button-input'])[2]"));
        nothanks.click();
        Thread.sleep(2000);
        WebElement price = driver.findElement(By.xpath("//div/div/span/span"));
        price.getText().toString();



    }


    
    



}
