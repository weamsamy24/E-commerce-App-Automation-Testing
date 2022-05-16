package stepDefinition.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TagLocator;

import java.util.concurrent.TimeUnit;


public class SelectDifferentTag {

    WebDriver driver=null;
    TagLocator email;
    TagLocator password;
    @Given("customer open browser and home page")
    public void openBrowser()  {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        email=new TagLocator();
        password=new TagLocator();
    }

    @When("user enter his information")
    public void validData() throws InterruptedException {
        Thread.sleep(4000);


        email=new TagLocator();
        email.email(driver).clear();
        email.email(driver).sendKeys("Udacity@gmail.com");

        password=new TagLocator();
        password.password(driver).sendKeys("1234567");


        Thread.sleep(1000);
    }

    @And("open log")
    public void login() throws InterruptedException {
        driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]")).click();
        Thread.sleep(3000);
    }


    @Then("customer select different tags")
    public void selectDifferentTags() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/adidas-consortium-campus-80s-running-shoes");
        driver.findElement(By.xpath("//a//span[@itemprop=\"name\"]")).click();
        //Choose Apparel page from tags
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/apparel");
        //Choose Homepage from tags
        driver.findElement(By.cssSelector("a[title=\"Home\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        Thread.sleep(3000);

    }

    @And("close all tabs")
    public void B() { driver.quit();}

}


