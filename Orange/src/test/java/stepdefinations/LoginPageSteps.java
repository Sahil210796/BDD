/**
 * 
 */
package stepdefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.internal.BaseClassFinder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * @author Avdhut Pawar
 * @date 2023-02-23
 * @description  
 */
public class LoginPageSteps {
	
	WebDriver driver;
	@Given("user is already on Login Page")
	public void user_is_already_on_login_page() {
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	}

	@When("title of login page is login")
	public void title_of_login_page_is() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_and(String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}

	@Then("user is on Dashboard")
	public void user_is_on_dashboard() {
		boolean result = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText().equals("Dashboard");
		Assert.assertEquals(result, true);
	}

	@Then("Close the browser")
	public void close_the_browser() {
	driver.quit();
	}

}
