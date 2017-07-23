package Selenium.Project01;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class TestIETest {
	public static void snapshot(TakesScreenshot drivername,String filename) {
	File scrFile=drivername.getScreenshotAs(OutputType.FILE);
	try{
		FileUtils.copyFile(scrFile, new File("C:\\Users\\yanj\\workspace02\\Project01\\Screen\\"+filename));
	}catch (IOException e) {
        e.printStackTrace();
    } 
	finally
    {
        System.out.println("screen shot finished");
    }
	}
  @Test
  public void f() {
	  System.setProperty("webdriver.ie.driver","C:\\webdriver\\IEDriverServer.exe");
	  WebDriver driver=new InternetExplorerDriver();
	  driver.get("http://www.baidu.com");
	  driver.manage().window().maximize();
	  System.out.println("1 page Title is :"+driver.getTitle());
	  WebElement element=driver.findElement(By.id("kw"));
	  element.sendKeys("严佳音");
	  element.submit();
	  System.out.println("2 page Title is :"+driver.getTitle());
	  snapshot((TakesScreenshot)driver,"1.png");
	  //driver.quit();
  }
}
