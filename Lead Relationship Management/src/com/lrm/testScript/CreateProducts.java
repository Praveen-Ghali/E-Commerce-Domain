package com.lrm.testScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateProducts {

	public static void main(String[] args) throws AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.150.128:8080/crm/HomePage.do");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("rashmi@dell.com");
		driver.findElement(By.xpath("//input[@id='passWord']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//input[@value='New Product']")).click();
		driver.findElement(By.xpath("//input[@name='property(Product Name)']")).sendKeys("Vivo 1726");
		driver.findElement(By.xpath("//input[@name='property(Product Code)']")).sendKeys("AZ1000SDM50061");
		driver.findElement(By.xpath("//input[@name='property(Vendor Name)']/..//img")).click();
		String pWh = driver.getWindowHandle();
		Set<String> allWh = driver.getWindowHandles();
		for(String wh:allWh) {
			driver.switchTo().window(wh);
			String title = driver.getTitle();
			if (title.equals("Zoho CRM - Vendor Name Lookup")) {
				driver.switchTo().window(wh);
				driver.findElement(By.className("textField")).sendKeys("Vivo");
				driver.findElement(By.xpath("//input[@name='Submit']")).click();				driver.findElement(By.xpath("//a[contains(text(),'Vivo mobile exporter')]")).click();
				//driver.close();
			}
		}
			driver.switchTo().window(pWh);
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("//input[@name='property(Sales Start Date)']")).sendKeys("03/07/2025");
			WebElement manufactureDD = driver.findElement(By.xpath("//select[@name='property(Manufacturer)']"));
			Select s=new Select(manufactureDD);
			s.selectByIndex(1);
			WebElement productCatDD=driver.findElement(By.xpath("//select[@name='property(Product Category)']"));
			Select s1=new Select(productCatDD);
			s1.selectByIndex(1);
			driver.findElement(By.xpath("//input[@name='property(Sales End Date)']")).sendKeys("03/12/2025");
			driver.findElement(By.xpath("//input[@name='property(Support Start Date)']")).sendKeys("03/01/2025");
			driver.findElement(By.xpath("//input[@name='property(Support Expiry Date)']")).sendKeys("03/31/2025");
			driver.findElement(By.xpath("//input[@name='property(Unit Price)']")).sendKeys("15000");
			WebElement usageUnitDD = driver.findElement(By.xpath("//select[@name='property(Usage Unit)']"));
			Select s2=new Select(usageUnitDD);
			s2.selectByIndex(9);
			driver.findElement(By.xpath("//input[@name='property(Qty/Unit)']")).sendKeys("1");
			driver.findElement(By.xpath("//input[@name='property(Qty in Stock)']")).sendKeys("100");
			driver.findElement(By.xpath("//input[@value='Save']")).click();
			System.out.println("Vivo product details is created successfully");
		
		
	}

}
