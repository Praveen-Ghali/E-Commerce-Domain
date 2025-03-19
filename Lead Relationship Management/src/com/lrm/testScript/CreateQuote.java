package com.lrm.testScript;

import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import graphql.language.Document;

public class CreateQuote {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.150.128:8080/crm/HomePage.do");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("rashmi@dell.com");
		driver.findElement(By.xpath("//input[@id='passWord']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		Thread.sleep(5000);
		for(int i=1; i<=3; i++) {
			driver.findElement(By.id("scrollright")).click();
		}
		
		driver.findElement(By.xpath("//a[text()='Quotes']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='New Quote']")).click();
		driver.findElement(By.xpath("//img[@title='Potential Name Lookup']")).click();
		String pWh = driver.getWindowHandle();
		Set<String> allWh = driver.getWindowHandles();
		for(String wh:allWh) {
			driver.switchTo().window(wh);
			String title = driver.getTitle();
			//System.out.println(title);
			if (title.equals("Zoho CRM - Potential Name Lookup")) {
				driver.switchTo().window(wh);
				driver.findElement(By.name("fldValue")).sendKeys("veera vahana");
				driver.findElement(By.xpath("//input[@value='Go']")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Veera Vahana')]")).click();
			}
		}
		driver.switchTo().window(pWh);
		driver.findElement(By.xpath("//input[@name='property(Subject)']")).sendKeys("vivo mobile quotation");
		driver.findElement(By.xpath("//img[@title='Calendar']")).click();
		Set<String> allWh1 = driver.getWindowHandles();
		for(String wh1:allWh1) {
			driver.switchTo().window(wh1);
			String title = driver.getTitle();
			//System.out.println(title);
			if (title.equals("Valid Till")) {
				driver.switchTo().window(wh1);
				JavascriptExecutor j=(JavascriptExecutor) driver;
				j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				driver.findElement(By.xpath("(//tr)[9]/td[2]")).click();
			}
		}
		driver.switchTo().window(pWh);
		WebElement quoteStageDD = driver.findElement(By.xpath("//select[@name='property(Quote Stage)']"));
		Select s=new Select(quoteStageDD);
		s.selectByIndex(2);
		driver.findElement(By.xpath("//img[@title=\"Contact Name Lookup\"]")).click();
		Set<String> allWh2 = driver.getWindowHandles();
		for(String wh2:allWh2) {
			driver.switchTo().window(wh2);
			String title = driver.getTitle();
			System.out.println(title);
			if (title.equals("Zoho CRM - Contact Name Lookup")) {
				driver.switchTo().window(wh2);
				driver.findElement(By.className("textField")).sendKeys("Praveen Shetti");
				driver.findElement(By.xpath("//input[@value='Go']")).click();
				driver.findElement(By.xpath("//a[text()='Praveen Shetti']")).click();
			}
		}
		driver.switchTo().window(pWh);
		driver.findElement(By.xpath("//img[@title='Account Name Lookup']")).click();
		Set<String> allWh3 = driver.getWindowHandles();
		for(String wh3:allWh3) {
			driver.switchTo().window(wh3);
			String title = driver.getTitle();
			System.out.println(title);
			if (title.equals("Zoho CRM - Account Name Lookup")) {
				driver.switchTo().window(wh3);
				driver.findElement(By.name("fldValue")).sendKeys("veera vahana");
				driver.findElement(By.xpath("//input[@value='Go']")).click();
				driver.findElement(By.xpath("//a[text()='Veera Vahana Pvt.Ltd']")).click();
			}
		}
		driver.switchTo().window(pWh);
		driver.findElement(By.xpath("//input[@id='copyAddress']")).click();
		driver.findElement(By.xpath("//td[text()='Billing to Shipping']")).click();
		driver.findElement(By.xpath("//img[@title='Product Name Lookup']")).click();
		Set<String> allWh4 = driver.getWindowHandles();
		for(String wh4:allWh4) {
			driver.switchTo().window(wh4);
			String title = driver.getTitle();
			System.out.println(title);
			if (title.equals("Zoho CRM - Product Name Lookup")) {
				driver.switchTo().window(wh4);
				driver.findElement(By.name("fldValue")).sendKeys("vivo");
				driver.findElement(By.xpath("//input[@value='Go']")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Vivo')]")).click();
			}
			
		}
		driver.switchTo().window(pWh);
		driver.findElement(By.xpath("//input[@name='property(txtQty1)']")).sendKeys("20");
		driver.findElement(By.xpath("//input[@name='property(txtListPrice1)']")).sendKeys("14500");
		driver.findElement(By.xpath("//textarea[@name='property(Terms and Conditions)']")).sendKeys("No replaceable policy");
		driver.findElement(By.xpath("//input[@value='Save']")).click();	
		driver.findElement(By.linkText("Logout [rashmi@dell.com]")).click();
	}

}
