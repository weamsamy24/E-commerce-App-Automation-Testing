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
import pages.loginlocator;

public class B_Loginpage {
    WebDriver driver=null;
    loginlocator email;
    loginlocator password;

    @Given("user open browser")
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        email=new loginlocator();

    }
    @And("user navigate to login page")
    public void openApplication(){
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");

    }
    @When("user enter valid user name and password and login")
    public void validdata() throws InterruptedException {
        email=new loginlocator();
        email.email(driver).clear();
        email.email(driver).sendKeys("Udacity@gmail.com");

        password=new loginlocator();
        password.password(driver).sendKeys("1234567");

        password.password(driver).sendKeys(Keys.ENTER);

        Thread.sleep(1000);
    }
    @Then("user could login successfully")
    public void LoginSuccess() {
        Assert.assertEquals("https://demo.nopcommerce.com/",driver.getCurrentUrl());

    }

    @When("user enter valid user name and password and login with remember button")
    public void validData() throws InterruptedException {
        email=new loginlocator();
        email.email(driver).clear();
        email.email(driver).sendKeys("Udacity@gmail.com");

        password=new loginlocator();
        password.password(driver).sendKeys("1234567");

        Thread.sleep(1000);
    }

    @And("user choose Remember me Button")
    public void rememberME(){
        email.Rememberme(driver).click();
    }
    @And("click on Login Button")
    public void LoginButton(){
        email.Rememberme(driver).click();
    }

    @Then("user login successfully")
    public void assertTheLogin() {
        String messageForcolor = driver.findElement(By.cssSelector("div[class=\"master-wrapper-page\"]")).getCssValue("color");
        System.out.println(messageForcolor);

    }

    @And("close App")
    public void closBro() {
        driver.quit();
    }

}
