package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginlocator {

    public WebElement email(WebDriver driver) {
        By email = By.name("Email");
        WebElement emailEle= driver.findElement(email);
        return emailEle;
    }

    public WebElement password(WebDriver driver) {
        return driver.findElement(By.name("Password"));
    }
    public WebElement Rememberme(WebDriver driver) {
        return driver.findElement(By.id("RememberMe"));
    }

}
