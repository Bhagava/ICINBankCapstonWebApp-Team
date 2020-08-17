package com.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
@Test
public class ChequeBookRequest {

		
		WebDriver driver;
		public void chequeRequest() {
		System.setProperty("webdriver.gecko.driver","D:\\firefoxdriver\\geckodriver.exe" );
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		 driver = new FirefoxDriver(capabilities);
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://localhost:4200/chequebook");
		driver.findElement(By.xpath("//a[contains(@href, '/request')]")).click();
		driver.findElement(By.name("description")).sendKeys("I need chequebook");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
}
}