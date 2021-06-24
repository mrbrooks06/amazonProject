package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utulities.WebDriverFactory;

import java.util.List;

public class Cast_Iron_Dutch_Oven {
WebDriver driver;
 @BeforeMethod
 public void setUp() {
  driver = WebDriverFactory.getDriver("chrome");
 }
  @Test
  public void test1() throws InterruptedException {
   driver.get("https://www.amazon.com");
   driver.manage().window().maximize();
   //2. Search for "hats for men" (Configurationdan cagir)
   driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Hp Elitebook");
   driver.findElement(By.id("nav-search-submit-button")).click();
   driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
 //newest
   Thread.sleep(3000);
   List<WebElement> newestList = driver.findElements(By.xpath("//div[@class='a-popover-wrapper']//li"));
   newestList.get(4).click();
 //select firstItem
   Thread.sleep(5000);//click on first product
  driver.findElement(By.xpath("(//div/h2/a/span)[1]")).click();
//click on dropdowm menu
   driver.findElement(By.xpath("(//span/span/span/span)[1]")).click();
//quanttiyt 2
   List<WebElement>dropDown = driver.findElements(By.xpath("//div[@class='a-popover-wrapper']//li"));
   dropDown.get(1).click();
   driver.findElement(By.id("add-to-cart-button")).click();
   //get price from subtotal
   String Price1 =driver.findElement(By.xpath("(//div[@id='hlb-subcart']//span/span)[2]")).getText();
   System.out.println(Price1);
// click cart
    driver.findElement(By.xpath("//span/span/a")).click();
//get price from subtotal
    String Price2=driver.findElement(By.xpath("((//div[@data-name='Subtotals'])[2]/span)[2]/span")).getText();
   System.out.println(Price2);

   Assert.assertEquals(Price1,Price2,"check price are same");

  }
  @AfterMethod
 public void tearDown() throws InterruptedException {
  Thread.sleep(3000);
  driver.quit();
  }
}




