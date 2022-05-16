package stepDefinition.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ForgotPasswordLocator;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordPage {
    WebDriver driver=null;
    ForgotPasswordLocator Email;
    ForgotPasswordLocator password;
    ForgotPasswordLocator NewPassword;
    ForgotPasswordLocator conPassword;
    ForgotPasswordLocator email;
    ForgotPasswordLocator passwordlogin;


    @Given("The user will open her browser and go to the login page if she wants to reset her email")
    public void navigateTofirstStepPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        Email=new ForgotPasswordLocator();
    }

    @Then("At first, a user must enter correct information about the user")
    public void ResetUserPassword() throws InterruptedException {
        //First Before we will change the password we need to login.
        //Enter the valid email
        email=new ForgotPasswordLocator();
        email.email(driver).clear();
        email.email(driver).sendKeys("Udacity@gmail.com");
        //Enter the valid password
        passwordlogin=new ForgotPasswordLocator();
        passwordlogin.passwordforlogin(driver).sendKeys("1234567");
        //Click on Login Button.
        passwordlogin.passwordforlogin(driver).sendKeys(Keys.ENTER);

        Thread.sleep(3000);
    }

        @And("The customer will navigate to HomePage and will select the Change password page")
        public void ChangePassPage() throws InterruptedException {
        //Second Step Change the Password.
        driver.navigate().to("https://demo.nopcommerce.com/customer/changepassword");
        password=new ForgotPasswordLocator();
        password.password(driver).sendKeys("1234567"); //oldpassword
        NewPassword=new ForgotPasswordLocator();
        NewPassword.newPassword(driver).sendKeys("123456778"); //newpassword
        conPassword=new ForgotPasswordLocator();
        conPassword.confirmPassword(driver).sendKeys("123456778"); //confirmnewpassword
        driver.findElement(By.linkText("Change password")).click();
        Thread.sleep(3000);

    }

    @And("If the user Forget her password she will change it from the Login page")
    public void Forgot_password_Page() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        driver.findElement(By.linkText("Forgot password?")).click();
        Email=new ForgotPasswordLocator();
        Email.emailELE(driver).sendKeys("Udacity@gmail.com");
        Email.emailELE(driver).sendKeys(Keys.ENTER);
        String excpectedresult="Email with instructions has been sent to you.";
        String actualresult=driver.findElement(Email.recovermessage()).getText();
        Assert.assertTrue(actualresult.contains(excpectedresult));

        Thread.sleep(2000);

    }

    @And("System will apply Previous steps then close the Browser")
    public void LastStep() {
        driver.quit();
    }
}
