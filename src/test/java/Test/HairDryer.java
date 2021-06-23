package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utulities.WebDriverFactory;

import java.util.List;

public class HairDryer {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver= WebDriverFactory.getDriver ( "chrome" );


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep ( 3000 );

        driver.quit ();

    }

    @Test
    public void hairDryerTest() throws InterruptedException {
        driver.get ( "https://www.amazon.com/" );

        driver.findElement ( By.xpath ( "(//div/input)[4]" ) ).sendKeys ( "Hair dryer" );

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

       String  expected=subtotal1.getText ();
        System.out.println ( subtotal1.getText () );

        //click proceed too checkout

        driver.findElement ( By.xpath ( "(//span/span/a)[1]" ) ).click ();

        //find 2nd sub total

        WebElement subTotal2 =driver.findElement ( By.xpath ( "(//div/span/span)[7]" ) );
        System.out.println ( subTotal2.getText () );
        String actual=subTotal2.getText ();

        //Verify subtotal1 equals subtotal2

        Assert.assertEquals ( expected,actual,"verify subtotals are equals" );
        System.out.println ("finished");

    }


}
