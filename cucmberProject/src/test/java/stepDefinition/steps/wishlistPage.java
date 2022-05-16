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
import pages.wishlistLocator;

import java.util.concurrent.TimeUnit;

public class wishlistPage {
    WebDriver driver=null;
    wishlistLocator email;
    wishlistLocator password;
    wishlistLocator product;
    wishlistLocator mobile;
    wishlistLocator choose;
    wishlistLocator macBook;

    @Given("The user opens the chrome browser and navigates to the login page")
    public void firstStep(){
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        email=new wishlistLocator();
        password=new wishlistLocator();
        product=new wishlistLocator();

    }
    @When("The user starts to enter his personal information and clk on submit login")
    public void VD_test() throws InterruptedException {
        //Enter the valid email and password.
        email=new wishlistLocator();
        email.email(driver).clear();
        email.email(driver).sendKeys("Udacity@gmail.com");
        //Enter the valid password
        password=new wishlistLocator();
        password.password(driver).sendKeys("1234567");
        //Click on Login Button.
        password.password(driver).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
    @Then("The user navigates to the home page and starts to add some products to list")
    public void addMobilToWishlist() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        //Add HTC mobile To the cart.
        product=new wishlistLocator();
        product.SelectProduct(driver).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/htc-one-m8-android-l-50-lollipop");
        mobile=new wishlistLocator();
        mobile.addtocart(driver).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p//a[@href=\"/wishlist\"]")).click();

        Thread.sleep(3000);
    }
    @And("The user adds another product to his wishlist cart")
    public void addlaptopToWishlist() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        //Add Apple MacBook Pro 13-inch To the cart.
        choose=new wishlistLocator();
        choose.SelectlabProduct(driver).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/apple-macbook-pro-13-inch");
        macBook=new wishlistLocator();
        macBook.addcartELE(driver).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p//a[@href=\"/wishlist\"]")).click();

        Thread.sleep(3000);
    }
    @And("System Will close the browser after applying this method")
    public void RCL() {driver.close();}

}
