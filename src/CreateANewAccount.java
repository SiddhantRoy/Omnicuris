import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TestUtil.Readdata;

public class CreateANewAccount {
	
public class CreateAccount {
		
		WebDriver driver;

		@BeforeMethod
		public void setUp()
		{
		

		System.setProperty("webdriver.chrome.driver","C:\\Users\\siddhant sankar\\Desktop\\74Chrom\\chromedriver_win32\\chromedriver.exe");
		    driver=new ChromeDriver();
		    
			//System.setProperty("webdriver.gecko.driver","C:\\geckodriver\\geckodriver.exe");
			//driver=new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("https://testweb.omnicuris.com/user/login");
			Readdata data =new Readdata(); 
			
			
		}
		
		
		@Test
		public void CreateAccount(String FirstName,String LastName,String Email,String MobileNumber,String CreateaPassword, String MedicalRegistraionNo )
		{
			//firstname
			driver.findElement(By.xpath("//input[@aria-label='First Name']")).sendKeys(FirstName);
			
			//lastname
			driver.findElement(By.xpath("//input[@aria-label='Last Name']")).sendKeys(LastName);
			
			//Email
			driver.findElement(By.xpath("//input[@aria-label='E-mail']")).sendKeys(Email);
			
			//MobileNumber
			driver.findElement(By.xpath("//input[@aria-label='Mobile Number (eg. 9876543210)' and @type='text']")).sendKeys(MobileNumber);
			
			//Create Password
			driver.findElement(By.xpath("//input[@aria-label='Create a Password']")).sendKeys(CreateaPassword);
			
		//Medical Registration
			driver.findElement(By.xpath("//div[@class='flex col-md-6']/descendant::input[@aria-label='Medical Registration No']")).sendKeys(MedicalRegistraionNo);
			
			
			//dropdown
			WebElement wb= driver.findElement(By.xpath("//div[@class='flex col-md-6']/descendant::div[@class='input-group__selections']"));
			wb.click();
		
			List<WebElement> lst=driver.findElements(By.xpath("//div[@class='list']//a[@class='list__tile list__tile--link']//div[@class='list__tile__content']/div[@class='list__tile__title']"));
			
			for(int i=0;i<lst.size();i++)
			{
				String s=lst.get(i).getText();
				System.out.println(s);
				if(s.equals("Andhra Pradesh"))
				{
					lst.get(i).click();
				}
				
				
			}
			
			
		}
		
	

		@AfterMethod
		public void tearDown()
		{
			driver.close();
		}

		

}}
