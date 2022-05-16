package stepDefinition.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.compareListLocator;

import java.util.concurrent.TimeUnit;

public class compareListPage {
    WebDriver driver=null;
    compareListLocator email;
    compareListLocator password;
    compareListLocator product;
    compareListLocator compare;


    @Given("open Browser and Go to Login Page")
    public void First_Method() {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        email=new compareListLocator();
        password=new compareListLocator();

    }
    @When("Customer start to enter Some information and CLK to login Button")
    public void LOG_with_valid_dataa() throws InterruptedException {
        //Enter the valid email
        email=new compareListLocator();
        email.email(driver).clear();
        email.email(driver).sendKeys("Udacity@gmail.com");
        //Enter the valid password
        password=new compareListLocator();
        password.password(driver).sendKeys("1234567");
        //Click on Login Button.
        password.password(driver).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @Then("Select the HomePage to add some items to compare list")
    public void mobileComparelist() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        product=new compareListLocator();
        product.SelectProduct(driver).click();
        compare=new compareListLocator();
        Thread.sleep(1000);
        compare.com(driver).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/compareproducts");

        Thread.sleep(4000);

    }
    @And("After applying the previous steps close the browser")
    public void finish(){
        driver.quit();
    }



}
