package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utulities.WebDriverFactory;

import java.util.List;

public class Mixer_Test {

    WebDriver driver;

    @Test

    public void mixerTest() throws InterruptedException {

        //        1. Go to https://www.amazon.com/
        driver = WebDriverFactory.getDriver("chrome");
        driver.get(" https://www.amazon.com/");

//        2. Enter your item and click search
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("mixer");
        driver.findElement(By.cssSelector("#nav-search-submit-button")).click();

//        3. Sort by rating and click most popular

        driver.findElement(By.cssSelector(".a-dropdown-prompt")).click();
        List<WebElement> dropDownElements = driver.findElements(By.className("a-dropdown-item"));
        System.out.println("dropDownElements.size() = " + dropDownElements.size());

        dropDownElements.get(4).click();


//        4. Click first product
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div//div/h2/a[@class='a-link-normal a-text-normal'])[3]")).click();

//        5. Adjust qty 2

        driver.findElement(By.xpath("(//span[@class='a-dropdown-prompt'])[1]")).click();
        Thread.sleep(2000);

        List<WebElement> quantityDropdownElements = driver.findElements(By.xpath("(//ul[@class='a-nostyle a-list-link'])/li"));
        System.out.println("quantityDropdownElements.size() = " + quantityDropdownElements.size());

        quantityDropdownElements.get(1).click();
//        6. Pick to color
//        7. Click add to chart
        driver.findElement(By.cssSelector("#add-to-cart-button")).click();

        String priceBeforeChart = driver.findElement(By.xpath("(//span[@class='a-color-price hlb-price a-inline-block a-text-bold'])[1]")).getText();
        System.out.println("priceBeforeChart = " + priceBeforeChart);

//        8. Click view cart & checkout
//        9. Verify popup page’s subtotal and check out’s subtotal should be same


    }
}
