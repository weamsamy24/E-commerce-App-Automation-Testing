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
import org.openqa.selenium.support.ui.Select;
import pages.SearchLocator;

import java.util.concurrent.TimeUnit;

public class SearchPage {
    WebDriver driver=null;
    SearchLocator email;
    SearchLocator password;
    SearchLocator searchLabel;


    @Given("open the chromeBrowser and navigate to the Login page")
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        email=new SearchLocator();
        password=new SearchLocator();
        searchLabel=new SearchLocator();
    }

    @When("The Users start to Sign-in with valid data")
    public void EnterUser_ValidData() throws InterruptedException {
        //Enter the valid email
        email=new SearchLocator();
        email.email(driver).clear();
        email.email(driver).sendKeys("Udacity@gmail.com");
        //Enter the valid password
        password=new SearchLocator();
        password.password(driver).sendKeys("1234567");
        //Click on Login Button.
        password.password(driver).sendKeys(Keys.ENTER);
        Thread.sleep(2000); }

    @Then("If the user wants to search for any product he should use the search label")
    //Enter a valid email and password to go to "My account" then select the Search form.
    public void searchFor_Product() throws InterruptedException {
        driver.findElement(By.linkText("My account")).click();
        searchLabel = new SearchLocator();
        searchLabel.searchStore(driver).sendKeys("shoes");
        searchLabel.searchStore(driver).sendKeys(Keys.ENTER);
        // Choose the product with the name "Nike Floral Roshe Customized Running Shoes".
        driver.findElement(By.linkText("Nike Floral Roshe Customized Running Shoes")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/nike-floral-roshe-customized-running-shoes");
        Thread.sleep(2000);
    }
    @And("If the user wants to switch between currencies US AND Euro")
    //Enter a valid email and password to go to "My account" then select the Search form.
    public void currencyExchange() throws InterruptedException {
        driver.findElement(By.linkText("My account")).click();
        searchLabel = new SearchLocator();
        searchLabel.searchStore(driver).sendKeys("shoes");
        searchLabel.searchStore(driver).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("select[name=\"customerCurrency\"]"));
        //Select Us=new Select(driver.findElement(By.cssSelector("select[name=\"customerCurrency\"]")));
        //Us.selectByVisibleText("US Dollar");
        Select euro=new Select(driver.findElement(By.cssSelector("select[name=\"customerCurrency\"]")));
        euro.selectByVisibleText("Euro");

        Thread.sleep(2000);}

    @And("Logged user could select different Categories select Electronics Category")
    //Logged user could select different Categories "select Electronics Category"
    public void differentCategories() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/customer/info");
        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//li//a[@href=\"/electronics\"]"))).perform();
        driver.findElement(By.xpath("//li//a[@href=\"/camera-photo\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/camera-photo");
        Thread.sleep(3000);

    }

    @And("Logged user could select different Categories select Apparel Category")
    //Logged user could select different Categories "select Apparel Category"
    public void differentCategoriesApparel() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/customer/info");
        Actions acta=new Actions(driver);
        acta.moveToElement(driver.findElement(By.xpath("//li//a[@href=\"/apparel\"]"))).perform();
        driver.findElement(By.xpath("//li//a[@href=\"/shoes\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/shoes");

        Thread.sleep(3000);

    }



    @And("When the user finishes his shopping process, close the browser")
    public void closeBrowser() {
        driver.quit();
    }
}
