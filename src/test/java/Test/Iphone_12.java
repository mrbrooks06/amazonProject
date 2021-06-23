package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import utulities.WebDriverFactory;

public class Iphone_12 {

WebDriver driver;
    @BeforeMethod
    public void start(){

        driver= WebDriverFactory.getDriver("chrome");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

         Thread.sleep(10000);

        driver.quit();

    }
@Test
    public void test() throws InterruptedException {

 //navigate to page
    driver.get("https://www.amazon.com/");
    // find input write Iphone 12
    driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("Iphone 12");
    //submit button
    driver.findElement(By.id("nav-search-submit-button")).click();
    Thread.sleep(3000);
// find dropdown and click
   // driver.findElement(By.id("#a-autoid-0-announce")).click();
    driver.findElement ( By.xpath ( "//span[@class='a-button-text a-declarative']" ) ).click();

    // span[@class='a-button-text a-declarative']
//click
    driver.findElement(By.xpath("//div/div/ul[@class=\"a-nostyle a-list-link\"]/li/a[.=\"Newest Arrivals\"]")).click();
    Thread.sleep(3000);

    driver.findElement(By.xpath("//div[@class=\"a-row a-color-base\"]/a")).click();

    //driver.findElement(By.xpath("//li[@title=\"Click to select Gold\"]//span//input")).click();




}





}
