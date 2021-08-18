package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestTwo {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:8080/justThinkIt/view/creaDonazioneMap.jsp");
			
		
			
			driver.findElement(By.xpath("/html/body/div/form/div[2]/div/div/div[2]/input")).click();
			driver.findElement(By.xpath("//*[@id=\"IndirizzoVolontario\"]")).sendKeys("via Roma");
			driver.findElement(By.xpath("//*[@id=\"descrizione\"]")).sendKeys("Ho donato 3kg di pasta");
			
			Thread.sleep(2000);
			
			driver.close();
			
		}
}
