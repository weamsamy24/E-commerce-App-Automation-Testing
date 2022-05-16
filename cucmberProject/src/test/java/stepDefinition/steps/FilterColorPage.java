package stepDefinition.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.FilterColorLocator;

import java.util.concurrent.TimeUnit;

public class FilterColorPage {
    WebDriver driver=null;
    FilterColorLocator email;
    FilterColorLocator password;

    @Given("Open Browser and Go to the Login page as a first step")
    public void GoToLogin_Page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        email=new FilterColorLocator();
        password=new FilterColorLocator();
    }
    @When("User tries to enter the right information about him Like password and email")
    public void User() throws InterruptedException {
        //Login with valid username and password.
        email=new FilterColorLocator();
        email.email(driver).clear();
        email.email(driver).sendKeys("Udacity@gmail.com");
        //Enter the valid password
        password=new FilterColorLocator();
        password.password(driver).sendKeys("1234567");
        //Click on Login Button.
        password.password(driver).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

    }
    @Then("user go to home page select Shoes Category and select Red color")
    public void filterRedColor() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/customer/info");
        Actions acta=new Actions(driver);
        acta.moveToElement(driver.findElement(By.xpath("//li//a[@href=\"/apparel\"]"))).perform();
        driver.findElement(By.xpath("//li//a[@href=\"/shoes\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/shoes");
        driver.findElement(By.cssSelector("input[id=\"attribute-option-15\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/shoes?viewmode=grid&orderby=0&pagesize=6&specs=15");
        Thread.sleep(3000);

    }


    @And("The Customer will he will apply the previous steps Close Chrome")
    public void Step() {
        driver.quit();
    }

}
