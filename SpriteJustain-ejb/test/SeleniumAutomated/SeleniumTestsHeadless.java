/*
 *  Justian Tremblay and Martin Weaver
 *  SeleniumTests.java
 *  Purose: The goal of this class is to test our program using selenium. It does this by accsesing the web page and interacting with it.
 *          This is the headless version of Selenium as opposed to the other version which isn't headless. 
            The headless version doesn't show the automatiom, but provides sprite info for feedback. 
            ##### HEADLESS MODE MAY NOT WORK WITH AUTH #####
 */
package SeleniumAutomated;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Justain and Martin
 */
public class SeleniumTestsHeadless {
public static void main(String[] args) throws InterruptedException {

//setting the driver executable
//replace with your chrome driver
System.setProperty("webdriver.chrome.driver", "C:\\Users\\marti\\Desktop\\Chromedriver\\chromedriver_win32\\chromedriver.exe");

//Initiating your chromedriver
ChromeOptions headless = new ChromeOptions();       //Enables hesless mode
headless.addArguments("--headless");                //Creating the headless driver
WebDriver driver=new ChromeDriver(headless);        

//This section randomizes values for our automated headless sprite
//It allows to verify that it was made. 
Random rand = new Random();
int x = rand.nextInt(250);
int y = rand.nextInt(250);
int height = rand.nextInt(250);
int width = rand.nextInt(250);
int dx = rand.nextInt(250);
int dy = rand.nextInt(250);
int color = rand.nextInt(1000000);
String colorFormatted = "#" + Integer.toString(color);

//Applied wait time
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//maximize window
driver.manage().window().maximize();

//open browser with desried URL
driver.get("http://localhost:8080/SpriteJustain-war/");

System.out.println("Going to main page.");

TimeUnit.SECONDS.sleep(10);

//Click show all sprites
driver.findElement(By.xpath("/html/body/a[1]")).click();
System.out.println("Click on the 'show all sprite items'");

TimeUnit.SECONDS.sleep(5);

// Click create new sprite
driver.findElement(By.xpath("//*[@id=\"j_idt11\"]/a[2]")).click();
System.out.println("Click Create new Sprite");

TimeUnit.SECONDS.sleep(5);

//Setting width
driver.findElement(By.xpath("//*[@id=\"j_idt12:panelWidth\"]")).sendKeys(Keys.DELETE, Keys.DELETE, Keys.BACK_SPACE,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:panelWidth\"]")).sendKeys(Integer.toString(width));
System.out.println("Deleting width and entering width info.");

TimeUnit.SECONDS.sleep(5);

//Setting height
driver.findElement(By.xpath("//*[@id=\"j_idt12:panelHeight\"]")).sendKeys(Keys.DELETE, Keys.DELETE, Keys.BACK_SPACE,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:panelHeight\"]")).sendKeys(Integer.toString(height));
System.out.println("Deleting height and entering height info.");

TimeUnit.SECONDS.sleep(5);

//Setting x
driver.findElement(By.xpath("//*[@id=\"j_idt12:x\"]")).sendKeys(Keys.DELETE, Keys.DELETE, Keys.BACK_SPACE,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:x\"]")).sendKeys(Integer.toString(x));
System.out.println("Deleting x and entering new x.");

TimeUnit.SECONDS.sleep(5);

//Setting y
driver.findElement(By.xpath("//*[@id=\"j_idt12:y\"]")).sendKeys(Keys.DELETE, Keys.DELETE, Keys.BACK_SPACE,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:y\"]")).sendKeys(Integer.toString(y));
System.out.println("Deleting y and entering new y.");

TimeUnit.SECONDS.sleep(5);

//Setting dx
driver.findElement(By.xpath("//*[@id=\"j_idt12:dx\"]")).sendKeys(Keys.DELETE, Keys.DELETE, Keys.BACK_SPACE,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:dx\"]")).sendKeys(Integer.toString(dx));
System.out.println("Deleting dx and entering new dx.");

TimeUnit.SECONDS.sleep(5);

//Setting dy
driver.findElement(By.xpath("//*[@id=\"j_idt12:dy\"]")).sendKeys(Keys.DELETE, Keys.DELETE, Keys.BACK_SPACE,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:dy\"]")).sendKeys(Integer.toString(dy));
System.out.println("Deleting dy and entering new dy.");

TimeUnit.SECONDS.sleep(5);

//Setting Color
driver.findElement(By.xpath("//*[@id=\"j_idt12:color\"]")).sendKeys(Keys.CONTROL + "a" ,Keys.BACK_SPACE);
driver.findElement(By.xpath("//*[@id=\"j_idt12:color\"]")).sendKeys(colorFormatted);
System.out.println("Deleted color and entered new one.");

TimeUnit.SECONDS.sleep(3);

//Saving the new sprite
System.out.println("Saved the sprite.");
driver.findElement(By.xpath("//*[@id=\"j_idt12\"]/a[1]")).click();

TimeUnit.SECONDS.sleep(3);

//*[@id="j_idt12"]/a[2] ----Show Sprites
driver.findElement(By.xpath("//*[@id=\"j_idt12\"]/a[2]")).click();
TimeUnit.SECONDS.sleep(5);

//Displaying the info of the saved sprite
System.out.println("\n\nSaved the following sprite: ");
System.out.println("Width - " + Integer.toString(width)); 
System.out.println("Height - " + Integer.toString(height)); 
System.out.println("x - " + Integer.toString(x)); 
System.out.println("y - " + Integer.toString(y)); 
System.out.println("dx - " + Integer.toString(dx)); 
System.out.println("dy - " + Integer.toString(dy)); 
System.out.println("color - " + colorFormatted); 

System.out.println("\nFinished automation...\n");

//closing the browser
driver.close();

}
}
