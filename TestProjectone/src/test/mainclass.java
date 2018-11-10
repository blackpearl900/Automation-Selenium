package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			System.out.println("Hello Bhai");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vbstudent\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			driver.manage().window().maximize();
	
			WebElement username;
			username = driver.findElement(By.id("input-email"));
			username.sendKeys("adnan.adil900@avanzasolutions.com");
			
			WebElement Password;
			Password = driver.findElement(By.id("input-password"));
			Password.sendKeys("adnanadil");
			
			WebElement loginButton;
			loginButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
			loginButton.click();
			
			String actualpagetitle = driver.getTitle();
			String expectedTitle = "My Account";
			
					if(actualpagetitle.contentEquals(expectedTitle)) {
						System.out.println("pappu Pass ho gaya");
					}
					else {
						System.out.println("pappu Fail ho gaya");
					}
			
			driver.close(); //browser will be closed
			driver.quit(); //kill all process of drivers
	
	}

}
