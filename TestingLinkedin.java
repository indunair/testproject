import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class TestingLinkedin {

	@Test
	//Negative testing of Linkedin.com
	public void testLinkedinLogin() {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://linkedin.com");
		// using the WebElement interface for login 
		
		driver.findElement(By.id("session_key-login")).sendKeys("dummy@gmail.com");
		
		driver.findElement(By.id("session_password-login")).sendKeys("dummy");
		driver.findElement(By.id("signin")).submit();
		//driver.findElement(By.id("signin")).click();
		
	}

	
	@Test
	//Positive testing of NYTimes registration
	public void testNyTimesRegistrationSubmission() {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://myaccount.nytimes.com/register?action=click&region=Masthead&pgtype=Homepage&module=Registration&contentCollection=Homepage&t=qry263");
		driver.findElement(By.id("email_address")).sendKeys("nair.indulekha@gmail.com");
		driver.findElement(By.id("password1")).sendKeys("testPassword");
		driver.findElement(By.id("password2")).sendKeys("testPassword");
		driver.findElement(By.id("specialOffers")).click();
		driver.findElement(By.id("submit")).submit();
	}
	
	//This has a bug do not know how to manage a link to click register on the nytimes.com
	//Attempt to register to NYtimes from the first page
	@Test
	public void testNyRegister() {
	    FirefoxDriver driver = new FirefoxDriver();
	    driver.get("http://nytimes.com");
	    //String val= driver.findElement(By.xpath("//*[@id='masthead-tools']/li[3]/a")).getAttribute("value");
	    driver.findElement(By.linkText("Register")).click();
	    //System.out.print(val);
	}
	
}
