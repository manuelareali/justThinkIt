package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestOne {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:8080/justThinkIt/view/contattaNegozio.jsp");
			
		
			driver.findElement(By.xpath("//*[@id=\"codice_mittente\"]")).sendKeys("c");
			driver.findElement(By.xpath("//*[@id=\"codice_destinatario\"]")).sendKeys("n");
			driver.findElement(By.xpath("//*[@id=\"oggetto\"]")).sendKeys("Evento del 5 ottobre");
			driver.findElement(By.xpath("//*[@id=\"messaggio\"]")).sendKeys("Bisogna creare una lista per le prenotazioni già effettuate");
			
			Thread.sleep(2000);
			
			driver.close();
			
		}
	
}
