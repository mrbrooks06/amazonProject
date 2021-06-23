package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
   driver.get("https://www.amazon.com.tr/");
   driver.manage().window().maximize();
   //2. Search for "hats for men" (Configurationdan cagir)
   driver.findElement(By.id("twotabsearchtextbox")).sendKeys("tarak");
   driver.findElement(By.id("nav-search-submit-button")).click();
   driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
 //newest
   Thread.sleep(5000);
   List<WebElement> newestList = driver.findElements(By.xpath("//div[@class='a-popover-wrapper']//li"));
   newestList.get(4).click();
 //select firstItem
   Thread.sleep(5000);
   //kaldı calısmıyor
  driver.findElement(By.xpath("(//div/h2/a/span)[1]")).click();

  }


}




