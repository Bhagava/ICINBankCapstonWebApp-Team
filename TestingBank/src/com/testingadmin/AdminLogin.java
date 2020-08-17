package com.testingadmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
@Test
public class AdminLogin {
	
	public void login() {
	WebDriver driver;
	System.setProperty("webdriver.gecko.driver","D:\\firefoxdriver\\geckodriver.exe" );
	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	capabilities.setCapability("marionette", true);
	 driver = new FirefoxDriver(capabilities);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.navigate().to("http://localhost:4200");
	driver.findElement(By.linkText("Admin")).click();
	driver.findElement(By.name("email")).sendKeys("admin");
	driver.findElement(By.name("password")).sendKeys("Admin@123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.linkText("View User Profiles")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.linkText("Requests")).click();
	driver.findElement(By.linkText("Logout")).click();
	
	
	}
}
