package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

public class ApplicationFunctionalityTest {

	private WebDriver driver;
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testLoginSuccess() {
		System.setProperty("webdriver.chrome.driver", "/Users/wenzongxuan/Downloads/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
		driver.get("http://localhost:8080/login");

		sleep(5);
		
		// Find username element
		//
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("wenzong");
		
		// Find password element
		//
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("wenzong_pass");
		
		// Find Submit button, and click on button.
		//
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		Assert.assertEquals("http://localhost:8080/q1", driver.getCurrentUrl());
	}
	
	@Test
    public void testQ1PageAfterLogin() {

		testLoginSuccess();
        driver.get("http://localhost:8080/q1");

        WebElement firstNumberInput = driver.findElement(By.name("number1"));
        WebElement secondNumberInput = driver.findElement(By.name("number2"));
        WebElement resultInput = driver.findElement(By.name("result"));
        
        firstNumberInput.sendKeys("10");
        secondNumberInput.sendKeys("20");
        resultInput.sendKeys("30");

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        
        driver.close(); 
	}
}
