package com.lrm.testScript;
//WAS TO CREATE SALES ORDER
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateSalesOrder {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.150.128:8080/crm/HomePage.do");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("rashmi@dell.com");
		driver.findElement(By.xpath("//input[@id='passWord']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		WebElement target = driver.findElement(By.xpath("//a[@id='showSubMenu']"));
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
		driver.findElement(By.linkText("New Sales Order")).click();
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
				driver.findElement(By.xpath("(//a[contains(text(),'Veera Vahana')])[1]")).click();
			}
		}
		driver.switchTo().window(pWh);
		//ERROR
		driver.findElement(By.xpath("//input[@name='property(Subject)']")).sendKeys("Vivo mobile Sales order");
		driver.findElement(By.xpath("//input[@name='property(Customer No)']")).sendKeys("9075141016");
		driver.findElement(By.xpath("//img[@title='Calendar']")).click();
		Set<String> allWh1 = driver.getWindowHandles();
		for(String wh1:allWh1) {
			driver.switchTo().window(wh1);
			String title = driver.getTitle();
			//System.out.println(title);
			if (title.equals("Due Date")) {
				driver.switchTo().window(wh1);
				JavascriptExecutor j=(JavascriptExecutor) driver;
				j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				driver.findElement(By.xpath("(//tr)[9]/td[2]")).click();
			}
		}
		driver.switchTo().window(pWh);
		driver.findElement(By.xpath("//img[@title='Quote Lookup']")).click();
		Set<String> allWh2 = driver.getWindowHandles();
		for(String wh2:allWh2) {
			driver.switchTo().window(wh2);
			String title = driver.getTitle();
			//System.out.println(title);
			if (title.equals("Zoho CRM - Quote Name Lookup")) {
				driver.switchTo().window(wh2);
				driver.findElement(By.xpath("//a[text()='vivo mobile quotation']")).click();
			}
		}
		driver.switchTo().window(pWh);
		driver.findElement(By.xpath("//img[@title='Calculator']")).click();
		Set<String> allWh3 = driver.getWindowHandles();
		for(String wh3:allWh3) {
			driver.switchTo().window(wh3);
			String title = driver.getTitle();
			System.out.println(title);
			if (title.equals("Excise Duty")) {
				driver.switchTo().window(wh3);
				driver.findElement(By.xpath("(//tr)[14]/td[2]")).click();
				driver.findElement(By.xpath("(//tr)[14]/td[3]")).click();
				driver.findElement(By.xpath("(//tr)[14]/td[4]")).click();
				driver.findElement(By.xpath("(//tr)[13]/td[2]")).click();
				driver.findElement(By.xpath("(//tr)[13]/td[3]")).click();
				JavascriptExecutor j=(JavascriptExecutor) driver;
				j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				driver.findElement(By.xpath("(//tr)[15]/td[4]")).click();
			}
			
		}
		driver.switchTo().window(pWh);
		WebElement statusDD = driver.findElement(By.xpath("//select[@name='property(Status)']"));
		Select s=new Select(statusDD);
		s.selectByIndex(2);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		driver.findElement(By.linkText("Logout [rashmi@dell.com]")).click();		
	}

}
