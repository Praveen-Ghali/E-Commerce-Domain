package com.lrm.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateVendor {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.150.128:8080/crm/HomePage.do");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("rashmi@dell.com");
		driver.findElement(By.xpath("//input[@id='passWord']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		driver.findElement(By.xpath("//a[text()='Vendors']")).click();
		driver.findElement(By.xpath("//input[@value='New Vendor']")).click();
		driver.findElement(By.xpath("//input[@name='property(Vendor Name)']")).sendKeys("Vivo mobile exporter");
		driver.findElement(By.xpath("//input[@name='property(Phone)']")).sendKeys("9075141016");
		driver.findElement(By.xpath("//input[@name='property(Email)']")).sendKeys("vivoexporter@gmail.com");
		driver.findElement(By.xpath("//input[@name='property(Website)']")).sendKeys("www.vivo_dealer.com");
		WebElement glAccDD = driver.findElement(By.xpath("//select[@name='property(GL Account)']"));
		Select s=new Select(glAccDD);
		s.selectByIndex(1);
		driver.findElement(By.xpath("//input[@name='property(Street)']")).sendKeys("Basavanagudi");
		driver.findElement(By.xpath("//input[@name='property(City)']")).sendKeys("Bengalore");
		driver.findElement(By.xpath("//input[@name='property(State)']")).sendKeys("Karnataka");
		driver.findElement(By.xpath("//input[@name='property(Zip Code)']")).sendKeys("560009");
		driver.findElement(By.xpath("//input[@name='property(Country)']")).sendKeys("India");
		driver.findElement(By.xpath("//textarea[@name='property(Description)']")).sendKeys("Discount for 10% on each product for whole sale");
		driver.findElement(By.xpath("//input[@value='Save']")).submit();
		System.out.println("Vendor is created successfully");
		
	}

}
