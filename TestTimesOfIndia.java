import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class TestTimesOfIndia {
	@Test
	//Passing parameter to a drop box
	//Finding number of elements in a drop box
	//Printing out elements in a drop box
	public void TestTimesOfIndiaFirstPage(){
		FirefoxDriver driver= new FirefoxDriver();
		driver.get("http://www.ndtv.com/article/list/cities");
		driver.findElement(By.className("slct_city")).sendKeys("Goa");
		//droplist.sendKeys("Goa");
		WebElement webDrop = driver.findElement(By.className("slct_city"));
		List<WebElement> dropbox= webDrop.findElements(By.tagName("option"));  
		System.out.println("The Cities combobox has "+dropbox.size());
		for(int i=0;i<dropbox.size();i++)
		{
			System.out.println(dropbox.get(i).getText());
		}
	}
	
	@Test
	//Clicking on video 
	// This code can be improved to find videos and then clicking on them 
	public void TestNdtvVedios(){
		FirefoxDriver driver= new FirefoxDriver();
		driver.get("http://www.ndtv.com/video");
		driver.findElement(By.id("gif316247_featured_videos")).click();
	}
}
