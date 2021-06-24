package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

         Thread.sleep(2000);

        driver.quit();

    }
@Test
    public void test() throws InterruptedException {

    //navigate to page
    driver.get("https://www.amazon.com/");

    // find input write Iphone 12
    driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("samsung tablet");

    //submit button
    driver.findElement(By.id("nav-search-submit-button")).click();
    Thread.sleep(3000);

    // find dropdown and click

    driver.findElement ( By.xpath ( "//span[@class='a-button-text a-declarative']" ) ).click();


    //click
    driver.findElement(By.xpath("//div/div/ul[@class=\"a-nostyle a-list-link\"]/li/a[.=\"Newest Arrivals\"]")).click();
    Thread.sleep(3000);

    //click the first picture
    driver.findElement(By.xpath("//img[@class=\"s-image\"]")).click();

    //choose color
    driver.findElement(By.xpath("(//img[@class=\"imgSwatch\"])[2]")).click();
    Thread.sleep(2000);
    //choose quantitiy
    driver.findElement(By.xpath("//span[@class=\"a-dropdown-container\"]")).click();
   Thread.sleep(2000);
    driver.findElement(By.xpath("//span[@class=\"a-dropdown-container\"]/select/option[@value=\"2\"]")).click();

    // add to Cart

    driver.findElement(By.id("add-to-cart-button")).click();
    Thread.sleep(2000);
    //get the price
    WebElement priceElementExpected=driver.findElement(By.xpath("//span[contains(@class,\"a-color-price hlb-price a-inline-block a-text-bold\")]"));
    String expectedPrice=priceElementExpected.getText();
  //  System.out.println(expectedPrice);
   //click the cart
    Thread.sleep(2000);
driver.findElement(By.id("hlb-view-cart")).click();
Thread.sleep(2000);

WebElement priceElementActual=driver.findElement(By.xpath("//span[@id=\"sc-subtotal-amount-buybox\"]/span"));
String actualPrice=priceElementActual.getText();

    Assert.assertEquals(expectedPrice,actualPrice,"Verify prices");












}





}
