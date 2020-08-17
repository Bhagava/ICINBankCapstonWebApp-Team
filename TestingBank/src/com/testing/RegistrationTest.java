package com.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
@Test
public class RegistrationTest {
		
	WebDriver driver;

	public void SignUp() {
	System.setProperty("webdriver.gecko.driver","D:\\firefoxdriver\\geckodriver.exe" );
	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	capabilities.setCapability("marionette", true);
	driver = new FirefoxDriver(capabilities);
	driver.navigate().to("http://localhost:4200");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.findElement(By.linkText("Sign Up/Register")).click();
	driver.findElement(By.name("fullname")).sendKeys("Sanjana");
	driver.findElement(By.name("surname")).sendKeys("Sri");
	driver.findElement(By.name("mailid")).sendKeys("test67@gmail.com");
	driver.findElement(By.name("phonenumber")).sendKeys("9087654321");
	driver.findElement(By.name("address")).sendKeys("Bangalore");
	driver.findElement(By.name("password")).sendKeys("Sanjana@123");
	driver.findElement(By.xpath("//button[contains(.,'Register')]")).click();
	
	System.out.println("Registration Successful");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("email")).sendKeys("test67@gmail.com");
	driver.findElement(By.name("password")).sendKeys("Sanjana@123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	
}
}
