package Selenium.Project01;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChrome {
	public static void snapshot(TakesScreenshot drivername, String filename)
	  {
	      // this method will take screen shot ,require two parameters ,one is driver name, another is file name
	      
	      
	    File scrFile = drivername.getScreenshotAs(OutputType.FILE);
	        // Now you can do whatever you need to do with it, for example copy somewhere
	        try {
	            FileUtils.copyFile(scrFile, new File("C:\\Users\\yanj\\workspace02\\Project01\\Screen\\"+filename));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	        finally
	        {
	            System.out.println("screen shot finished");
	        }
	  }

  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","C:\\ch\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www.bing.com");
	  driver.manage().window().maximize();
	  WebElement element=driver.findElement(By.name("go"));
	  System.out.println("1 page Title is :"+driver.getTitle());
	  element.sendKeys("Echo");
	  element.submit();
	  snapshot((TakesScreenshot)driver,"2.png");
	  System.out.println("2 page Title is :"+driver.getTitle());
//	  WebElement link= driver.findElement(By.linkText("echoçš„éŸ³ä¹�_è™¾ç±³éŸ³ä¹�"));
//	  link.click();
//	  System.out.println("3 page Title is :"+driver.getTitle());
//	  snapshot((TakesScreenshot)driver,"3.png");
	  //driver.quit();
  }
 

}
