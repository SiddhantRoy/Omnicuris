	import java.util.List;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

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
			
		}
		
		
		@Test
		public void CreateAccount()
		{
			//firstname
			driver.findElement(By.xpath("//input[@aria-label='First Name']")).sendKeys("siddhant");
			
			//lastname
			driver.findElement(By.xpath("//input[@aria-label='Last Name']")).sendKeys("roy");
			
			//Email
			driver.findElement(By.xpath("//input[@aria-label='E-mail']")).sendKeys("siddhant@gmail.com");
			
			//MobileNumber
			driver.findElement(By.xpath("//input[@aria-label='Mobile Number (eg. 9876543210)' and @type='text']")).sendKeys("9437402001");
			
			//Create Password
			driver.findElement(By.xpath("//input[@aria-label='Create a Password']")).sendKeys("siddhant");
			
		//Medical Registration
			driver.findElement(By.xpath("//div[@class='flex col-md-6']/descendant::input[@aria-label='Medical Registration No']")).sendKeys("siddhant123");
			
			
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

		
	}

	
