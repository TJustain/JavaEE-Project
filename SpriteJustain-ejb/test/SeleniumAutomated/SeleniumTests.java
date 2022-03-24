/*
 *  Justian Tremblay and Martin Weaver
 *  SeleniumTests.java
 *  Purose: The goal of this class is to test our program using selenium. It does this by accsesing the web page and interacting with it.
 *          This is the non-headless version of Selenium as opposed to the other version which is headless. 
 */
package SeleniumAutomated;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Justain and Martin
 */
public class SeleniumTests {
public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub

//setting the driver executable
System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver_win32\\chromedriver.exe");

//Initiating your chromedriver
WebDriver driver=new ChromeDriver();

//Applied wait time
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//maximize window
driver.manage().window().maximize();

//open browser with desried URL
driver.get("http://localhost:8080/SpriteJustain-war/");
System.out.println("Going to main page.");

// This is a 10 second delay to allow login
TimeUnit.SECONDS.sleep(10);

// click on the "show all sprite" items
driver.findElement(By.xpath("/html/body/a[1]")).click();
System.out.println("Click on the 'show all sprite items'");

TimeUnit.SECONDS.sleep(5);

// Make a new sprite
driver.findElement(By.xpath("//*[@id=\"j_idt11\"]/a[2]")).click();
System.out.println("Click Create new Sprite");

TimeUnit.SECONDS.sleep(5);

//Setting the width
driver.findElement(By.xpath("//*[@id=\"j_idt12:panelWidth\"]")).sendKeys(Keys.DELETE, Keys.DELETE, Keys.BACK_SPACE,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:panelWidth\"]")).sendKeys("205");
System.out.println("Deleting width and entering width info.");

TimeUnit.SECONDS.sleep(5);

//Setting the height
driver.findElement(By.xpath("//*[@id=\"j_idt12:panelHeight\"]")).sendKeys(Keys.DELETE, Keys.DELETE, Keys.BACK_SPACE,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:panelHeight\"]")).sendKeys("234");
System.out.println("Deleting height and entering height info.");

TimeUnit.SECONDS.sleep(5);

// Setting x
driver.findElement(By.xpath("//*[@id=\"j_idt12:x\"]")).sendKeys(Keys.DELETE, Keys.DELETE, Keys.BACK_SPACE,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:x\"]")).sendKeys("333");
System.out.println("Deleting x and entering new x.");

TimeUnit.SECONDS.sleep(5);

// Setting y
driver.findElement(By.xpath("//*[@id=\"j_idt12:y\"]")).sendKeys(Keys.DELETE, Keys.DELETE, Keys.BACK_SPACE,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:y\"]")).sendKeys("123");
System.out.println("Deleting y and entering new y.");

TimeUnit.SECONDS.sleep(5);

//Setting dx
driver.findElement(By.xpath("//*[@id=\"j_idt12:dx\"]")).sendKeys(Keys.DELETE, Keys.DELETE, Keys.BACK_SPACE,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:dx\"]")).sendKeys("432");
System.out.println("Deleting dx and entering new dx.");

TimeUnit.SECONDS.sleep(5);

//Setting dy
driver.findElement(By.xpath("//*[@id=\"j_idt12:dy\"]")).sendKeys(Keys.DELETE, Keys.DELETE, Keys.BACK_SPACE,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:dy\"]")).sendKeys("111");
System.out.println("Deleting dy and entering new dy.");

TimeUnit.SECONDS.sleep(5);

//Setting color
driver.findElement(By.xpath("//*[@id=\"j_idt12:color\"]")).sendKeys(Keys.CONTROL + "a" ,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:color\"]")).sendKeys("#113355");
System.out.println("Deleted color and entered new one.");

TimeUnit.SECONDS.sleep(3);

//Saving sprite
System.out.println("Saved the sprite.");
driver.findElement(By.xpath("//*[@id=\"j_idt12\"]/a[1]")).click();

TimeUnit.SECONDS.sleep(3);

//Showing sprites
driver.findElement(By.xpath("//*[@id=\"j_idt12\"]/a[2]")).click();
TimeUnit.SECONDS.sleep(5);

//closing the browser
driver.close();

}
}
