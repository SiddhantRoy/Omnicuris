package com.qa.TestUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Readdata {

	public static void main(String[] args) throws Throwable  {
		File src=new File("C:\\Users\\siddhant sankar\\Neweclipse-workspace\\Omni\\src\\com\\qa\\Excel\\ABCDE.xlsx");
		
			FileInputStream fis=new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheet("Sheet1");
			
			
			for(int i=1;i<4;i++){
				Row row=sh.getRow(i);	
			
			//read the data from 
			String FirstName=row.getCell(0).getStringCellValue();
			String  LastName= row.getCell(1).getStringCellValue();
			String  Email= row.getCell(2).getStringCellValue();
			String  MobileNumber= row.getCell(3).getStringCellValue();
			String  CreateaPassword= row.getCell(4).getStringCellValue();
			String  MedicalRegistrationNo= row.getCell(5).getStringCellValue();
			String  MedicalCouncil= row.getCell(6).getStringCellValue();
			
			/*int rowcount=sh.getLastRowNum();
			System.out.println("total row"+rowcount);
			
			//loop
			for(int i=0;i<rowcount;i++)
			{
				String data=sh.getRow(i).getCell(i).getStringCellValue();
				System.out.println("testdata from Excel " +data);
			}
		*/
		

			System.setProperty("webdriver.chrome.driver","C:\\Users\\siddhant sankar\\Desktop\\74Chrom\\chromedriver_win32\\chromedriver.exe");
		  WebDriver  driver=new ChromeDriver();
		    
		    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("https://testweb.omnicuris.com/user/login");
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
				driver.findElement(By.xpath("//div[@class='flex col-md-6']/descendant::input[@aria-label='Medical Registration No']")).sendKeys(MedicalRegistrationNo);
				
				
				//dropdown
				WebElement wb1 = driver.findElement(By.xpath("//div[@class='flex col-md-6']/descendant::div[@class='input-group__selections']"));
				wb1.click();
			
				List<WebElement> lst=driver.findElements(By.xpath("//div[@class='list']//a[@class='list__tile list__tile--link']//div[@class='list__tile__content']/div[@class='list__tile__title']"));
				
				for(int j=0;j<lst.size();j++)
				{
					String s=lst.get(j).getText();
					System.out.println(s);
					if(s.equals(MedicalCouncil))
					{
						lst.get(j).click();
					}
					
					
				}
				
				
	}
	}
}
