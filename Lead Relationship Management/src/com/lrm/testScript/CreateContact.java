package com.lrm.testScript;
//WAS TO CREATE NEW CONTACT:

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.150.128:8080/crm/HomePage.do");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("rashmi@dell.com");
		driver.findElement(By.xpath("//input[@id='passWord']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//input[@value='New Contact']")).click();
		WebElement salutationDD = driver.findElement(By.xpath("//select[@name='property(saltName)']"));
		Select s1=new Select(salutationDD);
		s1.selectByIndex(1);
		WebElement leadSourceDD = driver.findElement(By.xpath("//select[@name='property(Lead Source)']"));
		Select s2=new Select(leadSourceDD);
		s2.selectByIndex(1);
		driver.findElement(By.xpath("//input[@name='property(First Name)']")).sendKeys("Praveen");
		driver.findElement(By.xpath("//input[@name='property(Last Name)']")).sendKeys("Ghali");
		
		 driver.findElement(By.xpath("//input[@name='property(Account Name)']")).sendKeys("Veera vahana Udyog.Pvt.Ltd");
		 driver.findElement(By.xpath("//input[@name='property(Email)']")).sendKeys("pmg9@gmail.com");
		 driver.findElement(By.xpath("//input[@name='property(Phone)']")).sendKeys("9637412585");
		 driver.findElement(By.xpath("//input[@name='property(Date of Birth)']")).sendKeys("07/14/1997");
		 driver.findElement(By.xpath("//input[@value='Save']")).click();
		 String cText = driver.findElement(By.xpath("(//td[@id='Last Name']/..//td[@class='value'])[2]")).getText();
		 System.out.println(cText+" contact is successfully created");
		 driver.findElement(By.linkText("Logout [rashmi@dell.com]")).click();
		 driver.quit();
		
	}

}
