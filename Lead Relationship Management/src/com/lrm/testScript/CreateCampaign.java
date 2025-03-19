package com.lrm.testScript;
//WAS TO CREATE A NEW CAMPAIGN AND VALIDATE IT IS CREATED OR NOT:

import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateCampaign {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.150.128:8080/crm/HomePage.do");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("rashmi@dell.com");
		driver.findElement(By.xpath("//input[@id='passWord']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();//HomePage
		
		driver.findElement(By.xpath("//input[@value='New Campaign']")).click();
		driver.findElement(By.xpath("//input[@name='property(Campaign Name)']")).sendKeys("Vivo Mobile Info");
		WebElement cType = driver.findElement(By.xpath("//select[@name='property(Type)']"));
		Select s=new Select(cType);
		s.selectByIndex(7);
		String pWh = driver.getWindowHandle();
		driver.findElement(By.xpath("(//img[@title='Calendar'])[1]")).click();
		Set<String> allwh1 = driver.getWindowHandles();
		 for( String wh:allwh1) {
			 driver.switchTo().window(wh);
			 String title = driver.getTitle();
			 if (title.equals("Start Date")) {
				driver.switchTo().window(wh);
				driver.findElement(By.xpath("(//tr[@align='center'])[5]/td[2]")).click();
			}
			
		}
		 driver.switchTo().window(pWh);
		 driver.findElement(By.xpath("(//img[@title='Calendar'])[2]")).click();
		 Set<String> allwh2 = driver.getWindowHandles();
		 for( String wh:allwh2) {
			 driver.switchTo().window(wh);
			 String title = driver.getTitle();
			 if (title.equals("End Date")) {
				driver.switchTo().window(wh);
				driver.findElement(By.xpath("(//tr[@align='center'])[5]/td[4]")).click();
				}
		}
		 driver.switchTo().window(pWh);
		 WebElement cStatus = driver.findElement(By.xpath("//select[@name='property(Status)']"));
		 Select s1=new Select(cStatus);
		 s1.selectByIndex(3);
		 driver.findElement(By.xpath("//input[@name='property(Expected Revenue)']")).sendKeys("500000");
		 driver.findElement(By.xpath("//input[@name='property(Budgeted Cost)']")).sendKeys("25000");
		 driver.findElement(By.xpath("//input[@name='property(Actual Cost)']")).sendKeys("350000");
		 driver.findElement(By.xpath("//input[@name='property(Expected Response)']")).sendKeys("150");
		 driver.findElement(By.xpath("//input[@name='property(Num sent)']")).sendKeys("150");
		 driver.findElement(By.xpath("//textarea[@name='property(Description)']")).sendKeys("Place: Palace ground Bengalore");
		 driver.findElement(By.xpath("(//input[@type='submit'])[2]")).submit();
		 String campaign = driver.findElement(By.xpath("//td[@id='Campaign Name']/..//span[@id='value_Campaign Name']")).getText();
		 System.out.println(campaign+" created successfully");
		// driver.findElement(By.linkText("Logout [rashmi@dell.com]")).click();
		 //driver.quit();
	}

}
	
