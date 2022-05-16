package stepDefinition.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.RegisterLocator;


public class A_RegisterPage {
    WebDriver driver=null;
    RegisterLocator input;
    RegisterLocator name;
    RegisterLocator email;
    RegisterLocator companyNAM;
    RegisterLocator password;

    RegisterLocator register;

    @Given("open Browser")
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(3000);
        input=new RegisterLocator();
        name=new RegisterLocator();
        email=new RegisterLocator();
        companyNAM=new RegisterLocator();

    }
    @And("user navigate to Register page")
    public void openRegisterPage(){
        driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");

    }
    @When("user enter valid data")
    public void validData() throws InterruptedException {
        //select the gender male:
        input=new RegisterLocator();
        input.Gendermale(driver).click();

        //write the first username:
        name=new RegisterLocator();
        name.userName(driver).clear();
        name.userName(driver).sendKeys("Ahmed");

        //write the lastname:
        name.Name(driver).clear();
        name.Name(driver).sendKeys("Mohammed");

        //Date of birth:
        Select birth=new Select(driver.findElement(By.name("DateOfBirthMonth")));
        birth.selectByValue("9");
        Select day=new Select(driver.findElement(By.name("DateOfBirthDay")));
        day.selectByValue("21");
        Select year=new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByValue("1998");

        //Enter email:
        email=new RegisterLocator();
        email.emailELE(driver).sendKeys("Udacity@gmail.com");

        //Company name:
        companyNAM=new RegisterLocator();
        companyNAM.COMname(driver).sendKeys("Udacity Online Programs");

        //Not selecting the Newsletter Button:
        driver.findElement(companyNAM.Newsletter()).click();

        //password:
        password=new RegisterLocator();
        password.passwordELE(driver).sendKeys("1234567");
        password.confirmPasswordELE(driver).sendKeys("1234567");
        Thread.sleep(1000);


    }
    @Then("user press the submit register")
    public void registerButton() throws InterruptedException {
        Thread.sleep(2000);
        register=new RegisterLocator();
        register.RegisterELE(driver).click();
        //driver.findElement(By.name("register-button")).click();
        Thread.sleep(1000);

    }
    @And("user make sure that the registers were successfully")
        public void register() throws InterruptedException {
        Assert.assertEquals("https://demo.nopcommerce.com/",driver.getCurrentUrl());
        Thread.sleep(3000);

    }


    @And("Close Tabs")
    public void cB() {
        driver.quit();
    }
}
