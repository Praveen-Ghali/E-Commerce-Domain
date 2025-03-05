package com.lrm.testScript;
import java.util.Set;

import org.jspecify.annotations.Nullable;
//WAS TO CREATE NEW LEAD AND VALIDATE IT IS CREATED SUCCESSFULLY OR NOT:
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.150.128:8080/crm/HomePage.do");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("rashmi@dell.com");
		driver.findElement(By.xpath("//input[@id='passWord']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//input[@onclick='createAction()']")).click();
		WebElement salutation = driver.findElement(By.xpath("//select[@name='property(saltName)']"));
		Select s1=new Select(salutation);
		s1.selectByIndex(1);
		driver.findElement(By.xpath("//input[@name='property(First Name)']")).sendKeys("Praveen");
		driver.findElement(By.xpath("//input[@name='property(Last Name)']")).sendKeys("Ghali");
		driver.findElement(By.xpath("//input[@name='property(Company)']")).sendKeys("Veera Vahana Udyog Pvt.Ltd");
		driver.findElement(By.xpath("//input[@name='property(Designation)']")).sendKeys("Service Engg");
		driver.findElement(By.xpath("//input[@name='property(Email)']")).sendKeys("pmg@gmail.com");
		driver.findElement(By.xpath("//input[@name='property(Phone)']")).sendKeys("9874561235");
		driver.findElement(By.xpath("//input[@name='property(Fax)']")).sendKeys("044 123 4567");
		driver.findElement(By.xpath("//input[@name='property(Mobile)']")).sendKeys("9874561235");
		driver.findElement(By.xpath("//input[@name='property(Website)']")).sendKeys("www.veera.com");
		WebElement leadSourceDD = driver.findElement(By.xpath("//select[@name='property(Lead Source)']"));
		Select s2=new Select(leadSourceDD);
		s2.selectByIndex(1);
		WebElement leadStatusDD = driver.findElement(By.xpath("//select[@name='property(Lead Status)']"));
		Select s3=new Select(leadStatusDD);
		s3.selectByIndex(2);
		WebElement industryDD = driver.findElement(By.xpath("//select[@name='property(Industry)']"));
		Select s4=new Select(industryDD);
		s4.selectByIndex(4);
		driver.findElement(By.xpath("//input[@name='property(No of Employees)']")).sendKeys("150");
		driver.findElement(By.xpath("//input[@name='property(Annual Revenue)']")).sendKeys("450000");
		WebElement ratingDD = driver.findElement(By.xpath("//select[@name='property(Rating)']"));
		Select s5=new Select(ratingDD);
		s5.selectByIndex(2);
		
		/*driver.findElement(By.xpath("//img[@title='Campaign Name Lookup']")).click();
		Set<String> allwh1 = driver.getWindowHandles();
		 for( String wh:allwh1) {
			 driver.switchTo().window(wh);
			 String title = driver.getTitle();
			 System.out.println(title);
			 if (title.equals("Zoho CRM - Campaign Name Lookup")) {
				driver.switchTo().window(wh);
				driver.findElement(By.xpath("//tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td[1]/a")).click();
				//driver.close();
			}
			 if (title.equals("Zoho CRM - Create Lead")) {
					driver.switchTo().window(wh);
					String title1 = driver.getTitle();
					 System.out.println(title1);
			}
		}*/
		
		driver.findElement(By.xpath("//input[@name='property(Street)']")).sendKeys("Basavanagudi");
		driver.findElement(By.xpath("//input[@name='property(City)']")).sendKeys("Bengalore");
		driver.findElement(By.xpath("//input[@name='property(State)']")).sendKeys("Karnataka");
		driver.findElement(By.xpath("//input[@name='property(Zip Code)']")).sendKeys("56009");
		driver.findElement(By.xpath("//input[@name='property(Country)']")).sendKeys("India");
		driver.findElement(By.xpath("//textarea[@name='property(Description)']")).sendKeys("Lead interested");
		driver.findElement(By.xpath("//input[@value='Save']")).submit();
		String text = driver.findElement(By.xpath("(//td[@id='Last Name']/..//td[@class='value'])[2]")).getText();
		System.out.println(text+" lead is created successfully");
		driver.findElement(By.linkText("Logout [rashmi@dell.com]")).click();
		driver.quit();
		
}
}
