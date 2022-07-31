package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	
	/*
	 * //Pseudo Code
	 * 
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	 * 
	 * 2. Enter UserName and Password Using Id Locator
	 * 
	 * 3. Click on Login Button using Class Locator
	 * 
	 * 4. Click on CRM/SFA Link
	 * 
	 * 5. Click on contacts Button
	 * 	
	 * 6. Click on Merge Contacts using Xpath Locator
	 * 
	 * 7. Click on Widget of From Contact
	 * 
	 * 8. Click on First Resulting Contact
	 * 
	 * 9. Click on Widget of To Contact
	 * 
	 * 10. Click on Second Resulting Contact
	 * 
	 * 11. Click on Merge button using Xpath Locator
	 * 
	 * 12. Accept the Alert
	 * 
	 * 13. Verify the title of the page
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager"); 
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click on Login Button using Class Locator
		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();
		Thread.sleep(5000);
		
		//Click on CRM/SFA Link
		WebElement crmsfaLink = driver.findElement(By.linkText("CRM/SFA"));
		crmsfaLink.click();
		
		//Click on contacts Button
		WebElement contactsButton = driver.findElement(By.linkText("Contacts"));
		contactsButton.click();
		 
		//Click on Merge Contacts using Xpath Locator
		WebElement mergeContacts = driver.findElement(By.linkText("Merge Contacts"));
		mergeContacts.click();
		
		//Click on Widget of From Contact
		WebElement fromContactSearch = driver.findElement(By.xpath("//span[text()='From Contact']/following::a"));
		fromContactSearch.click();
		Thread.sleep(3000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindows = new ArrayList<String>(windowHandles);
		String firstWindows = listWindows.get(0);
		String secondWindows = listWindows.get(1);
		
		driver.switchTo().window(secondWindows);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//Click on First Resulting Contact
		WebElement firstResultingId = driver.findElement(By.xpath("//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]//a"));
		firstResultingId.click();
		Thread.sleep(3000);
		
		driver.switchTo().window(firstWindows);
		Thread.sleep(3000);
		
		//Click on Widget of To Contact
		WebElement toContactSearch = driver.findElement(By.xpath("//span[text()='To Contact']/following::a"));
		toContactSearch.click();
		Thread.sleep(3000);
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listWindows1 = new ArrayList<String>(windowHandles1);
		String firstWindows1 = listWindows1.get(0);
		String secondWindows1 = listWindows1.get(1);
		
		driver.switchTo().window(secondWindows1);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//Click on Second Resulting Contact
		WebElement secondResultingId = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]"));
		secondResultingId.click();
		Thread.sleep(3000);
		
		driver.switchTo().window(firstWindows1);
		Thread.sleep(3000);
		
		//Click on Merge button using Xpath Locator
		WebElement mergeIcon = driver.findElement(By.linkText("Merge"));
		mergeIcon.click();
		Thread.sleep(3000);
		
		//Accept the Alert
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		
		//Verify the title of the page
		String title = driver.getTitle();
		System.out.println(title);
	}

}
