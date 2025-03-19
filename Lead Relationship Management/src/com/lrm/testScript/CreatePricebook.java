package com.lrm.testScript;
//WAS TO CREATE NEW PRICEBOOK AND ADD PRODUCT TO THE PRICEBOOK:
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatePricebook {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.150.128:8080/crm/HomePage.do");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("rashmi@dell.com");
		driver.findElement(By.xpath("//input[@id='passWord']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		driver.findElement(By.xpath("//a[text()='Price Books']")).click();
		driver.findElement(By.xpath("//input[@value='New Price Book']")).click();
		driver.findElement(By.xpath("//input[@name='property(Price Book Name)']")).sendKeys("Vivo mobiles catlog");
		driver.findElement(By.xpath("//textarea[@name='property(Description)']")).sendKeys("10% discount on each quantity");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		driver.findElement(By.xpath("//input[@value='Add Products']")).click();
		driver.findElement(By.xpath("//input[@name='searchString']")).sendKeys("vivo");
		driver.findElement(By.xpath("//input[@name='Go']")).click();
		//TO ADD PRODUCT TO THE PRICEBOOK
		driver.findElement(By.xpath("(//td[@class='tableData']/a)[1]")).click();
		driver.findElement(By.xpath("(//a[text()='Vivo 1726'])[2]/../..//input[@class='textField']")).sendKeys("14500");
		driver.findElement(By.xpath("//input[@value='Add to Products']")).click();
		System.out.println("Vivo 1726 added to the Pricebook successfully");
		driver.findElement(By.linkText("Logout [rashmi@dell.com]")).click();
		
	}

}
