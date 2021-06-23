package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utulities.WebDriverFactory;
import org.testng.annotations.Test;

import java.util.List;

public class MrBrook {
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
    public void hairDryerTest() throws InterruptedException {
        driver.get ( "https://www.amazon.com/" );

        driver.findElement ( By.xpath ( "(//div/input)[4]" ) ).sendKeys ( "Iphone 12" );

        driver.findElement ( By.xpath ( "(//span/input)[1]" ) ).click ();

        //sorting by newest

        WebElement dropdownElement =driver.findElement ( By.xpath ( "//span[@class='a-button-text a-declarative']" ) );
        dropdownElement.click ();
        List<WebElement> dropDownElements = driver.findElements(By.className("a-dropdown-item"));

        dropDownElements.get ( 4 ).click ();
        System.out.println ( dropdownElement.getText () );
        Thread.sleep ( 3000 );

        //first element

        driver.findElement ( By.xpath ( "(//div/h2/a/span)[1]" ) ).click ();

        //choose color
        driver.findElement ( By.xpath ( "(//div/img)[5]" ) ).click ();
        Thread.sleep ( 2000 );

        //adjust qty
        WebElement qtyElement = driver.findElement ( By.xpath ( "(//div/span/span/span)[1]" ) );
        qtyElement.click ();
        List<WebElement> qtys = driver.findElements ( By.className ( "a-dropdown-item" ) );
        qtys.get ( 1 ).click ();



        //add to chart
        driver.findElement ( By.xpath ( "(//span/input)[2]" ) ).click ();
        //find cart subTotal
        WebElement subtotal1=driver.findElement ( By.xpath ( "(//div/span/span)[3]" ) );
        System.out.println ( subtotal1.getText () );

        //click proceed too checkout

        driver.findElement ( By.xpath ( "(//span/span/a)[1]" ) ).click ();

        //find 2nd sub total

        WebElement subTotal2 =driver.findElement ( By.xpath ( "(//span/span/a)[1]" ) );

    }
}