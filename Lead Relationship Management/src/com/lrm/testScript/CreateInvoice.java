package com.lrm.testScript;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateInvoice {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.150.128:8080/crm/HomePage.do");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("rashmi@dell.com");
		driver.findElement(By.xpath("//input[@id='passWord']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		WebElement target = driver.findElement(By.xpath("//a[@id='showSubMenu']"));
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
		driver.findElement(By.linkText("New Invoice")).click();
		driver.findElement(By.xpath("//img[@title='SalesOrder Lookup']")).click();	
		String pWh = driver.getWindowHandle();
		Set<String> allWh = driver.getWindowHandles();
		for(String wh:allWh) {
			driver.switchTo().window(wh);
			String title = driver.getTitle();
			if (title.equals("Zoho CRM - Sales Order Name Lookup")) {
				driver.findElement(By.xpath("//a[text()='vivo mobile quotation']")).click();
			}
		}
		driver.switchTo().window(pWh);
		driver.findElement(By.xpath("(//img[@title='Calendar'])[1]")).click();
		Set<String> allWh1 = driver.getWindowHandles();
		for(String wh1:allWh1) {
			driver.switchTo().window(wh1);
			String title = driver.getTitle();
			if (title.equals("Invoice Date")) {
			driver.findElement(By.xpath("(//tr)[6]/td[4]")).click();
			}
		}
		driver.switchTo().window(pWh);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		System.out.println("Invoice is created successfully");
		driver.findElement(By.linkText("Logout [rashmi@dell.com]")).click();
		driver.quit();
	}

}
