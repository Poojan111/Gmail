package testing;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import java.util.Iterator;
public class Compose {
	
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\701616\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    String baseUrl = "https://accounts.google.com/signin";
    driver.get(baseUrl);
    driver.manage().window().maximize();
    String Title = driver.getTitle();
    System.out.println("****** User Has successfully Launched Driver and is on "+ Title + " page ******");
    
    //invalid mail
    
    String invalidEmail="@com.gamiltestuser";
    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@type='email']")).sendKeys(invalidEmail);
    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    String aerror1 = driver.findElement(By.xpath("//div[contains(text(),'Enter a valid email or phone number')]")).getText();
    Assert.assertEquals("Enter a valid email or phone number", aerror1);   
    
    //Valid mail
    
     String ValidMail="testuser01200@gmail.com";
    driver.findElement(By.xpath("//input[@type='email']")).clear();
    driver.findElement(By.xpath("//input[@type='email']")).sendKeys(ValidMail);
    driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
    String Title2 = driver.getTitle();
    System.out.println(Title2);
  
    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    String password="testuser@123";
    
    driver.findElement(By.name("password")).sendKeys(password);
   driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
   driver.findElement(By.id("passwordNext")).click();
   driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);
    
    String Title3 = driver.getTitle();
    System.out.println("****** Successful Login "+ Title3 + " page ******");
    
    driver.findElement(By.xpath("//h2[contains(text(),'Account storage')]")).click();
    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//a[@aria-label='Link to Gmail']")).click();
    String parent=driver.getWindowHandle();
    Set<String>s=driver.getWindowHandles();
    Iterator<String> I1= s.iterator();
    while(I1.hasNext())
    {
    String child_window=I1.next();
    if(!parent.equals(child_window))
    {
    driver.switchTo().window(child_window);
    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    String Title4 = driver.getTitle();
    System.out.println("****** "+ Title4 + " ******");
    
    //Compose
    
    driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("testuser1@gmail.com,");
    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    driver.findElement(By.xpath("(//textarea[@name='to'])[1]")).sendKeys("testuser1@yahoo.com");
    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    driver.findElement(By.xpath("(//span[contains(text(),'Cc')])[1]")).click();
    driver.findElement(By.xpath("//textarea[@aria-label='Cc']")).sendKeys("testsubuser1@gmail.com");
    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//textarea[@aria-label='Cc']")).sendKeys("testsubuser2@yahoo.com");
    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Happy Birthday");
    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Many Many Happy Retursn of the day TestUser1");
    driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")).click();
    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    
    //close
    
    driver.quit();
    }
    }
	}
    
}
