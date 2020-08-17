package com.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
@Test
public class Myprofile {
		
		WebDriver driver;
		public void viewProfile() {
		System.setProperty("webdriver.gecko.driver","D:\\firefoxdriver\\geckodriver.exe" );
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		 driver = new FirefoxDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.navigate().to("http://localhost:4200");
		driver.findElement(By.linkText("My Profile")).click();
	}
	}
		


