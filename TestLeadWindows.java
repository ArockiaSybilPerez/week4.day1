package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLeadWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();

		// Click button to open home page in New Window
		WebElement openHomePage = driver.findElement(By.xpath("//button[text()='Open Home Page']"));
		openHomePage.click();
		Thread.sleep(3000);

		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listWindowHandles1 = new ArrayList<String>(windowHandles1);
		
        String firstWindow = listWindowHandles1.get(0);
		String secondWindow = listWindowHandles1.get(1);
		
		driver.switchTo().window(secondWindow);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.close();

		driver.switchTo().window(firstWindow);
		
		//Find the number of opened windows
		WebElement openMultipleWindows = driver.findElement(By.xpath("//button[text()='Open Multiple Windows']"));
		openMultipleWindows.click();
		Thread.sleep(3000);
		
		int openWindows = driver.getWindowHandles().size();
		System.out.println("Opened Windows are " + openWindows);
				
	    Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> listWindowHandles2= new ArrayList<String>(windowHandles2);
		
		String firstWindows1 = listWindowHandles2.get(0);
		String secondWindows1 = listWindowHandles2.get(1);
		String thridWindows1 = listWindowHandles2.get(2);
		
		driver.switchTo().window(thridWindows1);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.close();
		
		driver.switchTo().window(secondWindows1);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.close();
		
		driver.switchTo().window(firstWindows1);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		// Wait for 2 new Windows to open
		WebElement doNotcloseMe	= driver.findElement(By.xpath("(//button[@id='color'])[2]"));
		doNotcloseMe.click();
		Thread.sleep(3000);

		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> listWindowHandles3 = new ArrayList<String>(windowHandles3);

		String firstWindows11 = listWindowHandles3.get(0);
		String secondWindows22 = listWindowHandles3.get(1);
		String thridWindows33 = listWindowHandles3.get(2);
				
		driver.switchTo().window(firstWindows11);
		System.out.println("Third Window Title is " + driver.getTitle());
		Thread.sleep(3000);
		
		driver.switchTo().window(secondWindows22);
		System.out.println("Second Window Title is " + driver.getTitle());
		Thread.sleep(3000);
		
		driver.switchTo().window(thridWindows33);
		System.out.println("First Window Title is " + driver.getTitle());
	}

}
