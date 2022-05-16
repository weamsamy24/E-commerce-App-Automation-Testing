package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartLocator {

    public WebElement email(WebDriver driver) {
        By email = By.name("Email");
        WebElement emailEle= driver.findElement(email);
        return emailEle;
    }

    public WebElement password(WebDriver driver) {
        return driver.findElement(By.name("Password"));
    }

    public WebElement SelectProduct(WebDriver driver) {
        return driver.findElement(By.cssSelector("a[href=\"/htc-one-m8-android-l-50-lollipop\"]"));
    }
    public WebElement addtocart(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[id=\"add-to-cart-button-18\"]"));}

    public WebElement SelectlabProduct(WebDriver driver) {
        return driver.findElement(By.xpath("//h2//a[@href=\"/apple-macbook-pro-13-inch\"]"));
    }

    public WebElement addcartELE(WebDriver driver) {
        return driver.findElement(By.xpath("//button[@id=\"add-to-cart-button-4\"]"));}



}
