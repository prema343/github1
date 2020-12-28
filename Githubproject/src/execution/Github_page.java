

package execution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//Functional Testing for GitHUB login page
public class Github_page {
	WebDriver driver;
	@BeforeMethod()
    public void openApplication() {
   	 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
   		 driver= new ChromeDriver();
   		driver.get("https://github.com/login");
   		
	}
   
	
	@Test(dataProvider ="authentication")
	public void prfg(String username,String password ) {
		driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys(username);
   		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
   					
   				driver.findElement(By.xpath("//input[@value='Sign in']")).click();
   			driver.findElement(By.xpath("//div[@class='Header-item position-relative d-none d-md-flex']")).click();
   			driver.findElement(By.xpath("//a[@href='/new']")).click();
   				driver.findElement(By.xpath("//input[@id='repository_name']")).sendKeys("&*&*&*****");
   				
    }
	
	@DataProvider(name="authentication")
	public Object[][] getData(){
		
		
		
		return new  Object[][] {
			{"premaqsp@gmail.com","Qsp123456789"},
			{"premaqsp@gmail.com","qsp2233"},
			{"prema26@gmail.com","Qsp123456789"},
			{"prema26@gmail.com","qsp345678"},
		{"prema343","qsp12345678"},
		{"prema","Qsp123456789"},
		{"prema22","qsp1234dd5678"},
		{"prema343","Qsp123456789"}
			
			
	
			};
		
	}
	
	@AfterMethod()
	public void closeApplication() {
		driver.quit();
	}
	
	}