package stepDefinition.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShoppingCartLocator;

import java.util.concurrent.TimeUnit;

public class ShoppingCartPage {
    WebDriver driver=null;
    ShoppingCartLocator email;
    ShoppingCartLocator password;
    ShoppingCartLocator product;
    ShoppingCartLocator mobile;
    ShoppingCartLocator choose;
    ShoppingCartLocator macBook;

    @Given("The system opens the browser and goes to the login page")
    public void open() {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        email=new ShoppingCartLocator();
        password=new ShoppingCartLocator();
        product=new ShoppingCartLocator();
    }
    @When("login with valid password and username and clk on login button")
    public void data() throws InterruptedException {
        //Enter the valid email and password.
        email=new ShoppingCartLocator();
        email.email(driver).clear();
        email.email(driver).sendKeys("Udacity@gmail.com");
        //Enter the valid password
        password=new ShoppingCartLocator();
        password.password(driver).sendKeys("1234567");
        //Click on Login Button.
        password.password(driver).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
    @Then("The customer starts to add different items to the shopping cart like the HTC mobile")
    public void additemtoCart() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        //Add HTC mobile To the cart.
        product=new ShoppingCartLocator();
        product.SelectProduct(driver).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/htc-one-m8-android-l-50-lollipop");
        mobile=new ShoppingCartLocator();
        mobile.addtocart(driver).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p//a[@href=\"/cart\"]")).click();

        Thread.sleep(3000);
    }
    @And("The customer starts to add Apple MacBook Pro 13-inch to the shopping cart")
    public void addlaptop() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        //Add Apple MacBook Pro 13-inch To the cart.
        choose=new ShoppingCartLocator();
        choose.SelectlabProduct(driver).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/apple-macbook-pro-13-inch");
        macBook=new ShoppingCartLocator();
        macBook.addcartELE(driver).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p//a[@href=\"/cart\"]")).click();

        Thread.sleep(3000);
    }

    @And("close the website")
    public void close() {
        driver.quit();
    }
}
